package cn.tuyucheng.taketoday.jpa.projection.repository;

import cn.tuyucheng.taketoday.jpa.projection.model.Address;
import cn.tuyucheng.taketoday.jpa.projection.view.AddressView;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface AddressRepository extends Repository<Address, Long> {
   List<AddressView> getAddressByState(String state);
}