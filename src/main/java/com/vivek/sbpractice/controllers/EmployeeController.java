package com.vivek.sbpractice.controllers;

import com.vivek.sbpractice.entities.Employee;
import com.vivek.sbpractice.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //instead you can also use the controller annotation on top class + (responsebody + request mapping) on methods..
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> employees = employeeService.readAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    //create
    @PostMapping("/employees")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee employee1 = employeeService.create(employee);
        return new ResponseEntity<>(employee1,HttpStatus.CREATED);
    }

    //read
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") String id){
        Employee emp = employeeService.read(Integer.parseInt(id));
        if(emp==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return new ResponseEntity<>(emp,HttpStatus.OK);
    }


    //update
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee,@PathVariable("id") String id){
        Employee update = employeeService.update(employee,Integer.parseInt(id));
        if(update==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return  new ResponseEntity<>(update,HttpStatus.OK);
    }

    //delete
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id")String id){
        try {
            employeeService.delete(Integer.parseInt(id));
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
