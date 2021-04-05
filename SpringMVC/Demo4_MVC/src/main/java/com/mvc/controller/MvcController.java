package com.mvc.controller;

import com.mvc.dao.DepartmentDao;
import com.mvc.dao.EmployeeDao;
import com.mvc.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class MvcController {
    @RequestMapping("/success")
    public String mvc(){
        return "success";
    }

    @RequestMapping("/sub")
    public String submit(){
        return "submit";
    }

//    ______________________________________________
    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping("/info")
    public String info(Map<String,Object> map){
        map.put("employees",employeeDao.getAll());
        return "info";
    }

    @Autowired
    private DepartmentDao departmentDao;

    @RequestMapping(value = "emp",method = RequestMethod.GET)
    public String submit(Map<String,Object> map){
        map.put("departments",departmentDao.getDepartments());
        map.put("employee",new Employee());
        return "submit";
    }

//    @RequestMapping(value = "emp",method = RequestMethod.POST)
//    public String save(Employee employee){
//        employeeDao.save(employee);
//        return "redirect:/info";
//
//    }
}
