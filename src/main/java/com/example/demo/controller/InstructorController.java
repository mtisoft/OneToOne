package com.example.demo.controller;

import com.example.demo.model.Instructor;
import com.example.demo.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class InstructorController {

    @Autowired  // dependency injection.
    InstructorRepository instructorRepository;

    //add instructor

    @PostMapping
    public ResponseEntity<Instructor> add_instructor(@RequestBody Instructor instructor){

//        if (instructor.getId()<0){
//            return new ResponseEntity<Instructor>(new Instructor(), HttpStatus.BAD_REQUEST);
//        }else{
//
//        }

        return  new ResponseEntity<Instructor>(instructorRepository.save(instructor),HttpStatus.OK);
    }

    //listAll instructor
    @GetMapping
    public ResponseEntity<List<Instructor>> get_all_insturctor(){

        List<Instructor> list_instructor= new ArrayList<>();

        Iterable<Instructor> interable = instructorRepository.findAll();

        interable.forEach(instructor -> {
            list_instructor.add(instructor);
        });

//        for (Instructor instructor : request) {
//            //System.out.println(instructor.getLastname()+" **************************");
//            list_instructor.add(instructor);
//        }

        return new ResponseEntity<List<Instructor>>(list_instructor,HttpStatus.OK);
    }

    //listone instructor
    @GetMapping("/{index}")
    public ResponseEntity<Instructor> get_one_instructor(@PathVariable Long index){
        Optional<Instructor> element = instructorRepository.findById(index);
        if (element.isPresent()){
            return new ResponseEntity<Instructor>(element.get(),HttpStatus.OK);
        }else{
            return  new ResponseEntity<Instructor>(new Instructor(),HttpStatus.BAD_REQUEST);
        }
    }

    //update instructor
    @PutMapping("/{index}")
    public ResponseEntity<Instructor> update_instructor(@PathVariable Long index , @RequestBody Instructor instructor){
        Optional<Instructor> element = instructorRepository.findById(index);
        if (element.isPresent()){
            // updation code

            Instructor inst = element.get();

            inst.setEmail(instructor.getEmail());
            inst.setFirstname(instructor.getFirstname());
            inst.setLastname(instructor.getLastname());

            inst.setInstructorDetail(instructor.getInstructorDetail());


            // i have to look how to do to change the instructorDetail object of this instructor object

            return new ResponseEntity<Instructor>(instructorRepository.save(inst),HttpStatus.OK);
        }else{
            return  new ResponseEntity<Instructor>(new Instructor(),HttpStatus.BAD_REQUEST);
        }

    }

    //delete instructor
    @DeleteMapping("/{index}")
    public String delete_Instructor(@PathVariable Long index){
        Optional<Instructor> element = instructorRepository.findById(index);
        if (element.isPresent()){
            String instructor_name = element.get().getLastname();
            instructorRepository.deleteById(index);
            return " the Instructor : "+instructor_name + " Deleted successfully";
        }else{
            return "ERREUR Deleting !!!";
        }
    }

}
