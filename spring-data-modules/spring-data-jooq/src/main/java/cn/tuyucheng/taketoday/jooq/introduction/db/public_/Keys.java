/*
 * This file is generated by jOOQ.
 */
package cn.tuyucheng.taketoday.jooq.introduction.db.public_;


import cn.tuyucheng.taketoday.jooq.introduction.db.public_.tables.Author;
import cn.tuyucheng.taketoday.jooq.introduction.db.public_.tables.AuthorBook;
import cn.tuyucheng.taketoday.jooq.introduction.db.public_.tables.Book;
import cn.tuyucheng.taketoday.jooq.introduction.db.public_.tables.records.AuthorBookRecord;
import cn.tuyucheng.taketoday.jooq.introduction.db.public_.tables.records.AuthorRecord;
import cn.tuyucheng.taketoday.jooq.introduction.db.public_.tables.records.BookRecord;
import org.jooq.ForeignKey;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * PUBLIC.
 */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class Keys {

   // -------------------------------------------------------------------------
   // UNIQUE and PRIMARY KEY definitions
   // -------------------------------------------------------------------------

   public static final UniqueKey<AuthorRecord> CONSTRAINT_7 = Internal.createUniqueKey(Author.AUTHOR, DSL.name("CONSTRAINT_7"), new TableField[]{Author.AUTHOR.ID}, true);
   public static final UniqueKey<AuthorBookRecord> CONSTRAINT_A = Internal.createUniqueKey(AuthorBook.AUTHOR_BOOK, DSL.name("CONSTRAINT_A"), new TableField[]{AuthorBook.AUTHOR_BOOK.AUTHOR_ID, AuthorBook.AUTHOR_BOOK.BOOK_ID}, true);
   public static final UniqueKey<BookRecord> CONSTRAINT_1 = Internal.createUniqueKey(Book.BOOK, DSL.name("CONSTRAINT_1"), new TableField[]{Book.BOOK.ID}, true);

   // -------------------------------------------------------------------------
   // FOREIGN KEY definitions
   // -------------------------------------------------------------------------

   public static final ForeignKey<AuthorBookRecord, AuthorRecord> FK_AB_AUTHOR = Internal.createForeignKey(AuthorBook.AUTHOR_BOOK, DSL.name("FK_AB_AUTHOR"), new TableField[]{AuthorBook.AUTHOR_BOOK.AUTHOR_ID}, Keys.CONSTRAINT_7, new TableField[]{Author.AUTHOR.ID}, true);
   public static final ForeignKey<AuthorBookRecord, BookRecord> FK_AB_BOOK = Internal.createForeignKey(AuthorBook.AUTHOR_BOOK, DSL.name("FK_AB_BOOK"), new TableField[]{AuthorBook.AUTHOR_BOOK.BOOK_ID}, Keys.CONSTRAINT_1, new TableField[]{Book.BOOK.ID}, true);
}
