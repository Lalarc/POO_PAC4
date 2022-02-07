package edu.uoc.pac4;

public class Company{

	private String name;
	private String nif;
	
	private Office office;
	private Ceo ceo;
	
	public Company(String name, String nif, double latitude, double longitude, String nameCeo) {
		setName(name);
		setNif(nif);
		
		office = new Office(latitude, longitude);
		ceo = new Ceo(nameCeo);
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public Office getOffice() {
		return office;
	}

	public Ceo getCeo() {
		return ceo;
	}
}
