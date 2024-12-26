package cn.tuyucheng.taketoday.spring.data.redis.repo;

import cn.tuyucheng.taketoday.spring.data.redis.config.RedisConfig;
import cn.tuyucheng.taketoday.spring.data.redis.model.Student;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.embedded.RedisServerBuilder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RedisConfig.class)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
public class StudentRepositoryManualTest {

   @Autowired
   private StudentRepository studentRepository;

   private static redis.embedded.RedisServer redisServer;

   @BeforeClass
   public static void startRedisServer() {
      redisServer = new RedisServerBuilder().port(6379).setting("maxmemory 128M").build();
      redisServer.start();
   }

   @AfterClass
   public static void stopRedisServer() {
      redisServer.stop();
   }

   @Test
   public void whenSavingStudent_thenAvailableOnRetrieval() {
      final Student student = new Student("Eng2015001", "John Doe", Student.Gender.MALE, 1);
      studentRepository.save(student);
      final Student retrievedStudent = studentRepository.findById(student.getId()).get();
      assertEquals(student.getId(), retrievedStudent.getId());
   }

   @Test
   public void whenUpdatingStudent_thenAvailableOnRetrieval() {
      final Student student = new Student("Eng2015001", "John Doe", Student.Gender.MALE, 1);
      studentRepository.save(student);
      student.setName("Richard Watson");
      studentRepository.save(student);
      final Student retrievedStudent = studentRepository.findById(student.getId()).get();
      assertEquals(student.getName(), retrievedStudent.getName());
   }

   @Test
   public void whenSavingStudents_thenAllShouldAvailableOnRetrieval() {
      final Student engStudent = new Student("Eng2015001", "John Doe", Student.Gender.MALE, 1);
      final Student medStudent = new Student("Med2015001", "Gareth Houston", Student.Gender.MALE, 2);
      studentRepository.save(engStudent);
      studentRepository.save(medStudent);
      List<Student> students = new ArrayList<>();
      studentRepository.findAll().forEach(students::add);
      assertEquals(2, students.size());
   }

   @Test
   public void whenDeletingStudent_thenNotAvailableOnRetrieval() {
      final Student student = new Student("Eng2015001", "John Doe", Student.Gender.MALE, 1);
      studentRepository.save(student);
      studentRepository.deleteById(student.getId());
      final Student retrievedStudent = studentRepository.findById(student.getId()).orElse(null);
      assertNull(retrievedStudent);
   }
}