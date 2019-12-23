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
 * Servlet implementation class AddProdut
 */
@WebServlet("/ajouterunproduit")
public class AddProdut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProdut() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		FornisseurService produitService = new FornisseurServiceImpl();
		List<Fornisseur> listFornisseur = new ArrayList<Fornisseur>();
		listFornisseur = produitService.getlistFornisseurs();
		request.setAttribute("listFornisseur", listFornisseur);
		this.getServletContext().getRequestDispatcher("/WEB-INF/home/ajouterproduit.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		try {
			String nomProduit = request.getParameter("nomProduit");
			float prixUnitaire = Float.parseFloat(request.getParameter("prixUnitaire"));
			int quantite = Integer.parseInt(request.getParameter("quantite"));
			String description = request.getParameter("description");
			int idfournisseur = Integer.parseInt(request.getParameter("fournisseur"));
			Produit produit = new Produit(nomProduit, prixUnitaire, quantite, description);
			ProduiService produiService = new ProduiServiceImpl();
			produiService.addproduit(produit,idfournisseur);
			request.setAttribute("msgmanupilationproduit", "Produit ("+nomProduit+") Ajouté avec sucée");
			this.getServletContext().getRequestDispatcher("/listproduit").forward(request, response);
		} catch (NumberFormatException  e) {
			request.setAttribute("msgmanupilationproduit","Nomber Invalide");
			this.getServletContext().getRequestDispatcher("/WEB-INF/home/ajouterproduit.jsp").forward(request, response);
		}catch (Exception e) {
			request.setAttribute("msgmanupilationproduit","Erreur inonue");
			this.getServletContext().getRequestDispatcher("/WEB-INF/home/ajouterproduit.jsp").forward(request, response);
		}

	}

}
