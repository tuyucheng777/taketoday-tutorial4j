package cn.tuyucheng.taketoday.spring.data.jpa.getnextseq;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.math.BigInteger;

@Service
public class MyEntityService {

   @PersistenceContext
   private EntityManager entityManager;

   public Long getNextSequenceValue(String sequenceName) {
      BigInteger nextValue = (BigInteger) entityManager.createNativeQuery("SELECT NEXTVAL(:sequenceName)")
            .setParameter("sequenceName", sequenceName)
            .getSingleResult();
      return nextValue.longValue();
   }
}