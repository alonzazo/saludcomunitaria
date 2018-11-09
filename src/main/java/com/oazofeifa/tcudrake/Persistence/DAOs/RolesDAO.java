package com.oazofeifa.tcudrake.Persistence.DAOs;

import com.oazofeifa.tcudrake.Persistence.Entities.Roles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesDAO extends CrudRepository<Roles,Integer> {
}
