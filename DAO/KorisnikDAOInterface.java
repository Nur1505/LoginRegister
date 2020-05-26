package DAO;

import java.sql.SQLException;

import DTO.Korisnik;

public interface KorisnikDAOInterface  {
	
	
	public boolean updateKorisnik(Korisnik korisnik)throws SQLException;
	
	public boolean logOut(Korisnik korisnik)throws SQLException;
	
	public void dodajKorisnika(Korisnik korisnik)throws SQLException;
	
	public Korisnik vracaKorisnikaPrekoUsernamea(String Username)throws SQLException;
}
