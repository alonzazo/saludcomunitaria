package com.oazofeifa.tcudrake.Persistence.DAOs;

import com.oazofeifa.tcudrake.Persistence.Entities.BlogEntry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogEntryDAO extends CrudRepository<BlogEntry,Integer> {
}
