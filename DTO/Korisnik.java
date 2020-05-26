package DTO;

public class Korisnik  {

	protected String ime;
	protected String prezime;
	protected String username;
	protected String sifra;
	
	public Korisnik ()
	{}
	
	public Korisnik (String ime,String prezime, String username,String sifra)
	{
		this.ime=ime;
		this.prezime=prezime;
		this.username=username;
		this.sifra=sifra;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}


	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	


	
}

