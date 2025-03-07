package cn.tuyucheng.taketoday.spring.data.couchbase2b.service;

import cn.tuyucheng.taketoday.spring.data.couchbase.model.Student;
import cn.tuyucheng.taketoday.spring.data.couchbase2b.repos.StudentRepository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

   private StudentRepository repo;

   @Autowired
   public void setStudentRepository(StudentRepository repo) {
      this.repo = repo;
   }

   public Optional<Student> findOne(String id) {
      return repo.findById(id);
   }

   public List<Student> findAll() {
      List<Student> people = new ArrayList<>();
      for (Student student : repo.findAll()) {
         people.add(student);
      }
      return people;
   }

   public List<Student> findByFirstName(String firstName) {
      return repo.findByFirstName(firstName);
   }

   public List<Student> findByLastName(String lastName) {
      return repo.findByLastName(lastName);
   }

   public void create(Student student) {
      student.setCreated(DateTime.now());
      repo.save(student);
   }

   public void update(Student student) {
      student.setUpdated(DateTime.now());
      repo.save(student);
   }

   public void delete(Student student) {
      repo.delete(student);
   }
}