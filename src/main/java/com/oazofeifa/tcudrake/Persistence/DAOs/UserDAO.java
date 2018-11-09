package com.oazofeifa.tcudrake.Persistence.DAOs;

import com.oazofeifa.tcudrake.Persistence.Entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends CrudRepository<User,String> {
}
