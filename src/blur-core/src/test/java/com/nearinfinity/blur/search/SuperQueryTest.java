package com.nearinfinity.blur.search;

import static junit.framework.Assert.assertEquals;

import java.io.IOException;
import java.util.UUID;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.index.TermDocs;
import org.apache.lucene.index.IndexWriter.MaxFieldLength;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.LockObtainFailedException;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;

import com.nearinfinity.blur.lucene.index.SuperDocument;
import com.nearinfinity.blur.lucene.search.BlurSearcher;
import com.nearinfinity.blur.lucene.search.SuperQuery;
import com.nearinfinity.blur.manager.IndexManager;
import com.nearinfinity.blur.thrift.generated.ScoreType;
import com.nearinfinity.blur.utils.PrimeDocCache;

public class SuperQueryTest {
	
    @Test
	public void testSimpleSuperQuery() throws CorruptIndexException, IOException, InterruptedException {
		BooleanQuery booleanQuery = new BooleanQuery();
		booleanQuery.add(wrapSuper(new TermQuery(new Term("person.name","aaron"))), Occur.MUST);
		booleanQuery.add(wrapSuper(new TermQuery(new Term("address.street","sulgrave"))), Occur.MUST);
		
		Directory directory = createIndex();
		IndexReader reader = IndexReader.open(directory);
		printAll(new Term("person.name","aaron"),reader);
		printAll(new Term("address.street","sulgrave"),reader);
		printAll(new Term(SuperDocument.PRIME_DOC,SuperDocument.PRIME_DOC_VALUE),reader);
		BlurSearcher searcher = new BlurSearcher(reader, PrimeDocCache.getTableCache().getShardCache("test2").getIndexReaderCache("test2"));
		TopDocs topDocs = searcher.search(booleanQuery, 10);
		assertEquals(2, topDocs.totalHits);
		assertEquals("1",searcher.doc(topDocs.scoreDocs[0].doc).get(SuperDocument.ID));
		assertEquals("3",searcher.doc(topDocs.scoreDocs[1].doc).get(SuperDocument.ID));
	}
    
    @Test
    public void testAggregateScoreTypes() throws Exception {
    	BlurSearcher searcher = createSearcher();
		BooleanQuery booleanQuery = new BooleanQuery();
		booleanQuery.add(wrapSuper("person.name","aaron", ScoreType.AGGREGATE), Occur.SHOULD);
		booleanQuery.add(wrapSuper("address.street","sulgrave", ScoreType.AGGREGATE), Occur.MUST);
		TopDocs topDocs = searcher.search(booleanQuery, 10);
		printTopDocs(topDocs);
		assertEquals(3, topDocs.totalHits);
		assertEquals(3.30, topDocs.scoreDocs[0].score, 0.01);
		assertEquals(2.20, topDocs.scoreDocs[1].score, 0.01);
		assertEquals(0.55, topDocs.scoreDocs[2].score, 0.01);
    }
    
    @Test
    public void testBestScoreTypes() throws Exception {
    	BlurSearcher searcher = createSearcher();
		BooleanQuery booleanQuery = new BooleanQuery();
		booleanQuery.add(wrapSuper("person.name","aaron", ScoreType.BEST), Occur.SHOULD);
		booleanQuery.add(wrapSuper("address.street","sulgrave", ScoreType.BEST), Occur.MUST);
		TopDocs topDocs = searcher.search(booleanQuery, 10);
		assertEquals(3, topDocs.totalHits);
		printTopDocs(topDocs);
		assertEquals(2.20, topDocs.scoreDocs[0].score, 0.01);
		assertEquals(2.20, topDocs.scoreDocs[1].score, 0.01);
		assertEquals(0.55, topDocs.scoreDocs[2].score, 0.01);
    }
    
    private void printTopDocs(TopDocs topDocs) {
		for(int i = 0; i< topDocs.totalHits; i++){
			System.out.println("doc " + i + " score " + topDocs.scoreDocs[i].score);
		}
		
	}

	@Test
    public void testConstantScoreTypes() throws Exception {
    	BlurSearcher searcher = createSearcher();
		BooleanQuery booleanQuery = new BooleanQuery();
		booleanQuery.add(wrapSuper("person.name","aaron", ScoreType.CONSTANT), Occur.SHOULD);
		booleanQuery.add(wrapSuper("address.street","sulgrave", ScoreType.CONSTANT), Occur.MUST);
		TopDocs topDocs = searcher.search(booleanQuery, 10);
		assertEquals(3, topDocs.totalHits);
		printTopDocs(topDocs);
		assertEquals(2.0, topDocs.scoreDocs[0].score, 0.01);
		assertEquals(2.0, topDocs.scoreDocs[1].score, 0.01);
		assertEquals(0.5, topDocs.scoreDocs[2].score, 0.01);
    }
    
    @Test
    public void testSuperScoreTypes() throws Exception {
    	BlurSearcher searcher = createSearcher();
		BooleanQuery booleanQuery = new BooleanQuery();
		booleanQuery.add(wrapSuper("person.name","aaron", ScoreType.SUPER), Occur.SHOULD);
		booleanQuery.add(wrapSuper("address.street","sulgrave", ScoreType.SUPER), Occur.MUST);
		TopDocs topDocs = searcher.search(booleanQuery, 10);
		assertEquals(3, topDocs.totalHits);
		printTopDocs(topDocs);
		assertEquals(3.10, topDocs.scoreDocs[0].score, 0.01);
		assertEquals(3.00, topDocs.scoreDocs[1].score, 0.01);
		assertEquals(0.75, topDocs.scoreDocs[2].score, 0.01);
    }

	private void printAll(Term term, IndexReader reader) throws IOException {
		TermDocs termDocs = reader.termDocs(term);
		while (termDocs.next()) {
			System.out.println(term + "=>" + termDocs.doc());
		}
	}
	
	private static BlurSearcher createSearcher() throws Exception {
		Directory directory = createIndex();
		IndexReader reader = IndexReader.open(directory);
		return new BlurSearcher(reader, PrimeDocCache.getTableCache().getShardCache("test2").getIndexReaderCache("test2"));
	}

	public static Directory createIndex() throws CorruptIndexException, LockObtainFailedException, IOException {
		Directory directory = new RAMDirectory();
		IndexWriter writer = new IndexWriter(directory, new StandardAnalyzer(Version.LUCENE_30), MaxFieldLength.UNLIMITED);
		IndexManager.replace(writer, create("1","person.name:aaron","person.name:aaron","address.street:sulgrave"));
		IndexManager.replace(writer, create("2","person.name:hannah","address.street:sulgrave"));
		IndexManager.replace(writer, create("3","person.name:aaron","address.street:sulgrave court"));
		writer.close();
		return directory;
	}

	public static SuperDocument create(String id, String... parts) {
		SuperDocument document = new SuperDocument(id);
		for (String part : parts) {
			String[] split = part.split(":");
			String value = split[1];
			String[] split2 = split[0].split("\\.");
			String superName = split2[0];
			String fieldName = split2[1];
			document.addFieldAnalyzedNoNorms(superName, UUID.randomUUID().toString(), fieldName, value);
		}
		return document;
	}

	private Query wrapSuper(Query query) {
		return new SuperQuery(query, ScoreType.AGGREGATE);
	}
	private Query wrapSuper(String field, String value, ScoreType scoreType) {
		return new SuperQuery(new TermQuery(new Term(field,value)), scoreType);
	}

}
