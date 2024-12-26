package cn.tuyucheng.taketoday.persistence.dao.impl;

import cn.tuyucheng.taketoday.persistence.dao.IChildDao;
import cn.tuyucheng.taketoday.persistence.dao.common.AbstractHibernateDao;
import cn.tuyucheng.taketoday.persistence.model.Child;
import org.springframework.stereotype.Repository;

@Repository
public class ChildDao extends AbstractHibernateDao<Child> implements IChildDao {

   public ChildDao() {
      super();

      setClazz(Child.class);
   }

   // API
}