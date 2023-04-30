package com.geekster.University.Management.System.controller;

import com.geekster.University.Management.System.model.Department;
import com.geekster.University.Management.System.model.StudentModel;
import com.geekster.University.Management.System.service.StudentService;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
@Autowired
    StudentService studentService;
    @PostMapping("/student")
    public String addUser(@Valid @RequestBody StudentModel sm){
        studentService.studentAdd(sm);
        return "student has been added";
    }
    @GetMapping("/student")
    public List<StudentModel> getStudent(@Nullable @RequestParam int id){
        return studentService.getStudent(id);
    }
   /* @GetMapping("/getUser/{id}")
    public StudentModel getUserByid(@PathVariable Integer id){
        return studentService.findById(id);
    }*/
    @DeleteMapping("/student")
    public  void deleteStudent(@RequestParam int id){
        studentService.deleteStudent(id);
    }
    @PutMapping("/student/{department}/{id}")
    public  String updateStudent(@PathVariable int id ,@PathVariable Department department ){
        return  studentService.updateStudentInService(id,department);
    }

}
