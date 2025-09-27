package cn.tuyucheng.taketoday.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import cn.tuyucheng.taketoday.persistence.dao.IFooDao;
import cn.tuyucheng.taketoday.persistence.dao.common.AbstractHibernateDao;
import cn.tuyucheng.taketoday.persistence.model.Foo;

@Repository
public class FooDao extends AbstractHibernateDao<Foo> implements IFooDao {

   public FooDao() {
      super();

      setClazz(Foo.class);
   }

   // API
}