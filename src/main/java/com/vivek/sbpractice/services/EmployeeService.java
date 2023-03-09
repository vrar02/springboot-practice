package com.vivek.sbpractice.services;

import com.vivek.sbpractice.entities.Employee;

import java.util.List;

public interface EmployeeService {

    Employee create(Employee employee);

    Employee update(Employee employee, int id);


    Employee read(int id);

    List<Employee> readAll();

    List<Employee> readAllByNameAndCompany(String name, String company);

    List<Employee> readAllByCompanyContaining(String word);

    List<Employee> readAllByCompany(String comp);

    List<Object[]> readAllByCompanyNative(String comp);


    void delete(int id);

}
