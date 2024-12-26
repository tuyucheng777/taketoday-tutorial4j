package cn.tuyucheng.taketoday.persistence.dao.impl;

import cn.tuyucheng.taketoday.persistence.dao.IFooAuditableDao;
import cn.tuyucheng.taketoday.persistence.dao.common.AbstractHibernateAuditableDao;
import cn.tuyucheng.taketoday.persistence.model.Foo;

public class FooAuditableDao extends AbstractHibernateAuditableDao<Foo> implements IFooAuditableDao {

   public FooAuditableDao() {
      super();

      setClazz(Foo.class);
   }

   // API
}