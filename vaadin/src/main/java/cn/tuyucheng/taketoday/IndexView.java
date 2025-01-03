package cn.tuyucheng.taketoday;

import cn.tuyucheng.taketoday.introduction.PushView;
import cn.tuyucheng.taketoday.introduction.basics.VaadinFlowBasics;
import cn.tuyucheng.taketoday.introduction.FormView;
import cn.tuyucheng.taketoday.introduction.GridView;
import cn.tuyucheng.taketoday.spring.EmployeesView;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route("")
public class IndexView extends VerticalLayout {

   public IndexView() {
      add(new H1("Vaadin Flow examples"));

      add(new RouterLink("Basics", VaadinFlowBasics.class));
      add(new RouterLink("Grid", GridView.class));
      add(new RouterLink("Form", FormView.class));
      add(new RouterLink("Push", PushView.class));
      add(new RouterLink("CRUD", EmployeesView.class));
   }
}