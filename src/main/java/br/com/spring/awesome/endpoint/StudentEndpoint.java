package br.com.spring.awesome.endpoint;


import br.com.spring.awesome.error.CustomErrorType;
import br.com.spring.awesome.model.Student;
import br.com.spring.awesome.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Arrays.asList;

@RestController
@RequestMapping("students")
public class StudentEndpoint {

    private DateUtil dateUtil;

    @Autowired
    public StudentEndpoint(DateUtil dateUtil) {
        this.dateUtil = dateUtil;
    }

    @GetMapping("/list")
    public ResponseEntity<?>nselistAll(){
        System.out.println("--->>>"+dateUtil.formatLocalDateTimeToDataBaseStyle(LocalDateTime.now()));
        return new ResponseEntity<>(Student.studentList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentyById(@PathVariable("id") int id){
        Student student = new Student();
        student.setId(id);
        int index =Student.studentList.indexOf(student);
        if(index == -1){
            return new ResponseEntity<>(new CustomErrorType("Student not found"),HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(Student.studentList.get(index),HttpStatus.OK);
    }



}
