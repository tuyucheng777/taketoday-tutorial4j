package cn.tuyucheng.taketoday.listvsset.eager.list.moderatedomain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
