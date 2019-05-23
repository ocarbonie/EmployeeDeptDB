package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping("/")
    public String indexPage(Model model){
        model.addAttribute("departments", departmentRepository.findAll());
        return "deptForm";
    }
    @RequestMapping("/emplist")
    public String empList(Model model){
        model.addAttribute("employees", employeeRepository.findAll());
        return "empList";
    }
    @RequestMapping("/deptlist")
    public String deptList(Model model){
        model.addAttribute("departments", departmentRepository.findAll());
        return "deptList";
    }
    @GetMapping("/addDepartment")
        public String deptForm(Model model){
        model.addAttribute("department", new Department());
        return "deptForm";

    }
    @GetMapping("/addEmployee")
        public String empForm( Model model){
        model.addAttribute("departments", departmentRepository.findAll());
        model.addAttribute("employee", new Employee());
        return "empForm";

    }
    @RequestMapping("/detailEmp/{id}")
    public String showEmp(@PathVariable("id") long id, Model model){
        model.addAttribute("employee", employeeRepository.findById(id).get());
        return"showEmp";
    }
    @RequestMapping("/updateEmp/{id}")
    public String updateEmp(@PathVariable("id") long id, Model model){
        model.addAttribute("employee", employeeRepository.findById(id).get());
        return"empForm";
    }
    @RequestMapping("/deleteEmp/{id}")
    public String delEmp(@PathVariable("id") long id){
        employeeRepository.deleteById(id);
        return"Redirect:/empList";
    }
    @RequestMapping("/detailDept/{id}")
    public String showDept(@PathVariable("id") long id, Model model){
        model.addAttribute("deparment", departmentRepository.findById(id).get());
        return"showDept";
    }
    @RequestMapping("/updateDept/{id}")
    public String updateDept(@PathVariable("id") long id, Model model){
        model.addAttribute("deparment", departmentRepository.findById(id).get());
        return"deptForm";
    }
    @RequestMapping("/deleteDept/{id}")
    public String delDept(@PathVariable("id") long id){
       departmentRepository.deleteById(id);
        return"Redirect:/deptList";
    }


}
