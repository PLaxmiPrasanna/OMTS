package com.cg.omts.service;

import java.util.ArrayList;
import java.util.List;

import com.cg.omts.dto.Screen;
import com.cg.omts.dto.Show;
import com.cg.omts.exceptions.OMTSException;

public interface IScreenShowService {

	public boolean isScreenIdExists(int screenId) throws OMTSException;

	public Boolean addScreen(Screen screen, Integer theatreId) throws OMTSException;

	public Boolean deleteScreen(Integer screenId) throws OMTSException;

	public ArrayList<Screen> getScreenDetailsToDelete() throws OMTSException;

	public boolean addScreenSeatPrice(int screenId, int seatPrice) throws OMTSException;

	/*********
	 * @Description : To get details of all the shows
	 * @author : supraja
	 * @return : List of shows
	 * @Exception : throws OMTSException
	 **********/
	public List<Show> getShowDetails() throws OMTSException;

	/*********
	 * @Description : To add the registered show
	 * @author : supraja
	 * @param : show object
	 * @return : Number of shows inserted
	 * @Exception : throws OMTSException
	 * 
	 ********/
	public int addShow(Show show) throws OMTSException;

	/******
	 * @Description : To deleted requested show
	 * @author : supraja
	 * @param : show Id
	 * @return : number of shows deleted
	 * @Exception : throws OMTSException
	 ********/
	public int deleteShow(int showId) throws OMTSException;

	/*******
	 * @Description : To get the list of shows of specific show name
	 * @author : supraja
	 * @param : show name
	 * @return : List of shows of specified name
	 * @Exception : throws OMTSException
	 ********/

	public List<Show> getShowByName(String showName) throws OMTSException;

	/***
	 * @Description : To get the screen Id from movie and theatre
	 * @author : supraja
	 * @param theatreId
	 * @param movieId
	 * @return
	 * @throws OMTSException
	 */
	public List<Integer> getScreenFromMovieAndTheatre(int theatreId, int movieId) throws OMTSException;

	/*******
	 * @Description : To check if there exists a showname in screenId
	 * @author : supraja
	 * @param showName
	 * @param screenId
	 * @return
	 * @throws OMTSException
	 */
	public String checkShowNameandScreenId(String showName, int screenId) throws OMTSException;
}