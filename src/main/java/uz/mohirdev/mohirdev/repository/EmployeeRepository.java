package uz.mohirdev.mohirdev.repository;

import org.hibernate.stat.CollectionStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.mohirdev.mohirdev.entity.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{

    @Query("select e from Employee e where e.name=:name")
    List<Employee> findAll(@Param("name") String name);

    List<Employee> findAllByNameAndAndLastname(String name, String lastname);

    @Query(value = "SELECT * from Employee e where e.lastname=: name", nativeQuery = true)
    List<Employee> findalll(@Param("name") String name);

    List<Employee> findAllByNameLike(String name);

    @Query(value = "SELECT e from Employee  e where e.name like :name",nativeQuery = true)
    List<Employee> findAllByName(String name);

    @Query("select e FROM Employee e where  Upper(e.name) like concat(:name,'%')")
    List<Employee> findByName(String name);

    List<Employee> findAllByNameStartingWith(String name);

}