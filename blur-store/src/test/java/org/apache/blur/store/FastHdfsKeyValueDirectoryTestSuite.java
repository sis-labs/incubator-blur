package org.apache.blur.store;

/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Timer;

import org.apache.blur.store.hdfs_v2.FastHdfsKeyValueDirectory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.lucene.store.Directory;
import org.junit.Test;

public class FastHdfsKeyValueDirectoryTestSuite extends BaseDirectoryTestSuite {

  private Timer _timer;

  @Override
  protected Directory setupDirectory() throws IOException {
    URI uri = new File(file, "hdfs").toURI();
    Path hdfsDirPath = new Path(uri.toString());
    Configuration conf = new Configuration();
    _timer = new Timer("IndexImporter", true);
    return new FastHdfsKeyValueDirectory(false, _timer, conf, hdfsDirPath);
  }

  @Test
  public void runsTheTests() {
  }

  @Override
  protected void close() throws IOException {
    _timer.cancel();
    _timer.purge();
  }

}
