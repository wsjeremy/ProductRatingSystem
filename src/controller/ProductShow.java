package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import view.ProductStore;

/**
 * Servlet implementation class ProductShow
 */
@WebServlet(description = "Product Catalogue", urlPatterns = { "/ProductShow.do" })
public class ProductShow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductShow() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		ProductStore store=(ProductStore) context.getAttribute("store");
		HttpSession current=request.getSession();
		RequestDispatcher view = request.getRequestDispatcher("/productShow.jsp");
		request.setAttribute("products", store.getProducts());
		request.setAttribute("intotal", store.getProducts().size());
		User currentUser;
		if ((currentUser=(User) current.getAttribute("currentUser"))==null){
			currentUser=new User(store.getProducts().size());
			current.setAttribute("currentUser", currentUser);
		}
		request.setAttribute("currentUser", currentUser);
		view.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
