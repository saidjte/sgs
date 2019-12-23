package ma.safi.control.produit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.safi.entities.Produit;
import ma.safi.service.ProduiService;
import ma.safi.service.ProduiServiceImpl;

/**
 * Servlet implementation class Listeproduits
 */
@WebServlet("/listproduit")
public class Listeproduits extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Listeproduits() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		ProduiService produitService = new ProduiServiceImpl();
		List<Produit> listPoduits = new ArrayList<Produit>();
		listPoduits = produitService.getlistPoduits();
		request.setAttribute("listPoduits", listPoduits);
		this.getServletContext().getRequestDispatcher("/WEB-INF/home/listedespruits.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
