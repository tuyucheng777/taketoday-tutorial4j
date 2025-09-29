import cn.tuyucheng.taketoday.dddcontexts.ordercontext.repository.CustomerOrderRepository;
import cn.tuyucheng.taketoday.dddcontexts.ordercontext.service.OrderService;
import cn.tuyucheng.taketoday.dddcontexts.sharedkernel.events.EventBus;
import cn.tuyucheng.taketoday.dddcontexts.shippingcontext.repository.ShippingOrderRepository;
import cn.tuyucheng.taketoday.dddcontexts.shippingcontext.service.ShippingService;

module cn.tuyucheng.taketoday.dddcontexts.mainapp {
   uses EventBus;
   uses OrderService;
   uses CustomerOrderRepository;
   uses ShippingOrderRepository;
   uses ShippingService;
   requires transitive cn.tuyucheng.taketoday.dddcontexts.infrastructure;
}