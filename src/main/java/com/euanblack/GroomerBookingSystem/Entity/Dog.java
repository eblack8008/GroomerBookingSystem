package com.euanblack.GroomerBookingSystem.Entity;

import com.euanblack.GroomerBookingSystem.Entity.Customer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "dog")
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int dogId;

    @Column(name="breed")
    private String breed;

    @Column(name= "size")
    private String size;

    @Column(name = "age")
    private int age;

    @ManyToOne
    @JoinColumn(name = "ownerId")
    @JsonIgnore
    private Customer customer;

    public Dog() {
    }

    public Dog(String breed, String size, int age) {
        this.breed = breed;
        this.size = size;
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getDogId() {
        return dogId;
    }

    public void setDogId(int dogId) {
        this.dogId = dogId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + dogId +
                ", breed='" + breed + '\'' +
                ", size='" + size + '\'' +
                ", age=" + age +
                '}';
    }
}
