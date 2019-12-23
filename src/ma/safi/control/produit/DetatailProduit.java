package ma.safi.control.produit;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.safi.entities.Produit;
import ma.safi.service.ProduiService;
import ma.safi.service.ProduiServiceImpl;

/**
 * Servlet implementation class DetatailProduit
 */
@WebServlet("/detatailduproduit")
public class DetatailProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetatailProduit() {
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
		request.setAttribute("detailProduit", detailProduit);
		this.getServletContext().getRequestDispatcher("/WEB-INF/home/detailleproduit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
