package cn.tuyucheng.taketoday.persistence.service.common;

import cn.tuyucheng.taketoday.persistence.IOperations;
import com.google.common.collect.Lists;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Transactional
public abstract class AbstractService<T extends Serializable> implements IOperations<T> {

   @Override
   @Transactional(readOnly = true)
   public T findById(final long id) {
      return getDao().findById(id).orElse(null);
   }

   @Override
   @Transactional(readOnly = true)
   public List<T> findAll() {
      return Lists.newArrayList(getDao().findAll());
   }

   @Override
   public Page<T> findPaginated(final int page, final int size) {
      return getDao().findAll(PageRequest.of(page, size));
   }

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