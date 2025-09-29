package cn.tuyucheng.taketoday.dddhexagonalspring.infrastracture.configuration;

import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import cn.tuyucheng.taketoday.dddhexagonalspring.infrastracture.repository.cassandra.SpringDataCassandraOrderRepository;

@EnableCassandraRepositories(basePackageClasses = SpringDataCassandraOrderRepository.class)
public class CassandraConfiguration {
}