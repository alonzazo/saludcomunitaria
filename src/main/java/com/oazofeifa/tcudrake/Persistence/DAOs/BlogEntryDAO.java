package com.oazofeifa.tcudrake.Persistence.DAOs;

import com.oazofeifa.tcudrake.Persistence.Entities.BlogEntry;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogEntryDAO extends CrudRepository<BlogEntry,Integer> {
    List<BlogEntry> findAllByOrderByEntryIdDesc();
    @Query(value = "SELECT * FROM blog_entry WHERE news = true ORDER BY entry_id DESC LIMIT 5", nativeQuery = true)
    List<BlogEntry> findTop5ByOrderByEntryIdDesc();
}
