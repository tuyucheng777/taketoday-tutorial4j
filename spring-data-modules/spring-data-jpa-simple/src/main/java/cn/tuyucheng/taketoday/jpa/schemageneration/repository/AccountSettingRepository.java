package cn.tuyucheng.taketoday.jpa.schemageneration.repository;

import cn.tuyucheng.taketoday.jpa.schemageneration.model.AccountSetting;
import org.springframework.data.repository.CrudRepository;

public interface AccountSettingRepository extends CrudRepository<AccountSetting, Long> {

   AccountSetting findByAccountId(Long accountId);
}