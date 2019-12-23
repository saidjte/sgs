package ma.safi.service;

import java.util.List;

import ma.safi.dao.produit.ProduiDao;
import ma.safi.dao.produit.ProduiDaoImpl;
import ma.safi.entities.Produit;

public class ProduiServiceImpl implements ProduiService {
	ProduiDao produiDao;
	
	
	
	public ProduiServiceImpl() {
		produiDao = new ProduiDaoImpl();
	}



	@Override
	public List<Produit> getlistPoduits() {
		// TODO Auto-generated method stub
		return produiDao.getlistPoduits();
	}



	@Override
	public Produit getProduitByIdService(int id) {
		// TODO Auto-generated method stub
		return produiDao.getProduitByIdDao(id);
	}



	@Override
	public void deleteProduit(int id) {
		
		produiDao.deleteProduit(id);
	}



	@Override
	public void modifierProduit(Produit produit,int id, int idfornisseur) {
		produiDao.modifierProduit(produit,id,idfornisseur);
		
	}



	@Override
	public void addproduit(Produit produit, int idfournisseur) {
		produiDao.addproduit(produit,idfournisseur);
	}

}
