package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class EmployeeController {

    @RequestMapping(value = "/employees",method = RequestMethod.GET)
    public List<Employee> getEmployeeList() {
        List<Employee> employeeList = new ArrayList<>();

        Employee employee1 = new Employee(0,"小明",20,"男");
        Employee employee2 = new Employee(1,"小红",19,"女");
        Employee employee3 = new Employee(3,"小刚",16,"男");
        Employee employee4 = new Employee(4,"小霞",15,"女");

        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        employeeList.add(employee4);

        return employeeList;
    }

}
