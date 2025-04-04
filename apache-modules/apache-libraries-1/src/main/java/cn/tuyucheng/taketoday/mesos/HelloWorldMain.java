package cn.tuyucheng.taketoday.mesos;

import cn.tuyucheng.taketoday.mesos.schedulers.HelloWorldScheduler;
import org.apache.mesos.MesosSchedulerDriver;
import org.apache.mesos.Protos;
import org.apache.mesos.Protos.CommandInfo;
import org.apache.mesos.Protos.ExecutorInfo;
import org.apache.mesos.Protos.FrameworkInfo;

public class HelloWorldMain {

   public static void main(String[] args) {
      String path = System.getProperty("user.dir")
            + "/target/libraries2-1.0.0.jar";

      CommandInfo.URI uri = CommandInfo.URI.newBuilder().setValue(path).setExtract(false).build();

      String helloWorldCommand = "java -cp libraries2-1.0.0-SNAPSHOT.jar cn.tuyucheng.taketoday.mesos.executors.HelloWorldExecutor";
      CommandInfo commandInfoHelloWorld = CommandInfo.newBuilder().setValue(helloWorldCommand).addUris(uri)
            .build();

      ExecutorInfo executorHelloWorld = ExecutorInfo.newBuilder()
            .setExecutorId(Protos.ExecutorID.newBuilder().setValue("HelloWorldExecutor"))
            .setCommand(commandInfoHelloWorld).setName("Hello World (Java)").setSource("java").build();

      FrameworkInfo.Builder frameworkBuilder = FrameworkInfo.newBuilder().setFailoverTimeout(120000)
            .setUser("")
            .setName("Hello World Framework (Java)");

      frameworkBuilder.setPrincipal("test-framework-java");

      MesosSchedulerDriver driver = new MesosSchedulerDriver(new HelloWorldScheduler(executorHelloWorld), frameworkBuilder.build(), args[0]);

      int status = driver.run() == Protos.Status.DRIVER_STOPPED ? 0 : 1;

      // Ensure that the driver process terminates.
      driver.stop();

      System.exit(status);
   }
}