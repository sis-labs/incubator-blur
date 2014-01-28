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



import org.apache.blur.thirdparty.thrift_0_9_0.scheme.IScheme;
import org.apache.blur.thirdparty.thrift_0_9_0.scheme.SchemeFactory;
import org.apache.blur.thirdparty.thrift_0_9_0.scheme.StandardScheme;

import org.apache.blur.thirdparty.thrift_0_9_0.scheme.TupleScheme;
import org.apache.blur.thirdparty.thrift_0_9_0.protocol.TTupleProtocol;
import org.apache.blur.thirdparty.thrift_0_9_0.protocol.TProtocolException;
import org.apache.blur.thirdparty.thrift_0_9_0.EncodingUtils;
import org.apache.blur.thirdparty.thrift_0_9_0.TException;
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
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

/**
 * The BlurResult carries the score, the location id and the fetched result (if any) form each query.
 */
public class BlurResult implements org.apache.blur.thirdparty.thrift_0_9_0.TBase<BlurResult, BlurResult._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.blur.thirdparty.thrift_0_9_0.protocol.TStruct STRUCT_DESC = new org.apache.blur.thirdparty.thrift_0_9_0.protocol.TStruct("BlurResult");

  private static final org.apache.blur.thirdparty.thrift_0_9_0.protocol.TField LOCATION_ID_FIELD_DESC = new org.apache.blur.thirdparty.thrift_0_9_0.protocol.TField("locationId", org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRING, (short)1);
  private static final org.apache.blur.thirdparty.thrift_0_9_0.protocol.TField SCORE_FIELD_DESC = new org.apache.blur.thirdparty.thrift_0_9_0.protocol.TField("score", org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.DOUBLE, (short)2);
  private static final org.apache.blur.thirdparty.thrift_0_9_0.protocol.TField FETCH_RESULT_FIELD_DESC = new org.apache.blur.thirdparty.thrift_0_9_0.protocol.TField("fetchResult", org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRUCT, (short)3);
  private static final org.apache.blur.thirdparty.thrift_0_9_0.protocol.TField SORT_FIELDS_FIELD_DESC = new org.apache.blur.thirdparty.thrift_0_9_0.protocol.TField("sortFields", org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.LIST, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new BlurResultStandardSchemeFactory());
    schemes.put(TupleScheme.class, new BlurResultTupleSchemeFactory());
  }

  /**
   * WARNING: This is an internal only attribute and is not intended for use by clients.
   */
  public String locationId; // required
  /**
   * The score for the hit in the query.
   */
  public double score; // required
  /**
   * The fetched result if any.
   */
  public FetchResult fetchResult; // required
  /**
   * The fields used for sorting.
   */
  public List<SortField> sortFields; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.blur.thirdparty.thrift_0_9_0.TFieldIdEnum {
    /**
     * WARNING: This is an internal only attribute and is not intended for use by clients.
     */
    LOCATION_ID((short)1, "locationId"),
    /**
     * The score for the hit in the query.
     */
    SCORE((short)2, "score"),
    /**
     * The fetched result if any.
     */
    FETCH_RESULT((short)3, "fetchResult"),
    /**
     * The fields used for sorting.
     */
    SORT_FIELDS((short)4, "sortFields");

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
        case 1: // LOCATION_ID
          return LOCATION_ID;
        case 2: // SCORE
          return SCORE;
        case 3: // FETCH_RESULT
          return FETCH_RESULT;
        case 4: // SORT_FIELDS
          return SORT_FIELDS;
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
  private static final int __SCORE_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.LOCATION_ID, new org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldMetaData("locationId", org.apache.blur.thirdparty.thrift_0_9_0.TFieldRequirementType.DEFAULT, 
        new org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldValueMetaData(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRING)));
    tmpMap.put(_Fields.SCORE, new org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldMetaData("score", org.apache.blur.thirdparty.thrift_0_9_0.TFieldRequirementType.DEFAULT, 
        new org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldValueMetaData(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.FETCH_RESULT, new org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldMetaData("fetchResult", org.apache.blur.thirdparty.thrift_0_9_0.TFieldRequirementType.DEFAULT, 
        new org.apache.blur.thirdparty.thrift_0_9_0.meta_data.StructMetaData(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRUCT, FetchResult.class)));
    tmpMap.put(_Fields.SORT_FIELDS, new org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldMetaData("sortFields", org.apache.blur.thirdparty.thrift_0_9_0.TFieldRequirementType.DEFAULT, 
        new org.apache.blur.thirdparty.thrift_0_9_0.meta_data.ListMetaData(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.LIST, 
            new org.apache.blur.thirdparty.thrift_0_9_0.meta_data.StructMetaData(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRUCT, SortField.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldMetaData.addStructMetaDataMap(BlurResult.class, metaDataMap);
  }

  public BlurResult() {
  }

  public BlurResult(
    String locationId,
    double score,
    FetchResult fetchResult,
    List<SortField> sortFields)
  {
    this();
    this.locationId = locationId;
    this.score = score;
    setScoreIsSet(true);
    this.fetchResult = fetchResult;
    this.sortFields = sortFields;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public BlurResult(BlurResult other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetLocationId()) {
      this.locationId = other.locationId;
    }
    this.score = other.score;
    if (other.isSetFetchResult()) {
      this.fetchResult = new FetchResult(other.fetchResult);
    }
    if (other.isSetSortFields()) {
      List<SortField> __this__sortFields = new ArrayList<SortField>();
      for (SortField other_element : other.sortFields) {
        __this__sortFields.add(new SortField(other_element));
      }
      this.sortFields = __this__sortFields;
    }
  }

  public BlurResult deepCopy() {
    return new BlurResult(this);
  }

  @Override
  public void clear() {
    this.locationId = null;
    setScoreIsSet(false);
    this.score = 0.0;
    this.fetchResult = null;
    this.sortFields = null;
  }

  /**
   * WARNING: This is an internal only attribute and is not intended for use by clients.
   */
  public String getLocationId() {
    return this.locationId;
  }

  /**
   * WARNING: This is an internal only attribute and is not intended for use by clients.
   */
  public BlurResult setLocationId(String locationId) {
    this.locationId = locationId;
    return this;
  }

  public void unsetLocationId() {
    this.locationId = null;
  }

  /** Returns true if field locationId is set (has been assigned a value) and false otherwise */
  public boolean isSetLocationId() {
    return this.locationId != null;
  }

  public void setLocationIdIsSet(boolean value) {
    if (!value) {
      this.locationId = null;
    }
  }

  /**
   * The score for the hit in the query.
   */
  public double getScore() {
    return this.score;
  }

  /**
   * The score for the hit in the query.
   */
  public BlurResult setScore(double score) {
    this.score = score;
    setScoreIsSet(true);
    return this;
  }

  public void unsetScore() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __SCORE_ISSET_ID);
  }

  /** Returns true if field score is set (has been assigned a value) and false otherwise */
  public boolean isSetScore() {
    return EncodingUtils.testBit(__isset_bitfield, __SCORE_ISSET_ID);
  }

  public void setScoreIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __SCORE_ISSET_ID, value);
  }

  /**
   * The fetched result if any.
   */
  public FetchResult getFetchResult() {
    return this.fetchResult;
  }

  /**
   * The fetched result if any.
   */
  public BlurResult setFetchResult(FetchResult fetchResult) {
    this.fetchResult = fetchResult;
    return this;
  }

  public void unsetFetchResult() {
    this.fetchResult = null;
  }

  /** Returns true if field fetchResult is set (has been assigned a value) and false otherwise */
  public boolean isSetFetchResult() {
    return this.fetchResult != null;
  }

  public void setFetchResultIsSet(boolean value) {
    if (!value) {
      this.fetchResult = null;
    }
  }

  public int getSortFieldsSize() {
    return (this.sortFields == null) ? 0 : this.sortFields.size();
  }

  public java.util.Iterator<SortField> getSortFieldsIterator() {
    return (this.sortFields == null) ? null : this.sortFields.iterator();
  }

  public void addToSortFields(SortField elem) {
    if (this.sortFields == null) {
      this.sortFields = new ArrayList<SortField>();
    }
    this.sortFields.add(elem);
  }

  /**
   * The fields used for sorting.
   */
  public List<SortField> getSortFields() {
    return this.sortFields;
  }

  /**
   * The fields used for sorting.
   */
  public BlurResult setSortFields(List<SortField> sortFields) {
    this.sortFields = sortFields;
    return this;
  }

  public void unsetSortFields() {
    this.sortFields = null;
  }

  /** Returns true if field sortFields is set (has been assigned a value) and false otherwise */
  public boolean isSetSortFields() {
    return this.sortFields != null;
  }

  public void setSortFieldsIsSet(boolean value) {
    if (!value) {
      this.sortFields = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case LOCATION_ID:
      if (value == null) {
        unsetLocationId();
      } else {
        setLocationId((String)value);
      }
      break;

    case SCORE:
      if (value == null) {
        unsetScore();
      } else {
        setScore((Double)value);
      }
      break;

    case FETCH_RESULT:
      if (value == null) {
        unsetFetchResult();
      } else {
        setFetchResult((FetchResult)value);
      }
      break;

    case SORT_FIELDS:
      if (value == null) {
        unsetSortFields();
      } else {
        setSortFields((List<SortField>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case LOCATION_ID:
      return getLocationId();

    case SCORE:
      return Double.valueOf(getScore());

    case FETCH_RESULT:
      return getFetchResult();

    case SORT_FIELDS:
      return getSortFields();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case LOCATION_ID:
      return isSetLocationId();
    case SCORE:
      return isSetScore();
    case FETCH_RESULT:
      return isSetFetchResult();
    case SORT_FIELDS:
      return isSetSortFields();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof BlurResult)
      return this.equals((BlurResult)that);
    return false;
  }

  public boolean equals(BlurResult that) {
    if (that == null)
      return false;

    boolean this_present_locationId = true && this.isSetLocationId();
    boolean that_present_locationId = true && that.isSetLocationId();
    if (this_present_locationId || that_present_locationId) {
      if (!(this_present_locationId && that_present_locationId))
        return false;
      if (!this.locationId.equals(that.locationId))
        return false;
    }

    boolean this_present_score = true;
    boolean that_present_score = true;
    if (this_present_score || that_present_score) {
      if (!(this_present_score && that_present_score))
        return false;
      if (this.score != that.score)
        return false;
    }

    boolean this_present_fetchResult = true && this.isSetFetchResult();
    boolean that_present_fetchResult = true && that.isSetFetchResult();
    if (this_present_fetchResult || that_present_fetchResult) {
      if (!(this_present_fetchResult && that_present_fetchResult))
        return false;
      if (!this.fetchResult.equals(that.fetchResult))
        return false;
    }

    boolean this_present_sortFields = true && this.isSetSortFields();
    boolean that_present_sortFields = true && that.isSetSortFields();
    if (this_present_sortFields || that_present_sortFields) {
      if (!(this_present_sortFields && that_present_sortFields))
        return false;
      if (!this.sortFields.equals(that.sortFields))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(BlurResult other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    BlurResult typedOther = (BlurResult)other;

    lastComparison = Boolean.valueOf(isSetLocationId()).compareTo(typedOther.isSetLocationId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLocationId()) {
      lastComparison = org.apache.blur.thirdparty.thrift_0_9_0.TBaseHelper.compareTo(this.locationId, typedOther.locationId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetScore()).compareTo(typedOther.isSetScore());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetScore()) {
      lastComparison = org.apache.blur.thirdparty.thrift_0_9_0.TBaseHelper.compareTo(this.score, typedOther.score);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFetchResult()).compareTo(typedOther.isSetFetchResult());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFetchResult()) {
      lastComparison = org.apache.blur.thirdparty.thrift_0_9_0.TBaseHelper.compareTo(this.fetchResult, typedOther.fetchResult);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSortFields()).compareTo(typedOther.isSetSortFields());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSortFields()) {
      lastComparison = org.apache.blur.thirdparty.thrift_0_9_0.TBaseHelper.compareTo(this.sortFields, typedOther.sortFields);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TProtocol iprot) throws org.apache.blur.thirdparty.thrift_0_9_0.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TProtocol oprot) throws org.apache.blur.thirdparty.thrift_0_9_0.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("BlurResult(");
    boolean first = true;

    sb.append("locationId:");
    if (this.locationId == null) {
      sb.append("null");
    } else {
      sb.append(this.locationId);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("score:");
    sb.append(this.score);
    first = false;
    if (!first) sb.append(", ");
    sb.append("fetchResult:");
    if (this.fetchResult == null) {
      sb.append("null");
    } else {
      sb.append(this.fetchResult);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("sortFields:");
    if (this.sortFields == null) {
      sb.append("null");
    } else {
      sb.append(this.sortFields);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.blur.thirdparty.thrift_0_9_0.TException {
    // check for required fields
    // check for sub-struct validity
    if (fetchResult != null) {
      fetchResult.validate();
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.blur.thirdparty.thrift_0_9_0.protocol.TCompactProtocol(new org.apache.blur.thirdparty.thrift_0_9_0.transport.TIOStreamTransport(out)));
    } catch (org.apache.blur.thirdparty.thrift_0_9_0.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.blur.thirdparty.thrift_0_9_0.protocol.TCompactProtocol(new org.apache.blur.thirdparty.thrift_0_9_0.transport.TIOStreamTransport(in)));
    } catch (org.apache.blur.thirdparty.thrift_0_9_0.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class BlurResultStandardSchemeFactory implements SchemeFactory {
    public BlurResultStandardScheme getScheme() {
      return new BlurResultStandardScheme();
    }
  }

  private static class BlurResultStandardScheme extends StandardScheme<BlurResult> {

    public void read(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TProtocol iprot, BlurResult struct) throws org.apache.blur.thirdparty.thrift_0_9_0.TException {
      org.apache.blur.thirdparty.thrift_0_9_0.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // LOCATION_ID
            if (schemeField.type == org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRING) {
              struct.locationId = iprot.readString();
              struct.setLocationIdIsSet(true);
            } else { 
              org.apache.blur.thirdparty.thrift_0_9_0.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // SCORE
            if (schemeField.type == org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.DOUBLE) {
              struct.score = iprot.readDouble();
              struct.setScoreIsSet(true);
            } else { 
              org.apache.blur.thirdparty.thrift_0_9_0.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // FETCH_RESULT
            if (schemeField.type == org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRUCT) {
              struct.fetchResult = new FetchResult();
              struct.fetchResult.read(iprot);
              struct.setFetchResultIsSet(true);
            } else { 
              org.apache.blur.thirdparty.thrift_0_9_0.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // SORT_FIELDS
            if (schemeField.type == org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.LIST) {
              {
                org.apache.blur.thirdparty.thrift_0_9_0.protocol.TList _list58 = iprot.readListBegin();
                struct.sortFields = new ArrayList<SortField>(_list58.size);
                for (int _i59 = 0; _i59 < _list58.size; ++_i59)
                {
                  SortField _elem60; // required
                  _elem60 = new SortField();
                  _elem60.read(iprot);
                  struct.sortFields.add(_elem60);
                }
                iprot.readListEnd();
              }
              struct.setSortFieldsIsSet(true);
            } else { 
              org.apache.blur.thirdparty.thrift_0_9_0.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.blur.thirdparty.thrift_0_9_0.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TProtocol oprot, BlurResult struct) throws org.apache.blur.thirdparty.thrift_0_9_0.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.locationId != null) {
        oprot.writeFieldBegin(LOCATION_ID_FIELD_DESC);
        oprot.writeString(struct.locationId);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(SCORE_FIELD_DESC);
      oprot.writeDouble(struct.score);
      oprot.writeFieldEnd();
      if (struct.fetchResult != null) {
        oprot.writeFieldBegin(FETCH_RESULT_FIELD_DESC);
        struct.fetchResult.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.sortFields != null) {
        oprot.writeFieldBegin(SORT_FIELDS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.blur.thirdparty.thrift_0_9_0.protocol.TList(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRUCT, struct.sortFields.size()));
          for (SortField _iter61 : struct.sortFields)
          {
            _iter61.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class BlurResultTupleSchemeFactory implements SchemeFactory {
    public BlurResultTupleScheme getScheme() {
      return new BlurResultTupleScheme();
    }
  }

  private static class BlurResultTupleScheme extends TupleScheme<BlurResult> {

    @Override
    public void write(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TProtocol prot, BlurResult struct) throws org.apache.blur.thirdparty.thrift_0_9_0.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetLocationId()) {
        optionals.set(0);
      }
      if (struct.isSetScore()) {
        optionals.set(1);
      }
      if (struct.isSetFetchResult()) {
        optionals.set(2);
      }
      if (struct.isSetSortFields()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetLocationId()) {
        oprot.writeString(struct.locationId);
      }
      if (struct.isSetScore()) {
        oprot.writeDouble(struct.score);
      }
      if (struct.isSetFetchResult()) {
        struct.fetchResult.write(oprot);
      }
      if (struct.isSetSortFields()) {
        {
          oprot.writeI32(struct.sortFields.size());
          for (SortField _iter62 : struct.sortFields)
          {
            _iter62.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TProtocol prot, BlurResult struct) throws org.apache.blur.thirdparty.thrift_0_9_0.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.locationId = iprot.readString();
        struct.setLocationIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.score = iprot.readDouble();
        struct.setScoreIsSet(true);
      }
      if (incoming.get(2)) {
        struct.fetchResult = new FetchResult();
        struct.fetchResult.read(iprot);
        struct.setFetchResultIsSet(true);
      }
      if (incoming.get(3)) {
        {
          org.apache.blur.thirdparty.thrift_0_9_0.protocol.TList _list63 = new org.apache.blur.thirdparty.thrift_0_9_0.protocol.TList(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRUCT, iprot.readI32());
          struct.sortFields = new ArrayList<SortField>(_list63.size);
          for (int _i64 = 0; _i64 < _list63.size; ++_i64)
          {
            SortField _elem65; // required
            _elem65 = new SortField();
            _elem65.read(iprot);
            struct.sortFields.add(_elem65);
          }
        }
        struct.setSortFieldsIsSet(true);
      }
    }
  }

}

