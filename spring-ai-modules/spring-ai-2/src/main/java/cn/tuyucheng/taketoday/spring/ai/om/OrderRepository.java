package cn.tuyucheng.taketoday.spring.ai.om;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<OrderInfo, Long> {
   @Override
   OrderInfo save(OrderInfo entity);

   Optional<List<OrderInfo>> findByUserID(String userID);
}