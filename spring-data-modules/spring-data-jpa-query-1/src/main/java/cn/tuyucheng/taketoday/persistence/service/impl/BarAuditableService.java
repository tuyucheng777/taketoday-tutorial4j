package cn.tuyucheng.taketoday.persistence.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.tuyucheng.taketoday.persistence.dao.IBarAuditableDao;
import cn.tuyucheng.taketoday.persistence.dao.IBarDao;
import cn.tuyucheng.taketoday.persistence.dao.common.IAuditOperations;
import cn.tuyucheng.taketoday.persistence.dao.common.IOperations;
import cn.tuyucheng.taketoday.persistence.model.Bar;
import cn.tuyucheng.taketoday.persistence.service.IBarAuditableService;
import cn.tuyucheng.taketoday.persistence.service.common.AbstractHibernateAuditableService;

@Service
public class BarAuditableService extends AbstractHibernateAuditableService<Bar> implements IBarAuditableService {

   @Autowired
   @Qualifier("barHibernateDao")
   private IBarDao dao;

   @Autowired
   @Qualifier("barHibernateAuditableDao")
   private IBarAuditableDao auditDao;

   public BarAuditableService() {
      super();
   }

   // API

   @Override
   protected IOperations<Bar> getDao() {
      return dao;
   }

   @Override
   protected IAuditOperations<Bar> getAuditableDao() {
      return auditDao;
   }
}