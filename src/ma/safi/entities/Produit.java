package ma.safi.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produit")
public class Produit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idprod")
	private int idProduit;
	@Column(name = "nomprod")
	private String nomProduit;
	@Column(name = "prixunitaire")
	private float prixUnitaire;
	@Column(name = "quantite")
	private int quantite;
	@Column(name = "description")
	private String description;

	
	@ManyToOne (cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	@JoinColumn(name="idfour")
	private Fornisseur founisseur;
	
	public Produit() {
		
	}
	
	public Produit(String nomProduit, float prixUnitaire, int quantite, String description) {
		this.nomProduit = nomProduit;
		this.prixUnitaire = prixUnitaire;
		this.quantite = quantite;
		this.description = description;
	}

	

	public Produit(int idProduit, String nomProduit, float prixUnitaire, int quantite, String description) {
		this.idProduit = idProduit;
		this.nomProduit = nomProduit;
		this.prixUnitaire = prixUnitaire;
		this.quantite = quantite;
		this.description = description;
	}

	public int getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}
	public String getNomProduit() {
		return nomProduit;
	}
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
	public float getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Fornisseur getFounisseur() {
		return founisseur;
	}
	public void setFounisseur(Fornisseur founisseur) {
		this.founisseur = founisseur;
	}

	@Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", nomProduit=" + nomProduit + ", prixUnitaire=" + prixUnitaire
				+ ", quantite=" + quantite + ", description=" + description + ", founisseur=" + founisseur + "]";
	}
	
	
}
