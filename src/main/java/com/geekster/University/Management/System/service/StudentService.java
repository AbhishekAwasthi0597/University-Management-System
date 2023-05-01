package com.geekster.University.Management.System.service;

import com.geekster.University.Management.System.dao.StudentRepo;
import com.geekster.University.Management.System.model.Department;
import com.geekster.University.Management.System.model.StudentModel;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;

    public void studentAdd(StudentModel sm) {
         studentRepo.save(sm);
    }

    public List<StudentModel> getStudent(Integer id) {
        List<StudentModel> list=new ArrayList<>();
        if(id==null){
            return studentRepo.findAll();
        }else{
            list.add(studentRepo.findById(id).get());
            return list;
        }

    }

  /*  public StudentModel findById(Integer id) {
        return studentRepo.findById(id).get();
    }*/

    public void deleteStudent(int id) {
        studentRepo.deleteById(id);
    }
    @Transactional
    public String updateStudentInService(int id,Department department) {
        String departmentString=department.name();
        studentRepo.updateDepartment(id,departmentString);
        return  "updated successfully";
    }


}
