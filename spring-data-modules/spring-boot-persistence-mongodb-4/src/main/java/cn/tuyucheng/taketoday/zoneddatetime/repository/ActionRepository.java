package cn.tuyucheng.taketoday.zoneddatetime.repository;

import cn.tuyucheng.taketoday.zoneddatetime.model.Action;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ActionRepository extends MongoRepository<Action, String> { }