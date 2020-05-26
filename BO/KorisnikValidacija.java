package BO;

import java.sql.SQLException;

import DAO.KorisnikDAOImplementation;
import DTO.Korisnik;

public class KorisnikValidacija {

	public boolean validacijaRegistracijeUsername(String username) throws SQLException
	{	boolean usernameDaLiPostoji;
		KorisnikDAOImplementation registracija = new KorisnikDAOImplementation();
		Korisnik korisnik;
		korisnik=registracija.vracaKorisnikaPrekoUsernamea(username);
		if(korisnik.getUsername()==null)
		{usernameDaLiPostoji= false;}
		else{System.out.println("Username vec postoji.");usernameDaLiPostoji= true;}	
		
		
			return usernameDaLiPostoji;
	}
	public boolean validacijaRegistracijePassword(String password) throws SQLException
	{boolean passvordDuzinaVecaOd5=false;
		if(password.length()>5) 
		{
			passvordDuzinaVecaOd5=true;
		}else {System.out.println("Sifra treba biti duza od 5 karaktera.");}
		
		return passvordDuzinaVecaOd5;
	}
}
