package com.example.ecoleittp1.web;

import com.example.ecoleittp1.entities.Country;
import com.example.ecoleittp1.entities.Student;
import com.example.ecoleittp1.repositories.CountryRepository;
import com.example.ecoleittp1.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*",methods = {RequestMethod.DELETE,RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE} )
@RestController
public class Controller {
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping(value="/listcountries")
    public List<Country> ListCountries(){
        return countryRepository.findAll();
    }

    @GetMapping(value="/countryy/{id}")
    public Country Countries(@PathVariable(name="id") Long id){
        return countryRepository.findById(id).get();
    }

    @PutMapping(value="/updatecountry/{id}")
    public Country update(@PathVariable(name="id") Long id,@RequestBody Country c){
        c.setId(id);
        return countryRepository.save(c);
    }

    @PostMapping(value="/AddCountry")
    public Country save(@RequestBody Country c){
        return countryRepository.save(c);
    }

    @DeleteMapping(value="/deletecountry/{id}")
    public void delete(@PathVariable(name="id") Long id){

        countryRepository.deleteById(id);
    }

    /***********************************************************************************************/

    @GetMapping(value="/liststudent")
    public List<Student> ListStudents(){
        return studentRepository.findAll();
    }

    @GetMapping(value="/studentt/{id}")
    public Student students(@PathVariable(name="id") Long id){
        return studentRepository.findById(id).get();
    }

    @PutMapping(value="/updatestudent/{id}")
    public Student updatestdent(@PathVariable(name="id") Long id,@RequestBody Student s){
        s.setId(id);
        return studentRepository.save(s);
    }

    @PostMapping(value="/AddStudend")
    public Student save(@RequestBody Student s){
        return studentRepository.save(s);
    }

    @DeleteMapping(value="/deletestudent/{id}")
    public void deletes(@PathVariable(name="id") Long id){

        studentRepository.deleteById(id);
    }
}
