package cn.tuyucheng.taketoday.connectingtoremotemysqlssh;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static cn.tuyucheng.taketoday.connectingtoremotemysqlssh.RemoteMysqlConnection.setUpJsch;
import static cn.tuyucheng.taketoday.connectingtoremotemysqlssh.RemoteMysqlConnection.createSession;
import static cn.tuyucheng.taketoday.connectingtoremotemysqlssh.RemoteMysqlConnection.disconnect;
import static cn.tuyucheng.taketoday.connectingtoremotemysqlssh.RemoteMysqlConnection.createTable;
import static cn.tuyucheng.taketoday.connectingtoremotemysqlssh.RemoteMysqlConnection.insertData;
import static cn.tuyucheng.taketoday.connectingtoremotemysqlssh.RemoteMysqlConnection.isTableExists;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RemoteMysqlConnectionLiveTest {

   @Test
   public void givenJschSessionAndMySqlServer_whenConnectingToRemoteMySqlDatabase_thenSuccess() throws JSchException, SQLException {
      JSch jsch = setUpJsch();
      Session session = createSession(jsch);
      int port = RemoteMysqlConnection.tunnelNetwork(session);
      Connection connection = RemoteMysqlConnection.databaseConnection(port);
      assertNotNull(connection);
      disconnect(session, connection);
   }

   @Test
   public void givenJschSessionAndMySqlServer_whenCreatingTableAndAddingRecordToTheTable_thenSuccess() throws JSchException, SQLException {
      JSch jsch = setUpJsch();
      Session session = createSession(jsch);
      int port = RemoteMysqlConnection.tunnelNetwork(session);
      Connection connection = RemoteMysqlConnection.databaseConnection(port);
      String newTableName = "test_table";
      createTable(connection, newTableName);
      insertData(connection, newTableName);
      disconnect(session, connection);
   }

   @Test
   public void givenJschSessionAndMySqlServer_whenVerifyingTable_thenTableExists() throws JSchException, SQLException {
      JSch jsch = setUpJsch();
      Session session = createSession(jsch);
      int port = RemoteMysqlConnection.tunnelNetwork(session);
      Connection connection = RemoteMysqlConnection.databaseConnection(port);
      String newTableName = "test_table";
      assertTrue(isTableExists(connection, newTableName));
      disconnect(session, connection);
   }

}