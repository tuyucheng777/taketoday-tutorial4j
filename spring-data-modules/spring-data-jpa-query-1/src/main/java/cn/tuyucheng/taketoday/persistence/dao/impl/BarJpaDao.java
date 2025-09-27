package cn.tuyucheng.taketoday.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import cn.tuyucheng.taketoday.persistence.dao.IBarDao;
import cn.tuyucheng.taketoday.persistence.dao.common.AbstractJpaDao;
import cn.tuyucheng.taketoday.persistence.model.Bar;

@Repository
public class BarJpaDao extends AbstractJpaDao<Bar> implements IBarDao {

   public BarJpaDao() {
      super();

      setClazz(Bar.class);
   }

   // API
}