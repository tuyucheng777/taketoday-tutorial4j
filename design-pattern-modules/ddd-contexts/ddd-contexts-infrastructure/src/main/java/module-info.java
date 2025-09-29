import cn.tuyucheng.taketoday.dddcontexts.ordercontext.repository.CustomerOrderRepository;
import cn.tuyucheng.taketoday.dddcontexts.sharedkernel.events.EventBus;
import cn.tuyucheng.taketoday.dddcontexts.shippingcontext.repository.ShippingOrderRepository;
import cn.tuyucheng.taketoday.dddcontexts.infrastructure.db.InMemoryOrderStore;
import cn.tuyucheng.taketoday.dddcontexts.infrastructure.events.SimpleEventBus;

module cn.tuyucheng.taketoday.dddcontexts.infrastructure {
   requires transitive cn.tuyucheng.taketoday.dddcontexts.sharedkernel;
   requires transitive cn.tuyucheng.taketoday.dddcontexts.ordercontext;
   requires transitive cn.tuyucheng.taketoday.dddcontexts.shippingcontext;
   provides EventBus
         with SimpleEventBus;
   provides CustomerOrderRepository
         with InMemoryOrderStore;
   provides ShippingOrderRepository
         with InMemoryOrderStore;
}