package cn.tuyucheng.taketoday.partialupdate.repository;

import cn.tuyucheng.taketoday.partialupdate.model.ContactPhone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactPhoneRepository extends CrudRepository<ContactPhone, Long> {
   ContactPhone findById(long id);

   ContactPhone findByCustomerId(long id);
}