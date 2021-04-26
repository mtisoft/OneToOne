package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="instructor")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="firstname",length = 50)
    private String firstname;

    @Column(name="lastname" ,length = 50)
    private String lastname;

    @Column(name="email" , length = 50)
    private String email;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY )  // cascade : in case of update or delate all related entity will be affected. // note if you remove coscade , then an update on the entity will not affect the other
    @JoinColumn(name="instructor_detail_id")  // here we define the foregn key that will present in instructor table
    private InstructorDetail instructorDetail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public InstructorDetail getInstructorDetail() {
        return instructorDetail;
    }

    public void setInstructorDetail(InstructorDetail instructorDetail) {
        this.instructorDetail = instructorDetail;
    }

    public Instructor(){

    }

    public Instructor(String firstname, String lastname, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }
}
