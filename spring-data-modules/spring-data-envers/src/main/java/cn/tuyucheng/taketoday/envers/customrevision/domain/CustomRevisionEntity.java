package cn.tuyucheng.taketoday.envers.customrevision.domain;

import cn.tuyucheng.taketoday.envers.customrevision.service.CustomRevisionListener;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

@Entity
@RevisionEntity
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(CustomRevisionListener.class)
public class CustomRevisionEntity extends DefaultRevisionEntity {

   private String remoteHost;
   private String remoteUser;
}