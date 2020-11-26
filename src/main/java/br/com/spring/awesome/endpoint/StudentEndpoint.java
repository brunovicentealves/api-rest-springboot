package br.com.spring.awesome.endpoint;


import br.com.spring.awesome.Repository.StudentyRepository;
import br.com.spring.awesome.error.CustomErrorType;
import br.com.spring.awesome.error.ResourceNotFoundException;
import br.com.spring.awesome.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("students")
public class StudentEndpoint {


    private StudentyRepository studentyRepository;

    @Autowired
    public StudentEndpoint(StudentyRepository studentyRepository) {
        this.studentyRepository = studentyRepository;
    }

    @GetMapping
    public ResponseEntity<?>listAllStudenty(){
        return new ResponseEntity<>(studentyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentyById(@PathVariable("id") Long id){
        Student student = studentyRepository.findOne(id);
        verifyIfStudentExists(id);
        return  new ResponseEntity<>(student,HttpStatus.OK);
    }
    @GetMapping("/findByName/{name}")
    public ResponseEntity<?> findStudentByName(@PathVariable String name){
        return new ResponseEntity<>(studentyRepository.findByNameIgnoreCaseContaining(name),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?>saveStudenty(@RequestBody Student student){
        return new ResponseEntity<>(studentyRepository.save(student),HttpStatus.CREATED);
    }
    @DeleteMapping
    public ResponseEntity<?> deleteStudenty(@PathVariable Long id){
        verifyIfStudentExists(id);
       studentyRepository.delete(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateStudenty (@RequestBody Student student){
        verifyIfStudentExists(student.getId());
        studentyRepository.save(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void verifyIfStudentExists(Long id){

        if(studentyRepository.findOne(id) == null){
            throw new ResourceNotFoundException("Student not found for ID : "+id);
        }
    }




}
