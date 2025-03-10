package cn.tuyucheng.taketoday.boot.collection.name.dao;

import cn.tuyucheng.taketoday.boot.collection.name.data.Compilation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompilationRepository extends MongoRepository<Compilation, String> {

}
