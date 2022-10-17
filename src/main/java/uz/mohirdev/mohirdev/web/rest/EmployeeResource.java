package uz.mohirdev.mohirdev.web.rest;

import org.apache.catalina.LifecycleState;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.mohirdev.mohirdev.entity.Employee;
import uz.mohirdev.mohirdev.repository.EmployeeRepository;
import uz.mohirdev.mohirdev.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeResource {
private final EmployeeService employeeService;


    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping("/employee")
    public ResponseEntity create(@RequestBody Employee employee){
        Employee result  = employeeService.save(employee);
        return ResponseEntity.ok(result);
    }
    @PutMapping("/employee")
    public  ResponseEntity update(@RequestBody Employee employee){
        if(employee.getId()==null){
            return ResponseEntity.ok("error");
        }
        Employee result = employeeService.save(employee);
        return ResponseEntity.ok(result);


    }

   @GetMapping("/employee/{id}")
   public ResponseEntity<Employee> get(@PathVariable Long id){
        Employee result = employeeService.findById(id);
        return ResponseEntity.ok(result);
   }


    @DeleteMapping("/employee/{id}")
    public ResponseEntity del(@PathVariable Long id){
        employeeService.delete(id);
        return ResponseEntity.ok("done");

    }
    @GetMapping("/employee")
    public ResponseEntity findAll(@RequestParam String param
                                  ){
        List<Employee> employees = employeeService.findALlBYNameAndLastname(param);
        return ResponseEntity.ok(employees);}


    @GetMapping("/employee/search")
    public ResponseEntity fina(@RequestParam String name){
        List<Employee> re = employeeService.findAllBYNameLike(name);
        return ResponseEntity.ok(re);

        

    }
}
