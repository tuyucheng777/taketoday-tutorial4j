package cn.tuyucheng.taketoday.boot.file.daos;

import org.springframework.data.mongodb.repository.MongoRepository;

import cn.tuyucheng.taketoday.boot.file.models.Photo;

public interface PhotoRepository extends MongoRepository<Photo, String> {

}
