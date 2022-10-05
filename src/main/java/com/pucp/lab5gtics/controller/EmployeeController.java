package com.pucp.lab5gtics.controller;

import com.pucp.lab5gtics.entity.EmployeesEntity;
import com.pucp.lab5gtics.repository.DepartmentRepository;
import com.pucp.lab5gtics.repository.EmployeeRepository;
import com.pucp.lab5gtics.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping(value = "/empleado")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    JobRepository jobRepository;
    @GetMapping({"/lista", "/"})
    public String listEmployee(Model model,
                               @RequestParam(name = "search",required = false) String search,
                               @RequestParam(name = "order", required = false) Integer order,
                               RedirectAttributes attributes){
        model.addAttribute("empleadosList",employeeRepository.findAll());
        return "employee/list";
    }


    //Buscar Empleado
    public String searchEmployee(Model model, @RequestParam(name = "search",required = false) String search, @RequestParam(name = "order", required = false) Integer order, RedirectAttributes attributes){

        return "XXXXXX";
    }


    //Editar Empleado
    //@...Mapping("")
    public String informEmployee(  ) {
        //        COMPLETAR
        return "XXXXXX";
    }

    //Guardar Empleado
    //@...Mapping("")
    public String saveEmployee(  ) {
        //        COMPLETAR
        return "XXXXXX";
    }

    //Nuevo Empleado
    @GetMapping(value = "/edicion")
    public String editNewEmpleado(Model model,
                                  @ModelAttribute("empleado")EmployeesEntity empleado,
                                  @RequestParam("id")int id) {

        Optional<EmployeesEntity> opt=employeeRepository.findById(id);
        if(opt.isPresent()){
            empleado= opt.get();
            model.addAttribute("empleado", empleado);
        }
        model.addAttribute("listaDepartments", departmentRepository.findAll());
        model.addAttribute("listaJobs", jobRepository.findAll());
        //        COMPLETAR
        return "employee/Editar";
    }
}
