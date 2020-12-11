package br.com.spring.awesome.Repository;

import br.com.spring.awesome.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentyRepository extends CrudRepository<Student,Long> {

    List<Student> findByNameIgnoreCaseContaining(String name);

}
