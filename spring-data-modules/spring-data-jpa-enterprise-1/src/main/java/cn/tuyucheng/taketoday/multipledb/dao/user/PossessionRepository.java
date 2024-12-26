package cn.tuyucheng.taketoday.multipledb.dao.user;

import cn.tuyucheng.taketoday.multipledb.model.user.Possession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PossessionRepository extends JpaRepository<Possession, Long> {
}