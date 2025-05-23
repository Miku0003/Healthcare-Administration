package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PackageDao;
import model.Packages;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PackageDao;
import model.Packages;

/**
 * Servlet implementation class PackageController
 */
@WebServlet("/PackageController")
public class PackageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PackageController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("add")) {
			Packages p = new Packages();
			p.setDid(Integer.parseInt(request.getParameter("did")));
			p.setP_name(request.getParameter("p_name"));
			p.setP_amount(Integer.parseInt(request.getParameter("p_amount")));
			p.setP_test(request.getParameter("p_test"));
			System.out.println(p);
			PackageDao.insertPackage(p);
			response.sendRedirect("d-home.jsp");
		}
		else if(action.equalsIgnoreCase("update")) {
			Packages p = new Packages();
			p.setP_id(Integer.parseInt(request.getParameter("pid")));
			p.setP_name(request.getParameter("p_name"));
			p.setP_amount(Integer.parseInt(request.getParameter("p_amount")));
			p.setP_test(request.getParameter("p_test"));
			PackageDao.updatePackage(p);
			response.sendRedirect("d-manage-package.jsp");
		}
	}

}