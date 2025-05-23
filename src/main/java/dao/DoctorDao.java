package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnection;
import model.Doctor;

public class DoctorDao {
	public static boolean checkDoctorEmail(String email) {
		boolean flag = false;
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from doctor where email=?";
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

	public static void insertDoctor(Doctor d) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "insert into doctor(image,name,contact,address,specialization,w_address,email,password) values(?,?,?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, d.getImage());
			pst.setString(2, d.getName());
			pst.setLong(3, d.getContact());
			pst.setString(4, d.getAddress());
			pst.setString(5, d.getSpecialization());
			pst.setString(6, d.getWork_address());
			pst.setString(7, d.getEmail());
			pst.setString(8, d.getPassword());
			pst.executeUpdate();
			System.out.println("done");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Doctor doctorLogin(Doctor u) {
		Doctor d = null;
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from doctor where email=? and password=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, u.getEmail());
			pst.setString(2, u.getPassword());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				d = new Doctor();
				d.setDid(rs.getInt("did"));
				d.setImage(rs.getString("image"));
				d.setName(rs.getString("name"));
				d.setContact(rs.getLong("contact"));
				d.setAddress(rs.getString("address"));
				d.setSpecialization(rs.getString("specialization"));
				d.setWork_address(rs.getString("w_address"));
				d.setEmail(rs.getString("email"));
				d.setPassword(rs.getString("password"));
				System.out.println("d in DAO class : " + d);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}
	public static void updateProfile(Doctor d) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "update doctor set image=?,name=?,contact=?,address=?,specialization=?,w_address=?,email=? where did=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, d.getImage());
			pst.setString(2, d.getName());
			pst.setLong(3, d.getContact());
			pst.setString(4, d.getAddress());
			pst.setString(5, d.getSpecialization());
			pst.setString(6, d.getWork_address());
			pst.setString(7, d.getEmail());
			pst.setInt(8, d.getDid());
			pst.executeUpdate();
			System.out.println("updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void changePassword(int id,String np) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "update doctor set password=? where did=?";
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
			String sql = "select * from doctor where password=? and did=?";
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
			String sql = "update doctor set password=? where email=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, np);
			pst.setString(2, email);
			pst.executeUpdate();
			System.out.println("pass updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static List<Doctor> getAllDoctors(){
		List<Doctor> list = new ArrayList<Doctor>();
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from doctor";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Doctor d = new Doctor();
				d.setDid(rs.getInt("did"));
				d.setImage(rs.getString("image"));
				d.setName(rs.getString("name"));
				d.setContact(rs.getLong("contact"));
				d.setAddress(rs.getString("address"));
				d.setSpecialization(rs.getString("specialization"));
				d.setWork_address(rs.getString("w_address"));
				d.setEmail(rs.getString("email"));
				System.out.println("d in DAO class : " + d);
				list.add(d);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static Doctor getDoctorByDid(int id) {
		Doctor d = null;
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from doctor where did=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				d = new Doctor();
				d.setDid(rs.getInt("did"));
				d.setImage(rs.getString("image"));
				d.setName(rs.getString("name"));
				d.setContact(rs.getLong("contact"));
				d.setAddress(rs.getString("address"));
				d.setSpecialization(rs.getString("specialization"));
				d.setWork_address(rs.getString("w_address"));
				d.setEmail(rs.getString("email"));
				d.setPassword(rs.getString("password"));
				System.out.println("d in DAO class : " + d);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}
}