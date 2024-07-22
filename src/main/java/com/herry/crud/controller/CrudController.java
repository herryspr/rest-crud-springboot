package com.herry.crud.controller;

import com.herry.crud.model.Ebook;
import com.herry.crud.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ebooks")
public class CrudController {
    @Autowired
    private CrudService crudService;

    @PostMapping
    public ResponseEntity<Ebook> createEbook(@RequestBody Ebook ebook) {
        crudService.save(ebook);
        return new ResponseEntity<>(ebook, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ebook> getEbookById(@PathVariable Long id) {
        Ebook ebook = crudService.findById(id);
        return new ResponseEntity<>(ebook, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ebook> updateEbook(@PathVariable Long id, @RequestBody Ebook ebookDetails) {
        Ebook ebook = crudService.findById(id);
        ebook.setTitle(ebookDetails.getTitle());
        ebook.setSummary(ebookDetails.getSummary());
        ebook.setAuthor(ebookDetails.getAuthor());
        crudService.update(ebook);
        return new ResponseEntity<>(ebook, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEbook(@PathVariable Long id) {
        crudService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<Ebook>> getAllEbooks() {
        List<Ebook> ebooks = crudService.findAll();
        return new ResponseEntity<>(ebooks, HttpStatus.OK);
    }
}
