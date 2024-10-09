package com.example.firstProject.controller;


import com.example.firstProject.model.StudentModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")
public class FirstController {
    static public List<StudentModel> students = new ArrayList<>();
    @GetMapping
    public List<StudentModel> getAllStudents() {
        return students;
    }
    @PostMapping("/create")
    public Map<String,String> createStudent(@RequestBody StudentModel student){
        Map<String,String> output = new HashMap<>();
        students.add(student);
        output.put("message","Student created successfully");
        return output;
    }

    @DeleteMapping("/deleteStudent")
    public Map<String,String> deleteStudent(@RequestBody StudentModel studentData){
        boolean status = false;
        StudentModel currentStudent = null;
        Map<String,String> output = new HashMap<>();

        for(StudentModel student : students){
            if(student.getPrn()==studentData.getPrn()){
                currentStudent = student;
                status = true;
            }
        }
        if (status){
            students.remove(currentStudent);
            output.put("message","Student deleted successfully");
            return output;
        }
        else {
            output.put("message","Student Not present");
            return output;
        }

    }

    @PatchMapping("/updateStudent")
    public Map<String,String> updateStudent(@RequestBody StudentModel stu){
        students.forEach(student -> {
            if(student.getPrn() == stu.prn){
                student.setName(stu.name);
            }
        });
        Map<String,String> output = new HashMap<>();
        output.put("message","Student updated successfully");
        return output;
    }

}
