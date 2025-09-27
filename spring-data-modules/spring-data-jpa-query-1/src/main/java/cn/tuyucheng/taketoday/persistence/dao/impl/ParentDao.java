package cn.tuyucheng.taketoday.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import cn.tuyucheng.taketoday.persistence.dao.IParentDao;
import cn.tuyucheng.taketoday.persistence.dao.common.AbstractHibernateDao;
import cn.tuyucheng.taketoday.persistence.model.Parent;

@Repository
public class ParentDao extends AbstractHibernateDao<Parent> implements IParentDao {

   public ParentDao() {
      super();

      setClazz(Parent.class);
   }

   // API
}