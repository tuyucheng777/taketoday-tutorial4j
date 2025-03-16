package cn.tuyucheng.taketoday.spring.notamanagedtype.missedannotationfixed;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EntityWithoutAnnotationFixedRepository
      extends JpaRepository<EntityWithoutAnnotationFixed, Long> {

}
