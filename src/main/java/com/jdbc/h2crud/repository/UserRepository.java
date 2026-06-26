package com.jdbc.h2crud.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jdbc.h2crud.model.User;

@Repository
public class UserRepository {
	    private final JdbcTemplate jdbcTemplate;

	    public UserRepository(JdbcTemplate jdbcTemplate) {
	        this.jdbcTemplate = jdbcTemplate;
	    }

	    // Map database row to User object
	    private final RowMapper<User> userRowMapper = (rs, rowNum) -> new User(
	            rs.getInt("id"),
	            rs.getString("name"),
	            rs.getString("email")
	    );



	    // CREATE
	    public int save(User user) {
	        return jdbcTemplate.update("INSERT INTO userdata (name, email) VALUES (?, ?)", user.getName(), user.getEmail());
	    }

	    // READ ALL
	    public List<User> findAll() {
	        return jdbcTemplate.query("SELECT * FROM userdata", userRowMapper);
	    }

	    // READ BY ID
	    public User findById(Long id) {
	        return jdbcTemplate.queryForObject("SELECT * FROM userdata WHERE id = ?", userRowMapper, id);
	    }

	    // UPDATE
	    public int update(User user) {
	        return jdbcTemplate.update("UPDATE userdata SET name = ?, email = ? WHERE id = ?", user.getName(), user.getEmail(), user.getId());
	    }

	    // DELETE
	    public int deleteById(Long id) {
	        return jdbcTemplate.update("DELETE FROM userdata WHERE id = ?", id);
	    }
	

}
