package com.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.app.model.User;

public class UserDaoImp implements UserDao {
	@Autowired
	DataSource datasource;
	
	Connection connect=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
//	String username="root";
//	String password="123456";
//	String url="jdbc:mysql://localhost:3306/userdb1";
	
//	public Connection getConnection() throws SQLException, ClassNotFoundException{
//		Class.forName("com.mysql.jdbc.Driver");
//		connect=ds.getConnection(url, username, password);
//		return connect;
//	}
//	
	
//	@Autowired
//	 public UserDaoImp() {
//		 DriverManagerDataSource datasource;
//		 
//	 }
	

	@Override
	public User login(User user) {
		String query="select * from user where username=? and password=?";
		User user1=new User();
		try {
			ps=datasource.getConnection().prepareStatement(query);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			rs=ps.executeQuery();
			while(rs.next()){
				user1.setUsername(rs.getString("username"));
				user1.setPassword(rs.getString("role"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user1;
	}

}
