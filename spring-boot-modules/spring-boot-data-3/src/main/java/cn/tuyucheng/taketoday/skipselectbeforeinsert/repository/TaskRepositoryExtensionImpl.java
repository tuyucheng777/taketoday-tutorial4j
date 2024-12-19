package cn.tuyucheng.taketoday.skipselectbeforeinsert.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import cn.tuyucheng.taketoday.skipselectbeforeinsert.model.Task;

@Component
public class TaskRepositoryExtensionImpl implements TaskRepositoryExtension {
   @PersistenceContext
   private EntityManager entityManager;

   @Override
   public Task persistAndFlush(Task task) {
      entityManager.persist(task);
      entityManager.flush();
      return task;
   }
}