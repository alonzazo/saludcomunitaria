package com.oazofeifa.tcudrake.Services;

import com.oazofeifa.tcudrake.Persistence.Entities.BlogEntry;

import java.util.List;

public interface BlogEntriesService {

    List<BlogEntry> findAll();
    List<BlogEntry> findAllByOrderByEntryIdDesc();
    BlogEntry findById(Integer id);
    void delete(Integer id);
    BlogEntry save(BlogEntry blogEntry);

}
