package com.example.ecoleittp1;

import com.example.ecoleittp1.entities.Country;
import com.example.ecoleittp1.repositories.CountryRepository;
import com.example.ecoleittp1.web.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcoleitTp1Application implements CommandLineRunner {
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private Controller controller;
    public static void main(String[] args) {
        SpringApplication.run(EcoleitTp1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Country c1 = countryRepository.save(new Country(null,"Morocco","Rabat","morocco.png","ergergegergergergzegzergzergzregergergerzgzergerzgerberbe"));
        Country c2 = countryRepository.save(new Country(null,"France","Paris","france.png","ergergegergergergzegzergzergzregergergerzgzergerzgerberbe"));
        Country c3 = countryRepository.save(new Country(null,"USA","Washington","usa.png","ergergegergergergzegzergzergzregergergerzgzergerzgerberbe"));
        Country c4 = countryRepository.save(new Country(null,"England","London","england.png","ergergegergergergzegzergzergzregergergerzgzergerzgerberbe"));
        Country c5 = countryRepository.save(new Country(null,"Algeria","Algeria","algeria.png","ergergegergergergzegzergzergzregergergerzgzergerzgerberbe"));
        Country c6 = countryRepository.save(new Country(null,"Spain","Madrid","spain.png","ergergegergergergzegzergzergzregergergerzgzergerzgerberbe"));
        Country c7 = countryRepository.save(new Country(null,"Germany","Berlin","germany.png","ergergegergergergzegzergzergzregergergerzgzergerzgerberbe"));
        Country c8 = countryRepository.save(new Country(null,"Canada","Ottawa","canada.png","ergergegergergergzegzergzergzregergergerzgzergerzgerberbe"));
        Country c9 = countryRepository.save(new Country(null,"Japan","Tokyo","Japan.png","ergergegergergergzegzergzergzregergergerzgzergerzgerberbe"));
        Country c10 = countryRepository.save(new Country(null,"China","Pekin","china.png","ergergegergergergzegzergzergzregergergerzgzergerzgerberbe"));
        Country c11 = countryRepository.save(new Country(null,"South Korea","Séoul","Korea.png","ergergegergergergzegzergzergzregergergerzgzergerzgerberbe"));
        Country c12 = countryRepository.save(new Country(null,"Belgium","Bruxelle","Belgium.png","ergergegergergergzegzergzergzregergergerzgzergerzgerberbe"));
        Country c13 = countryRepository.save(new Country(null,"Italy","Rome","italy.png","ergergegergergergzegzergzergzregergergerzgzergerzgerberbe"));
        Country c14 = countryRepository.save(new Country(null,"Portugal","Lisbonne","portugal.png","ergergegergergergzegzergzergzregergergerzgzergerzgerberbe"));
        Country c15 = countryRepository.save(new Country(null,"Switzerland","Berne","switzerland.png","ergergegergergergzegzergzergzregergergerzgzergerzgerberbe"));
        Country c16 = countryRepository.save(new Country(null,"Sweden","Stockholm","sweden.png","ergergegergergergzegzergzergzregergergerzgzergerzgerberbe"));
        Country c17 = countryRepository.save(new Country(null,"Denmark","Copenhagen","denmark.png","ergergegergergergzegzergzergzregergergerzgzergerzgerberbe"));
        Country c18 = countryRepository.save(new Country(null,"Finland","Helsinki","finland.png","ergergegergergergzegzergzergzregergergerzgzergerzgerberbe"));


    /*    do{
            System.out.println("Menu");
            System.out.println("1 ==> Students list");
            System.out.println("2 ==> Add Student");
            System.out.println("3 ==> Update Student");
            System.out.println("4 ==> Delete Student");
            System.out.println("5 ==> Search Student note greater than : ");
            System.out.println("9 ==> Exit");
            System.out.println("type your answer : ");
            Scanner Response = new Scanner(System.in);  // Create a Scanner object
            String input = Response.nextLine();
            List<Student>students = studentRepository.findAll();
            if(input.equals("9")){ System.out.println("you exited"); break;}
            if(input.equals("1")){
                List<Student>stds = studentRepository.findAll();
                stds.forEach(s->{
                    System.out.println(s.getId()+" "+s.getPrenom()+" "+s.getNom()+" "+s.getNote());
                });
            }else if(input.equals("2")){
                System.out.println("Put your object");
                String prenom = Response.next();
                String nom = Response.next();
                double note = Double.parseDouble(Response.next());
                Student s5 = studentRepository.save(new Student(null,prenom,nom,note));
                    System.out.println(s5.getId()+" "+s5.getPrenom()+" "+s5.getNom()+" "+s5.getNote());
                    students.add(s5);
                    System.out.println(s5);
            }else if(input.equals("3")){
                System.out.println("Put your object id");
                Long id = Long.valueOf(Response.next());
                System.out.println("Type your new object");
                String prenom = Response.next();
                String nom = Response.next();
                double note = Double.parseDouble(Response.next());
                Student updatedstudent = studentRepository.findById(id).get();
                updatedstudent.setId(id);
                updatedstudent.setPrenom(prenom);
                updatedstudent.setNom(nom);
                updatedstudent.setNote(note);
                Student s6 = studentRepository.save(updatedstudent);
                System.out.println(s6.getId()+" "+s6.getPrenom()+" "+s6.getNom()+" "+s6.getNote());
            }else if(input.equals("4")){
                System.out.println("Put student id to delete");
                Long id = Long.valueOf(Response.next());
                studentRepository.deleteById(id);
            }else if(input.equals("5")){
               List<Student>students1 = studentRepository.findStudentByNoteIsGreaterThan(15);
                students1.forEach(s->{
                    System.out.println(s.getId()+" "+s.getPrenom()+" "+s.getNom()+" "+s.getNote());
                });
            }
        }while(true);*/
    }
}


