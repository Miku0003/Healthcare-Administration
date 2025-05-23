package controller;

//import java.io.File;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import javax.servlet.http.Part;

//import dao.DoctorDao;
import dao.PatientDao;
//import model.Doctor;
import model.Patient;
import service_OTP.Servicesss;

/**
 * Servlet implementation class PatientController
 */
@WebServlet("/PatientController")
public class PatientController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PatientController() {
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
		if (action.equalsIgnoreCase("register")) {
			Patient p = new Patient();
			p.setName(request.getParameter("name"));
			p.setContact(Long.parseLong(request.getParameter("contact")));
			p.setAddress(request.getParameter("address"));
			p.setEmail(request.getParameter("email"));
			p.setPassword(request.getParameter("password"));
			System.out.println(p);
			boolean flag = PatientDao.checkPatientEmail(request.getParameter("email"));
			if (flag == false) {
				PatientDao.insertPatient(p);
				response.sendRedirect("p-login.jsp");
			} else {
				request.setAttribute("msg", "Account already registered!");
				request.getRequestDispatcher("p-registser.jsp").forward(request, response);
			}
		} else if (action.equalsIgnoreCase("login")) {
			Patient p = new Patient();
			p.setEmail(request.getParameter("email"));
			p.setPassword(request.getParameter("password"));
			System.out.println(p);
			boolean flag = PatientDao.checkPatientEmail(request.getParameter("email"));
			System.out.println(flag);
			if (flag == true) {
				Patient p1 = PatientDao.patientLogin(p);
				System.out.println("p1 : " + p1);
				if (p1 != null) {
					HttpSession session = request.getSession();
					session.setAttribute("data", p1);
					request.getRequestDispatcher("p-home.jsp").forward(request, response);
				} else {
					request.setAttribute("msg", "Password is Incorrect");
					request.getRequestDispatcher("p-login.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("msg", "Account not found");
				request.getRequestDispatcher("p-login.jsp").forward(request, response);
			}
		}
		else if (action.equalsIgnoreCase("update")) {

			Patient p = new Patient();
			p.setPid(Integer.parseInt(request.getParameter("id")));
			p.setName(request.getParameter("name"));
			p.setContact(Long.parseLong(request.getParameter("contact")));
			p.setAddress(request.getParameter("address"));
			p.setEmail(request.getParameter("email"));
			System.out.println(p);
			PatientDao.updateProfile(p);
			HttpSession session = request.getSession();
			session.setAttribute("data",p);
			request.getRequestDispatcher("p-home.jsp").forward(request, response);
		} else if (action.equalsIgnoreCase("cp")) {
			int pid = Integer.parseInt(request.getParameter("pid"));
			String op = request.getParameter("op");
			String np = request.getParameter("np");
			String cnp = request.getParameter("cnp");
			boolean flag = PatientDao.checkOldPassword(pid, op);
			if (flag == true) {
				if (np.equals(cnp)) {
					PatientDao.changePassword(pid, np);
					response.sendRedirect("p-home.jsp");
				} else {
					request.setAttribute("msg", "Password not matched");
					request.getRequestDispatcher("p-change-pass.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("msg", "Old Password incorrect");
				request.getRequestDispatcher("p-change-pass.jsp").forward(request, response);
			}
		} else if (action.equalsIgnoreCase("fp")) {
			String email = request.getParameter("email");
			boolean flag = PatientDao.checkPatientEmail(email);
			if (flag == true) {
				Random r = new Random();
				int num = r.nextInt(999999);
				System.out.println(num);
				Servicesss s = new Servicesss();
				s.sendMail(email, num);
				request.setAttribute("email", email);
				request.setAttribute("otp", num);
				request.getRequestDispatcher("p-verify-otp.jsp").forward(request, response);
			} else {
				request.setAttribute("msg", "account doen't exist !");
				request.getRequestDispatcher("p-forgot-password.jsp").forward(request, response);
			}
		} else if (action.equalsIgnoreCase("verify")) {
			String email = request.getParameter("email");
			int otp1 = Integer.parseInt(request.getParameter("otp1"));
			int otp2 = Integer.parseInt(request.getParameter("otp2"));
			if (otp1 == otp2) {
				request.setAttribute("email", email);
				request.getRequestDispatcher("p-new-password.jsp").forward(request, response);
			} else {
				request.setAttribute("otp", otp1);
				request.setAttribute("email", email);
				request.setAttribute("msg", "OTP not matched");
				request.getRequestDispatcher("p-verify-otp.jsp").forward(request, response);
			}
		} else if (action.equalsIgnoreCase("np")) {
			String email = request.getParameter("email");
			String np = request.getParameter("np");
			String cnp = request.getParameter("cnp");
			if (np.equals(cnp)) {
				PatientDao.newPassword(email, np);
				response.sendRedirect("p-login.jsp");
			} else {
				request.setAttribute("msg", "password not matched");
				request.getRequestDispatcher("p-new-password.jsp").forward(request, response);
			}
		}
	}

}