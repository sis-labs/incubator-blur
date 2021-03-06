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
 * The current schema of the table.
 */
public class Schema implements org.apache.blur.thirdparty.thrift_0_9_0.TBase<Schema, Schema._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.blur.thirdparty.thrift_0_9_0.protocol.TStruct STRUCT_DESC = new org.apache.blur.thirdparty.thrift_0_9_0.protocol.TStruct("Schema");

  private static final org.apache.blur.thirdparty.thrift_0_9_0.protocol.TField TABLE_FIELD_DESC = new org.apache.blur.thirdparty.thrift_0_9_0.protocol.TField("table", org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRING, (short)1);
  private static final org.apache.blur.thirdparty.thrift_0_9_0.protocol.TField FAMILIES_FIELD_DESC = new org.apache.blur.thirdparty.thrift_0_9_0.protocol.TField("families", org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.MAP, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new SchemaStandardSchemeFactory());
    schemes.put(TupleScheme.class, new SchemaTupleSchemeFactory());
  }

  /**
   * The table name.
   */
  public String table; // required
  /**
   * Families and the column definitions within them.
   */
  public Map<String,Map<String,ColumnDefinition>> families; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.blur.thirdparty.thrift_0_9_0.TFieldIdEnum {
    /**
     * The table name.
     */
    TABLE((short)1, "table"),
    /**
     * Families and the column definitions within them.
     */
    FAMILIES((short)2, "families");

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
        case 1: // TABLE
          return TABLE;
        case 2: // FAMILIES
          return FAMILIES;
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
  public static final Map<_Fields, org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TABLE, new org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldMetaData("table", org.apache.blur.thirdparty.thrift_0_9_0.TFieldRequirementType.DEFAULT, 
        new org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldValueMetaData(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRING)));
    tmpMap.put(_Fields.FAMILIES, new org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldMetaData("families", org.apache.blur.thirdparty.thrift_0_9_0.TFieldRequirementType.DEFAULT, 
        new org.apache.blur.thirdparty.thrift_0_9_0.meta_data.MapMetaData(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.MAP, 
            new org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldValueMetaData(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRING), 
            new org.apache.blur.thirdparty.thrift_0_9_0.meta_data.MapMetaData(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.MAP, 
                new org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldValueMetaData(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRING), 
                new org.apache.blur.thirdparty.thrift_0_9_0.meta_data.StructMetaData(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRUCT, ColumnDefinition.class)))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldMetaData.addStructMetaDataMap(Schema.class, metaDataMap);
  }

  public Schema() {
  }

  public Schema(
    String table,
    Map<String,Map<String,ColumnDefinition>> families)
  {
    this();
    this.table = table;
    this.families = families;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Schema(Schema other) {
    if (other.isSetTable()) {
      this.table = other.table;
    }
    if (other.isSetFamilies()) {
      Map<String,Map<String,ColumnDefinition>> __this__families = new HashMap<String,Map<String,ColumnDefinition>>();
      for (Map.Entry<String, Map<String,ColumnDefinition>> other_element : other.families.entrySet()) {

        String other_element_key = other_element.getKey();
        Map<String,ColumnDefinition> other_element_value = other_element.getValue();

        String __this__families_copy_key = other_element_key;

        Map<String,ColumnDefinition> __this__families_copy_value = new HashMap<String,ColumnDefinition>();
        for (Map.Entry<String, ColumnDefinition> other_element_value_element : other_element_value.entrySet()) {

          String other_element_value_element_key = other_element_value_element.getKey();
          ColumnDefinition other_element_value_element_value = other_element_value_element.getValue();

          String __this__families_copy_value_copy_key = other_element_value_element_key;

          ColumnDefinition __this__families_copy_value_copy_value = new ColumnDefinition(other_element_value_element_value);

          __this__families_copy_value.put(__this__families_copy_value_copy_key, __this__families_copy_value_copy_value);
        }

        __this__families.put(__this__families_copy_key, __this__families_copy_value);
      }
      this.families = __this__families;
    }
  }

  public Schema deepCopy() {
    return new Schema(this);
  }

  @Override
  public void clear() {
    this.table = null;
    this.families = null;
  }

  /**
   * The table name.
   */
  public String getTable() {
    return this.table;
  }

  /**
   * The table name.
   */
  public Schema setTable(String table) {
    this.table = table;
    return this;
  }

  public void unsetTable() {
    this.table = null;
  }

  /** Returns true if field table is set (has been assigned a value) and false otherwise */
  public boolean isSetTable() {
    return this.table != null;
  }

  public void setTableIsSet(boolean value) {
    if (!value) {
      this.table = null;
    }
  }

  public int getFamiliesSize() {
    return (this.families == null) ? 0 : this.families.size();
  }

  public void putToFamilies(String key, Map<String,ColumnDefinition> val) {
    if (this.families == null) {
      this.families = new HashMap<String,Map<String,ColumnDefinition>>();
    }
    this.families.put(key, val);
  }

  /**
   * Families and the column definitions within them.
   */
  public Map<String,Map<String,ColumnDefinition>> getFamilies() {
    return this.families;
  }

  /**
   * Families and the column definitions within them.
   */
  public Schema setFamilies(Map<String,Map<String,ColumnDefinition>> families) {
    this.families = families;
    return this;
  }

  public void unsetFamilies() {
    this.families = null;
  }

  /** Returns true if field families is set (has been assigned a value) and false otherwise */
  public boolean isSetFamilies() {
    return this.families != null;
  }

  public void setFamiliesIsSet(boolean value) {
    if (!value) {
      this.families = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case TABLE:
      if (value == null) {
        unsetTable();
      } else {
        setTable((String)value);
      }
      break;

    case FAMILIES:
      if (value == null) {
        unsetFamilies();
      } else {
        setFamilies((Map<String,Map<String,ColumnDefinition>>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case TABLE:
      return getTable();

    case FAMILIES:
      return getFamilies();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case TABLE:
      return isSetTable();
    case FAMILIES:
      return isSetFamilies();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Schema)
      return this.equals((Schema)that);
    return false;
  }

  public boolean equals(Schema that) {
    if (that == null)
      return false;

    boolean this_present_table = true && this.isSetTable();
    boolean that_present_table = true && that.isSetTable();
    if (this_present_table || that_present_table) {
      if (!(this_present_table && that_present_table))
        return false;
      if (!this.table.equals(that.table))
        return false;
    }

    boolean this_present_families = true && this.isSetFamilies();
    boolean that_present_families = true && that.isSetFamilies();
    if (this_present_families || that_present_families) {
      if (!(this_present_families && that_present_families))
        return false;
      if (!this.families.equals(that.families))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(Schema other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    Schema typedOther = (Schema)other;

    lastComparison = Boolean.valueOf(isSetTable()).compareTo(typedOther.isSetTable());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTable()) {
      lastComparison = org.apache.blur.thirdparty.thrift_0_9_0.TBaseHelper.compareTo(this.table, typedOther.table);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFamilies()).compareTo(typedOther.isSetFamilies());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFamilies()) {
      lastComparison = org.apache.blur.thirdparty.thrift_0_9_0.TBaseHelper.compareTo(this.families, typedOther.families);
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
    StringBuilder sb = new StringBuilder("Schema(");
    boolean first = true;

    sb.append("table:");
    if (this.table == null) {
      sb.append("null");
    } else {
      sb.append(this.table);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("families:");
    if (this.families == null) {
      sb.append("null");
    } else {
      sb.append(this.families);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.blur.thirdparty.thrift_0_9_0.TException {
    // check for required fields
    // check for sub-struct validity
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
      read(new org.apache.blur.thirdparty.thrift_0_9_0.protocol.TCompactProtocol(new org.apache.blur.thirdparty.thrift_0_9_0.transport.TIOStreamTransport(in)));
    } catch (org.apache.blur.thirdparty.thrift_0_9_0.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class SchemaStandardSchemeFactory implements SchemeFactory {
    public SchemaStandardScheme getScheme() {
      return new SchemaStandardScheme();
    }
  }

  private static class SchemaStandardScheme extends StandardScheme<Schema> {

    public void read(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TProtocol iprot, Schema struct) throws org.apache.blur.thirdparty.thrift_0_9_0.TException {
      org.apache.blur.thirdparty.thrift_0_9_0.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TABLE
            if (schemeField.type == org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRING) {
              struct.table = iprot.readString();
              struct.setTableIsSet(true);
            } else { 
              org.apache.blur.thirdparty.thrift_0_9_0.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // FAMILIES
            if (schemeField.type == org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.MAP) {
              {
                org.apache.blur.thirdparty.thrift_0_9_0.protocol.TMap _map146 = iprot.readMapBegin();
                struct.families = new HashMap<String,Map<String,ColumnDefinition>>(2*_map146.size);
                for (int _i147 = 0; _i147 < _map146.size; ++_i147)
                {
                  String _key148; // required
                  Map<String,ColumnDefinition> _val149; // required
                  _key148 = iprot.readString();
                  {
                    org.apache.blur.thirdparty.thrift_0_9_0.protocol.TMap _map150 = iprot.readMapBegin();
                    _val149 = new HashMap<String,ColumnDefinition>(2*_map150.size);
                    for (int _i151 = 0; _i151 < _map150.size; ++_i151)
                    {
                      String _key152; // required
                      ColumnDefinition _val153; // required
                      _key152 = iprot.readString();
                      _val153 = new ColumnDefinition();
                      _val153.read(iprot);
                      _val149.put(_key152, _val153);
                    }
                    iprot.readMapEnd();
                  }
                  struct.families.put(_key148, _val149);
                }
                iprot.readMapEnd();
              }
              struct.setFamiliesIsSet(true);
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

    public void write(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TProtocol oprot, Schema struct) throws org.apache.blur.thirdparty.thrift_0_9_0.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.table != null) {
        oprot.writeFieldBegin(TABLE_FIELD_DESC);
        oprot.writeString(struct.table);
        oprot.writeFieldEnd();
      }
      if (struct.families != null) {
        oprot.writeFieldBegin(FAMILIES_FIELD_DESC);
        {
          oprot.writeMapBegin(new org.apache.blur.thirdparty.thrift_0_9_0.protocol.TMap(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRING, org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.MAP, struct.families.size()));
          for (Map.Entry<String, Map<String,ColumnDefinition>> _iter154 : struct.families.entrySet())
          {
            oprot.writeString(_iter154.getKey());
            {
              oprot.writeMapBegin(new org.apache.blur.thirdparty.thrift_0_9_0.protocol.TMap(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRING, org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRUCT, _iter154.getValue().size()));
              for (Map.Entry<String, ColumnDefinition> _iter155 : _iter154.getValue().entrySet())
              {
                oprot.writeString(_iter155.getKey());
                _iter155.getValue().write(oprot);
              }
              oprot.writeMapEnd();
            }
          }
          oprot.writeMapEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class SchemaTupleSchemeFactory implements SchemeFactory {
    public SchemaTupleScheme getScheme() {
      return new SchemaTupleScheme();
    }
  }

  private static class SchemaTupleScheme extends TupleScheme<Schema> {

    @Override
    public void write(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TProtocol prot, Schema struct) throws org.apache.blur.thirdparty.thrift_0_9_0.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetTable()) {
        optionals.set(0);
      }
      if (struct.isSetFamilies()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetTable()) {
        oprot.writeString(struct.table);
      }
      if (struct.isSetFamilies()) {
        {
          oprot.writeI32(struct.families.size());
          for (Map.Entry<String, Map<String,ColumnDefinition>> _iter156 : struct.families.entrySet())
          {
            oprot.writeString(_iter156.getKey());
            {
              oprot.writeI32(_iter156.getValue().size());
              for (Map.Entry<String, ColumnDefinition> _iter157 : _iter156.getValue().entrySet())
              {
                oprot.writeString(_iter157.getKey());
                _iter157.getValue().write(oprot);
              }
            }
          }
        }
      }
    }

    @Override
    public void read(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TProtocol prot, Schema struct) throws org.apache.blur.thirdparty.thrift_0_9_0.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.table = iprot.readString();
        struct.setTableIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.blur.thirdparty.thrift_0_9_0.protocol.TMap _map158 = new org.apache.blur.thirdparty.thrift_0_9_0.protocol.TMap(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRING, org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.MAP, iprot.readI32());
          struct.families = new HashMap<String,Map<String,ColumnDefinition>>(2*_map158.size);
          for (int _i159 = 0; _i159 < _map158.size; ++_i159)
          {
            String _key160; // required
            Map<String,ColumnDefinition> _val161; // required
            _key160 = iprot.readString();
            {
              org.apache.blur.thirdparty.thrift_0_9_0.protocol.TMap _map162 = new org.apache.blur.thirdparty.thrift_0_9_0.protocol.TMap(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRING, org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRUCT, iprot.readI32());
              _val161 = new HashMap<String,ColumnDefinition>(2*_map162.size);
              for (int _i163 = 0; _i163 < _map162.size; ++_i163)
              {
                String _key164; // required
                ColumnDefinition _val165; // required
                _key164 = iprot.readString();
                _val165 = new ColumnDefinition();
                _val165.read(iprot);
                _val161.put(_key164, _val165);
              }
            }
            struct.families.put(_key160, _val161);
          }
        }
        struct.setFamiliesIsSet(true);
      }
    }
  }

}

