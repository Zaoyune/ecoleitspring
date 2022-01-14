package com.example.ecoleittp1;

import com.example.ecoleittp1.entities.Country;
import com.example.ecoleittp1.entities.Student;
import com.example.ecoleittp1.repositories.CountryRepository;
import com.example.ecoleittp1.repositories.StudentRepository;
import com.example.ecoleittp1.web.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class EcoleitTp1Application implements CommandLineRunner {
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private Controller controller;
    public static void main(String[] args) {
        SpringApplication.run(EcoleitTp1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Country c1 = countryRepository.save(new Country(null,"Morocco","Rabat",1,""));
        Country c2 = countryRepository.save(new Country(null,"France","Paris",1,""));
        Country c3 = countryRepository.save(new Country(null,"USA","Washington",1,""));
        Country c4 = countryRepository.save(new Country(null,"England","London",1,""));

        Student s1 = studentRepository.save(new Student(null,"tttttt","ttttttt",20));
        Student s2 = studentRepository.save(new Student(null,"pppppppp","ppppppp",10));
        Student s3 = studentRepository.save(new Student(null,"rrrrrrr","rrrrrrrrr",12));
        Student s4 = studentRepository.save(new Student(null,"zzzzzzzzzz","zzzzzzzzzzz",20));

        do{
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
        }while(true);
    }
}


