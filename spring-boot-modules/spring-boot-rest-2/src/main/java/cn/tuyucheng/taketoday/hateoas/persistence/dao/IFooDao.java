package cn.tuyucheng.taketoday.hateoas.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.tuyucheng.taketoday.hateoas.persistence.model.Foo;

public interface IFooDao extends JpaRepository<Foo, Long> {
}