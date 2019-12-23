package ma.safi.control.fornisseur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.safi.service.FornisseurService;
import ma.safi.service.FornisseurServiceImpl;

/**
 * Servlet implementation class DeleteProduct
 */
@WebServlet("/supprimerfornisseur")
public class DeleteFornisseur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFornisseur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		int id = Integer.valueOf(request.getParameter("id"));
		FornisseurService deleteFornisseurService = new FornisseurServiceImpl();
		deleteFornisseurService.deleteFornisseur(id);
		request.setAttribute("msgmanupilationFornisseur", "Fornisseur Supprimer avec sucée");
		this.getServletContext().getRequestDispatcher("/listfornisseurs").forward(request, response);

	}

}
