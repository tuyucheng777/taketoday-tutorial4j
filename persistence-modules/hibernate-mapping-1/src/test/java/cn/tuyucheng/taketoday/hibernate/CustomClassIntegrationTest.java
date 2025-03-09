package cn.tuyucheng.taketoday.hibernate;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;

import cn.tuyucheng.taketoday.hibernate.entities.DeptEmployee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cn.tuyucheng.taketoday.hibernate.entities.Department;
import cn.tuyucheng.taketoday.hibernate.pojo.Result;

public class CustomClassIntegrationTest {

   private Session session;

   private Transaction transaction;

   @BeforeEach
   public void setUp() throws IOException {
      session = HibernateUtil.getSessionFactory().openSession();
      transaction = session.beginTransaction();
      session.createNativeQuery("delete from department").executeUpdate();
      Department department = new Department("Sales");
      DeptEmployee employee = new DeptEmployee("John Smith", "001", department);
      session.persist(department);
      session.persist(employee);
      transaction.commit();
      transaction = session.beginTransaction();
   }

   @Test
   public void whenAllManagersAreSelected_ThenObjectGraphIsReturned() {
      Query<DeptEmployee> query = session.createQuery("from cn.tuyucheng.taketoday.hibernate.entities.DeptEmployee");
      List<DeptEmployee> deptEmployees = query.list();
      DeptEmployee deptEmployee = deptEmployees.get(0);
      assertEquals("John Smith", deptEmployee.getName());
      assertEquals("Sales", deptEmployee.getDepartment().getName());
   }

   @Test
   public void whenIndividualPropertiesAreSelected_ThenObjectArrayIsReturned() {
      Query query = session.createQuery("select m.name, m.department.name from cn.tuyucheng.taketoday.hibernate.entities.DeptEmployee m");
      List managers = query.list();
      Object[] manager = (Object[]) managers.get(0);
      assertEquals("John Smith", manager[0]);
      assertEquals("Sales", manager[1]);
   }

   @Test
   public void whenResultConstructorInSelect_ThenListOfResultIsReturned() {
      Query<Result> query = session.createQuery("select new cn.tuyucheng.taketoday.hibernate.pojo.Result(m.name, m.department.name) "
            + "from DeptEmployee m");
      List<Result> results = query.list();
      Result result = results.get(0);
      assertEquals("John Smith", result.getEmployeeName());
      assertEquals("Sales", result.getDepartmentName());
   }

   @Test
   public void whenResultTransformerOnQuery_ThenListOfResultIsReturned() {
      Query query = session.createQuery("select m.name as employeeName, m.department.name as departmentName "
            + "from cn.tuyucheng.taketoday.hibernate.entities.DeptEmployee m");
      query.setResultTransformer(Transformers.aliasToBean(Result.class));
      List<Result> results = query.list();
      Result result = results.get(0);
      assertEquals("John Smith", result.getEmployeeName());
      assertEquals("Sales", result.getDepartmentName());
   }

   @Test
   public void whenCastResultQueryToList_ThenListOfResultIsReturned() {
      Query<Result> query = session.createQuery("select new cn.tuyucheng.taketoday.hibernate.pojo.Result(m.name, m.department.name) "
            + "from DeptEmployee m");
      List<Result> results = query.list();
      assertNotNull(results);
      assertEquals(1, results.size());
   }

}
