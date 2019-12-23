package ma.safi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_info")
public class Users {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name = "iduser")
	private int idUser;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "prenom")
	private String preNom;
	
	@Column(name = "post")
	private String poste;
	
	@Column(name = "login")
	private String login;
	
	@Column(name = "password")
	private String password;


	public Users() {
	}


	public Users(String nom, String preNom, String login, String password) {
		super();
		this.nom = nom;
		this.preNom = preNom;
		this.login = login;
		this.password = password;
	}


	public Users(String nom, String preNom, String login) {
		super();
		this.nom = nom;
		this.preNom = preNom;
		this.login = login;
	}


	public Users(String nom, String preNom, String poste, String login, String password) {
		super();
		this.nom = nom;
		this.preNom = preNom;
		this.poste = poste;
		this.login = login;
		this.password = password;
	}

	public Users(int idUser, String nom, String preNom, String poste, String login, String password) {
		super();
		this.idUser = idUser;
		this.nom = nom;
		this.preNom = preNom;
		this.poste = poste;
		this.login = login;
		this.password = password;
	}


	public int getIdUser() {
		return idUser;
	}


	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPreNom() {
		return preNom;
	}


	public void setPreNom(String preNom) {
		this.preNom = preNom;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public String getPoste() {
		return poste;
	}


	public void setPoste(String poste) {
		this.poste = poste;
	}
	
	
}
