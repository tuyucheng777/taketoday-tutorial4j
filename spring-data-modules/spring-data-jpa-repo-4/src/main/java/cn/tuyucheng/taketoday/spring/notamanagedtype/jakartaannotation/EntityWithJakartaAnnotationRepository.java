package cn.tuyucheng.taketoday.spring.notamanagedtype.jakartaannotation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EntityWithJakartaAnnotationRepository extends JpaRepository<EntityWithJakartaAnnotation, Long> {
}