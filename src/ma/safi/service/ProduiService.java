package ma.safi.service;

import java.util.List;

import ma.safi.entities.Produit;

public interface ProduiService {

	List<Produit> getlistPoduits();

	Produit getProduitByIdService(int id);

	void deleteProduit(int id);

	void modifierProduit(Produit produit,int id, int idfornisseur);

	void addproduit(Produit produit, int idfournisseur);

}
