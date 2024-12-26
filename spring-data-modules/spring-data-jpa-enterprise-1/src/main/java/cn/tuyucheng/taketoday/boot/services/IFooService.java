package cn.tuyucheng.taketoday.boot.services;

import cn.tuyucheng.taketoday.boot.domain.Foo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFooService extends IOperations<Foo> {

   Foo retrieveByName(String name);

   Page<Foo> findPaginated(Pageable pageable);
}