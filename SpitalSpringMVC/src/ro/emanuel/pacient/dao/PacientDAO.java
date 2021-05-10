package ro.emanuel.pacient.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ro.emanuel.pacient.dao.PacientDAO;
import ro.emanuel.pacient.helpers.DBHelperPacient;
import ro.emanuel.pacient.pojo.Pacient;

public class PacientDAO {
	public static Pacient getpacientById(int id)throws SQLException{
		String select = "select * from pacient where id=?";
		Connection con = DBHelperPacient.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		Pacient result = null;
		if(rs.next()) {
			String nume = rs.getString("nume");
			String adresa = rs.getString("adresa");
			int varsta = rs.getInt("varsta");
			String diagnostic = rs.getString("diagnostic");
			result = new Pacient(id, nume, adresa, varsta, diagnostic);
		}
		DBHelperPacient.closeConnection();
		return result;
	}
	
	public static ArrayList<Pacient> getPacientByName(String nameQuery) throws SQLException{
		String select = "select * from pacient where nume like '%?%'";
		Connection con = DBHelperPacient.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		stmt.setString(1, nameQuery);
		ResultSet rs = stmt.executeQuery();
		ArrayList<Pacient> result = new ArrayList<Pacient>();
		while(rs.next()) {
			int id = rs.getInt("id");
			String nume = rs.getString("nume");
			String adresa = rs.getString("adresa");
			int varsta = rs.getInt("varsta");
			String diagnostic = rs.getString("diagnostic");
			result.add(new Pacient(id, nume, adresa, varsta, diagnostic));
		}
		DBHelperPacient.closeConnection();
		return result;
	}
	
	public static ArrayList<Pacient> getPacient() throws SQLException{
		String select = "select * from pacient";
		Connection con = DBHelperPacient.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		ArrayList<Pacient> result = new ArrayList<Pacient>();
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("id");
			String nume = rs.getString("nume");
			String adresa = rs.getString("adresa");
			int varsta = rs.getInt("varsta");
			String diagnostic = rs.getString("diagnostic");
			Pacient pa = new Pacient(id, nume, adresa, varsta, diagnostic);
			result.add(pa);
		}
		DBHelperPacient.closeConnection();
		return result;
	}
	public static void createPacient(Pacient pa)throws SQLException{
		PacientDAO.createPacient(pa.getNume(), pa.getAdresa(), pa.getVarsta(),pa.getDiagnostic());
	}
	public static void createPacient( String nume, String adresa, int varsta, String diagnostic) throws SQLException{
		String insert = "insert into pacient (nume,adresa, varsta, diagnostic) Value(?,?,?,?)";
	    Connection con = DBHelperPacient.getConnection();
	    PreparedStatement stmt = con.prepareStatement(insert);
	    stmt.setString(1, nume);
	    stmt.setString(2, adresa);
	    stmt.setInt(3, varsta);
	    stmt.setString(4, diagnostic);
	    stmt.executeUpdate();
	    DBHelperPacient.closeConnection();
	}
	public static void updatePacient( Pacient pa) throws SQLException{
		String update = "update pacient set nume=?, adresa=?, varsta=?, diagnostic=? where id=?";
	    Connection con = DBHelperPacient.getConnection();
	    PreparedStatement stmt = con.prepareStatement(update);
	    stmt.setString(1, pa.getNume());
	    stmt.setString(2, pa.getAdresa());
	    stmt.setInt(3, pa.getVarsta());
	    stmt.setString(4, pa.getDiagnostic());
	    stmt.executeUpdate();
	    DBHelperPacient.closeConnection();
	}
	public static void deletePacient(Pacient pa)throws SQLException{
		PacientDAO.deletePacient(pa.getId());
	}
	public static void deletePacient(int id) throws SQLException {
		String delete = "delete from pacient where id=?";
		Connection con = DBHelperPacient.getConnection();
		PreparedStatement stmt = con.prepareStatement(delete);
	    stmt.setInt(1, id);
	    stmt.executeUpdate();
	    DBHelperPacient.closeConnection();
	}
}
