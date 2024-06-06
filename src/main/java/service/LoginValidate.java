package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Employee;
import repository.EmployeeRepository;

public class LoginValidate {
	
	public boolean checkLogin(Integer id, String password) throws ClassNotFoundException, SQLException {
		Connection conn = EmployeeRepository.getConnection();
		PreparedStatement ps = conn.prepareStatement("select id, password from emp where id=? AND password=?");
		//? - placeholder
		ps.setInt(1, id);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			return true;
		} else {
			return false;
		}
		
	}

}
