package cn.tuyucheng.taketoday.hibernate.manytomany.dao.impl;

import org.springframework.stereotype.Repository;

import cn.tuyucheng.taketoday.hibernate.manytomany.dao.IEmployeeDao;
import cn.tuyucheng.taketoday.hibernate.manytomany.dao.common.AbstractHibernateDao;
import cn.tuyucheng.taketoday.hibernate.manytomany.model.Employee;

@Repository
public class EmployeeDao extends AbstractHibernateDao<Employee> implements IEmployeeDao {

   public EmployeeDao() {
      super();

      setClazz(Employee.class);
   }
}
