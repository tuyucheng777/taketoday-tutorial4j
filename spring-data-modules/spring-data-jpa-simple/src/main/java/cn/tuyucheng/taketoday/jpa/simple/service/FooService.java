package cn.tuyucheng.taketoday.jpa.simple.service;

import cn.tuyucheng.taketoday.jpa.simple.model.Foo;
import cn.tuyucheng.taketoday.jpa.simple.repository.IFooDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FooService implements IFooService {

   @Autowired
   private IFooDAO dao;

   @Override
   public Foo create(Foo foo) {
      return dao.save(foo);
   }
}