package cn.tuyucheng.taketoday.commons.dbutils;

import org.apache.commons.dbutils.AsyncQueryRunner;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DbUtilsUnitTest {

   private Connection connection;

   @Before
   public void setupDB() throws Exception {
      Class.forName("org.h2.Driver");
      String db = "jdbc:h2:mem:;INIT=runscript from 'classpath:/employees.sql'";
      connection = DriverManager.getConnection(db);
   }

   @After
   public void closeBD() {
      DbUtils.closeQuietly(connection);
   }

   @Test
   public void givenResultHandler_whenExecutingQuery_thenExpectedList() throws SQLException {
      MapListHandler beanListHandler = new MapListHandler();

      QueryRunner runner = new QueryRunner();
      List<Map<String, Object>> list = runner.query(connection, "SELECT * FROM employee", beanListHandler);

      assertEquals(5, list.size());
      assertEquals("John", list.get(0).get("firstname"));
      assertEquals("Christian", list.get(4).get("firstname"));
   }

   @Test
   public void givenResultHandler_whenExecutingQuery_thenEmployeeList() throws SQLException {
      BeanListHandler<Employee> beanListHandler = new BeanListHandler<>(Employee.class);

      QueryRunner runner = new QueryRunner();
      List<Employee> employeeList = runner.query(connection, "SELECT * FROM employee", beanListHandler);

      assertEquals(5, employeeList.size());
      assertEquals("John", employeeList.get(0).getFirstName());
      assertEquals("Christian", employeeList.get(4).getFirstName());
   }

   @Test
   public void givenResultHandler_whenExecutingQuery_thenExpectedScalar() throws SQLException {
      ScalarHandler<Long> scalarHandler = new ScalarHandler<>();

      QueryRunner runner = new QueryRunner();
      String query = "SELECT COUNT(*) FROM employee";
      long count = runner.query(connection, query, scalarHandler);

      assertEquals(5, count);
   }

   @Test
   public void givenResultHandler_whenExecutingQuery_thenEmailsSetted() throws SQLException {
      EmployeeHandler employeeHandler = new EmployeeHandler(connection);

      QueryRunner runner = new QueryRunner();
      List<Employee> employees = runner.query(connection, "SELECT * FROM employee", employeeHandler);

      assertEquals(2, employees.get(0).getEmails().size());
      assertEquals(3, employees.get(2).getEmails().size());
      assertNotNull(employees.get(0).getEmails().get(0).getEmployeeId());
   }

   @Test
   public void givenResultHandler_whenExecutingQuery_thenAllPropertiesSetted() throws SQLException {
      EmployeeHandler employeeHandler = new EmployeeHandler(connection);

      QueryRunner runner = new QueryRunner();
      String query = "SELECT * FROM employee_legacy";
      List<Employee> employees = runner.query(connection, query, employeeHandler);

      assertEquals(1, (int) employees.get(0).getId());
      assertEquals("John", employees.get(0).getFirstName());
   }

   @Test
   public void whenInserting_thenInserted() throws SQLException {
      QueryRunner runner = new QueryRunner();
      String insertSQL = "INSERT INTO employee (firstname,lastname,salary, hireddate) VALUES (?, ?, ?, ?)";

      int numRowsInserted = runner.update(connection, insertSQL, "Leia", "Kane", 60000.60, new Date());

      assertEquals(1, numRowsInserted);
   }

   @Test
   public void givenHandler_whenInserting_thenExpectedId() throws SQLException {
      ScalarHandler<Integer> scalarHandler = new ScalarHandler<>();

      QueryRunner runner = new QueryRunner();
      String insertSQL = "INSERT INTO employee (firstname,lastname,salary, hireddate) VALUES (?, ?, ?, ?)";

      int newId = runner.insert(connection, insertSQL, scalarHandler, "Jenny", "Medici", 60000.60, new Date());

      assertEquals(6, newId);
   }

   @Test
   public void givenSalary_whenUpdating_thenUpdated() throws SQLException {
      double salary = 35000;

      QueryRunner runner = new QueryRunner();
      String updateSQL = "UPDATE employee SET salary = salary * 1.1 WHERE salary <= ?";
      int numRowsUpdated = runner.update(connection, updateSQL, salary);

      assertEquals(3, numRowsUpdated);
   }

   @Test
   public void whenDeletingRecord_thenDeleted() throws SQLException {
      QueryRunner runner = new QueryRunner();
      String deleteSQL = "DELETE FROM employee WHERE id = ?";
      int numRowsDeleted = runner.update(connection, deleteSQL, 3);

      assertEquals(1, numRowsDeleted);
   }

   @Test
   public void givenAsyncRunner_whenExecutingQuery_thenExpectedList() throws Exception {
      AsyncQueryRunner runner = new AsyncQueryRunner(Executors.newCachedThreadPool());

      EmployeeHandler employeeHandler = new EmployeeHandler(connection);
      String query = "SELECT * FROM employee";
      Future<List<Employee>> future = runner.query(connection, query, employeeHandler);
      List<Employee> employeeList = future.get(10, TimeUnit.SECONDS);

      assertEquals(5, employeeList.size());
   }
}