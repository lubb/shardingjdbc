package com.lbb.shardingjdbc.mapper;

import com.lbb.shardingjdbc.entity.User;
import java.util.List;


public interface UserMapper {
    
    Integer insert(User u);
    
    List<User> findAll();
    
    List<User> findByUserIds(List<Integer> userIds);
}
