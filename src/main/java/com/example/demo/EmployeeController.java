package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping(value="/employees")     // 通过这里配置使下面的映射都在/users下
public class EmployeeController {

    // 创建线程安全的Map
    static Map<Long, Employee> employees = Collections.synchronizedMap(new HashMap<Long, Employee>());

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Employee> getEmployeeList() {
        //处理"/employees/"的GET请求，用来获取employee列表
        // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递

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


    @RequestMapping(value="/", method=RequestMethod.POST)
    public String postEmployee(@ModelAttribute Employee employee) {

        // 处理"/employees/"的POST请求，用来创建Employee
        // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数

        employees.put(employee.getId(), employee);
        return "success";
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Employee getEmployee(@PathVariable Long id) {

        // 处理"/employees/{id}"的GET请求，用来获取url中id值的Employee信息
        // url中的id可通过@PathVariable绑定到函数的参数中

        return employees.get(id);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String putEmployee(@PathVariable Long id, @ModelAttribute Employee employee) {

        // 处理"/employees/{id}"的PUT请求，用来更新Employee信息

        Employee e = employees.get(id);

        e.setId(employee.getId());
        e.setName(employee.getName());
        e.setAge(employee.getAge());
        e.setGender(employee.getGender());
        
        employees.put(id, e);
        return "success";
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable Long id) {

        // 处理"/employees/{id}"的DELETE请求，用来删除Employee

        employees.remove(id);
        return "success";
    }

}
