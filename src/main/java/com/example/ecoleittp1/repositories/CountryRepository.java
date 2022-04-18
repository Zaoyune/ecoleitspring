package com.example.ecoleittp1.repositories;

import com.example.ecoleittp1.entities.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@CrossOrigin(value = "*",methods = {RequestMethod.DELETE,RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.PATCH} )
@RepositoryRestResource
public interface CountryRepository extends JpaRepository<Country,Long> {
    @RestResource(path="/ByName")
    public Page<Country> findByNameContainsIgnoreCase(@Param("name") String name, Pageable pageable);
    @RestResource(path="/ByCapital")
    public Page<Country> findByCapitalContainsIgnoreCase(@Param("capital") String capital, Pageable pageable);
    //http://localhost:8080/countries/search/ByDesignationPage?des=Mo&page=0&size=5
    @RestResource(path="/name")
    public Country findByNameContainsIgnoreCase(@Param("name") String name);

    @RestResource(path="/Listname")
    public List<Country> findAllByNameContainsIgnoreCase(@Param("name") String name);

   /* @RestResource(path="/countryByName")
    public List<Country>findCountryByNameIgnoreCase(@Param("name") String name);*/

    @Query("select c from  Country c where c.name like :x or c.capital like :x")
    public Page<Country> Search(@Param("x") String mc, Pageable pageable);
    //http://localhost:8080/SPro?mc=France&page=0&size=5


}
