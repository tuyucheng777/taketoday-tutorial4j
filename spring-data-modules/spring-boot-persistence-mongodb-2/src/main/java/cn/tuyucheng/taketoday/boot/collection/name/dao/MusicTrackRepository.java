package cn.tuyucheng.taketoday.boot.collection.name.dao;

import cn.tuyucheng.taketoday.boot.collection.name.data.MusicTrack;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MusicTrackRepository extends MongoRepository<MusicTrack, String> {

}
