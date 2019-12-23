package ma.safi.control.fornisseur;

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
 * Servlet implementation class DetatailProduit
 */
@WebServlet("/detataildufornisseur")
public class DetatailFornisseur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetatailFornisseur() {
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
		FornisseurService detailFornisseurService = new FornisseurServiceImpl();
		Fornisseur detailFornisseur = new Fornisseur();
		detailFornisseur = detailFornisseurService.getFornisseurByIdService(id);
		
		List<Produit> listPoduits = new ArrayList<Produit>();

//		ProduiService produitService = new ProduiServiceImpl();
//		listPoduits = produitService.getlistPoduits()

		listPoduits = detailFornisseur.getListeProduits();
		
		request.setAttribute("listPoduits", listPoduits);
		request.setAttribute("detailfornisseur", detailFornisseur);
		this.getServletContext().getRequestDispatcher("/WEB-INF/home/detaillefornisseur.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
