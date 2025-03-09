package cn.tuyucheng.taketoday.hibernate.jpacriteriabuilder.service;

import java.util.List;

import cn.tuyucheng.taketoday.hibernate.entities.DeptEmployee;

public interface EmployeeSearchService {

   List<DeptEmployee> filterbyTitleUsingCriteriaBuilder(List<String> titles);

   List<DeptEmployee> filterbyTitleUsingExpression(List<String> titles);

   List<DeptEmployee> searchByDepartmentQuery(String query);

}
