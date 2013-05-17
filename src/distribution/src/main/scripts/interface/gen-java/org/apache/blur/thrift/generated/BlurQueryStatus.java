/**
 * Autogenerated by Thrift Compiler (0.9.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.blur.thrift.generated;

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



import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 */
public class BlurQueryStatus implements org.apache.thrift.TBase<BlurQueryStatus, BlurQueryStatus._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("BlurQueryStatus");

  private static final org.apache.thrift.protocol.TField QUERY_FIELD_DESC = new org.apache.thrift.protocol.TField("query", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField CPU_TIMES_FIELD_DESC = new org.apache.thrift.protocol.TField("cpuTimes", org.apache.thrift.protocol.TType.MAP, (short)2);
  private static final org.apache.thrift.protocol.TField COMPLETE_SHARDS_FIELD_DESC = new org.apache.thrift.protocol.TField("completeShards", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField TOTAL_SHARDS_FIELD_DESC = new org.apache.thrift.protocol.TField("totalShards", org.apache.thrift.protocol.TType.I32, (short)4);
  private static final org.apache.thrift.protocol.TField STATE_FIELD_DESC = new org.apache.thrift.protocol.TField("state", org.apache.thrift.protocol.TType.I32, (short)5);
  private static final org.apache.thrift.protocol.TField UUID_FIELD_DESC = new org.apache.thrift.protocol.TField("uuid", org.apache.thrift.protocol.TType.I64, (short)6);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new BlurQueryStatusStandardSchemeFactory());
    schemes.put(TupleScheme.class, new BlurQueryStatusTupleSchemeFactory());
  }

  /**
   * 
   */
  public BlurQuery query; // required
  /**
   * 
   */
  public Map<String,CpuTime> cpuTimes; // required
  /**
   * 
   */
  public int completeShards; // required
  /**
   * 
   */
  public int totalShards; // required
  /**
   * 
   * 
   * @see QueryState
   */
  public QueryState state; // required
  /**
   * 
   */
  public long uuid; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 
     */
    QUERY((short)1, "query"),
    /**
     * 
     */
    CPU_TIMES((short)2, "cpuTimes"),
    /**
     * 
     */
    COMPLETE_SHARDS((short)3, "completeShards"),
    /**
     * 
     */
    TOTAL_SHARDS((short)4, "totalShards"),
    /**
     * 
     * 
     * @see QueryState
     */
    STATE((short)5, "state"),
    /**
     * 
     */
    UUID((short)6, "uuid");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // QUERY
          return QUERY;
        case 2: // CPU_TIMES
          return CPU_TIMES;
        case 3: // COMPLETE_SHARDS
          return COMPLETE_SHARDS;
        case 4: // TOTAL_SHARDS
          return TOTAL_SHARDS;
        case 5: // STATE
          return STATE;
        case 6: // UUID
          return UUID;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __COMPLETESHARDS_ISSET_ID = 0;
  private static final int __TOTALSHARDS_ISSET_ID = 1;
  private static final int __UUID_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.QUERY, new org.apache.thrift.meta_data.FieldMetaData("query", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, BlurQuery.class)));
    tmpMap.put(_Fields.CPU_TIMES, new org.apache.thrift.meta_data.FieldMetaData("cpuTimes", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING), 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, CpuTime.class))));
    tmpMap.put(_Fields.COMPLETE_SHARDS, new org.apache.thrift.meta_data.FieldMetaData("completeShards", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.TOTAL_SHARDS, new org.apache.thrift.meta_data.FieldMetaData("totalShards", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.STATE, new org.apache.thrift.meta_data.FieldMetaData("state", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, QueryState.class)));
    tmpMap.put(_Fields.UUID, new org.apache.thrift.meta_data.FieldMetaData("uuid", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(BlurQueryStatus.class, metaDataMap);
  }

  public BlurQueryStatus() {
  }

  public BlurQueryStatus(
    BlurQuery query,
    Map<String,CpuTime> cpuTimes,
    int completeShards,
    int totalShards,
    QueryState state,
    long uuid)
  {
    this();
    this.query = query;
    this.cpuTimes = cpuTimes;
    this.completeShards = completeShards;
    setCompleteShardsIsSet(true);
    this.totalShards = totalShards;
    setTotalShardsIsSet(true);
    this.state = state;
    this.uuid = uuid;
    setUuidIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public BlurQueryStatus(BlurQueryStatus other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetQuery()) {
      this.query = new BlurQuery(other.query);
    }
    if (other.isSetCpuTimes()) {
      Map<String,CpuTime> __this__cpuTimes = new HashMap<String,CpuTime>();
      for (Map.Entry<String, CpuTime> other_element : other.cpuTimes.entrySet()) {

        String other_element_key = other_element.getKey();
        CpuTime other_element_value = other_element.getValue();

        String __this__cpuTimes_copy_key = other_element_key;

        CpuTime __this__cpuTimes_copy_value = new CpuTime(other_element_value);

        __this__cpuTimes.put(__this__cpuTimes_copy_key, __this__cpuTimes_copy_value);
      }
      this.cpuTimes = __this__cpuTimes;
    }
    this.completeShards = other.completeShards;
    this.totalShards = other.totalShards;
    if (other.isSetState()) {
      this.state = other.state;
    }
    this.uuid = other.uuid;
  }

  public BlurQueryStatus deepCopy() {
    return new BlurQueryStatus(this);
  }

  @Override
  public void clear() {
    this.query = null;
    this.cpuTimes = null;
    setCompleteShardsIsSet(false);
    this.completeShards = 0;
    setTotalShardsIsSet(false);
    this.totalShards = 0;
    this.state = null;
    setUuidIsSet(false);
    this.uuid = 0;
  }

  /**
   * 
   */
  public BlurQuery getQuery() {
    return this.query;
  }

  /**
   * 
   */
  public BlurQueryStatus setQuery(BlurQuery query) {
    this.query = query;
    return this;
  }

  public void unsetQuery() {
    this.query = null;
  }

  /** Returns true if field query is set (has been assigned a value) and false otherwise */
  public boolean isSetQuery() {
    return this.query != null;
  }

  public void setQueryIsSet(boolean value) {
    if (!value) {
      this.query = null;
    }
  }

  public int getCpuTimesSize() {
    return (this.cpuTimes == null) ? 0 : this.cpuTimes.size();
  }

  public void putToCpuTimes(String key, CpuTime val) {
    if (this.cpuTimes == null) {
      this.cpuTimes = new HashMap<String,CpuTime>();
    }
    this.cpuTimes.put(key, val);
  }

  /**
   * 
   */
  public Map<String,CpuTime> getCpuTimes() {
    return this.cpuTimes;
  }

  /**
   * 
   */
  public BlurQueryStatus setCpuTimes(Map<String,CpuTime> cpuTimes) {
    this.cpuTimes = cpuTimes;
    return this;
  }

  public void unsetCpuTimes() {
    this.cpuTimes = null;
  }

  /** Returns true if field cpuTimes is set (has been assigned a value) and false otherwise */
  public boolean isSetCpuTimes() {
    return this.cpuTimes != null;
  }

  public void setCpuTimesIsSet(boolean value) {
    if (!value) {
      this.cpuTimes = null;
    }
  }

  /**
   * 
   */
  public int getCompleteShards() {
    return this.completeShards;
  }

  /**
   * 
   */
  public BlurQueryStatus setCompleteShards(int completeShards) {
    this.completeShards = completeShards;
    setCompleteShardsIsSet(true);
    return this;
  }

  public void unsetCompleteShards() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __COMPLETESHARDS_ISSET_ID);
  }

  /** Returns true if field completeShards is set (has been assigned a value) and false otherwise */
  public boolean isSetCompleteShards() {
    return EncodingUtils.testBit(__isset_bitfield, __COMPLETESHARDS_ISSET_ID);
  }

  public void setCompleteShardsIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __COMPLETESHARDS_ISSET_ID, value);
  }

  /**
   * 
   */
  public int getTotalShards() {
    return this.totalShards;
  }

  /**
   * 
   */
  public BlurQueryStatus setTotalShards(int totalShards) {
    this.totalShards = totalShards;
    setTotalShardsIsSet(true);
    return this;
  }

  public void unsetTotalShards() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __TOTALSHARDS_ISSET_ID);
  }

  /** Returns true if field totalShards is set (has been assigned a value) and false otherwise */
  public boolean isSetTotalShards() {
    return EncodingUtils.testBit(__isset_bitfield, __TOTALSHARDS_ISSET_ID);
  }

  public void setTotalShardsIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __TOTALSHARDS_ISSET_ID, value);
  }

  /**
   * 
   * 
   * @see QueryState
   */
  public QueryState getState() {
    return this.state;
  }

  /**
   * 
   * 
   * @see QueryState
   */
  public BlurQueryStatus setState(QueryState state) {
    this.state = state;
    return this;
  }

  public void unsetState() {
    this.state = null;
  }

  /** Returns true if field state is set (has been assigned a value) and false otherwise */
  public boolean isSetState() {
    return this.state != null;
  }

  public void setStateIsSet(boolean value) {
    if (!value) {
      this.state = null;
    }
  }

  /**
   * 
   */
  public long getUuid() {
    return this.uuid;
  }

  /**
   * 
   */
  public BlurQueryStatus setUuid(long uuid) {
    this.uuid = uuid;
    setUuidIsSet(true);
    return this;
  }

  public void unsetUuid() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __UUID_ISSET_ID);
  }

  /** Returns true if field uuid is set (has been assigned a value) and false otherwise */
  public boolean isSetUuid() {
    return EncodingUtils.testBit(__isset_bitfield, __UUID_ISSET_ID);
  }

  public void setUuidIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __UUID_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case QUERY:
      if (value == null) {
        unsetQuery();
      } else {
        setQuery((BlurQuery)value);
      }
      break;

    case CPU_TIMES:
      if (value == null) {
        unsetCpuTimes();
      } else {
        setCpuTimes((Map<String,CpuTime>)value);
      }
      break;

    case COMPLETE_SHARDS:
      if (value == null) {
        unsetCompleteShards();
      } else {
        setCompleteShards((Integer)value);
      }
      break;

    case TOTAL_SHARDS:
      if (value == null) {
        unsetTotalShards();
      } else {
        setTotalShards((Integer)value);
      }
      break;

    case STATE:
      if (value == null) {
        unsetState();
      } else {
        setState((QueryState)value);
      }
      break;

    case UUID:
      if (value == null) {
        unsetUuid();
      } else {
        setUuid((Long)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case QUERY:
      return getQuery();

    case CPU_TIMES:
      return getCpuTimes();

    case COMPLETE_SHARDS:
      return Integer.valueOf(getCompleteShards());

    case TOTAL_SHARDS:
      return Integer.valueOf(getTotalShards());

    case STATE:
      return getState();

    case UUID:
      return Long.valueOf(getUuid());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case QUERY:
      return isSetQuery();
    case CPU_TIMES:
      return isSetCpuTimes();
    case COMPLETE_SHARDS:
      return isSetCompleteShards();
    case TOTAL_SHARDS:
      return isSetTotalShards();
    case STATE:
      return isSetState();
    case UUID:
      return isSetUuid();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof BlurQueryStatus)
      return this.equals((BlurQueryStatus)that);
    return false;
  }

  public boolean equals(BlurQueryStatus that) {
    if (that == null)
      return false;

    boolean this_present_query = true && this.isSetQuery();
    boolean that_present_query = true && that.isSetQuery();
    if (this_present_query || that_present_query) {
      if (!(this_present_query && that_present_query))
        return false;
      if (!this.query.equals(that.query))
        return false;
    }

    boolean this_present_cpuTimes = true && this.isSetCpuTimes();
    boolean that_present_cpuTimes = true && that.isSetCpuTimes();
    if (this_present_cpuTimes || that_present_cpuTimes) {
      if (!(this_present_cpuTimes && that_present_cpuTimes))
        return false;
      if (!this.cpuTimes.equals(that.cpuTimes))
        return false;
    }

    boolean this_present_completeShards = true;
    boolean that_present_completeShards = true;
    if (this_present_completeShards || that_present_completeShards) {
      if (!(this_present_completeShards && that_present_completeShards))
        return false;
      if (this.completeShards != that.completeShards)
        return false;
    }

    boolean this_present_totalShards = true;
    boolean that_present_totalShards = true;
    if (this_present_totalShards || that_present_totalShards) {
      if (!(this_present_totalShards && that_present_totalShards))
        return false;
      if (this.totalShards != that.totalShards)
        return false;
    }

    boolean this_present_state = true && this.isSetState();
    boolean that_present_state = true && that.isSetState();
    if (this_present_state || that_present_state) {
      if (!(this_present_state && that_present_state))
        return false;
      if (!this.state.equals(that.state))
        return false;
    }

    boolean this_present_uuid = true;
    boolean that_present_uuid = true;
    if (this_present_uuid || that_present_uuid) {
      if (!(this_present_uuid && that_present_uuid))
        return false;
      if (this.uuid != that.uuid)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(BlurQueryStatus other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    BlurQueryStatus typedOther = (BlurQueryStatus)other;

    lastComparison = Boolean.valueOf(isSetQuery()).compareTo(typedOther.isSetQuery());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetQuery()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.query, typedOther.query);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCpuTimes()).compareTo(typedOther.isSetCpuTimes());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCpuTimes()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.cpuTimes, typedOther.cpuTimes);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCompleteShards()).compareTo(typedOther.isSetCompleteShards());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCompleteShards()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.completeShards, typedOther.completeShards);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTotalShards()).compareTo(typedOther.isSetTotalShards());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTotalShards()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.totalShards, typedOther.totalShards);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetState()).compareTo(typedOther.isSetState());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetState()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.state, typedOther.state);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUuid()).compareTo(typedOther.isSetUuid());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUuid()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.uuid, typedOther.uuid);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("BlurQueryStatus(");
    boolean first = true;

    sb.append("query:");
    if (this.query == null) {
      sb.append("null");
    } else {
      sb.append(this.query);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("cpuTimes:");
    if (this.cpuTimes == null) {
      sb.append("null");
    } else {
      sb.append(this.cpuTimes);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("completeShards:");
    sb.append(this.completeShards);
    first = false;
    if (!first) sb.append(", ");
    sb.append("totalShards:");
    sb.append(this.totalShards);
    first = false;
    if (!first) sb.append(", ");
    sb.append("state:");
    if (this.state == null) {
      sb.append("null");
    } else {
      sb.append(this.state);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("uuid:");
    sb.append(this.uuid);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (query != null) {
      query.validate();
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class BlurQueryStatusStandardSchemeFactory implements SchemeFactory {
    public BlurQueryStatusStandardScheme getScheme() {
      return new BlurQueryStatusStandardScheme();
    }
  }

  private static class BlurQueryStatusStandardScheme extends StandardScheme<BlurQueryStatus> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, BlurQueryStatus struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // QUERY
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.query = new BlurQuery();
              struct.query.read(iprot);
              struct.setQueryIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // CPU_TIMES
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map92 = iprot.readMapBegin();
                struct.cpuTimes = new HashMap<String,CpuTime>(2*_map92.size);
                for (int _i93 = 0; _i93 < _map92.size; ++_i93)
                {
                  String _key94; // required
                  CpuTime _val95; // optional
                  _key94 = iprot.readString();
                  _val95 = new CpuTime();
                  _val95.read(iprot);
                  struct.cpuTimes.put(_key94, _val95);
                }
                iprot.readMapEnd();
              }
              struct.setCpuTimesIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // COMPLETE_SHARDS
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.completeShards = iprot.readI32();
              struct.setCompleteShardsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // TOTAL_SHARDS
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.totalShards = iprot.readI32();
              struct.setTotalShardsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // STATE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.state = QueryState.findByValue(iprot.readI32());
              struct.setStateIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // UUID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.uuid = iprot.readI64();
              struct.setUuidIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, BlurQueryStatus struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.query != null) {
        oprot.writeFieldBegin(QUERY_FIELD_DESC);
        struct.query.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.cpuTimes != null) {
        oprot.writeFieldBegin(CPU_TIMES_FIELD_DESC);
        {
          oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRUCT, struct.cpuTimes.size()));
          for (Map.Entry<String, CpuTime> _iter96 : struct.cpuTimes.entrySet())
          {
            oprot.writeString(_iter96.getKey());
            _iter96.getValue().write(oprot);
          }
          oprot.writeMapEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(COMPLETE_SHARDS_FIELD_DESC);
      oprot.writeI32(struct.completeShards);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(TOTAL_SHARDS_FIELD_DESC);
      oprot.writeI32(struct.totalShards);
      oprot.writeFieldEnd();
      if (struct.state != null) {
        oprot.writeFieldBegin(STATE_FIELD_DESC);
        oprot.writeI32(struct.state.getValue());
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(UUID_FIELD_DESC);
      oprot.writeI64(struct.uuid);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class BlurQueryStatusTupleSchemeFactory implements SchemeFactory {
    public BlurQueryStatusTupleScheme getScheme() {
      return new BlurQueryStatusTupleScheme();
    }
  }

  private static class BlurQueryStatusTupleScheme extends TupleScheme<BlurQueryStatus> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, BlurQueryStatus struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetQuery()) {
        optionals.set(0);
      }
      if (struct.isSetCpuTimes()) {
        optionals.set(1);
      }
      if (struct.isSetCompleteShards()) {
        optionals.set(2);
      }
      if (struct.isSetTotalShards()) {
        optionals.set(3);
      }
      if (struct.isSetState()) {
        optionals.set(4);
      }
      if (struct.isSetUuid()) {
        optionals.set(5);
      }
      oprot.writeBitSet(optionals, 6);
      if (struct.isSetQuery()) {
        struct.query.write(oprot);
      }
      if (struct.isSetCpuTimes()) {
        {
          oprot.writeI32(struct.cpuTimes.size());
          for (Map.Entry<String, CpuTime> _iter97 : struct.cpuTimes.entrySet())
          {
            oprot.writeString(_iter97.getKey());
            _iter97.getValue().write(oprot);
          }
        }
      }
      if (struct.isSetCompleteShards()) {
        oprot.writeI32(struct.completeShards);
      }
      if (struct.isSetTotalShards()) {
        oprot.writeI32(struct.totalShards);
      }
      if (struct.isSetState()) {
        oprot.writeI32(struct.state.getValue());
      }
      if (struct.isSetUuid()) {
        oprot.writeI64(struct.uuid);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, BlurQueryStatus struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(6);
      if (incoming.get(0)) {
        struct.query = new BlurQuery();
        struct.query.read(iprot);
        struct.setQueryIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TMap _map98 = new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.cpuTimes = new HashMap<String,CpuTime>(2*_map98.size);
          for (int _i99 = 0; _i99 < _map98.size; ++_i99)
          {
            String _key100; // required
            CpuTime _val101; // optional
            _key100 = iprot.readString();
            _val101 = new CpuTime();
            _val101.read(iprot);
            struct.cpuTimes.put(_key100, _val101);
          }
        }
        struct.setCpuTimesIsSet(true);
      }
      if (incoming.get(2)) {
        struct.completeShards = iprot.readI32();
        struct.setCompleteShardsIsSet(true);
      }
      if (incoming.get(3)) {
        struct.totalShards = iprot.readI32();
        struct.setTotalShardsIsSet(true);
      }
      if (incoming.get(4)) {
        struct.state = QueryState.findByValue(iprot.readI32());
        struct.setStateIsSet(true);
      }
      if (incoming.get(5)) {
        struct.uuid = iprot.readI64();
        struct.setUuidIsSet(true);
      }
    }
  }

}
