package ma.safi.dao.produit;

import java.util.List;

import ma.safi.entities.Produit;

public interface ProduiDao {

	List<Produit> getlistPoduits();

	Produit getProduitByIdDao(int id);

	void deleteProduit(int id);

	void modifierProduit(Produit produit, int id, int idfornisseur);

	void addproduit(Produit produit, int idfournisseur);

}
