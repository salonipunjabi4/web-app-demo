package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Employee;
import repository.EmployeeRepository;

public class EmployeeService {
	
	public boolean save(Employee e) throws ClassNotFoundException, SQLException {
		Connection conn = EmployeeRepository.getConnection();
		PreparedStatement ps = conn.prepareStatement("insert into emp(id, name, password, email, salary) values(?,?,?,?,?)");
		//? - placeholder
		ps.setInt(1, e.getId());
		ps.setString(2, e.getName());
		ps.setString(3, e.getPassword());
		ps.setString(4, e.getEmail());
		ps.setString(5, e.getSalary());
		int x = ps.executeUpdate();
		if(x > 0) {
			return true;
		} else {
			return false;
		}
		
	}

}
