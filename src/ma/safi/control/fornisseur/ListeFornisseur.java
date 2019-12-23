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
import ma.safi.service.FornisseurService;
import ma.safi.service.FornisseurServiceImpl;

/**
 * Servlet implementation class listfornisseurs
 */
@WebServlet("/listfornisseurs")
public class ListeFornisseur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeFornisseur() {
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
		this.getServletContext().getRequestDispatcher("/WEB-INF/home/listedesfouniseur.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
