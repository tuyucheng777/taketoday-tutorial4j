package cn.tuyucheng.taketoday.ratelimiting.bucket4japp;

import cn.tuyucheng.taketoday.ratelimiting.bucket4japp.service.PricingPlan;
import cn.tuyucheng.taketoday.ratelimiting.bucket4japp.service.PricingPlanService;
import io.github.bucket4j.Bucket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PricingPlanServiceUnitTest {

   private PricingPlanService service = new PricingPlanService();

   @Test
   public void givenAPIKey_whenFreePlan_thenReturnFreePlanBucket() {
      Bucket bucket = service.resolveBucket("FX001-UBSZ5YRYQ");

      assertEquals(PricingPlan.FREE.bucketCapacity(), bucket.getAvailableTokens());
   }

   @Test
   public void givenAPIKey_whenBasiclan_thenReturnBasicPlanBucket() {
      Bucket bucket = service.resolveBucket("BX001-MBSZ5YRYP");

      assertEquals(PricingPlan.BASIC.bucketCapacity(), bucket.getAvailableTokens());
   }

   @Test
   public void givenAPIKey_whenProfessionalPlan_thenReturnProfessionalPlanBucket() {
      Bucket bucket = service.resolveBucket("PX001-NBSZ5YRYY");

      assertEquals(PricingPlan.PROFESSIONAL.bucketCapacity(), bucket.getAvailableTokens());
   }
}