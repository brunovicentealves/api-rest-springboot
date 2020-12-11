package br.com.spring.awesome.endpoint;


import br.com.spring.awesome.Repository.StudentyRepository;
import br.com.spring.awesome.dto.StudentPostRequestBody;
import br.com.spring.awesome.dto.StudentputRequestBody;
import br.com.spring.awesome.error.CustomErrorType;
import br.com.spring.awesome.error.ResourceNotFoundException;
import br.com.spring.awesome.model.Student;
import br.com.spring.awesome.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("students")
public class StudentEndpoint {
    @Autowired
    private StudentyRepository studentyRepository;
    private StudentService studentService;

    @Autowired
    public StudentEndpoint(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<?>listAllStudenty(){
        return new ResponseEntity<>(studentService.listAll(), HttpStatus.OK);
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
    public ResponseEntity<?>saveStudenty(@RequestBody StudentPostRequestBody studentPostRequestBody){
        return new ResponseEntity<>(studentService.save(studentPostRequestBody),HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudenty(@PathVariable Long id){
        verifyIfStudentExists(id);
       studentService.delete(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateStudenty (@RequestBody StudentputRequestBody studentputRequestBody ){
        studentService.replice(studentputRequestBody);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void verifyIfStudentExists(Long id){

        if(studentyRepository.findOne(id) == null){
            throw new ResourceNotFoundException("Student not found for ID : "+id);
        }
    }




}
