package cn.tuyucheng.taketoday.boot.daos.impl;

import cn.tuyucheng.taketoday.boot.daos.CustomItemTypeRepository;
import cn.tuyucheng.taketoday.boot.domain.ItemType;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomItemTypeRepositoryImpl implements CustomItemTypeRepository {

   @Autowired
   private EntityManager entityManager;

   @Override
   public void deleteCustom(ItemType itemType) {
      entityManager.remove(itemType);
   }

   @Override
   public void findThenDelete(Long id) {
      ItemType itemTypeToDelete = entityManager.find(ItemType.class, id);
      entityManager.remove(itemTypeToDelete);
   }
}