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

import java.math.BigDecimal;
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
            if(order==null){
                model.addAttribute("empleadosList",employeeRepository.listar());
            }else{
                if(order==2){
                    model.addAttribute("empleadosList",employeeRepository.listar2());
                }else{
                    model.addAttribute("empleadosList",employeeRepository.listar());
                }
            }


        return "employee/list";
    }


    //Buscar Empleado
    @PostMapping("/buscar")
    public String searchEmployee(Model model, @RequestParam(name = "search",required = false) String search, @RequestParam(name = "order", required = false) Integer order,@RequestParam(name="searchField") String valor, RedirectAttributes attributes){

        model.addAttribute("empleadosList",employeeRepository.buscar(valor));
        model.addAttribute("searchField",valor);
        return "employee/list";
    }


    //Editar Empleado
    //@...Mapping("")
    public String informEmployee(  ) {
        //        COMPLETAR
        return "XXXXXX";
    }

    //Guardar Empleado
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute(value = "empleado") EmployeesEntity empleado,
                               RedirectAttributes rttd) {
        if(empleado.getEmployeeId()==0){
            rttd.addFlashAttribute("msg", "Se creó exitosamente");
        }else{
            rttd.addFlashAttribute("msg", "Se edito exitosamente");
        }
        employeeRepository.save(empleado);
        return "redirect:/empleado/lista";
    }

    //Nuevo Empleado
    @GetMapping(value = "/edicion")
    public String editNewEmpleado(Model model,
                                  @ModelAttribute("empleado")EmployeesEntity empleado,
                                  @RequestParam("id") Integer id) {
        Optional<EmployeesEntity> opt=employeeRepository.findById(id);
        if(opt.isPresent()){
            empleado= opt.get();
        }
        model.addAttribute("empleado", empleado);
        model.addAttribute("listaDepartments", departmentRepository.findAll());
        model.addAttribute("listaJobs", jobRepository.findAll());
        //        COMPLETAR
        return "employee/Editar";
    }

    @GetMapping(value = "/nuevo")
    public String editNewEmpleado(Model model,
                                  @ModelAttribute("empleado")EmployeesEntity empleado){
        empleado.setSalary(new BigDecimal("2000.00"));

        model.addAttribute("empleado", empleado);
        model.addAttribute("listaDepartments", departmentRepository.findAll());
        model.addAttribute("listaJobs", jobRepository.findAll());
        return "employee/Editar";
    }
}
