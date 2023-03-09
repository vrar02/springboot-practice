package com.vivek.sbpractice.repositories;

import com.vivek.sbpractice.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    List<Employee> findByNameAndCompany(String name, String company);

    List<Employee> findByCompanyContaining(String word);

    @Query("select e from Employee e where e.company=:comp")
    List<Employee> allEmployees(@Param("comp") String comp);

}
