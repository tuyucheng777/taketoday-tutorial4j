package cn.tuyucheng.taketoday.protobuf;

import cn.tuyucheng.taketoday.protobuf.TaketodayTraining.Course;

import java.util.Map;

public class CourseRepository {

   private final Map<Integer, Course> courses;

   public CourseRepository(Map<Integer, Course> courses) {
      this.courses = courses;
   }

   public Course getCourse(int id) {
      return courses.get(id);
   }
}