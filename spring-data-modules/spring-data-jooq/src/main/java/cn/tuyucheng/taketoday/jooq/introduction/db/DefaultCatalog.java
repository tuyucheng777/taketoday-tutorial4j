/*
 * This file is generated by jOOQ.
 */
package cn.tuyucheng.taketoday.jooq.introduction.db;


import cn.tuyucheng.taketoday.jooq.introduction.db.information_schema.InformationSchema;
import cn.tuyucheng.taketoday.jooq.introduction.db.public_.Public;
import org.jooq.Schema;
import org.jooq.impl.CatalogImpl;

import java.util.Arrays;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class DefaultCatalog extends CatalogImpl {

   private static final long serialVersionUID = 1L;

   /**
    * The reference instance of <code>DEFAULT_CATALOG</code>
    */
   public static final DefaultCatalog DEFAULT_CATALOG = new DefaultCatalog();

   /**
    * The schema <code>INFORMATION_SCHEMA</code>.
    */
   public final InformationSchema INFORMATION_SCHEMA = InformationSchema.INFORMATION_SCHEMA;

   /**
    * The schema <code>PUBLIC</code>.
    */
   public final Public PUBLIC = Public.PUBLIC;

   /**
    * No further instances allowed
    */
   private DefaultCatalog() {
      super("");
   }

   @Override
   public final List<Schema> getSchemas() {
      return Arrays.<Schema>asList(
            InformationSchema.INFORMATION_SCHEMA,
            Public.PUBLIC);
   }
}
