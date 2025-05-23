package controller;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AppointmentDao;
import model.Appointment;
import service_OTP.Servicesss;

@WebServlet("/AppointmentController")
public class AppointmentController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("confirm")) {
			int aid = Integer.parseInt(request.getParameter("aid"));
			String email = request.getParameter("email");
			Servicesss s = new Servicesss();
			s.sendMsg(email, "Your Appointment has been booked");
			AppointmentDao.updateStatus(aid);
			response.sendRedirect("d-pending-appointment.jsp");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action  = request.getParameter("action");
		if(action.equalsIgnoreCase("book")) {
			Appointment a = new Appointment();
			a.setPid(Integer.parseInt(request.getParameter("pid")));
			a.setPack_id(Integer.parseInt(request.getParameter("pack_id")));
			a.setP_name(request.getParameter("p_name"));
			a.setP_amount(Integer.parseInt(request.getParameter("p_amount")));
			a.setP_test(request.getParameter("p_test"));
			a.setDate(Date.valueOf(request.getParameter("date")));
			a.setStatus("pending");
			System.out.println(a);
			AppointmentDao.bookAppointment(a);
			response.sendRedirect("p-home.jsp");
		}
	}

}