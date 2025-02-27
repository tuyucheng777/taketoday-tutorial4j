package cn.tuyucheng.taketoday.batchinserts.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class School {

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private long id;

   private String name;

   @OneToMany(mappedBy = "school")
   private List<Student> students;

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public List<Student> getStudents() {
      return students;
   }

   public void setStudents(List<Student> students) {
      this.students = students;
   }
}