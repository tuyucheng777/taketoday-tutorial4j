package cn.tuyucheng.taketoday.libraries.ormlite;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

public interface LibraryDao extends Dao<Library, Long> {
   List<Library> findByName(String name) throws SQLException;
}