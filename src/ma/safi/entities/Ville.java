package ma.safi.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ville")
public class Ville {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ville")
	private int idVille;
	@Column(name = "nom_ville")
	private String nomVille;
	
	@OneToMany(mappedBy="ville",cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
	private List<Fornisseur> listeFornisseurs ;
	
	public Ville() {
		
	}
	public Ville(String nomVille, List<Fornisseur> listeFornisseurs) {
		this.nomVille = nomVille;
		this.listeFornisseurs = listeFornisseurs;
	}
	public Ville(String nomVille) {
		this.nomVille = nomVille;
	}
	
	public int getIdVille() {
		return idVille;
	}
	public void setIdVille(int idVille) {
		this.idVille = idVille;
	}
	public String getNomVille() {
		return nomVille;
	}
	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}
	public List<Fornisseur> getListeFornisseurs() {
		return listeFornisseurs;
	}
	public void setListeFornisseurs(List<Fornisseur> listeFornisseurs) {
		this.listeFornisseurs = listeFornisseurs;
	}
	
	public void add(Fornisseur fornisseur) {
		if(listeFornisseurs == null) {
			listeFornisseurs = new ArrayList<Fornisseur>();
		}
		listeFornisseurs.add(fornisseur);
		fornisseur.setVille(this);
	}
}
