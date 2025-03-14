/*
 * This file is generated by jOOQ.
 */
package cn.tuyucheng.taketoday.jooq.introduction.db.information_schema.tables;


import cn.tuyucheng.taketoday.jooq.introduction.db.information_schema.InformationSchema;
import cn.tuyucheng.taketoday.jooq.introduction.db.information_schema.tables.records.ReferentialConstraintsRecord;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row9;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class ReferentialConstraints extends TableImpl<ReferentialConstraintsRecord> {

   private static final long serialVersionUID = 1L;

   /**
    * The reference instance of <code>INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS</code>
    */
   public static final ReferentialConstraints REFERENTIAL_CONSTRAINTS = new ReferentialConstraints();

   /**
    * The class holding records for this type
    */
   @Override
   public Class<ReferentialConstraintsRecord> getRecordType() {
      return ReferentialConstraintsRecord.class;
   }

   /**
    * The column <code>INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS.CONSTRAINT_CATALOG</code>.
    */
   public final TableField<ReferentialConstraintsRecord, String> CONSTRAINT_CATALOG = createField(DSL.name("CONSTRAINT_CATALOG"), SQLDataType.VARCHAR(2147483647), this, "");

   /**
    * The column <code>INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS.CONSTRAINT_SCHEMA</code>.
    */
   public final TableField<ReferentialConstraintsRecord, String> CONSTRAINT_SCHEMA = createField(DSL.name("CONSTRAINT_SCHEMA"), SQLDataType.VARCHAR(2147483647), this, "");

   /**
    * The column <code>INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS.CONSTRAINT_NAME</code>.
    */
   public final TableField<ReferentialConstraintsRecord, String> CONSTRAINT_NAME = createField(DSL.name("CONSTRAINT_NAME"), SQLDataType.VARCHAR(2147483647), this, "");

   /**
    * The column <code>INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS.UNIQUE_CONSTRAINT_CATALOG</code>.
    */
   public final TableField<ReferentialConstraintsRecord, String> UNIQUE_CONSTRAINT_CATALOG = createField(DSL.name("UNIQUE_CONSTRAINT_CATALOG"), SQLDataType.VARCHAR(2147483647), this, "");

   /**
    * The column <code>INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS.UNIQUE_CONSTRAINT_SCHEMA</code>.
    */
   public final TableField<ReferentialConstraintsRecord, String> UNIQUE_CONSTRAINT_SCHEMA = createField(DSL.name("UNIQUE_CONSTRAINT_SCHEMA"), SQLDataType.VARCHAR(2147483647), this, "");

   /**
    * The column <code>INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS.UNIQUE_CONSTRAINT_NAME</code>.
    */
   public final TableField<ReferentialConstraintsRecord, String> UNIQUE_CONSTRAINT_NAME = createField(DSL.name("UNIQUE_CONSTRAINT_NAME"), SQLDataType.VARCHAR(2147483647), this, "");

   /**
    * The column <code>INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS.MATCH_OPTION</code>.
    */
   public final TableField<ReferentialConstraintsRecord, String> MATCH_OPTION = createField(DSL.name("MATCH_OPTION"), SQLDataType.VARCHAR(2147483647), this, "");

   /**
    * The column <code>INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS.UPDATE_RULE</code>.
    */
   public final TableField<ReferentialConstraintsRecord, String> UPDATE_RULE = createField(DSL.name("UPDATE_RULE"), SQLDataType.VARCHAR(2147483647), this, "");

   /**
    * The column <code>INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS.DELETE_RULE</code>.
    */
   public final TableField<ReferentialConstraintsRecord, String> DELETE_RULE = createField(DSL.name("DELETE_RULE"), SQLDataType.VARCHAR(2147483647), this, "");

   private ReferentialConstraints(Name alias, Table<ReferentialConstraintsRecord> aliased) {
      this(alias, aliased, null);
   }

   private ReferentialConstraints(Name alias, Table<ReferentialConstraintsRecord> aliased, Field<?>[] parameters) {
      super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
   }

   /**
    * Create an aliased <code>INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS</code> table reference
    */
   public ReferentialConstraints(String alias) {
      this(DSL.name(alias), REFERENTIAL_CONSTRAINTS);
   }

   /**
    * Create an aliased <code>INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS</code> table reference
    */
   public ReferentialConstraints(Name alias) {
      this(alias, REFERENTIAL_CONSTRAINTS);
   }

   /**
    * Create a <code>INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS</code> table reference
    */
   public ReferentialConstraints() {
      this(DSL.name("REFERENTIAL_CONSTRAINTS"), null);
   }

   public <O extends Record> ReferentialConstraints(Table<O> child, ForeignKey<O, ReferentialConstraintsRecord> key) {
      super(child, key, REFERENTIAL_CONSTRAINTS);
   }

   @Override
   public Schema getSchema() {
      return InformationSchema.INFORMATION_SCHEMA;
   }

   @Override
   public ReferentialConstraints as(String alias) {
      return new ReferentialConstraints(DSL.name(alias), this);
   }

   @Override
   public ReferentialConstraints as(Name alias) {
      return new ReferentialConstraints(alias, this);
   }

   /**
    * Rename this table
    */
   @Override
   public ReferentialConstraints rename(String name) {
      return new ReferentialConstraints(DSL.name(name), null);
   }

   /**
    * Rename this table
    */
   @Override
   public ReferentialConstraints rename(Name name) {
      return new ReferentialConstraints(name, null);
   }

   // -------------------------------------------------------------------------
   // Row9 type methods
   // -------------------------------------------------------------------------

   @Override
   public Row9<String, String, String, String, String, String, String, String, String> fieldsRow() {
      return (Row9) super.fieldsRow();
   }
}
