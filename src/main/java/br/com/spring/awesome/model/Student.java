package br.com.spring.awesome.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Arrays.asList;

public class Student {
    private int id;
     private String name;
    public static List<Student> studentList;

    static{
        StudentRepository();
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }



    public static void StudentRepository() {
        studentList = new ArrayList<>(asList(new Student(1,"Deku"),new Student(2,"Todoroki"), new Student(3,"Naruto")));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
