package br.com.spring.awesome.service;

import br.com.spring.awesome.Repository.StudentyRepository;
import br.com.spring.awesome.dto.StudentPostRequestBody;
import br.com.spring.awesome.dto.StudentputRequestBody;
import br.com.spring.awesome.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private  StudentyRepository studentyRepository ;

    @Autowired
    public StudentService(StudentyRepository studentyRepository) {
        this.studentyRepository = studentyRepository;
    }

    public List<Student> listAll(){
        return (List<Student>) studentyRepository.findAll();
    }

    public List<Student> findByName(String name ){
        return studentyRepository.findByNameIgnoreCaseContaining(name);
    }

    public Student findByidOrThrowBadRequestException(Long id ){
        return studentyRepository.findOne(id);
    }

    public Student save(StudentPostRequestBody studentPostRequestBody){
        return studentyRepository.save(Student.builder().name(studentPostRequestBody.getName()).build());

    }

    public void delete (Long id){
        studentyRepository.delete(findByidOrThrowBadRequestException(id));
    }
    public void replice(StudentputRequestBody studentputRequestBody){
       Student savedstudent =  findByidOrThrowBadRequestException(studentputRequestBody.getId());
        Student student =Student.builder()
                .id(savedstudent.getId())
                .name(studentputRequestBody.getName())
                .build();
        studentyRepository.save(student);
    }
}
