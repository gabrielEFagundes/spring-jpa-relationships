package com.at.one.repository;

import com.at.one.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    // I have to
    @Query("SELECT d FROM Department d JOIN d.employees e WHERE e.id = :id")
    Optional<Department> findByEmployeeId(@Param("id") Long id);

    // 😭
    @Query("SELECT d FROM Department d JOIN d.employees e WHERE e.name = :name")
    List<Department> findByEmployeeName(@Param("name") String name);
}
