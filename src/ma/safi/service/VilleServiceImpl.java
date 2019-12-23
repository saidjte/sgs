package ma.safi.service;

import java.util.List;

import ma.safi.dao.ville.VilleDao;
import ma.safi.dao.ville.VilleDaoImpl;
import ma.safi.entities.Ville;

public class VilleServiceImpl implements VilleService {
	VilleDao villeDao;

	public VilleServiceImpl() {
		villeDao = new VilleDaoImpl();

	}

	@Override
	public List<Ville> getvilleList() {
		
		return villeDao.getlistVille();
	}

}
