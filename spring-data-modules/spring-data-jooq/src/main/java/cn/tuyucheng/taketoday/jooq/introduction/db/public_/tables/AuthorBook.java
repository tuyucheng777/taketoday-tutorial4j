/*
 * This file is generated by jOOQ.
 */
package cn.tuyucheng.taketoday.jooq.introduction.db.public_.tables;


import cn.tuyucheng.taketoday.jooq.introduction.db.public_.Keys;
import cn.tuyucheng.taketoday.jooq.introduction.db.public_.Public;
import cn.tuyucheng.taketoday.jooq.introduction.db.public_.tables.records.AuthorBookRecord;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row2;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

import java.util.Arrays;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class AuthorBook extends TableImpl<AuthorBookRecord> {

   private static final long serialVersionUID = 1L;

   /**
    * The reference instance of <code>PUBLIC.AUTHOR_BOOK</code>
    */
   public static final AuthorBook AUTHOR_BOOK = new AuthorBook();

   /**
    * The class holding records for this type
    */
   @Override
   public Class<AuthorBookRecord> getRecordType() {
      return AuthorBookRecord.class;
   }

   /**
    * The column <code>PUBLIC.AUTHOR_BOOK.AUTHOR_ID</code>.
    */
   public final TableField<AuthorBookRecord, Integer> AUTHOR_ID = createField(DSL.name("AUTHOR_ID"), SQLDataType.INTEGER.nullable(false), this, "");

   /**
    * The column <code>PUBLIC.AUTHOR_BOOK.BOOK_ID</code>.
    */
   public final TableField<AuthorBookRecord, Integer> BOOK_ID = createField(DSL.name("BOOK_ID"), SQLDataType.INTEGER.nullable(false), this, "");

   private AuthorBook(Name alias, Table<AuthorBookRecord> aliased) {
      this(alias, aliased, null);
   }

   private AuthorBook(Name alias, Table<AuthorBookRecord> aliased, Field<?>[] parameters) {
      super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
   }

   /**
    * Create an aliased <code>PUBLIC.AUTHOR_BOOK</code> table reference
    */
   public AuthorBook(String alias) {
      this(DSL.name(alias), AUTHOR_BOOK);
   }

   /**
    * Create an aliased <code>PUBLIC.AUTHOR_BOOK</code> table reference
    */
   public AuthorBook(Name alias) {
      this(alias, AUTHOR_BOOK);
   }

   /**
    * Create a <code>PUBLIC.AUTHOR_BOOK</code> table reference
    */
   public AuthorBook() {
      this(DSL.name("AUTHOR_BOOK"), null);
   }

   public <O extends Record> AuthorBook(Table<O> child, ForeignKey<O, AuthorBookRecord> key) {
      super(child, key, AUTHOR_BOOK);
   }

   @Override
   public Schema getSchema() {
      return Public.PUBLIC;
   }

   @Override
   public UniqueKey<AuthorBookRecord> getPrimaryKey() {
      return Keys.CONSTRAINT_A;
   }

   @Override
   public List<UniqueKey<AuthorBookRecord>> getKeys() {
      return Arrays.<UniqueKey<AuthorBookRecord>>asList(Keys.CONSTRAINT_A);
   }

   @Override
   public List<ForeignKey<AuthorBookRecord, ?>> getReferences() {
      return Arrays.<ForeignKey<AuthorBookRecord, ?>>asList(Keys.FK_AB_AUTHOR, Keys.FK_AB_BOOK);
   }

   private transient Author _author;
   private transient Book _book;

   public Author author() {
      if (_author == null)
         _author = new Author(this, Keys.FK_AB_AUTHOR);

      return _author;
   }

   public Book book() {
      if (_book == null)
         _book = new Book(this, Keys.FK_AB_BOOK);

      return _book;
   }

   @Override
   public AuthorBook as(String alias) {
      return new AuthorBook(DSL.name(alias), this);
   }

   @Override
   public AuthorBook as(Name alias) {
      return new AuthorBook(alias, this);
   }

   /**
    * Rename this table
    */
   @Override
   public AuthorBook rename(String name) {
      return new AuthorBook(DSL.name(name), null);
   }

   /**
    * Rename this table
    */
   @Override
   public AuthorBook rename(Name name) {
      return new AuthorBook(name, null);
   }

   // -------------------------------------------------------------------------
   // Row2 type methods
   // -------------------------------------------------------------------------

   @Override
   public Row2<Integer, Integer> fieldsRow() {
      return (Row2) super.fieldsRow();
   }
}
