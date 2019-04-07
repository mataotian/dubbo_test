package com.qf.service;

import com.qf.entity.Student;

import java.util.List;

public interface IStuService {

    void addStu(Student student);
    List<Student> queryAll();
}
