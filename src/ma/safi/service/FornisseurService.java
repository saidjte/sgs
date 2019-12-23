package ma.safi.service;

import java.util.List;

import ma.safi.entities.Fornisseur;

public interface FornisseurService {

	List<Fornisseur> getlistFornisseurs();

	Fornisseur getFornisseurByIdService(int id);

	void deleteFornisseur(int id);

	void modifierFornisseur(Fornisseur fornisseur,int id,int idville);

	void addFornisseur(Fornisseur fornisseur, int idville);

}
