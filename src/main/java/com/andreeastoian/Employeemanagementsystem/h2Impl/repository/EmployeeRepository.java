package com.andreeastoian.Employeemanagementsystem.h2Impl.repository;

import com.andreeastoian.Employeemanagementsystem.Entity.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Optional<Employee> findByEmail(String email);
    List<Employee> findByOrderByEmploymentDateAsc();
    @Query(value = "SELECT EMAIL FROM EMPLOYEE WHERE EMAIL = :email", nativeQuery = true)
    String findEmail(@Param("email") String email);
    List<Employee> findByOrderBySalaryDesc();

    List<Employee> findByOrderBySalaryAsc();

    List<Employee> findByOrderByEmployeeResignDate();

    List<Employee> findByOrderByManagerName();

    List<Employee> findByOrderByFunction();




}
