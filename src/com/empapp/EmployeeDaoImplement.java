package com.empapp;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDaoImplement implements EmployeeDaoInterface{
Connection con;

@Override
public void createEmployee(Employee emp) {
	// TODO Auto-generated method stub
	con=DBconnection.createDBConnection();
	String query="insert into Employee values(?,?,?,?);";
	try {
		PreparedStatement pstm=con.prepareStatement(query);
		pstm.setInt(1,emp.getId());
		pstm.setString(2, emp.getName());
		pstm.setDouble(3, emp.getSalary());
		pstm.setInt(4,emp.getAge());
		int cnt=pstm.executeUpdate();
		if(cnt!=0) {
			System.out.println("Data inserted successfully........");
		}
	}catch (SQLException e) {
        // Handle the case where the insert fails due to a duplicate primary key
        if (e.getSQLState().equals("23000")) {
            System.out.println("Failed to insert record: Duplicate key. Please enter another key.");
        } else {
            e.printStackTrace(); // Handle other SQL exceptions
        }
    }
}
  


@Override
public void showAllEmployee() {
	// TODO Auto-generated method stub
	con=DBconnection.createDBConnection();
	String query="select * from Employee";
	System.out.println("--------------------------------");
	System.out.println("Employee Details: ");
	System.out.println("--------------------------------");
	System.out.println("Id\tName\tSalary\t\tAge\n");
	
	try {
		Statement stmt=con.createStatement();
		ResultSet result=stmt.executeQuery(query);
		while(result.next()) {
			System.out.format("%d\t%s\t%f\t%d",result.getInt(1),result.getString(2),result.getDouble(3),result.getInt(4));
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
}

@Override
public void showEmployeeBasedOnId(int id) {
	// TODO Auto-generated method stub
	con=DBconnection.createDBConnection();
	String query="select * from Employee where id="+id;
	System.out.println("--------------------------------");
	System.out.println("Employee Details: ");
	System.out.println("--------------------------------");
	System.out.println("Id\tName\tSalary\tAge\n");
	
	try {
		Statement stmt=con.createStatement();
		ResultSet result=stmt.executeQuery(query);
		while(result.next()) {
			System.out.format("%d\t%s\t%f\t%d",result.getInt(1),result.getString(2),result.getDouble(3),result.getInt(4));
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
}


@Override
public void updateEmployee(int id, String name) {
	// TODO Auto-generated method stub
	con=DBconnection.createDBConnection();
	String query="update Employee set name=? where id=?";
	try {
		PreparedStatement pstm=con.prepareStatement(query);
		pstm.setString(1, name);
		pstm.setInt(2,id);
		int cnt=pstm.executeUpdate();
		if(cnt!=0) {
			System.out.println("data updated successfully");
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
}

@Override
public void deleteEmployee(int id) {
	// TODO Auto-generated method stub
	con=DBconnection.createDBConnection();
	String query="delete from Employee where id=?";
	try {
		PreparedStatement pstm=con.prepareStatement(query);
		pstm.setInt(1,id);
		int cnt=pstm.executeUpdate();
		if(cnt!=0) {
			System.out.println("data deleted successfully");
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
}
}


