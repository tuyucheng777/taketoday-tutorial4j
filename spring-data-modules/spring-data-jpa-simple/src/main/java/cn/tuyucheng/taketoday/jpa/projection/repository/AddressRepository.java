package cn.tuyucheng.taketoday.jpa.projection.repository;

import java.util.List;

import cn.tuyucheng.taketoday.jpa.projection.view.AddressDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import cn.tuyucheng.taketoday.jpa.projection.model.Address;
import cn.tuyucheng.taketoday.jpa.projection.view.AddressView;
import org.springframework.data.repository.query.Param;

public interface AddressRepository extends Repository<Address, Long> {
   List<AddressView> getAddressByState(String state);

   @Query("SELECT c.zipCode as zipCode, c.person as person FROM Address c WHERE c.state = :state")
   List<AddressView> getViewAddressByState(@Param("state") String state);

   @Query("SELECT new cn.tuyucheng.taketoday.jpa.projection.view.AddressDto(a.zipCode," +
         "new cn.tuyucheng.taketoday.jpa.projection.view.PersonDto(p.firstName, p.lastName)) " +
         "FROM Address a JOIN a.person p WHERE a.state = :state")
   List<AddressDto> findAddressByState(@Param("state") String state);
}