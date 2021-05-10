package ro.emanuel.medic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ro.emanuel.medic.helpers.DBHelperMedic;
import ro.emanuel.medic.pojo.Medic;


public class MedicDAO {
	
	public static Medic getmedicById(int id)throws SQLException{
		String select = "select * from medic where id=?";
		Connection con = DBHelperMedic.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		Medic result = null;
		if(rs.next()) {
			String nume = rs.getString("nume");
			String specialitate = rs.getString("specialitate");
			int vechime = rs.getInt("vechime");
			int salar = rs.getInt("salar");
			result = new Medic(id,nume,specialitate, vechime, salar);
		}
		DBHelperMedic.closeConnection();
		return result;
	}
	
	public static ArrayList<Medic> getMedicByName(String nameQuery) throws SQLException{
		String select = "select * from medic where nume like '%?%'";
		Connection con = DBHelperMedic.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		stmt.setString(1, nameQuery);
		ResultSet rs = stmt.executeQuery();
		ArrayList<Medic> result = new ArrayList<Medic>();
		while(rs.next()) {
			int id = rs.getInt("id");
			String nume = rs.getString("nume");
			String specialitate = rs.getString("specialitate");
			int vechime = rs.getInt("vechime");
			int salar = rs.getInt("salar");
			result.add(new Medic(id,nume,specialitate, vechime, salar));
		}
		DBHelperMedic.closeConnection();
		return result;
	}
	
	public static ArrayList<Medic> getMedic() throws SQLException{
		String select = "select * from medic";
		Connection con = DBHelperMedic.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		ArrayList<Medic> result = new ArrayList<Medic>();
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("id");
			String nume = rs.getString("nume");
			String specialitate = rs.getString("specialitate");
			int vechime = rs.getInt("vechime");
			int salar = rs.getInt("salar");
			Medic md = new Medic(id,nume,specialitate, vechime, salar);
			result.add(md);
		}
		DBHelperMedic.closeConnection();
		return result;
	}
	public static void createMedic(Medic md)throws SQLException{
		MedicDAO.createMedic(md.getNume(), md.getSpecialitate(), md.getVechime(),md.getSalar());
	}
	public static void createMedic( String nume, String specialitate, int vechime, int salar) throws SQLException{
		String insert = "insert into medic (nume,specialitate,vechime, salar) Value(?,?,?,?)";
	    Connection con = DBHelperMedic.getConnection();
	    PreparedStatement stmt = con.prepareStatement(insert);
	    stmt.setString(1, nume);
	    stmt.setString(2, specialitate);
	    stmt.setInt(3, vechime);
	    stmt.setInt(4, salar);
	    stmt.executeUpdate();
	    DBHelperMedic.closeConnection();
	}
	public static void updateMedic( Medic md) throws SQLException{
		String update = "update medic set nume=?, specialitate=?, vechime=?, salar=? where id=?";
	    Connection con = DBHelperMedic.getConnection();
	    PreparedStatement stmt = con.prepareStatement(update);
	    stmt.setString(1, md.getNume());
	    stmt.setString(2, md.getSpecialitate());
	    stmt.setInt(3, md.getVechime());
	    stmt.setInt(4, md.getSalar());
	    stmt.executeUpdate();
	    DBHelperMedic.closeConnection();
	}
	public static void deleteMedic(Medic md)throws SQLException{
		MedicDAO.deleteMedic(md.getId());
	}
	public static void deleteMedic(int id) throws SQLException {
		String delete = "delete from medic where id=?";
		Connection con = DBHelperMedic.getConnection();
		PreparedStatement stmt = con.prepareStatement(delete);
	    stmt.setInt(1, id);
	    stmt.executeUpdate();
	    DBHelperMedic.closeConnection();
	}
		
}
