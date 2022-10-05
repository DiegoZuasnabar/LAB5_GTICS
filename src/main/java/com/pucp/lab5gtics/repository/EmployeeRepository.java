package com.pucp.lab5gtics.repository;

import com.pucp.lab5gtics.entity.EmployeesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//Completar
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeesEntity, Integer> {
   @Query(value="SELECT * FROM hr.employees\n" +
           "order by first_name;",nativeQuery = true)
    List<EmployeesEntity> listar();

    @Query(value="SELECT * FROM hr.employees order by first_name desc;",nativeQuery = true)
    List<EmployeesEntity> listar2();

   @Query(value="SELECT * FROM hr.employees where (first_name like %?1% or last_name like %?1% );",nativeQuery = true)
    List<EmployeesEntity> buscar(String valor);

}
