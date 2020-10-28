package br.com.spring.awesome.Repository;

import br.com.spring.awesome.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentyRepository extends CrudRepository<Student,Long> {

    List<Student> findByName(String name);
}
