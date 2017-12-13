package com.lbb.shardingjdbc.mapper;

import com.lbb.shardingjdbc.entity.Student;

import java.util.List;

public interface StudentMapper {
    
    Integer insert(Student s);
    
    List<Student> findAll();
    
    List<Student> findByStudentIds(List<Integer> studentIds);

}
