package com.example.ecoleittp1.repositories;

import com.example.ecoleittp1.entities.Country;
import com.example.ecoleittp1.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@CrossOrigin(value = "*",methods = {RequestMethod.DELETE,RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.PATCH} )
@RepositoryRestResource
public interface StudentRepository extends JpaRepository<Student,Long> {
    public List<Student> findStudentByNoteIsGreaterThan(@Param("des") double note);
}
