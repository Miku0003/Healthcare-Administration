package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnection;
import model.Appointment;

public class AppointmentDao {
	public static void bookAppointment(Appointment a) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "insert into appointment(pid,p_id,date,status) values(?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, a.getPid());
			pst.setInt(2, a.getPack_id());
			pst.setDate(3, a.getDate());
			pst.setString(4, a.getStatus());
			pst.executeUpdate();
			System.out.println("booked");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static List<Appointment> getAppoinementsByPid(int pid){
		List<Appointment> list = new ArrayList<Appointment>();
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from appointment where pid =?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, pid);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Appointment a = new Appointment();
				a.setAid(rs.getInt("aid"));
				a.setPid(rs.getInt("pid"));
				a.setPack_id(rs.getInt("p_id"));
				a.setDate(rs.getDate("date"));
				a.setStatus(rs.getString("status"));
				list.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<Appointment> getAllAppoinements(){
		List<Appointment> list = new ArrayList<Appointment>();
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from appointment";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Appointment a = new Appointment();
				a.setAid(rs.getInt("aid"));
				a.setPid(rs.getInt("pid"));
				a.setPack_id(rs.getInt("p_id"));
				a.setDate(rs.getDate("date"));
				a.setStatus(rs.getString("status"));
				list.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static List<Appointment> getAllPendingAppoinements(int p_id){
		List<Appointment> list = new ArrayList<Appointment>();
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from appointment where p_id=? and status='pending'";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, p_id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Appointment a = new Appointment();
				a.setAid(rs.getInt("aid"));
				a.setPid(rs.getInt("pid"));
				a.setPack_id(rs.getInt("p_id"));
				a.setDate(rs.getDate("date"));
				a.setStatus(rs.getString("status"));
				list.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<Appointment> getAllConfirmedAppoinements(int p_id){
		List<Appointment> list = new ArrayList<Appointment>();
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from appointment where p_id=? and status='confirm'";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, p_id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Appointment a = new Appointment();
				a.setAid(rs.getInt("aid"));
				a.setPid(rs.getInt("pid"));
				a.setPack_id(rs.getInt("p_id"));
				a.setDate(rs.getDate("date"));
				a.setStatus(rs.getString("status"));
				list.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static Appointment getAppoinementsByAid(int aid){
		Appointment a = null;
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from appointment where aid =?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, aid);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				a = new Appointment();
				a.setAid(rs.getInt("aid"));
				a.setPid(rs.getInt("pid"));
				a.setPack_id(rs.getInt("p_id"));
				a.setDate(rs.getDate("date"));
				a.setStatus(rs.getString("status"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}
	public static void updateStatus(int aid) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "update appointment set status='confirm' where aid=? ";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, aid);
			pst.executeUpdate();
			System.out.println("status updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}