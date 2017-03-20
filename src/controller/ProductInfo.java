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

import model.Product;
import model.User;
import view.ProductStore;

/**
 * Servlet implementation class ProductInfo
 */
@WebServlet(description = "Product Detail", urlPatterns = { "/ProductInfo.do" })
public class ProductInfo extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductInfo() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession current=request.getSession(false);
		if (current==null){
			RequestDispatcher view = request.getRequestDispatcher("/rateFail.jsp");
			view.forward(request, response);
		}else{
			User currentUser=(User) current.getAttribute("currentUser");
			String proid = (String) request.getParameter("proid");
			ServletContext context = getServletContext();
			ProductStore store = (ProductStore) context.getAttribute("store");
			Product p = store.getProdcut(Integer.parseInt(proid));
			String pub = p.getPublisher() + "; " + p.getEdition()+ " edtion (" + p.getPubDate() + ")";
			/*String publisherInfo = pub.getPress() + "; "
				+ String.valueOf(pub.getEdition()) + " edition ("
				+ pub.getGetDisplayPublishDate() + ")";*/
			request.setAttribute("product", p);
			request.setAttribute("productId", proid);
			request.setAttribute("publisherInfo", pub);
			int youtRating=currentUser.getProductRating()[Integer.parseInt(proid)];
			request.setAttribute("yourRating", youtRating);
			RequestDispatcher view = request.getRequestDispatcher("/productInfo.jsp");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession current=request.getSession(false);
		if (current!=null){
			User currentUser=(User) current.getAttribute("currentUser");
			String selectedRate = (String) request.getParameter("selectedrate");
			String proid = (String) request.getParameter("proid");
			ServletContext context = getServletContext();
			ProductStore store = (ProductStore) context.getAttribute("store");
			Product p = store.getProdcut(Integer.parseInt(proid));
			synchronized (p) {
				p.addRating(Integer.parseInt(selectedRate));
			}
			store.modifyProdcut(Integer.parseInt(proid), p);
			currentUser.setProductRating(Integer.parseInt(proid), Integer.parseInt(selectedRate));
			current.setAttribute("currentUser", currentUser);

			RequestDispatcher view = request.getRequestDispatcher("/productInfo.jsp");

			request.setAttribute("product", p);
			request.setAttribute("productId", proid);
			request.setAttribute("publisherInfo", p.getPublisher());
			request.setAttribute("yourRating", Integer.parseInt(selectedRate));
			view.forward(request, response);
		}else{
			RequestDispatcher view = request.getRequestDispatcher("/rateFail.jsp");
			view.forward(request, response);
		}
	}

}
