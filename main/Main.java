package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import BO.KorisnikValidacija;
import DAO.KorisnikDAOImplementation;
import DTO.Korisnik;
import ui.MainUI;

public class Main {
	static Scanner unos   = new Scanner(System.in); 
	

		public static void main(String[] args) throws SQLException {
			
		
			for(;;)
			{
				
			
				
				int opcija = izvrsavanjeOpcijaZaPrviMenu() ;
				if(opcija==3)
				{
					
					break;
				}
				
					
			}	
			
			
			
		}
	
	public static int izvrsavanjeOpcijaZaPrviMenu() throws SQLException 
	{	MainUI menu=new MainUI();
		menu.printMenu();
		int opcija = unos.nextInt();
		
		if(opcija==1)
		{
			login();
			
		}
		else if(opcija==2)
		{
			registrovanje();

		}else if(opcija==3)
		{}
		else{
			
			System.out.println("Pogresan unos.");
			
		}
		return opcija;
		
	}
	
	public static void login() throws SQLException
	{
		
		System.out.println("Username: ");
		String username=unos.next();
		
		System.out.println("Password: ");
		String password=unos.next();
		
		izvrsavanjeOpcijaZaDrugiMenu( username,password);
		
	}
	public static void registrovanje() throws SQLException
	{
		
		System.out.println("Ime: ");
		String ime=unos.next();
		
		System.out.println("Prezime: ");
		String prezime=unos.next();
		
		System.out.println("Userame: ");
		String username=unos.next();
		
		unosSifre( username,  ime,  prezime);
	}
	
	public static void izvrsavanjeOpcijaZaDrugiMenu(String username, String password) throws SQLException
	{	KorisnikDAOImplementation prijava = new KorisnikDAOImplementation();
		
		Korisnik korisnik=new Korisnik();
		korisnik.setIme(prijava.vracaKorisnikaPrekoUsernamea(username).getIme());
		korisnik.setPrezime(prijava.vracaKorisnikaPrekoUsernamea(username).getPrezime());
		korisnik.setSifra(prijava.vracaKorisnikaPrekoUsernamea(username).getSifra());
		korisnik.setUsername(prijava.vracaKorisnikaPrekoUsernamea(username).getUsername());
		
		if(korisnik.getUsername()!=null)
		{	
		MainUI menu = new MainUI();
		menu.printMenuLogin();
		
		if(korisnik.getSifra().equals(password))
		{	
			int opcijaLogin = unos.nextInt();
			if (opcijaLogin==1)
			{
				izvrsavanjeOpcijaZaPrviMenu();
			}
			else if(opcijaLogin==2)
			{	System.out.println("Novo ime: ");
				String novoIme=unos.next();
				korisnik.setIme(novoIme);
				prijava.updateKorisnik(korisnik);
			}
			else if(opcijaLogin==3)
			{
				System.out.println("Novo prezime: ");
				String novoPrezime=unos.next();
				korisnik.setPrezime(novoPrezime);
				prijava.updateKorisnik(korisnik);
			}
			else{
				System.out.println("Pogresan unos.");
				izvrsavanjeOpcijaZaDrugiMenu( username,  password);
			}
		}
		else 
		{	
		System.out.println("Neispravna sifra. Ako zelite ponovo pokusati unesite 1 ako ne unesite 0.");
		int opcija=unos.nextInt();
		if((opcija==1)||(opcija==0))
		{
			if (opcija==1){izvrsavanjeOpcijaZaPrviMenu();}
			else{login();}
		}else {System.out.println("Pogresan unos.");izvrsavanjeOpcijaZaPrviMenu();}
		
	}
		}else {System.out.println("Pogresan username.");}
	}
	
	public static String unosSifre(String username, String ime, String prezime) throws SQLException
	{
		KorisnikValidacija podaciZaRegistracijuProvjera = new KorisnikValidacija();
		System.out.println("Password: ");
		String sifra=unos.next();
		if(podaciZaRegistracijuProvjera.validacijaRegistracijeUsername(username)==false)
		{	
		
			if(podaciZaRegistracijuProvjera.validacijaRegistracijePassword(sifra)==true)
				{	
					Korisnik korisnik = new Korisnik(ime,prezime,username,sifra);
					KorisnikDAOImplementation registracija = new KorisnikDAOImplementation();
					registracija.dodajKorisnika(korisnik);
				}else {unosSifre(username,ime,prezime);}
		}else {registrovanje();}
		
			return sifra;
	}
	
	
}
