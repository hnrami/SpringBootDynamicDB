package com.example.jpa.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.helper.DBConnectionInfo;
import com.example.jpa.vo.ConnectionVO;

@RestController
public class CommentController {

	
	
	
	@PostMapping("/reports")
	public void getsamplecall(@RequestBody ConnectionVO connectionVO) throws SQLException {
	    	//System.out.println(questionRepository.getallDate().size());;
	//	Connection connection = DBConnectionInfo.getConnection(connectionVO);
		Connection connection =	DBConnectionInfo.getDataSource(connectionVO).getConnection();
		try {
		dbCall(connection);
		}finally {
			connection.close();
		}
	 }
	
	
	@PostMapping("/sp")
	public void getsamplesp(@RequestBody ConnectionVO connectionVO) throws SQLException {
		
//		Connection connection = DBConnectionInfo.getConnection(connectionVO);
		Connection connection =	DBConnectionInfo.getDataSource(connectionVO).getConnection();
		sp(connection);
	 }

	private void dbCall(Connection connection) throws SQLException {
		Statement statement = connection.createStatement();
        // Result set get the result of the SQL query
       ResultSet  resultSet = statement
                .executeQuery("SELECT * FROM public.reports");
     
       while(resultSet.next()) {
    	   System.out.println(resultSet.getString(1));
       }
	}
	
	private void sp(Connection connection) throws SQLException {
		 CallableStatement stmt=connection.prepareCall("{call test(?,?)}");  
		 stmt.setInt(1,1);  
		 stmt.setInt(2,3);
		
		 stmt.execute();  
		 
		        ResultSet rs = stmt.getResultSet();

		        while(rs.next()) {
		     	   System.out.println(rs.getString(1));
		        }

	}
	
	 
	
}
