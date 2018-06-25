package com.projet.bdd;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.projet.webapp.*;

public class UserMapper implements RowMapper<User> {
	
	
	public User mapRow(ResultSet rs, int numRow) throws SQLException {
			
		return new User(rs.getInt("id"),
				rs.getString("firstname"),
				rs.getString("lastname"),
				rs.getString("email"),
				rs.getString("password"));
	}

}
