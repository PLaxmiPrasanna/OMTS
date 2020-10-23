package com.cg.omts.controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.omts.dao.ScreenShowDaoImpl;
import com.cg.omts.dto.Show;
import com.cg.omts.dto.Theatre;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.service.IScreenShowService;
import com.cg.omts.service.ScreenShowServiceImpl;
import org.apache.log4j.Logger;

@WebServlet("/DeleteShowServlet")
public class DeleteShowController extends HttpServlet {

	final static Logger LOGGER = Logger.getLogger(DeleteShowController.class);  
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String showName = request.getParameter("showNameSearch");
		
		IScreenShowService screenShowService = new ScreenShowServiceImpl();
		try {
			LOGGER.info("Getting show list");
			List<Show> searchShowList = screenShowService.getShowByName(showName);
			if(searchShowList.size()==0) {
				LOGGER.info("Show name not found");
				request.setAttribute("errorMessage","The Show Name does not exist");
			}
			request.setAttribute("searchShowList", searchShowList);
			RequestDispatcher rd = request.getRequestDispatcher("./deleteShows.jsp");
			rd.forward(request, response);
			
		} catch (OMTSException e) {
			// TODO Auto-generated catch block
			LOGGER.warn("Exception occured");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		int showId = Integer.parseInt(request.getParameter("showId"));
		IScreenShowService screenShowService = new ScreenShowServiceImpl();
		try {
			screenShowService.deleteShow(showId);
		} catch (OMTSException e) {
			// TODO Auto-generated catch block
		}
		response.sendRedirect("./deleteShows.jsp?message=Successfully Deleted");
	}
}
