package com.lbb.shardingjdbc.service.impl;

import javax.annotation.Resource;

import com.lbb.shardingjdbc.entity.Student;
import com.lbb.shardingjdbc.mapper.StudentMapper;
import com.lbb.shardingjdbc.service.StudentService;
import org.springframework.stereotype.Service;
@Service
public class StudentServiceImpl implements StudentService {
    
    @Resource
    public StudentMapper studentMapper;

    public boolean insert(Student student) {
        return studentMapper.insert(student) > 0 ? true : false;
    }

}
