package cn.tuyucheng.taketoday.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.tuyucheng.taketoday.persistence.model.Foo;

public interface IFooDao extends JpaRepository<Foo, Long> {
}