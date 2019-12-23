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
import ma.safi.entities.Ville;
import ma.safi.service.FornisseurService;
import ma.safi.service.FornisseurServiceImpl;
import ma.safi.service.VilleService;
import ma.safi.service.VilleServiceImpl;

/**
 * Servlet implementation class ModProduit
 */
@WebServlet("/modifierfornisseur")
public class ModFornisseur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModFornisseur() {
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
		List<Ville> vList = new ArrayList<Ville>();
		VilleService ville = new VilleServiceImpl();
		vList = ville.getvilleList();
		request.setAttribute("detailfornisseur", detailFornisseur);
		request.setAttribute("vList", vList);
		this.getServletContext().getRequestDispatcher("/WEB-INF/home/modifierfournisseur.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		int id = Integer.valueOf(request.getParameter("id"));
		String nomFournisseur = request.getParameter("nomfornisseur");
		String preNomFournisseur = request.getParameter("prenomfornisseur");
		String adresse = request.getParameter("adresse");
		int idville = Integer.valueOf(request.getParameter("ville"));
		Fornisseur fornisseur = new Fornisseur(nomFournisseur, preNomFournisseur, adresse);
		FornisseurService modifierFornisseur = new FornisseurServiceImpl();
		modifierFornisseur.modifierFornisseur(fornisseur,id,idville);
		request.setAttribute("msgmanupilationfornisseur", "Fornisseur ("+nomFournisseur+" "+preNomFournisseur+") modifier avec sucée ");
		this.getServletContext().getRequestDispatcher("/listfornisseurs").forward(request, response);

	}

}
