package com.example.jpa.helper;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.example.jpa.vo.ConnectionVO;

public class DBConnectionInfo {

	
	public static Connection getConnection(ConnectionVO connectionVO) {
		Connection connect = null;
		
		try {
			
			// Production Details SAC
			Class.forName(connectionVO.getDriver());
             connect = DriverManager
                    .getConnection(connectionVO.getUrl()+"?"
                            + "user="+connectionVO.getUser()+"&password="+connectionVO.getPassword());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connect;
	}
	
	
	public static DataSource getDataSource(ConnectionVO connectionVO) {

	    DriverManagerDataSource dataSource = new DriverManagerDataSource();

	    dataSource.setUsername(connectionVO.getUser());
	    dataSource.setPassword(connectionVO.getPassword());
	    dataSource.setUrl(connectionVO.getUrl());
	    dataSource.setDriverClassName(connectionVO.getDriver());

	    return dataSource;
	}
}
