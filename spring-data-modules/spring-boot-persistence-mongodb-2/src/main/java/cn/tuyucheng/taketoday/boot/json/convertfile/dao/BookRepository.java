package cn.tuyucheng.taketoday.boot.json.convertfile.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import cn.tuyucheng.taketoday.boot.json.convertfile.data.Book;

public interface BookRepository extends MongoRepository<Book, String> {

}
