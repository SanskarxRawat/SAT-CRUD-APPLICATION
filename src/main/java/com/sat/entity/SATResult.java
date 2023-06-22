package com.sat.entity;


import lombok.Data;



import javax.persistence.*;

@Data
@Entity
@Table(name = "result")
public class SATResult {

    @Id
    private String name;

    private String address;

    private String city;

    private String country;

    private String pinCode;

    private Integer satScore;

    private Boolean passed;

}