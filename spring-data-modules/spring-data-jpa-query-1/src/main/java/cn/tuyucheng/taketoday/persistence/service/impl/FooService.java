package cn.tuyucheng.taketoday.persistence.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.tuyucheng.taketoday.persistence.dao.IFooDao;
import cn.tuyucheng.taketoday.persistence.dao.common.IOperations;
import cn.tuyucheng.taketoday.persistence.model.Foo;
import cn.tuyucheng.taketoday.persistence.service.IFooService;
import cn.tuyucheng.taketoday.persistence.service.common.AbstractHibernateService;

@Service
public class FooService extends AbstractHibernateService<Foo> implements IFooService {

   @Autowired
   @Qualifier("fooHibernateDao")
   private IFooDao dao;

   public FooService() {
      super();
   }

   // API

   @Override
   protected IOperations<Foo> getDao() {
      return dao;
   }
}