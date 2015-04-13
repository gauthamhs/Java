package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user1 = new User("gautham","leel)");
		User user2 = new User("avi","kalla)");
		User user3 = new User("mani","honna)");
		
		HttpSession session = request.getSession();
		ServletContext context = getServletContext();
		
		request.setAttribute("user1", user1);
		session.setAttribute("user2", user2);
		context.setAttribute("user3", user3);
		
		// Maps
		
		Map<String, String> map = new HashMap<>();
		map.put("fruit","banana");
		request.setAttribute("mapping", map);
		
		//Link
		
		request.setAttribute("link", "<a href='https://gmail.com'>Click here to login</a>");
		
		request.getRequestDispatcher("/request.jsp").forward(request, response);
		

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
