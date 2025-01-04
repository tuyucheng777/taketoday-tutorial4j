package cn.tuyucheng.taketoday.apache.zookeeper.manager;

import org.apache.zookeeper.KeeperException;

public interface ZKManager {
   /**
    * Create a Znode and save some data
    *
    * @param path
    * @param data
    * @throws KeeperException
    * @throws InterruptedException
    */
   void create(String path, byte[] data) throws KeeperException, InterruptedException;

   /**
    * Get ZNode Data
    *
    * @param path
    * @param boolean watchFlag
    * @throws KeeperException
    * @throws InterruptedException
    */
   Object getZNodeData(String path, boolean watchFlag);

   /**
    * Update the ZNode Data
    *
    * @param path
    * @param data
    * @throws KeeperException
    * @throws InterruptedException
    */
   void update(String path, byte[] data) throws KeeperException, InterruptedException, KeeperException;
}