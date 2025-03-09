package cn.tuyucheng.taketoday.hibernate.manytomany.dao.impl;

import org.springframework.stereotype.Repository;

import cn.tuyucheng.taketoday.hibernate.manytomany.dao.IProjectDao;
import cn.tuyucheng.taketoday.hibernate.manytomany.dao.common.AbstractHibernateDao;
import cn.tuyucheng.taketoday.hibernate.manytomany.model.Project;

@Repository
public class ProjectDao extends AbstractHibernateDao<Project> implements IProjectDao {

   public ProjectDao() {
      super();

      setClazz(Project.class);
   }
}
