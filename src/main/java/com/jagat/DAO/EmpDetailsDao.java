package com.jagat.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jagat.MODEL.EmpDetails;

public class EmpDetailsDao {

	// database credentials
	private static final String url = "jdbc:mysql://localhost:3306/api_emp";
	private static final String user = "root";
	private static final String pass = "pass123";

	// query
	private static final String insert_emp = "insert into emp_details "
			+ "(emp_bank_acc,emp_company,emp_job_title,emp_last_name,emp_name,emp_salary,pf_acc_balance) values"
			+ "(?,?,?,?,?,?,?,?)";
	private static final String selectall = "select * from emp_details";

	// no arg constructor
	public EmpDetailsDao() {
	}

	protected Connection getConnection() {

		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, pass);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO: handle exception
		}
		return connection;
	}

	// insert method
	public void insertEmp(EmpDetails details) throws SQLException {
		System.out.println(insert_emp);
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(insert_emp)) {
 
			ps.setString(1, details.getEmpBankAcc());
			ps.setString(2, details.getEmpCompany());
			ps.setString(3, details.getEmpJobTitle());
			ps.setString(4, details.getEmpLastName());
			ps.setString(5, details.getEmpName());
			ps.setDouble(6, details.getEmpSalary());
			ps.setDouble(7, details.getPfAccBalance());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	// select all users
	public List<EmpDetails> selectAllUsers() {
		List<EmpDetails> details = new ArrayList<>();
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(selectall)) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				long id = rs.getLong("emp_id");
				String bankacc = rs.getString("emp_bank_acc");
				String company = rs.getString("emp_company");
				String emp_job_title = rs.getString("emp_job_title");
				String emp_lastName = rs.getString("emp_last_name");
				String emp_name = rs.getString("emp_name");
				double sal = rs.getDouble("emp_salary");
				double pfAcc = rs.getDouble("pf_acc_balance");
				details.add(new EmpDetails(id, bankacc, company, emp_job_title, emp_lastName, emp_name, sal, pfAcc));

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return details;
	}
}
