package com.oazofeifa.tcudrake.Services;

import com.oazofeifa.tcudrake.Persistence.Entities.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(String id);
    void delete(String id);
    User save(User user);
}
