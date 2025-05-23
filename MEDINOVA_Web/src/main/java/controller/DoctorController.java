package controller;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.DoctorDao;
import model.Doctor;
import service_OTP.Servicesss;
import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.DoctorDao;
import model.Doctor;
import service_OTP.Servicesss;

/**
 * Servlet implementation class DoctorController
 */
@WebServlet("/DoctorController")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 512, maxFileSize = 1024 * 1024 * 512, maxRequestSize = 1024 * 1024
* 512)
public class DoctorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	private String extractfilename(Part file) {
		String cd = file.getHeader("content-disposition");
		System.out.println(cd);
		String[] items = cd.split(";");
		for (String string : items) {
			if (string.trim().startsWith("filename")) {
				return string.substring(string.indexOf("=") + 2, string.length() - 1);
			}
		}
		return "";
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("register")) {
			String savePath = "C:\\Users\\Raushan\\eclipse-workspace\\MEDINOVA_Web\\src\\main\\webapp\\img";
			File fileSaveDir = new File(savePath);
			if (!fileSaveDir.exists()) {
				fileSaveDir.mkdir();
			}
			Part file1 = request.getPart("image");
			String fileName = extractfilename(file1);
			file1.write(savePath + File.separator + fileName);
			String filePath = savePath + File.separator + fileName;

			String savePath2 = "C:\\Users\\Raushan\\eclipse-workspace\\MEDINOVA_Web\\src\\main\\webapp\\img";
			File imgSaveDir = new File(savePath2);
			if (!imgSaveDir.exists()) {
				imgSaveDir.mkdir();
			}
			
			Doctor d = new Doctor();
			d.setImage(fileName);
			d.setName(request.getParameter("name"));
			d.setContact(Long.parseLong(request.getParameter("contact")));
			d.setAddress(request.getParameter("address"));
			d.setSpecialization(request.getParameter("specialization"));
			d.setWork_address(request.getParameter("w_address"));
			d.setEmail(request.getParameter("email"));
			d.setPassword(request.getParameter("password"));
			System.out.println(d);
			boolean flag = DoctorDao.checkDoctorEmail(request.getParameter("email"));
			if(flag == false) {
				DoctorDao.insertDoctor(d);
				response.sendRedirect("d-login.jsp");
			}
			else {
				request.setAttribute("msg","Account already registered!");
				request.getRequestDispatcher("d-registser.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("login")) {
			Doctor d = new Doctor();
			d.setEmail(request.getParameter("email"));
			d.setPassword(request.getParameter("password"));
			System.out.println(d);
			boolean flag = DoctorDao.checkDoctorEmail(request.getParameter("email"));
			System.out.println(flag);
			if(flag == true) {
				Doctor d1 =  DoctorDao.doctorLogin(d);
				System.out.println("d1 : "+d1);
				if(d1!=null) {
					HttpSession session = request.getSession();
					session.setAttribute("data",d1);
					request.getRequestDispatcher("d-home.jsp").forward(request, response);
				}
				else {
					request.setAttribute("msg", "Password is Incorrect");
					request.getRequestDispatcher("d-login.jsp").forward(request, response);
				}
			}
			else {
				request.setAttribute("msg", "Account not found");
				request.getRequestDispatcher("d-login.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("update")) {
			String savePath = "C:\\Users\\Raushan\\eclipse-workspace\\MEDINOVA_Web\\src\\main\\webapp\\img";
			File fileSaveDir = new File(savePath);
			if (!fileSaveDir.exists()) {
				fileSaveDir.mkdir();
			}
			Part file1 = request.getPart("image");
			String fileName = extractfilename(file1);
			file1.write(savePath + File.separator + fileName);
			String filePath = savePath + File.separator + fileName;

			String savePath2 = "C:\\Users\\Raushan\\eclipse-workspace\\MEDINOVA_Web\\src\\main\\webapp\\img";
			File imgSaveDir = new File(savePath2);
			if (!imgSaveDir.exists()) {
				imgSaveDir.mkdir();
			}
			
			Doctor d = new Doctor();
			d.setDid(Integer.parseInt(request.getParameter("did")));
			d.setImage(fileName);
			d.setName(request.getParameter("name"));
			d.setContact(Long.parseLong(request.getParameter("contact")));
			d.setAddress(request.getParameter("address"));
			d.setSpecialization(request.getParameter("specialization"));
			d.setWork_address(request.getParameter("w_address"));
			d.setEmail(request.getParameter("email"));
			System.out.println(d);
			DoctorDao.updateProfile(d);
			HttpSession session = request.getSession();
			session.setAttribute("data",d);
			request.getRequestDispatcher("d-home.jsp").forward(request, response);
		}
		else if(action.equalsIgnoreCase("cp")) {
			int id = Integer.parseInt(request.getParameter("did"));
			String op = request.getParameter("op");
			String np = request.getParameter("np");
			String cnp = request.getParameter("cnp");
			boolean flag = DoctorDao.checkOldPassword(id, op);
			if(flag == true) {
				if(np.equals(cnp)) {
					DoctorDao.changePassword(id, np);
					response.sendRedirect("d-home.jsp");
				}
				else {
					request.setAttribute("msg", "Password not matched");
					request.getRequestDispatcher("d-change-pass.jsp").forward(request, response);
				}
			}
			else {
				request.setAttribute("msg", "Old Password incorrect");
				request.getRequestDispatcher("d-change-pass.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("fp")) {
			String email = request.getParameter("email");
			boolean flag= DoctorDao.checkDoctorEmail(email);
			if(flag == true) {
				Random r = new Random();
				int num = r.nextInt(999999);
				System.out.println(num);
				Servicesss s = new Servicesss();
				s.sendMail(email, num);
				request.setAttribute("email", email);
				request.setAttribute("otp", num);
				request.getRequestDispatcher("d-verify-otp.jsp").forward(request, response);
			}
			else {
				request.setAttribute("msg", "account doen't exist !");
				request.getRequestDispatcher("d-forgot-password.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("verify")) {
			String email = request.getParameter("email");
			int otp1 = Integer.parseInt(request.getParameter("otp1"));
			int otp2 = Integer.parseInt(request.getParameter("otp2"));
			if(otp1 == otp2) {
				request.setAttribute("email", email);
				request.getRequestDispatcher("d-new-password.jsp").forward(request, response);
			}
			else {
				request.setAttribute("otp", otp1);
				request.setAttribute("email", email);
				request.setAttribute("msg", "OTP not matched");
				request.getRequestDispatcher("d-verify-otp.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("np")) {
			String email = request.getParameter("email");
			String np = request.getParameter("np");
			String cnp = request.getParameter("cnp");
			if(np.equals(cnp)) {
				DoctorDao.newPassword(email, np);
				response.sendRedirect("d-login.jsp");
			}
			else {
				request.setAttribute("msg", "password not matched");
				request.getRequestDispatcher("d-new-password.jsp").forward(request, response);
			}
		}
	}

}

