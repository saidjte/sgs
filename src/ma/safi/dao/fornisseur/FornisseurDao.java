package ma.safi.dao.fornisseur;

import java.util.List;

import ma.safi.entities.Fornisseur;

public interface FornisseurDao {

	List<Fornisseur> getlistFornisseurs();

	Fornisseur getFornisseurByIdDao(int id);

	void deleteFornisseur(int id);

	void modifierFornisseur(Fornisseur fornisseur, int id,int idville);

	void addFornisseur(Fornisseur fornisseur, int idville);

}
