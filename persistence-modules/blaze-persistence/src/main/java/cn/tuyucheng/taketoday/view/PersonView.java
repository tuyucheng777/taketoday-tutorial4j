package cn.tuyucheng.taketoday.view;

import cn.tuyucheng.taketoday.model.Person;
import com.blazebit.persistence.view.EntityView;
import com.blazebit.persistence.view.IdMapping;

@EntityView(Person.class)
public interface PersonView {

   @IdMapping
   Long getId();

   int getAge();

   String getName();
}
