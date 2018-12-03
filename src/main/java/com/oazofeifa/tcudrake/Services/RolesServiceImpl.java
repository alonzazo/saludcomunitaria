package com.oazofeifa.tcudrake.Services;

import com.oazofeifa.tcudrake.Persistence.DAOs.RolesDAO;
import com.oazofeifa.tcudrake.Persistence.Entities.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RolesServiceImpl implements RolesService {

    @Autowired
    private RolesDAO rolesDAO;

    @Override
    public List<Roles> findAll() {
        List<Roles> result = new ArrayList<>();
        rolesDAO.findAll().iterator().forEachRemaining(result::add);
        return result;
    }

    @Override
    public Roles findById(Integer id) {
        return rolesDAO.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        rolesDAO.deleteById(id);
    }

    @Override
    public Roles save(Roles roles) {
        return rolesDAO.save(roles);
    }
}
