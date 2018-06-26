package com.projet.bdd;


import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projet.webapp.*;

@Repository
@Transactional
public class UserDAO {

	private JdbcTemplate jdbcTemplate;
////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Set de la bdd
	@Autowired
	public void setDataSource(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////
//recupérer le nombre d'utilisateurs
	public int getNumberUsers() {
		return this.jdbcTemplate.queryForObject("SELECT COUNT(*) FROM Users", Integer.class);
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////
//recupérer la table d'utilisateurs
	public List<User> getListUsers() {
		return this.jdbcTemplate.query("SELECT * FROM Users", new UserMapper());	
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////
//ajouter des utilisateurs	
	public void addUser(User user) {
		this.jdbcTemplate.update("insert into Users (firstname, lastname, email, password) values(?,?,?,?)", user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());	
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////
//maj des utilisateurs	
	public void updateUser(User user, int id) {
		this.jdbcTemplate.update("update Users set firstname = ?, lastname = ?, email = ?, password = ? where id = ?", user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword() , id);	
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////
//suppression d'un utilisateurs
	public void deleteUser(int id) {
		this.jdbcTemplate.update("delete from Users where id = ?", id);
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////
//ajout de plusieurs utilisateurs	
	public void transactionAddUsers() {
		User u1 = new User ("charles", "allard", "user@gmail.com", "user");
		User u2 = new User ("guillaume", "allard", "user@yahoo.com", "user");
		User u3 = new User ("romain", "schmutz", "user@adoppi.com", "user");

		addUser(u1);
		addUser(u2);
		addUser(u3);
	}
	
	public Optional<User> findOneByLogin(String email) {
		return Optional.ofNullable(this.jdbcTemplate.query("SELECT * FROM Users WHERE email = ?", new UserMapper(), email).get(0));
	}	
}
