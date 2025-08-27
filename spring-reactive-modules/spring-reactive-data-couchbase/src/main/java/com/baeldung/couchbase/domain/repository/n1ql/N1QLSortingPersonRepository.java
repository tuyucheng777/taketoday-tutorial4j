package cn.tuyucheng.taketoday.couchbase.domain.repository.n1ql;

import cn.tuyucheng.taketoday.couchbase.domain.Person;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface N1QLSortingPersonRepository extends ReactiveCrudRepository<Person, UUID>, ReactiveSortingRepository<Person, UUID> {
}