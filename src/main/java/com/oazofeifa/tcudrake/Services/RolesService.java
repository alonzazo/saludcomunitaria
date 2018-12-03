package com.oazofeifa.tcudrake.Services;

import com.oazofeifa.tcudrake.Persistence.Entities.Roles;
import com.oazofeifa.tcudrake.Persistence.Entities.User;

import java.util.List;

public interface RolesService {
    List<Roles> findAll();
    Roles findById(Integer id);
    void delete(Integer id);
    Roles save(Roles uroles);
}
