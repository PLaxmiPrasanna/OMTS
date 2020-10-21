package com.cg.omts.service;

import java.util.ArrayList;
import java.util.List;

import com.cg.omts.dao.IScreenShowDao;
import com.cg.omts.dao.ScreenShowDaoImpl;
import com.cg.omts.dto.Screen;
import com.cg.omts.dto.Show;
import com.cg.omts.exceptions.OMTSException;

public class ScreenShowServiceImpl implements IScreenShowService{
	IScreenShowDao screenShowDao = null;
	@Override
	public Boolean addScreen(Screen screen, Integer theatreId) throws OMTSException {
		screenShowDao = new ScreenShowDaoImpl();
		Boolean isAdded = screenShowDao.addScreen(screen, theatreId);
		return isAdded;
	}

	@Override
	public Boolean deleteScreen(Integer screenId) throws OMTSException {
		screenShowDao = new ScreenShowDaoImpl();
		Boolean isAdded = screenShowDao.deleteScreen(screenId);
		return isAdded;
	}

	@Override
	public ArrayList<Screen> getScreenDetailsToDelete() throws OMTSException {
		screenShowDao = new ScreenShowDaoImpl();
		ArrayList<Screen> screenList = screenShowDao.getScreenDetailsToDelete();
		return screenList;
	}
	
	@Override
	public boolean isScreenIdExists(int screenId) throws OMTSException {
		screenShowDao = new ScreenShowDaoImpl();
		boolean isExists = screenShowDao.isScreenIdExists(screenId);
		return isExists;
	}
	
	@Override
	public boolean addScreenSeatPrice(int screenId, int seatPrice) throws OMTSException {
		screenShowDao = new ScreenShowDaoImpl();
		boolean isAdded = screenShowDao.addScreenSeatPrice(screenId, seatPrice);
		return isAdded;
	}

	@Override
	public List<Show> getShowDetails() throws OMTSException {
		// TODO Auto-generated method stub
		screenShowDao = new ScreenShowDaoImpl();
		return screenShowDao.getShowDetails();
		
	}

	@Override
	public int addShow(Show show) throws OMTSException {
		// TODO Auto-generated method stub
		screenShowDao = new ScreenShowDaoImpl();
		return screenShowDao.addShow(show);
	}

	@Override
	public int deleteShow(int showId) throws OMTSException {
		// TODO Auto-generated method stub
		screenShowDao = new ScreenShowDaoImpl();
		return screenShowDao.deleteShow(showId);
	}

	@Override
	public List<Show> getShowByName(String showName) throws OMTSException {
		// TODO Auto-generated method stub
		screenShowDao = new ScreenShowDaoImpl();
		return screenShowDao.getShowByName(showName);
	}

	@Override
	public List<Integer> getScreenFromMovieAndTheatre(int theatreId, int movieId) throws OMTSException {
		// TODO Auto-generated method stub
		screenShowDao = new ScreenShowDaoImpl();
		return screenShowDao.getScreenFromMovieAndTheatre(theatreId, movieId);
	}

	@Override
	public String checkShowNameandScreenId(String showName, int screenId) throws OMTSException {
		// TODO Auto-generated method stub
		screenShowDao = new ScreenShowDaoImpl();
		return screenShowDao.checkShowNameandScreenId(showName, screenId);
	}
}