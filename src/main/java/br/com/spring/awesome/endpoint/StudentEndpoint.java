package br.com.spring.awesome.endpoint;


import br.com.spring.awesome.Repository.StudentyRepository;
import br.com.spring.awesome.error.CustomErrorType;
import br.com.spring.awesome.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("students")
public class StudentEndpoint {
    @Autowired
    private StudentyRepository studentyRepository;


    @GetMapping
    public ResponseEntity<?>listAllStudenty(){
        return new ResponseEntity<>(studentyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentyById(@PathVariable("id") Long id){
        Student student = studentyRepository.findOne(id);
        if(student == null){
            return new ResponseEntity<>(new CustomErrorType("Student not found"),HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(student,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?>saveStudenty(@RequestBody Student student){
        return new ResponseEntity<>(studentyRepository.save(student),HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<?> deleteStudenty(@PathVariable Long id){
       studentyRepository.delete(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateStudenty (@RequestBody Student student){
        studentyRepository.save(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }





}
