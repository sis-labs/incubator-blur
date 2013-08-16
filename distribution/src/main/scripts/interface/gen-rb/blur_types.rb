#
# Autogenerated by Thrift Compiler (0.9.0)
#
# DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
#

require 'thrift'

module Blur
  module ErrorType
    UNKNOWN = 0
    QUERY_CANCEL = 1
    QUERY_TIMEOUT = 2
    BACK_PRESSURE = 3
    REQUEST_TIMEOUT = 4
    VALUE_MAP = {0 => "UNKNOWN", 1 => "QUERY_CANCEL", 2 => "QUERY_TIMEOUT", 3 => "BACK_PRESSURE", 4 => "REQUEST_TIMEOUT"}
    VALID_VALUES = Set.new([UNKNOWN, QUERY_CANCEL, QUERY_TIMEOUT, BACK_PRESSURE, REQUEST_TIMEOUT]).freeze
  end

  module ScoreType
    SUPER = 0
    AGGREGATE = 1
    BEST = 2
    CONSTANT = 3
    VALUE_MAP = {0 => "SUPER", 1 => "AGGREGATE", 2 => "BEST", 3 => "CONSTANT"}
    VALID_VALUES = Set.new([SUPER, AGGREGATE, BEST, CONSTANT]).freeze
  end

  module QueryState
    RUNNING = 0
    INTERRUPTED = 1
    COMPLETE = 2
    BACK_PRESSURE_INTERRUPTED = 3
    VALUE_MAP = {0 => "RUNNING", 1 => "INTERRUPTED", 2 => "COMPLETE", 3 => "BACK_PRESSURE_INTERRUPTED"}
    VALID_VALUES = Set.new([RUNNING, INTERRUPTED, COMPLETE, BACK_PRESSURE_INTERRUPTED]).freeze
  end

  module Status
    NOT_FOUND = 0
    FOUND = 1
    VALUE_MAP = {0 => "NOT_FOUND", 1 => "FOUND"}
    VALID_VALUES = Set.new([NOT_FOUND, FOUND]).freeze
  end

  module RowMutationType
    DELETE_ROW = 0
    REPLACE_ROW = 1
    UPDATE_ROW = 2
    VALUE_MAP = {0 => "DELETE_ROW", 1 => "REPLACE_ROW", 2 => "UPDATE_ROW"}
    VALID_VALUES = Set.new([DELETE_ROW, REPLACE_ROW, UPDATE_ROW]).freeze
  end

  module RecordMutationType
    DELETE_ENTIRE_RECORD = 0
    REPLACE_ENTIRE_RECORD = 1
    REPLACE_COLUMNS = 2
    APPEND_COLUMN_VALUES = 3
    VALUE_MAP = {0 => "DELETE_ENTIRE_RECORD", 1 => "REPLACE_ENTIRE_RECORD", 2 => "REPLACE_COLUMNS", 3 => "APPEND_COLUMN_VALUES"}
    VALID_VALUES = Set.new([DELETE_ENTIRE_RECORD, REPLACE_ENTIRE_RECORD, REPLACE_COLUMNS, APPEND_COLUMN_VALUES]).freeze
  end

  module ShardState
    OPENING = 0
    OPEN = 1
    OPENING_ERROR = 2
    CLOSING = 3
    CLOSED = 4
    CLOSING_ERROR = 5
    VALUE_MAP = {0 => "OPENING", 1 => "OPEN", 2 => "OPENING_ERROR", 3 => "CLOSING", 4 => "CLOSED", 5 => "CLOSING_ERROR"}
    VALID_VALUES = Set.new([OPENING, OPEN, OPENING_ERROR, CLOSING, CLOSED, CLOSING_ERROR]).freeze
  end

  # BlurException that carries a message plus the original stack
# trace (if any).
  class BlurException < ::Thrift::Exception
    include ::Thrift::Struct, ::Thrift::Struct_Union
    MESSAGE = 1
    STACKTRACESTR = 2
    ERRORTYPE = 3

    FIELDS = {
      # The message in the exception.
      MESSAGE => {:type => ::Thrift::Types::STRING, :name => 'message'},
      # The original stack trace (if any).
      STACKTRACESTR => {:type => ::Thrift::Types::STRING, :name => 'stackTraceStr'},
      ERRORTYPE => {:type => ::Thrift::Types::I32, :name => 'errorType', :enum_class => ::Blur::ErrorType}
    }

    def struct_fields; FIELDS; end

    def validate
      unless @errorType.nil? || ::Blur::ErrorType::VALID_VALUES.include?(@errorType)
        raise ::Thrift::ProtocolException.new(::Thrift::ProtocolException::UNKNOWN, 'Invalid value of field errorType!')
      end
    end

    ::Thrift::Struct.generate_accessors self
  end

  # Column is the lowest storage element in Blur, it stores a single name and value pair.
  class Column
    include ::Thrift::Struct, ::Thrift::Struct_Union
    NAME = 1
    VALUE = 2

    FIELDS = {
      # The name of the column.
      NAME => {:type => ::Thrift::Types::STRING, :name => 'name'},
      # The value to be indexed and stored.
      VALUE => {:type => ::Thrift::Types::STRING, :name => 'value'}
    }

    def struct_fields; FIELDS; end

    def validate
    end

    ::Thrift::Struct.generate_accessors self
  end

  # Records contain a list of columns, multiple columns with the same name are allowed.
  class Record
    include ::Thrift::Struct, ::Thrift::Struct_Union
    RECORDID = 1
    FAMILY = 2
    COLUMNS = 3

    FIELDS = {
      # Record id uniquely identifies a record within a single row.
      RECORDID => {:type => ::Thrift::Types::STRING, :name => 'recordId'},
      # The family in which this record resides.
      FAMILY => {:type => ::Thrift::Types::STRING, :name => 'family'},
      # A list of columns, multiple columns with the same name are allowed.
      COLUMNS => {:type => ::Thrift::Types::LIST, :name => 'columns', :element => {:type => ::Thrift::Types::STRUCT, :class => ::Blur::Column}}
    }

    def struct_fields; FIELDS; end

    def validate
    end

    ::Thrift::Struct.generate_accessors self
  end

  # Rows contain a list of records.
  class Row
    include ::Thrift::Struct, ::Thrift::Struct_Union
    ID = 1
    RECORDS = 2
    RECORDCOUNT = 3

    FIELDS = {
      # The row id.
      ID => {:type => ::Thrift::Types::STRING, :name => 'id'},
      # The list records within the row.  If paging is used this list will only
# reflect the paged records from the selector.
      RECORDS => {:type => ::Thrift::Types::LIST, :name => 'records', :element => {:type => ::Thrift::Types::STRUCT, :class => ::Blur::Record}},
      # The total record count for the row.  If paging is used in a selector to page
# through records of a row, this count will reflect the entire row.
      RECORDCOUNT => {:type => ::Thrift::Types::I32, :name => 'recordCount'}
    }

    def struct_fields; FIELDS; end

    def validate
    end

    ::Thrift::Struct.generate_accessors self
  end

  # The SimpleQuery object holds the query string (normal Lucene syntax), filters and type of scoring (used when super query is on).
  class SimpleQuery
    include ::Thrift::Struct, ::Thrift::Struct_Union
    QUERYSTR = 1
    SUPERQUERYON = 2
    TYPE = 3
    POSTSUPERFILTER = 4
    PRESUPERFILTER = 5

    FIELDS = {
      # A Lucene syntax based query.
      QUERYSTR => {:type => ::Thrift::Types::STRING, :name => 'queryStr'},
      # If the super query is on, meaning the query will be perform against all the records (joining records in some cases) and the result will be Rows (groupings of Record).
      SUPERQUERYON => {:type => ::Thrift::Types::BOOL, :name => 'superQueryOn', :default => true},
      # The scoring type, see the document on ScoreType for explanation of each score type.
      TYPE => {:type => ::Thrift::Types::I32, :name => 'type', :default =>       0, :enum_class => ::Blur::ScoreType},
      # The post super filter (normal Lucene syntax), is a filter performed after the join to filter out entire rows from the results.
      POSTSUPERFILTER => {:type => ::Thrift::Types::STRING, :name => 'postSuperFilter'},
      # The pre super filter (normal Lucene syntax), is a filter performed before the join to filter out records from the results.
      PRESUPERFILTER => {:type => ::Thrift::Types::STRING, :name => 'preSuperFilter'}
    }

    def struct_fields; FIELDS; end

    def validate
      unless @type.nil? || ::Blur::ScoreType::VALID_VALUES.include?(@type)
        raise ::Thrift::ProtocolException.new(::Thrift::ProtocolException::UNKNOWN, 'Invalid value of field type!')
      end
    end

    ::Thrift::Struct.generate_accessors self
  end

  # The HighlightOptions controls how the data is fetched and returned.
  class HighlightOptions
    include ::Thrift::Struct, ::Thrift::Struct_Union
    SIMPLEQUERY = 1
    PRETAG = 2
    POSTTAG = 3

    FIELDS = {
      # The original query is required if used in the Blur.fetchRow call.  If
# the highlightOptions is used in a call to Blur.query then the SimpleQuery
# passed into the call via the BlurQuery will be used if this simpleQuery is
# null.  So that means if you use highlighting from the query call you can
# leave this attribute null and it will default to the normal behavior.
      SIMPLEQUERY => {:type => ::Thrift::Types::STRUCT, :name => 'simpleQuery', :class => ::Blur::SimpleQuery},
      # The pre tag is the tag that marks the beginning of the highlighting.
      PRETAG => {:type => ::Thrift::Types::STRING, :name => 'preTag', :default => %q"<<<"},
      # The post tag is the tag that marks the end of the highlighting.
      POSTTAG => {:type => ::Thrift::Types::STRING, :name => 'postTag', :default => %q">>>"}
    }

    def struct_fields; FIELDS; end

    def validate
    end

    ::Thrift::Struct.generate_accessors self
  end

  # Select carries the request for information to be retrieved from the stored columns.
  class Selector
    include ::Thrift::Struct, ::Thrift::Struct_Union
    RECORDONLY = 1
    LOCATIONID = 2
    ROWID = 3
    RECORDID = 4
    COLUMNFAMILIESTOFETCH = 5
    COLUMNSTOFETCH = 6
    ALLOWSTALEDATA = 7
    STARTRECORD = 8
    MAXRECORDSTOFETCH = 9
    HIGHLIGHTOPTIONS = 10

    FIELDS = {
      # Fetch the Record only, not the entire Row.
      RECORDONLY => {:type => ::Thrift::Types::BOOL, :name => 'recordOnly'},
      # WARNING: This is an internal only attribute and is not intended for use by clients.
# The location id of the Record or Row to be fetched.
      LOCATIONID => {:type => ::Thrift::Types::STRING, :name => 'locationId'},
      # The row id of the Row to be fetched, not to be used with location id.
      ROWID => {:type => ::Thrift::Types::STRING, :name => 'rowId'},
      # The record id of the Record to be fetched, not to be used with location id.  However the row id needs to be provided to locate the correct Row with the requested Record.
      RECORDID => {:type => ::Thrift::Types::STRING, :name => 'recordId'},
      # The column families to fetch.  If null, fetch all.  If empty, fetch none.
      COLUMNFAMILIESTOFETCH => {:type => ::Thrift::Types::LIST, :name => 'columnFamiliesToFetch', :element => {:type => ::Thrift::Types::STRING}},
      # The columns in the families to fetch.  If null, fetch all.  If empty, fetch none.
      COLUMNSTOFETCH => {:type => ::Thrift::Types::MAP, :name => 'columnsToFetch', :key => {:type => ::Thrift::Types::STRING}, :value => {:type => ::Thrift::Types::SET, :element => {:type => ::Thrift::Types::STRING}}},
      # @deprecated This value is no longer used.  This allows the fetch to see the most current data that has been added to the table.
      ALLOWSTALEDATA => {:type => ::Thrift::Types::BOOL, :name => 'allowStaleData'},
      # Only valid for Row fetches, the record in the row to start fetching.  If the row contains 1000
# records and you want the first 100, then this value is 0.  If you want records 300-400 then this
# value would be 300.  If startRecord is beyond the end of the row, the row will be null in the
# FetchResult.  Used in conjunction with maxRecordsToFetch.
      STARTRECORD => {:type => ::Thrift::Types::I32, :name => 'startRecord', :default => 0},
      # Only valid for Row fetches, the number of records to fetch.  If the row contains 1000 records
# and you want the first 100, then this value is 100.  If you want records 300-400 then this value
# would be 100.  Used in conjunction with maxRecordsToFetch. By default this will fetch the first
# 1000 records of the row.
      MAXRECORDSTOFETCH => {:type => ::Thrift::Types::I32, :name => 'maxRecordsToFetch', :default => 1000},
      # The HighlightOptions object controls how the data is highlighted.  If null no highlighting will occur.
      HIGHLIGHTOPTIONS => {:type => ::Thrift::Types::STRUCT, :name => 'highlightOptions', :class => ::Blur::HighlightOptions}
    }

    def struct_fields; FIELDS; end

    def validate
    end

    ::Thrift::Struct.generate_accessors self
  end

  # FetchRowResult contains row result from a fetch.
  class FetchRowResult
    include ::Thrift::Struct, ::Thrift::Struct_Union
    ROW = 1

    FIELDS = {
      # The row fetched.
      ROW => {:type => ::Thrift::Types::STRUCT, :name => 'row', :class => ::Blur::Row}
    }

    def struct_fields; FIELDS; end

    def validate
    end

    ::Thrift::Struct.generate_accessors self
  end

  # FetchRecordResult contains rowid of the record and the record result from a fetch.
  class FetchRecordResult
    include ::Thrift::Struct, ::Thrift::Struct_Union
    ROWID = 1
    RECORD = 2

    FIELDS = {
      # The row id of the record being fetched.
      ROWID => {:type => ::Thrift::Types::STRING, :name => 'rowid'},
      # The record fetched.
      RECORD => {:type => ::Thrift::Types::STRUCT, :name => 'record', :class => ::Blur::Record}
    }

    def struct_fields; FIELDS; end

    def validate
    end

    ::Thrift::Struct.generate_accessors self
  end

  # FetchResult contains the row or record fetch result based if the Selector
# was going to fetch the entire row or a single record.
  class FetchResult
    include ::Thrift::Struct, ::Thrift::Struct_Union
    EXISTS = 1
    DELETED = 2
    TABLE = 3
    ROWRESULT = 4
    RECORDRESULT = 5

    FIELDS = {
      # True if the result exists, false if it doesn't.
      EXISTS => {:type => ::Thrift::Types::BOOL, :name => 'exists'},
      # If the row was marked as deleted.
      DELETED => {:type => ::Thrift::Types::BOOL, :name => 'deleted'},
      # The table the fetch result came from.
      TABLE => {:type => ::Thrift::Types::STRING, :name => 'table'},
      # The row result if a row was selected form the Selector.
      ROWRESULT => {:type => ::Thrift::Types::STRUCT, :name => 'rowResult', :class => ::Blur::FetchRowResult},
      # The record result if a record was selected form the Selector.
      RECORDRESULT => {:type => ::Thrift::Types::STRUCT, :name => 'recordResult', :class => ::Blur::FetchRecordResult}
    }

    def struct_fields; FIELDS; end

    def validate
    end

    ::Thrift::Struct.generate_accessors self
  end

  # Blur facet.
  class Facet
    include ::Thrift::Struct, ::Thrift::Struct_Union
    QUERYSTR = 1
    MINIMUMNUMBEROFBLURRESULTS = 2

    FIELDS = {
      # The facet query.
      QUERYSTR => {:type => ::Thrift::Types::STRING, :name => 'queryStr'},
      # The minimum number of results before no longer processing the facet.  This
# is a good way to decrease the strain on the system while using many facets. For
# example if you set this attribute to 1000, then the shard server will stop
# processing the facet at the 1000 mark.  However because this is processed at
# the shard server level the controller will likely return more than the minimum
# because it sums the answers from the shard servers.
      MINIMUMNUMBEROFBLURRESULTS => {:type => ::Thrift::Types::I64, :name => 'minimumNumberOfBlurResults', :default => 9223372036854775807}
    }

    def struct_fields; FIELDS; end

    def validate
    end

    ::Thrift::Struct.generate_accessors self
  end

  # The Blur Query object that contains the query that needs to be executed along
# with the query options.
  class BlurQuery
    include ::Thrift::Struct, ::Thrift::Struct_Union
    SIMPLEQUERY = 1
    FACETS = 3
    SELECTOR = 4
    USECACHEIFPRESENT = 6
    START = 7
    FETCH = 8
    MINIMUMNUMBEROFRESULTS = 9
    MAXQUERYTIME = 10
    UUID = 11
    USERCONTEXT = 12
    CACHERESULT = 13
    STARTTIME = 14

    FIELDS = {
      # The query information.
      SIMPLEQUERY => {:type => ::Thrift::Types::STRUCT, :name => 'simpleQuery', :class => ::Blur::SimpleQuery},
      # A list of Facets to execute with the given query.
      FACETS => {:type => ::Thrift::Types::LIST, :name => 'facets', :element => {:type => ::Thrift::Types::STRUCT, :class => ::Blur::Facet}},
      # Selector is used to fetch data in the search results, if null only location ids will be fetched.
      SELECTOR => {:type => ::Thrift::Types::STRUCT, :name => 'selector', :class => ::Blur::Selector},
      # Enabled by default to use a cached result if the query matches a previous run query with the
# configured amount of time.
      USECACHEIFPRESENT => {:type => ::Thrift::Types::BOOL, :name => 'useCacheIfPresent', :default => true},
      # The starting result position, 0 by default.
      START => {:type => ::Thrift::Types::I64, :name => 'start', :default => 0},
      # The number of fetched results, 10 by default.
      FETCH => {:type => ::Thrift::Types::I32, :name => 'fetch', :default => 10},
      # The minimum number of results to find before returning.
      MINIMUMNUMBEROFRESULTS => {:type => ::Thrift::Types::I64, :name => 'minimumNumberOfResults', :default => 9223372036854775807},
      # The maximum amount of time the query should execute before timing out.
      MAXQUERYTIME => {:type => ::Thrift::Types::I64, :name => 'maxQueryTime', :default => 9223372036854775807},
      # Sets the uuid of this query, this is normal set by the client so that the status
# of a running query can be found or the query can be canceled.
      UUID => {:type => ::Thrift::Types::I64, :name => 'uuid'},
      # Sets a user context, only used for logging at this point.
      USERCONTEXT => {:type => ::Thrift::Types::STRING, :name => 'userContext'},
      # Enabled by default to cache this result.  False would not cache the result.
      CACHERESULT => {:type => ::Thrift::Types::BOOL, :name => 'cacheResult', :default => true},
      # Sets the start time, if 0 the controller sets the time.
      STARTTIME => {:type => ::Thrift::Types::I64, :name => 'startTime', :default => 0}
    }

    def struct_fields; FIELDS; end

    def validate
    end

    ::Thrift::Struct.generate_accessors self
  end

  #  
  class BlurResult
    include ::Thrift::Struct, ::Thrift::Struct_Union
    LOCATIONID = 1
    SCORE = 2
    FETCHRESULT = 3

    FIELDS = {
      # WARNING: This is an internal only attribute and is not intended for use by clients.
      LOCATIONID => {:type => ::Thrift::Types::STRING, :name => 'locationId'},
      #  
      SCORE => {:type => ::Thrift::Types::DOUBLE, :name => 'score'},
      # 
      FETCHRESULT => {:type => ::Thrift::Types::STRUCT, :name => 'fetchResult', :class => ::Blur::FetchResult}
    }

    def struct_fields; FIELDS; end

    def validate
    end

    ::Thrift::Struct.generate_accessors self
  end

  # 
  class BlurResults
    include ::Thrift::Struct, ::Thrift::Struct_Union
    TOTALRESULTS = 1
    SHARDINFO = 2
    RESULTS = 3
    FACETCOUNTS = 4
    EXCEPTIONS = 5
    QUERY = 6

    FIELDS = {
      # 
      TOTALRESULTS => {:type => ::Thrift::Types::I64, :name => 'totalResults', :default => 0},
      # 
      SHARDINFO => {:type => ::Thrift::Types::MAP, :name => 'shardInfo', :key => {:type => ::Thrift::Types::STRING}, :value => {:type => ::Thrift::Types::I64}},
      # 
      RESULTS => {:type => ::Thrift::Types::LIST, :name => 'results', :element => {:type => ::Thrift::Types::STRUCT, :class => ::Blur::BlurResult}},
      # 
      FACETCOUNTS => {:type => ::Thrift::Types::LIST, :name => 'facetCounts', :element => {:type => ::Thrift::Types::I64}},
      # 
      EXCEPTIONS => {:type => ::Thrift::Types::LIST, :name => 'exceptions', :element => {:type => ::Thrift::Types::STRUCT, :class => ::Blur::BlurException}},
      # 
      QUERY => {:type => ::Thrift::Types::STRUCT, :name => 'query', :class => ::Blur::BlurQuery}
    }

    def struct_fields; FIELDS; end

    def validate
    end

    ::Thrift::Struct.generate_accessors self
  end

  # 
  class RecordMutation
    include ::Thrift::Struct, ::Thrift::Struct_Union
    RECORDMUTATIONTYPE = 1
    RECORD = 2

    FIELDS = {
      # 
      RECORDMUTATIONTYPE => {:type => ::Thrift::Types::I32, :name => 'recordMutationType', :enum_class => ::Blur::RecordMutationType},
      # 
      RECORD => {:type => ::Thrift::Types::STRUCT, :name => 'record', :class => ::Blur::Record}
    }

    def struct_fields; FIELDS; end

    def validate
      unless @recordMutationType.nil? || ::Blur::RecordMutationType::VALID_VALUES.include?(@recordMutationType)
        raise ::Thrift::ProtocolException.new(::Thrift::ProtocolException::UNKNOWN, 'Invalid value of field recordMutationType!')
      end
    end

    ::Thrift::Struct.generate_accessors self
  end

  # 
  class RowMutation
    include ::Thrift::Struct, ::Thrift::Struct_Union
    TABLE = 1
    ROWID = 2
    WAL = 3
    ROWMUTATIONTYPE = 4
    RECORDMUTATIONS = 5
    WAITTOBEVISIBLE = 6

    FIELDS = {
      # The that that the row mutation is to act upon.
      TABLE => {:type => ::Thrift::Types::STRING, :name => 'table'},
      # The row id that the row mutation is to act upon.
      ROWID => {:type => ::Thrift::Types::STRING, :name => 'rowId'},
      # Write ahead log, by default all updates are written to a write ahead log before the update is applied.  That way if a failure occurs before the index is committed the WAL can be replayed to recover any data that could have been lost.
      WAL => {:type => ::Thrift::Types::BOOL, :name => 'wal', :default => true},
      ROWMUTATIONTYPE => {:type => ::Thrift::Types::I32, :name => 'rowMutationType', :enum_class => ::Blur::RowMutationType},
      RECORDMUTATIONS => {:type => ::Thrift::Types::LIST, :name => 'recordMutations', :element => {:type => ::Thrift::Types::STRUCT, :class => ::Blur::RecordMutation}},
      # On mutate waits for the mutation to be visible to queries and fetch requests.
      WAITTOBEVISIBLE => {:type => ::Thrift::Types::BOOL, :name => 'waitToBeVisible', :default => false}
    }

    def struct_fields; FIELDS; end

    def validate
      unless @rowMutationType.nil? || ::Blur::RowMutationType::VALID_VALUES.include?(@rowMutationType)
        raise ::Thrift::ProtocolException.new(::Thrift::ProtocolException::UNKNOWN, 'Invalid value of field rowMutationType!')
      end
    end

    ::Thrift::Struct.generate_accessors self
  end

  # Holds the cpu time for a query executing on a single shard in a table.
  class CpuTime
    include ::Thrift::Struct, ::Thrift::Struct_Union
    CPUTIME = 1
    REALTIME = 2

    FIELDS = {
      # The total cpu time for the query on the given shard.
      CPUTIME => {:type => ::Thrift::Types::I64, :name => 'cpuTime'},
      # The real time of the query execution for a given shard.
      REALTIME => {:type => ::Thrift::Types::I64, :name => 'realTime'}
    }

    def struct_fields; FIELDS; end

    def validate
    end

    ::Thrift::Struct.generate_accessors self
  end

  # The BlurQueryStatus object hold the status of BlurQueries.  The state of the query
# (QueryState), the number of shards the query is executing against, the number of
# shards that are complete, etc.
  class BlurQueryStatus
    include ::Thrift::Struct, ::Thrift::Struct_Union
    QUERY = 1
    CPUTIMES = 2
    COMPLETESHARDS = 3
    TOTALSHARDS = 4
    STATE = 5
    UUID = 6
    STATUS = 7

    FIELDS = {
      # The original query.
      QUERY => {:type => ::Thrift::Types::STRUCT, :name => 'query', :class => ::Blur::BlurQuery},
      # A map of shard names to CpuTime, one for each shard in the table.
      CPUTIMES => {:type => ::Thrift::Types::MAP, :name => 'cpuTimes', :key => {:type => ::Thrift::Types::STRING}, :value => {:type => ::Thrift::Types::STRUCT, :class => ::Blur::CpuTime}},
      # The number of completed shards.  The shard server will respond with
# how many are complete on that server, while the controller will aggregate
# all the shard server completed totals together.
      COMPLETESHARDS => {:type => ::Thrift::Types::I32, :name => 'completeShards'},
      # The total number of shards that the query is executing against.  The shard
# server will respond with how many shards are being queried on that server, while
# the controller will aggregate all the shard server totals together.
      TOTALSHARDS => {:type => ::Thrift::Types::I32, :name => 'totalShards'},
      # The state of the query.  e.g. RUNNING, INTERRUPTED, COMPLETE
      STATE => {:type => ::Thrift::Types::I32, :name => 'state', :enum_class => ::Blur::QueryState},
      # The uuid of the query.
      UUID => {:type => ::Thrift::Types::I64, :name => 'uuid'},
      # The status of the query NOT_FOUND if uuid is not found else FOUND
      STATUS => {:type => ::Thrift::Types::I32, :name => 'status', :enum_class => ::Blur::Status}
    }

    def struct_fields; FIELDS; end

    def validate
      unless @state.nil? || ::Blur::QueryState::VALID_VALUES.include?(@state)
        raise ::Thrift::ProtocolException.new(::Thrift::ProtocolException::UNKNOWN, 'Invalid value of field state!')
      end
      unless @status.nil? || ::Blur::Status::VALID_VALUES.include?(@status)
        raise ::Thrift::ProtocolException.new(::Thrift::ProtocolException::UNKNOWN, 'Invalid value of field status!')
      end
    end

    ::Thrift::Struct.generate_accessors self
  end

  # 
  class TableStats
    include ::Thrift::Struct, ::Thrift::Struct_Union
    TABLENAME = 1
    BYTES = 2
    RECORDCOUNT = 3
    ROWCOUNT = 4
    QUERIES = 5

    FIELDS = {
      # 
      TABLENAME => {:type => ::Thrift::Types::STRING, :name => 'tableName'},
      # 
      BYTES => {:type => ::Thrift::Types::I64, :name => 'bytes'},
      # 
      RECORDCOUNT => {:type => ::Thrift::Types::I64, :name => 'recordCount'},
      # 
      ROWCOUNT => {:type => ::Thrift::Types::I64, :name => 'rowCount'},
      # 
      QUERIES => {:type => ::Thrift::Types::I64, :name => 'queries'}
    }

    def struct_fields; FIELDS; end

    def validate
    end

    ::Thrift::Struct.generate_accessors self
  end

  # The ColumnDefinition defines how a given Column should be interpreted (indexed/stored)
  class ColumnDefinition
    include ::Thrift::Struct, ::Thrift::Struct_Union
    FAMILY = 1
    COLUMNNAME = 2
    SUBCOLUMNNAME = 3
    FIELDLESSINDEXED = 4
    FIELDTYPE = 5
    PROPERTIES = 6

    FIELDS = {
      # Required. The family the this column existing within.
      FAMILY => {:type => ::Thrift::Types::STRING, :name => 'family'},
      # Required. The column name.
      COLUMNNAME => {:type => ::Thrift::Types::STRING, :name => 'columnName'},
      # If this column definition is for a sub column then provide the sub column name.  Otherwise leave this field null.
      SUBCOLUMNNAME => {:type => ::Thrift::Types::STRING, :name => 'subColumnName'},
      # If this column should be searchable without having to specify the name of the column in the query.
# NOTE: This will index the column as a full text field in a default field, so that means it's going to be indexed twice.
      FIELDLESSINDEXED => {:type => ::Thrift::Types::BOOL, :name => 'fieldLessIndexed'},
      # The field type for the column.  The built in types are:
# <ul>
# <li>text - Full text indexing.</li>
# <li>string - Indexed string literal</li>
# <li>int - Converted to an integer and indexed numerically.</li>
# <li>long - Converted to an long and indexed numerically.</li>
# <li>float - Converted to an float and indexed numerically.</li>
# <li>double - Converted to an double and indexed numerically.</li>
# <li>stored - Not indexed, only stored.</li>
# </ul>
      FIELDTYPE => {:type => ::Thrift::Types::STRING, :name => 'fieldType'},
      # For any custom field types, you can pass in configuration properties.
      PROPERTIES => {:type => ::Thrift::Types::MAP, :name => 'properties', :key => {:type => ::Thrift::Types::STRING}, :value => {:type => ::Thrift::Types::STRING}}
    }

    def struct_fields; FIELDS; end

    def validate
    end

    ::Thrift::Struct.generate_accessors self
  end

  # The current schema of the table.
  class Schema
    include ::Thrift::Struct, ::Thrift::Struct_Union
    TABLE = 1
    FAMILIES = 2

    FIELDS = {
      # The table name.
      TABLE => {:type => ::Thrift::Types::STRING, :name => 'table'},
      # Families and the column definitions within them.
      FAMILIES => {:type => ::Thrift::Types::MAP, :name => 'families', :key => {:type => ::Thrift::Types::STRING}, :value => {:type => ::Thrift::Types::MAP, :key => {:type => ::Thrift::Types::STRING}, :value => {:type => ::Thrift::Types::STRUCT, :class => ::Blur::ColumnDefinition}}}
    }

    def struct_fields; FIELDS; end

    def validate
    end

    ::Thrift::Struct.generate_accessors self
  end

  # The table descriptor defines the base structure of the table as well as properties need for setup.
  class TableDescriptor
    include ::Thrift::Struct, ::Thrift::Struct_Union
    ENABLED = 1
    SHARDCOUNT = 3
    TABLEURI = 4
    CLUSTER = 7
    NAME = 8
    SIMILARITYCLASS = 9
    BLOCKCACHING = 10
    BLOCKCACHINGFILETYPES = 11
    READONLY = 12
    PRECACHECOLS = 13
    TABLEPROPERTIES = 14
    STRICTTYPES = 15
    DEFAULTMISSINGFIELDTYPE = 16
    DEFAULTMISSINGFIELDLESSINDEXING = 17
    DEFAULTMISSINGFIELDPROPS = 18

    FIELDS = {
      # Is the table enabled or not, enabled by default.
      ENABLED => {:type => ::Thrift::Types::BOOL, :name => 'enabled', :default => true},
      # The number of shards within the given table.
      SHARDCOUNT => {:type => ::Thrift::Types::I32, :name => 'shardCount', :default => 1},
      # The location where the table should be stored this can be "file:///" for a local instance of Blur or "hdfs://" for a distributed installation of Blur.
      TABLEURI => {:type => ::Thrift::Types::STRING, :name => 'tableUri'},
      # The cluster where this table should be created.
      CLUSTER => {:type => ::Thrift::Types::STRING, :name => 'cluster', :default => %q"default"},
      # The table name.
      NAME => {:type => ::Thrift::Types::STRING, :name => 'name'},
      # Sets the similarity class in Lucene.
      SIMILARITYCLASS => {:type => ::Thrift::Types::STRING, :name => 'similarityClass'},
      # Should block cache be enable or disabled for this table.
      BLOCKCACHING => {:type => ::Thrift::Types::BOOL, :name => 'blockCaching', :default => true},
      # The files extensions that you would like to allow block cache to to cache.  If null (default) everything is cached.
      BLOCKCACHINGFILETYPES => {:type => ::Thrift::Types::SET, :name => 'blockCachingFileTypes', :element => {:type => ::Thrift::Types::STRING}},
      # If a table is set to be readonly, that means that mutates through Thrift are NOT allowed.  However
# updates through MapReduce are allowed and in fact they are only allowed if the table is in readOnly mode.
      READONLY => {:type => ::Thrift::Types::BOOL, :name => 'readOnly', :default => false},
      # This map sets what column families and columns to prefetch into block cache on shard open.
      PRECACHECOLS => {:type => ::Thrift::Types::LIST, :name => 'preCacheCols', :element => {:type => ::Thrift::Types::STRING}},
      # The table properties that can modify the default behavior of the table.  TODO: Document all options.
      TABLEPROPERTIES => {:type => ::Thrift::Types::MAP, :name => 'tableProperties', :key => {:type => ::Thrift::Types::STRING}, :value => {:type => ::Thrift::Types::STRING}},
      # Whether strict types are enabled or not (default).  If they are enabled no column can be added without first having it's type defined.
      STRICTTYPES => {:type => ::Thrift::Types::BOOL, :name => 'strictTypes', :default => false},
      # If strict is not enabled, the default field type.
      DEFAULTMISSINGFIELDTYPE => {:type => ::Thrift::Types::STRING, :name => 'defaultMissingFieldType', :default => %q"text"},
      # If strict is not enabled, defines whether or not field less indexing is enabled on the newly created fields.
      DEFAULTMISSINGFIELDLESSINDEXING => {:type => ::Thrift::Types::BOOL, :name => 'defaultMissingFieldLessIndexing', :default => true},
      # If strict is not enabled, defines the properties to be used in the new field creation.
      DEFAULTMISSINGFIELDPROPS => {:type => ::Thrift::Types::MAP, :name => 'defaultMissingFieldProps', :key => {:type => ::Thrift::Types::STRING}, :value => {:type => ::Thrift::Types::STRING}}
    }

    def struct_fields; FIELDS; end

    def validate
    end

    ::Thrift::Struct.generate_accessors self
  end

  # The Metric will hold all the information for a given Metric.
  class Metric
    include ::Thrift::Struct, ::Thrift::Struct_Union
    NAME = 1
    STRMAP = 2
    LONGMAP = 3
    DOUBLEMAP = 4

    FIELDS = {
      # metric name.
      NAME => {:type => ::Thrift::Types::STRING, :name => 'name'},
      # map of string values emitted by the Metric.
      STRMAP => {:type => ::Thrift::Types::MAP, :name => 'strMap', :key => {:type => ::Thrift::Types::STRING}, :value => {:type => ::Thrift::Types::STRING}},
      # map of long values emitted by the Metric.
      LONGMAP => {:type => ::Thrift::Types::MAP, :name => 'longMap', :key => {:type => ::Thrift::Types::STRING}, :value => {:type => ::Thrift::Types::I64}},
      # map of double values emitted by the Metric.
      DOUBLEMAP => {:type => ::Thrift::Types::MAP, :name => 'doubleMap', :key => {:type => ::Thrift::Types::STRING}, :value => {:type => ::Thrift::Types::DOUBLE}}
    }

    def struct_fields; FIELDS; end

    def validate
    end

    ::Thrift::Struct.generate_accessors self
  end

end
