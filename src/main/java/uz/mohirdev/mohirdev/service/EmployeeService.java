package uz.mohirdev.mohirdev.service;

import org.springframework.stereotype.Service;
import uz.mohirdev.mohirdev.entity.Employee;
import uz.mohirdev.mohirdev.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {
    private  final  EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;

    }
    public  Employee findById(Long id){
        Employee employee;
        employee = employeeRepository.findById(id).get();
        return  employee;

    }
    public  List<Employee> findALlBYNameAndLastname(String name){
        List<Employee> employees = employeeRepository.findalll(name);
        return employees;
    }

    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }
    public  void delete(Long id){
        employeeRepository.deleteById(id);
    }

    public List<Employee> findAllBYNameLike(String name){
        List<Employee> res = employeeRepository.findByName(name);
        return  res;

    }
}

