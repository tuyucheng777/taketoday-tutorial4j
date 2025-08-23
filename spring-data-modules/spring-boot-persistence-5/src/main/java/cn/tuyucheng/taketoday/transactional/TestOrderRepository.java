package cn.tuyucheng.taketoday.transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestOrderRepository extends JpaRepository<TestOrder, Long> {
}