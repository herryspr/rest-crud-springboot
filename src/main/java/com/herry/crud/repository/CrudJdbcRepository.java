package com.herry.crud.repository;

import com.herry.crud.model.Ebook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CrudJdbcRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int save(Ebook ebook) {
        return jdbcTemplate.update("INSERT INTO ebook (title, summary, author) VALUES (?, ?, ?)",
                ebook.getTitle(), ebook.getSummary(), ebook.getAuthor());
    }

    public int update(Ebook ebook) {
        return jdbcTemplate.update("UPDATE ebook SET title=?, summary=?, author=? WHERE id=?",
                ebook.getTitle(), ebook.getSummary(), ebook.getAuthor(), ebook.getId());
    }

    public Ebook findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM ebook WHERE id=?",
                BeanPropertyRowMapper.newInstance(Ebook.class), id);
    }

    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM ebook WHERE id=?", id);
    }

    public List<Ebook> findAll() {
        return jdbcTemplate.query("SELECT * FROM ebook", BeanPropertyRowMapper.newInstance(Ebook.class));
    }

}
