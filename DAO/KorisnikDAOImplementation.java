package DAO;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import DTO.Korisnik;

public class KorisnikDAOImplementation implements KorisnikDAOInterface {

	
	
	Connection connection = ConnectionManager.getInstance().getConnection();
	
	

	@Override
	public boolean updateKorisnik (Korisnik korisnik)throws SQLException {
		String query = "UPDATE accounts SET ime = ?, prezime = ?,  password = ? WHERE username = ?";

		try (PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setString(1, korisnik.getIme());
			statement.setString(2, korisnik.getPrezime());
			statement.setString(3, korisnik.getSifra());
			statement.setString(4, korisnik.getUsername());
			
			
			statement.executeUpdate();
			if (statement.executeUpdate() == 1) {
				return true;
			} else {
				return false;
			}

		}
	}

	@Override
	public boolean logOut(Korisnik korisnik)throws SQLException {
		// TODO Auto-generated method stub
		
		return false;
	}
	
	@Override
	public void dodajKorisnika(Korisnik korisnik)throws SQLException
	{
		String query = "INSERT INTO accounts (ime, prezime,username, password) VALUES (?, ?, ?, ?)";

		try (PreparedStatement statement = connection.prepareStatement(query);) {
			statement.setString(1, korisnik.getIme());
			statement.setString(2, korisnik.getPrezime());
			statement.setString(3, korisnik.getUsername());
			statement.setString(4, korisnik.getSifra());
			
			statement.executeUpdate();
			System.out.println("Baza podataka uspjesno updateana.");
		}
	}
		
	public Korisnik vracaKorisnikaPrekoUsernamea(String username)throws SQLException
	{
		Korisnik korisnik=new Korisnik();
		String query="SELECT * FROM accounts WHERE username=?";
		ResultSet rs = null;

		try(PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setString(1,username );
			rs = statement.executeQuery();

			
			if(rs.next()) {
				korisnik.setIme(rs.getString("ime"));
				korisnik.setPrezime(rs.getString("prezime"));
				korisnik.setUsername(rs.getString("username"));
				korisnik.setSifra(rs.getString("password"));
				rs.close();
			}
			
			return korisnik;
	}
	}
	}

