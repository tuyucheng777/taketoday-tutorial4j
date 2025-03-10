package cn.tuyucheng.taketoday.mybatisplus.migration;

import com.baomidou.mybatisplus.extension.ddl.SimpleDdl;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DBMigration extends SimpleDdl {

   @Override
   public List<String> getSqlFiles() {
      return Arrays.asList("db/db_v1.sql", "db/db_v2.sql");
   }
}