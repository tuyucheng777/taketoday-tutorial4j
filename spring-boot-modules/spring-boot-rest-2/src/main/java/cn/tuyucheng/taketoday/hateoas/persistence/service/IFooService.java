package cn.tuyucheng.taketoday.hateoas.persistence.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cn.tuyucheng.taketoday.hateoas.persistence.IOperations;
import cn.tuyucheng.taketoday.hateoas.persistence.model.Foo;

public interface IFooService extends IOperations<Foo> {

   Page<Foo> findPaginated(Pageable pageable);
}