package com.projet.bdd;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.jolbox.bonecp.BoneCPDataSource;


@Configuration
public class BoneCp {
	
	@Bean(destroyMethod = "close")    
	public DataSource dataSource() {   

		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		BoneCPDataSource dataSource = new BoneCPDataSource();  
		dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/webapp");        
		dataSource.setUsername("user");        
		dataSource.setPassword("user");        
		return dataSource;    
	}
	
	@Bean  
	public PlatformTransactionManager txManager() {     
		return new DataSourceTransactionManager(dataSource());  
		}

}
