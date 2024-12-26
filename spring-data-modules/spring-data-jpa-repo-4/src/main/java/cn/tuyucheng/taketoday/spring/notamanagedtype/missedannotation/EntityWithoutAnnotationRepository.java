package cn.tuyucheng.taketoday.spring.notamanagedtype.missedannotation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EntityWithoutAnnotationRepository
      extends JpaRepository<EntityWithoutAnnotation, Long> {
}