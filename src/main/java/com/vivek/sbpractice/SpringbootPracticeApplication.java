package com.vivek.sbpractice;

import com.vivek.sbpractice.entities.Employee;
import com.vivek.sbpractice.repositories.EmployeeRepository;
import com.vivek.sbpractice.services.EmployeeService;
import com.vivek.sbpractice.services.EmployeeServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringbootPracticeApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(SpringbootPracticeApplication.class, args);

		Employee employee1=new Employee();
		employee1.setCompany("freddiemac");
		employee1.setName("vivek");

		Employee employee2=new Employee();
		employee2.setCompany("walmart");
		employee2.setName("ravi");

		Employee employee3=new Employee();
		employee3.setCompany("walmart");
		employee3.setName("pruthvi");

		Employee employee4=new Employee();
		employee4.setCompany("walmart");
		employee4.setName("krishna");

		EmployeeService employeeService = context.getBean(EmployeeServiceImpl.class);

		//create
		employeeService.create(employee1);
		employeeService.create(employee2);
		employeeService.create(employee3);
		employeeService.create(employee4);


		//read
		Employee emp_read = employeeService.read(2);
		System.out.println(emp_read);


		//readAll
		List<Employee> employees = employeeService.readAll();
		employees.forEach(System.out::println);


		//update
		emp_read.setName("maneesh");
		employeeService.update(emp_read);

		//delete
		employeeService.delete(1);

		//read all from name and company //jpa combination query
		List<Employee> employees1 = employeeService.readAllByNameAndCompany("maneesh", "walmart");
		employees1.forEach(System.out::println);

		//find all employees which matches the company name containing "almar"
		List<Employee> walEmployees = employeeService.readAllByCompanyContaining("almar");
		walEmployees.forEach(System.out::println);


	}

}
