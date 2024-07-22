package com.herry.crud.service;

import com.herry.crud.model.Ebook;
import com.herry.crud.repository.CrudJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrudService {
    @Autowired
    private CrudJdbcRepository crudRepository;

    public int save(Ebook ebook) {
        return crudRepository.save(ebook);
    }

    public int update(Ebook ebook) {
        return crudRepository.update(ebook);
    }

    public Ebook findById(Long id) {
        return crudRepository.findById(id);
    }

    public int deleteById(Long id) {
        return crudRepository.deleteById(id);
    }

    public List<Ebook> findAll() {
        return crudRepository.findAll();
    }
}
