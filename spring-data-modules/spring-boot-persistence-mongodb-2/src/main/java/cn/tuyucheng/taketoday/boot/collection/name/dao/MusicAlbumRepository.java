package cn.tuyucheng.taketoday.boot.collection.name.dao;

import cn.tuyucheng.taketoday.boot.collection.name.data.MusicAlbum;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MusicAlbumRepository extends MongoRepository<MusicAlbum, String> {

}
