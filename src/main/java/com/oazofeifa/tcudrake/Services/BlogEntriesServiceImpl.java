package com.oazofeifa.tcudrake.Services;

import com.oazofeifa.tcudrake.Persistence.DAOs.BlogEntryDAO;
import com.oazofeifa.tcudrake.Persistence.Entities.BlogEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "blogEntriesService")
public class BlogEntriesServiceImpl implements BlogEntriesService {

    @Autowired
    private BlogEntryDAO blogEntryDAO;

    @Override
    public List<BlogEntry> findAll() {
        List<BlogEntry> list = new ArrayList<>();
        blogEntryDAO.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    public List<BlogEntry> findAllByOrderByEntryIdDesc(){
        List<BlogEntry> list = new ArrayList<>();
        blogEntryDAO.findAllByOrderByEntryIdDesc().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public BlogEntry findById(Integer id) {
        return blogEntryDAO.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        blogEntryDAO.deleteById(id);
    }

    @Override
    public BlogEntry save(BlogEntry blogEntry) {
        return blogEntryDAO.save(blogEntry);
    }
}
