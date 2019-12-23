package ma.safi.service;

import java.util.List;

import ma.safi.dao.fornisseur.FornisseurDao;
import ma.safi.dao.fornisseur.FornisseurDaoImpl;
import ma.safi.entities.Fornisseur;

public class FornisseurServiceImpl implements FornisseurService {
	FornisseurDao fornisseurDao;
	
	
	
	public FornisseurServiceImpl() {
		fornisseurDao = new FornisseurDaoImpl();
	}



	@Override
	public List<Fornisseur> getlistFornisseurs() {
		// TODO Auto-generated method stub
		return fornisseurDao.getlistFornisseurs();
	}



	@Override
	public Fornisseur getFornisseurByIdService(int id) {
		// TODO Auto-generated method stub
		return fornisseurDao.getFornisseurByIdDao(id);
	}



	@Override
	public void deleteFornisseur(int id) {
		
		fornisseurDao.deleteFornisseur(id);
	}



	@Override
	public void modifierFornisseur(Fornisseur fornisseur,int id,int idville) {
		fornisseurDao.modifierFornisseur(fornisseur,id,idville);
		
	}



	@Override
	public void addFornisseur(Fornisseur fornisseur, int idville) {
		fornisseurDao.addFornisseur(fornisseur,idville);
		
	}

}
