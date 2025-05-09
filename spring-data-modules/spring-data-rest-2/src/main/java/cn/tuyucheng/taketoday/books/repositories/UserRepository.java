package cn.tuyucheng.taketoday.books.repositories;

import cn.tuyucheng.taketoday.books.models.WebsiteUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends CrudRepository<WebsiteUser, Long> {

   @Override
   @RestResource(exported = false)
   void delete(WebsiteUser entity);

   @Override
   @RestResource(exported = false)
   void deleteAll();

   @Override
   @RestResource(exported = false)
   void deleteAll(Iterable<? extends WebsiteUser> entities);

   @Override
   @RestResource(exported = false)
   void deleteById(Long aLong);

   @RestResource(path = "byEmail", rel = "customFindMethod")
   WebsiteUser findByEmail(@Param("email") String email);
}