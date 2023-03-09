package com.vivek.sbpractice.services;

import com.vivek.sbpractice.entities.Employee;
import com.vivek.sbpractice.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }


    @Override
    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee read(int id) {
        Optional<Employee> byId = employeeRepository.findById(id);
        return byId.get();
    }

    @Override
    public List<Employee> readAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> readAllByNameAndCompany(String name, String company) {
        return employeeRepository.findByNameAndCompany(name,company);
    }

    @Override
    public List<Employee> readAllByCompanyContaining(String word) {
        return employeeRepository.findByCompanyContaining(word);
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }

}