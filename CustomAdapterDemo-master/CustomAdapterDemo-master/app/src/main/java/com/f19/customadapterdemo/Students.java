package com.f19.customadapterdemo;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.Random;

public class Students implements Serializable {

    String name;
    int id;
    String email;
    int  marks;


    public Students(String name, int id, String email, int marks) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.marks = marks;

    }



    @NonNull
    @Override
    public String toString() {
        return name + "\n" + id + "\n" + email;
    }
}
