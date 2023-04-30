package com.geekster.University.Management.System.dao;

import com.geekster.University.Management.System.model.Department;
import com.geekster.University.Management.System.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentRepo extends JpaRepository<StudentModel,Integer> {
    @Modifying
    @Query(value="update STUDENT_TBL set DEPARTMENT=:departmentString where STUDENT_ID=:id",nativeQuery = true)
    void updateDepartment( int id,String departmentString);
}
