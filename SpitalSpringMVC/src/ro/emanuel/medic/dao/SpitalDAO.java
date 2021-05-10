package ro.emanuel.medic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ro.emanuel.medic.helpers.DBHelperMedic;
import ro.emanuel.medic.pojo.Spital;



public class SpitalDAO {
	
	public static Spital getspitalById(int id)throws SQLException{
		String select = "select * from spital where id=?";
		Connection con = DBHelperMedic.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		Spital result = null;
		if(rs.next()) {
			String nume = rs.getString("nume");
			String adresa = rs.getString("adresa");
			String telefon = rs.getString("telefon");
			String email = rs.getString("email");
			result = new Spital(id,nume,adresa, telefon, email);
		}
		DBHelperMedic.closeConnection();
		return result;
	}
	
	public static ArrayList<Spital> getSpitalByName(String nameQuery) throws SQLException{
		String select = "select * from spital where nume like '%?%'";
		Connection con = DBHelperMedic.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		stmt.setString(1, nameQuery);
		ResultSet rs = stmt.executeQuery();
		ArrayList<Spital> result = new ArrayList<Spital>();
		while(rs.next()) {
			int id = rs.getInt("id");
			String nume = rs.getString("nume");
			String adresa = rs.getString("adresa");
			String telefon = rs.getString("telefon");
			String email= rs.getString("email");
			result.add(new Spital(id,nume,adresa, telefon, email));
		}
		DBHelperMedic.closeConnection();
		return result;
	}
	
	public static ArrayList<Spital> getSpital() throws SQLException{
		String select = "select * from spital";
		Connection con = DBHelperMedic.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		ArrayList<Spital> result = new ArrayList<Spital>();
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("id");
			String nume = rs.getString("nume");
			String adresa = rs.getString("adresa");
			String telefon = rs.getString("telefon");
			String email = rs.getString("email");
			Spital sp = new Spital(id,nume,adresa, telefon, email);
			result.add(sp);
		}
		DBHelperMedic.closeConnection();
		return result;
	}
	public static void createSpital(Spital sp)throws SQLException{
		SpitalDAO.createSpital(sp.getNume(), sp.getAdresa(), sp.getTelefon(),sp.getEmail());
	}
	public static void createSpital( String nume, String adresa, String telefon, String email) throws SQLException{
		String insert = "insert into spital (nume,adresa,telefon, email) Value(?,?,?,?)";
	    Connection con = DBHelperMedic.getConnection();
	    PreparedStatement stmt = con.prepareStatement(insert);
	    stmt.setString(1, nume);
	    stmt.setString(2, adresa);
	    stmt.setString(3, telefon);
	    stmt.setString(4, email);
	    stmt.executeUpdate();
	    DBHelperMedic.closeConnection();
	}
	public static void updateSpital( Spital sp) throws SQLException{
		String update = "update spital set nume=?, adresa=?, telefon=?, email=? where id=?";
	    Connection con = DBHelperMedic.getConnection();
	    PreparedStatement stmt = con.prepareStatement(update);
	    stmt.setString(1, sp.getNume());
	    stmt.setString(2, sp.getAdresa());
	    stmt.setString(3, sp.getTelefon());
	    stmt.setString(4, sp.getEmail());
	    stmt.executeUpdate();
	    DBHelperMedic.closeConnection();
	}
	public static void deleteSpital(Spital sp)throws SQLException{
		SpitalDAO.deleteSpital(sp.getId());
	}
	public static void deleteSpital(int id) throws SQLException {
		String delete = "delete from spital where id=?";
		Connection con = DBHelperMedic.getConnection();
		PreparedStatement stmt = con.prepareStatement(delete);
	    stmt.setInt(1, id);
	    stmt.executeUpdate();
	    DBHelperMedic.closeConnection();
	}
		
}
