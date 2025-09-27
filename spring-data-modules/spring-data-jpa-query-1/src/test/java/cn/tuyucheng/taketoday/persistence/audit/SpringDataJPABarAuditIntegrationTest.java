package cn.tuyucheng.taketoday.persistence.audit;

import cn.tuyucheng.taketoday.persistence.config.PersistenceTestConfig;
import cn.tuyucheng.taketoday.persistence.model.Bar;
import cn.tuyucheng.taketoday.persistence.service.IBarService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.junit.*;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceTestConfig.class}, loader = AnnotationConfigContextLoader.class)
public class SpringDataJPABarAuditIntegrationTest {

   private static final Logger logger = LoggerFactory.getLogger(SpringDataJPABarAuditIntegrationTest.class);

   @BeforeClass
   public static void setUpBeforeClass() throws Exception {
      logger.info("setUpBeforeClass()");
   }

   @AfterClass
   public static void tearDownAfterClass() {
      logger.info("tearDownAfterClass()");
   }

   @Autowired
   @Qualifier("barSpringDataJpaService")
   private IBarService barService;

   @Autowired
   @Qualifier("jpaEntityManager")
   private EntityManagerFactory entityManagerFactory;

   private EntityManager em;

   @Before
   public void setUp() throws Exception {
      logger.info("setUp()");
      em = entityManagerFactory.createEntityManager();
   }

   @After
   public void tearDown() throws Exception {
      logger.info("tearDown()");
      em.close();
   }

   @Test
   @WithMockUser(username = "tutorialuser")
   public final void whenBarsModified_thenBarsAudited() {
      Bar bar = new Bar("BAR1");
      barService.create(bar);
      assertEquals(bar.getCreatedDate(), bar.getModifiedDate());
      assertEquals("tutorialuser", bar.getCreatedBy(), bar.getModifiedBy());
      bar.setName("BAR2");
      bar = barService.update(bar);
      assertTrue(bar.getCreatedDate() < bar.getModifiedDate());
      assertEquals("tutorialuser", bar.getCreatedBy(), bar.getModifiedBy());
   }
}