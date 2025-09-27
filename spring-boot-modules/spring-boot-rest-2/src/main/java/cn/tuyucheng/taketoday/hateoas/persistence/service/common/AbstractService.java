package cn.tuyucheng.taketoday.hateoas.persistence.service.common;

import cn.tuyucheng.taketoday.hateoas.persistence.IOperations;
import com.google.common.collect.Lists;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Transactional
public abstract class AbstractService<T extends Serializable> implements IOperations<T> {

   // read - one

   @Override
   @Transactional(readOnly = true)
   public T findById(final long id) {
      return getDao().findById(id).orElse(null);
   }

   // read - all

   @Override
   @Transactional(readOnly = true)
   public List<T> findAll() {
      return Lists.newArrayList(getDao().findAll());
   }

   // write

   @Override
   public T create(final T entity) {
      return getDao().save(entity);
   }

   @Override
   public T update(final T entity) {
      return getDao().save(entity);
   }

   @Override
   public void delete(final T entity) {
      getDao().delete(entity);
   }

   @Override
   public void deleteById(final long entityId) {
      getDao().deleteById(entityId);
   }

   protected abstract JpaRepository<T, Long> getDao();
}