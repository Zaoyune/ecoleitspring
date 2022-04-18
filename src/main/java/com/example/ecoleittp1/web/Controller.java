package com.example.ecoleittp1.web;

import com.example.ecoleittp1.Exceptions.CountryNotFoundException;
import com.example.ecoleittp1.entities.Country;
import com.example.ecoleittp1.repositories.CountryRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@CrossOrigin(value = "*",methods = {RequestMethod.DELETE,RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE} )
@RestController
public class Controller {
    @Autowired
    private CountryRepository countryRepository;


    @GetMapping(path = "/photoCountry/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPhoto(@PathVariable("id") Long id) throws IOException {
        Country country = countryRepository.findById(id).get();
        return Files.readAllBytes(Paths.get("src","main","resources","photos/" + country.getFlag()));
    }

    @PostMapping(path = "/uploadPhoto/{id}")
    public void uploadPhoto(MultipartFile file, @PathVariable Long id) throws IOException {
        Country country = countryRepository.findById(id).get();
        country.setFlag(id + "__" + file.getOriginalFilename());
        Files.write(Paths.get("src","main","resources","photos/" + country.getFlag()), file.getBytes());
        countryRepository.save(country);
    }


    @GetMapping(value="/listcountries")
    public List<Country> ListCountries(){
        return countryRepository.findAll();
    }

    @GetMapping(value="/countryy/{id}")
    public Country Countries(@PathVariable(name="id") Long id){
        try {
            return countryRepository.findById(id).get();
        }catch (Exception e){
            throw new CountryNotFoundException("Country Not found With This ID : "+ id);
        }

    }

    @PutMapping(value="/updatecountry/{id}")
    public Country update(@PathVariable(name="id") Long id,@RequestBody Country c){
        c.setId(id);
        return countryRepository.save(c);

    }

    @PostMapping(value="/AddCountry")
    public Country save(@NotNull @RequestBody Country c){
        try {
           return countryRepository.save(c);
        }catch (Exception e){
            throw new CountryNotFoundException("Impossible to add this new Country");
        }
    }

    @DeleteMapping(value="/deletecountry/{id}")
    public void delete(@PathVariable(name="id") Long id){
        try {
            countryRepository.deleteById(id);
        }catch (Exception e){
            throw new CountryNotFoundException("Country not found with the current ID : "+id);
        }

    }

    @GetMapping(value="/FindCountry")
    Page<Country> FindCountry(@RequestParam(name = "name",defaultValue = "") String name,
                                     @RequestParam(name = "page",defaultValue = "0")int page,
                                     @RequestParam(name = "size",defaultValue = "5")int size){
        try {
           return countryRepository.findByNameContainsIgnoreCase(name,PageRequest.of(page,size));
        }catch (Exception e){
            throw new CountryNotFoundException("Country Not found With This NAME : "+ name);
        }
        //http://localhost:8080/FindCountry?name=fr&page=0&size=5
    }

    @GetMapping(value="/FindCount")
    Country FindCountry(@RequestParam(name = "name",defaultValue = "") String name){
        try {
            return countryRepository.findByNameContainsIgnoreCase(name);
        }catch (Exception e){
            throw new CountryNotFoundException("Country Not found With This NAME : "+ name);
        }
        //http://localhost:8080/FindCountry?name=fr&page=0&size=5
    }
    @GetMapping(value="/FindCountLisT")
    List<Country> FindCountryList(@RequestParam(name = "name",defaultValue = "") String name){
        try {
            return countryRepository.findAllByNameContainsIgnoreCase(name);
        }catch (Exception e){
            throw new CountryNotFoundException("Country Not found With This NAME : "+ name);
        }
        //http://localhost:8080/FindCountry?name=fr&page=0&size=5
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exeptionHandler(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    /***********************************************************************************************/

}
