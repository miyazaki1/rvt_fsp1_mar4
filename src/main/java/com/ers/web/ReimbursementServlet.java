package com.ers.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.model.Reimbursement;
import com.ers.services.ReimbursementService;
import com.ers.services.ReimbursementServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/ReimbursementServlet")
public class ReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final ObjectMapper mapper = new ObjectMapper();
	private final ReimbursementService service = new ReimbursementServiceImp();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// final LoginData user = service.attemptAuthentication(req, resp);
		final List<Reimbursement> reimbursement = service.requestAllReimbursements(req, res);
		res.setContentType("application/json");

		if (reimbursement != null) {
			for(int i = 0; i < reimbursement.size(); i++)
			{
				req.getSession().setAttribute("reimbursements["+i+"]" , reimbursement.get(i).getDescription());

			}
			// req.getSession().setAttribute("job_id", user.getJob_id());
	
			//res.getOutputStream().write(mapper.writeValueAsBytes(Dispatcher.processPost(req, res)));
			req.getRequestDispatcher("/Reimbursements.jsp").forward(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return;
		}
	}
}
