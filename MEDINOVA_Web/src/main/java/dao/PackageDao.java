package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnection;
import model.Packages;
import model.Patient;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnection;
import model.Packages;

public class PackageDao {
	public static void insertPackage(Packages p) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql="insert into package(did,p_name,p_amount,p_test) values(?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, p.getDid());
			pst.setString(2, p.getP_name());
			pst.setInt(3, p.getP_amount());
			pst.setString(4, p.getP_test());
			pst.executeUpdate();
			System.out.println("package uploaded");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static List<Packages> getPackagesByDid(int id){
		List<Packages> list = new ArrayList<Packages>();
		try {
			Connection conn = DBConnection.createConnection();
			String sql="select * from package where did=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Packages p = new Packages();
				p.setP_id(rs.getInt("p_id"));
				p.setDid(rs.getInt("did"));
				p.setP_name(rs.getString("p_name"));
				p.setP_amount(rs.getInt("p_amount"));
				p.setP_test(rs.getString("p_test"));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static Packages getPackageByPid(int pid) {
		Packages p = null;
		try {
			Connection conn = DBConnection.createConnection();
			String sql="select * from package where p_id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, pid);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				p = new  Packages();
				p.setP_id(rs.getInt("p_id"));
				p.setDid(rs.getInt("did"));
				p.setP_name(rs.getString("p_name"));
				p.setP_amount(rs.getInt("p_amount"));
				p.setP_test(rs.getString("p_test"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
	public static void updatePackage(Packages p) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql="update package set p_name=?,p_amount=?,p_test=? where p_id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, p.getP_name());
			pst.setInt(2, p.getP_amount());
			pst.setString(3, p.getP_test());
			pst.setInt(4,p.getP_id());
			pst.executeUpdate();
			System.out.println("package updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void deletPackage(int pid) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql="delete from package where p_id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, pid);
			pst.executeUpdate();
			System.out.println("package deleted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static List<Packages> getAllPackages(){
		List<Packages> list = new ArrayList<Packages>();
		try {
			Connection conn = DBConnection.createConnection();
			String sql="select * from package";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Packages p = new Packages();
				p.setP_id(rs.getInt("p_id"));
				p.setDid(rs.getInt("did"));
				p.setP_name(rs.getString("p_name"));
				p.setP_amount(rs.getInt("p_amount"));
				p.setP_test(rs.getString("p_test"));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	
}
	