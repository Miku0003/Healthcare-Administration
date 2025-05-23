package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnection;
import model.Patient;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.DBConnection;
import model.Appointment;
import model.Doctor;
import model.Patient;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.DBConnection;
import model.Patient;

public class PatientDao {
	public static boolean checkPatientEmail(String email) {
		boolean flag = false;
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from patient where email=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static void insertPatient(Patient p) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "insert into patient(name,contact,address,email,password) values(?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, p.getName());
			pst.setLong(2, p.getContact());
			pst.setString(3, p.getAddress());
			pst.setString(4, p.getEmail());
			pst.setString(5, p.getPassword());
			pst.executeUpdate();
			System.out.println("done");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public static Patient patientLogin(Patient u) {
		Patient p = null;
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from patient where email=? and password=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, u.getEmail());
			pst.setString(2, u.getPassword());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				p = new Patient();
				p.setPid(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setContact(rs.getLong("contact"));
				p.setAddress(rs.getString("address"));
				p.setEmail(rs.getString("email"));
				p.setPassword(rs.getString("password"));
				System.out.println("p in DAO class : " + p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
	
	public static void updateProfile(Patient p) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "update patient set name=?,contact=?,address=?,email=? where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, p.getName());
			pst.setLong(2, p.getContact());
			pst.setString(3, p.getAddress());
			pst.setString(4, p.getEmail());
			pst.setInt(5, p.getPid());
			pst.executeUpdate();
			System.out.println("updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void changePassword(int id,String np) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "update patient set password=? where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, np);
			pst.setInt(2, id);
			pst.executeUpdate();
			System.out.println("pass updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static boolean checkOldPassword(int id,String op) {
		boolean flag = false;
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from patient where password=? and id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, op);
			pst.setInt(2, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public static void newPassword(String email,String np) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "update patient set password=? where email=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, np);
			pst.setString(2, email);
			pst.executeUpdate();
			System.out.println("password updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Patient getpatientByPid(int id) {
		Patient p = null;
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from patient where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				p = new Patient();
				p.setPid(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setContact(rs.getLong("contact"));
				p.setAddress(rs.getString("address"));
				p.setEmail(rs.getString("email"));
				p.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
	
	
	public static List<Patient> getAllPatient(){
		List<Patient> list = new ArrayList<Patient>();
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from patient";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Patient p = new Patient();
				p.setPid(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setContact(rs.getLong("contact"));
				p.setAddress(rs.getString("address"));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
}