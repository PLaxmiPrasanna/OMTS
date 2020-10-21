package com.cg.omts.dao;

import java.util.ArrayList;
import java.util.List;

import com.cg.omts.dto.Screen;
import com.cg.omts.dto.Show;
import com.cg.omts.exceptions.OMTSException;

public interface IScreenShowDao {
		
	public List<Show> getShowDetails() throws OMTSException;//show screen
	
	public int addShow(Show show) throws OMTSException;//show
	
	public int deleteShow(int showId) throws OMTSException;//show
	
	public List<Show> getShowByName(String showName) throws OMTSException;//show
	
	public List<Integer> getScreenFromMovieAndTheatre(int theatreId, int movieId) throws OMTSException;
	
	public String checkShowNameandScreenId(String showName, int screenId) throws OMTSException;
	
	public boolean isScreenIdExists(int screenId) throws OMTSException;
	
	public  Boolean addScreen(Screen screen, Integer theatreId) throws OMTSException;
	
	public  Boolean deleteScreen(Integer screenId) throws OMTSException;//show
	
	public  ArrayList<Screen> getScreenDetailsToDelete() throws OMTSException;//show
	
	public boolean addScreenSeatPrice(int screenId, int seatPrice) throws OMTSException;

}