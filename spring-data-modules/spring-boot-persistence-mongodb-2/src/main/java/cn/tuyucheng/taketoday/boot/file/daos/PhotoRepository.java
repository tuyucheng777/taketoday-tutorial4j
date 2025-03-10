package cn.tuyucheng.taketoday.boot.file.daos;

import cn.tuyucheng.taketoday.boot.file.models.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PhotoRepository extends MongoRepository<Photo, String> {
}