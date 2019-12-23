package ma.safi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "fournisseur")
public class Fornisseur implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idfournisseur")
	private int idfournisseur;
	
	@Column(name = "nomfournisseur" )
	private String nomFournisseur;
	
	@Column(name = "prenomfournisseur")
	private String preNomFournisseur;
	
	@Column(name = "addresse")
	private String adresse;
	
	@ManyToOne (cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	@JoinColumn(name="id_ville")
	private Ville ville;
	
	@OneToMany(mappedBy="founisseur",cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
	private List<Produit> listeProduits ;

	public Fornisseur() {
	}
	
	public Fornisseur(String nomFournisseur, String preNomFournisseur, String adresse) {
		super();
		this.nomFournisseur = nomFournisseur;
		this.preNomFournisseur = preNomFournisseur;
		this.adresse = adresse;
	}

	public Fornisseur(String nomFournisseur, String preNomFournisseur, String adresse, Ville ville) {
		this.nomFournisseur = nomFournisseur;
		this.preNomFournisseur = preNomFournisseur;
		this.adresse = adresse;
		this.ville = ville;
	}

	public Fornisseur(int idfournisseur, String nomFournisseur, String preNomFournisseur, String adresse,
			Ville ville) {
		this.idfournisseur = idfournisseur;
		this.nomFournisseur = nomFournisseur;
		this.preNomFournisseur = preNomFournisseur;
		this.adresse = adresse;
		this.ville = ville;
	}

	public int getIdfournisseur() {
		return idfournisseur;
	}

	public void setIdfournisseur(int idfournisseur) {
		this.idfournisseur = idfournisseur;
	}

	public String getNomFournisseur() {
		return nomFournisseur;
	}

	public void setNomFournisseur(String nomFournisseur) {
		this.nomFournisseur = nomFournisseur;
	}

	public String getPreNomFournisseur() {
		return preNomFournisseur;
	}

	public void setPreNomFournisseur(String preNomFournisseur) {
		this.preNomFournisseur = preNomFournisseur;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}
	
	
	public List<Produit> getListeProduits() {
		return listeProduits;
	}

	public void setListeProduits(List<Produit> listeProduits) {
		this.listeProduits = listeProduits;
	}

	public void add(Produit produit) {
		if(listeProduits == null) {
			listeProduits = new ArrayList<Produit>();
		}
		listeProduits.add(produit);
		produit.setFounisseur(this);
	}

	
}
