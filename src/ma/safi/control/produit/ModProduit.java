package ma.safi.control.produit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.safi.entities.Fornisseur;
import ma.safi.entities.Produit;
import ma.safi.service.FornisseurService;
import ma.safi.service.FornisseurServiceImpl;
import ma.safi.service.ProduiService;
import ma.safi.service.ProduiServiceImpl;

/**
 * Servlet implementation class ModProduit
 */
@WebServlet("/modifierproduit")
public class ModProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModProduit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int id = Integer.valueOf(request.getParameter("id"));
		ProduiService detailProduitService = new ProduiServiceImpl();
		Produit detailProduit = new Produit();
		detailProduit = detailProduitService.getProduitByIdService(id);
		FornisseurService produitService = new FornisseurServiceImpl();
		List<Fornisseur> listFornisseur = new ArrayList<Fornisseur>();
		listFornisseur = produitService.getlistFornisseurs();
		request.setAttribute("listFornisseur", listFornisseur);
		request.setAttribute("detailProduit", detailProduit);
		this.getServletContext().getRequestDispatcher("/WEB-INF/home/modifierproduit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		try {
		int id = Integer.valueOf(request.getParameter("id"));
		String nomProduit = request.getParameter("nomProduit");
		float prixUnitaire = Float.valueOf(request.getParameter("prixUnitaire"));
		int quantite = Integer.valueOf(request.getParameter("quantite"));
		String description = request.getParameter("description");
		int fournisseur = Integer.valueOf(request.getParameter("fournisseur"));
		Produit produit = new Produit(nomProduit, prixUnitaire, quantite, description);
		ProduiService deleteProduitService = new ProduiServiceImpl();
		deleteProduitService.modifierProduit(produit,id,fournisseur);
		request.setAttribute("msgmanupilationproduit", "Produit ("+nomProduit+") modifier avec sucée");
		this.getServletContext().getRequestDispatcher("/listproduit").forward(request, response);
	} catch (NumberFormatException  e) {
		request.setAttribute("msgmanupilationproduite","Echec de modifiction, Nomber Invalide");
		this.getServletContext().getRequestDispatcher("/listproduit").forward(request, response);
	}catch (Exception e) {
		request.setAttribute("msgmanupilationproduite","Echec de modifiction,Erreur inonue");
		this.getServletContext().getRequestDispatcher("/listproduit").forward(request, response);
	}
	}

}
