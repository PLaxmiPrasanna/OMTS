package com.cg.omts.testing;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.cg.omts.dao.ScreenShowDaoImpl;
import com.cg.omts.dto.Movie;
import com.cg.omts.dto.Screen;
import com.cg.omts.dto.Show;
import com.cg.omts.dto.Theatre;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.service.IMovieTheatreService;
import com.cg.omts.service.IScreenShowService;
import com.cg.omts.service.MovieTheatreServiceImpl;
import com.cg.omts.service.ScreenShowServiceImpl;

public class AdminModuleTesting {

	IMovieTheatreService movieTheatreService = new MovieTheatreServiceImpl(); 
	IScreenShowService screenShowService = new ScreenShowServiceImpl(); 
	
	@Test
	public void getTheatreDetailsTest() throws OMTSException{
		List<Theatre> theatreList = movieTheatreService.getTheatreDetails();
		boolean actualTheatreList = false;
		if(theatreList.size()>0) {
			actualTheatreList = true;
		}
		boolean expectedTheatreList = true;
		assertEquals(expectedTheatreList, actualTheatreList);
	}
	
	@Test
	public void addTheatreTest() throws OMTSException {
		Theatre theatre = new Theatre();
		theatre.setTheatreId(21239);
		theatre.setTheatreName("Glitz");
		theatre.setTheatreCity("Bangkok");
		theatre.setManagerName("Gokkun");
		theatre.setManagerContact("9033332216");
		int rowsInserted = movieTheatreService.addTheatre(theatre);
		boolean actualRowsInserted = false;
		if(rowsInserted!=0) {
			actualRowsInserted = true;
		}
		boolean expectedRowsInserted = true;
		assertEquals(expectedRowsInserted, actualRowsInserted);
	}
	
	@Test
	public void addTheatreTest2(){
		Theatre theatre = new Theatre();
		theatre.setTheatreId(21239);
		theatre.setTheatreName("Charm");
		theatre.setTheatreCity("Singapore");
		theatre.setManagerName("Zen Lee");
		theatre.setManagerContact("9444402216");
		try {
			int noRowsInserted = movieTheatreService.addTheatre(theatre);
			Assert.fail("Duplicate entry for Theatre id");
		} catch (OMTSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void deleteTheatreTest() throws OMTSException {
		int theatreId = 2777;
		int rowsDeleted = movieTheatreService.deleteTheatre(theatreId);
		boolean actualRowsDeleted = false;
		if(rowsDeleted != 0 ) {
			actualRowsDeleted = true;
		}
		boolean expectedRowsDeleted = true;
		assertEquals(expectedRowsDeleted,actualRowsDeleted);
	}
	@Test
	public void deleteTheatreTest2() throws OMTSException {
		int theatreId = 2343;
		int noRowsDeleted = movieTheatreService.deleteTheatre(theatreId);
		boolean actualNoRowsDeleted = false;
		if(noRowsDeleted == 0 ) {
			actualNoRowsDeleted = true;
		}
		boolean expectedNoRowsDeleted = true;
		assertEquals(expectedNoRowsDeleted,actualNoRowsDeleted);

		
	}
	
	@Test
	public void getTheatreByNameTest() throws OMTSException {
		String theatreName = "Delhi";
		List<Theatre> theatreList = movieTheatreService.getTheatreByName(theatreName);
		boolean actualTheatreList = false;
		if(theatreList.size()>0) {
			actualTheatreList = true;
		}
		boolean expectedTheatreList = true;
		assertEquals(expectedTheatreList, actualTheatreList);
	}
	
	@Test
	public void getTheatreByNameTest2() throws OMTSException{
		String theatreName = "Pip";
		List<Theatre> theatreList = movieTheatreService.getTheatreByName(theatreName);
		boolean actualTheatreList = false;
		if(theatreList.size()==0) {
			actualTheatreList = true;
		}
		boolean expectedTheatreList = true;
		assertEquals(expectedTheatreList, actualTheatreList);
	}
	
	@Test
	public void getShowDetails() throws OMTSException {
		List<Show> showList = screenShowService.getShowDetails();
		boolean actualShowList = false;
		if(showList.size()>0) {
			actualShowList = true;
		}
		boolean expectedShowList = false;
		assertEquals(expectedShowList, actualShowList);
	}
	
	@Test
	public void addShowTest() throws OMTSException, ParseException {
		int rowsInserted = 0;
		Show show = new Show();
		show.setShowId(63434255);
		java.util.Date startTime = new SimpleDateFormat("hh:mm").parse("08:00:00"); 
		java.sql.Time showStartTime =  new java.sql.Time(startTime.getTime());
		java.util.Date endTime = new SimpleDateFormat("hh:mm").parse("10:00:00"); 
		java.sql.Time showEndTime =  new java.sql.Time(endTime.getTime());
		show.setShowStartTime(showStartTime);
		show.setShowEndTime(showEndTime);
		show.setShowName("Morning");
		show.setScreenId(42521239);
		show.setTheatreId(21239);
		show.setMovieId(34563);
		rowsInserted = screenShowService.addShow(show);
		boolean actualRowsInserted = false;
		if(rowsInserted > 0) {
			actualRowsInserted = true;
		}
		boolean expectedRowsInserted = false;
		assertEquals(expectedRowsInserted, actualRowsInserted);
	}
	
	@Test
	public void addShowTest2() throws OMTSException, ParseException {
		Show show = new Show();
		show.setShowId(654);
		java.util.Date startTime = new SimpleDateFormat("hh:mm").parse("08:00:00"); 
		java.sql.Time showStartTime =  new java.sql.Time(startTime.getTime());
		java.util.Date endTime = new SimpleDateFormat("hh:mm").parse("10:00:00"); 
		java.sql.Time showEndTime =  new java.sql.Time(endTime.getTime());
		show.setShowStartTime(showStartTime);
		show.setShowEndTime(showEndTime);
		show.setShowName("Morning");
		show.setScreenId(42521239);
		show.setTheatreId(21239);
		show.setMovieId(34563);
		try {
			screenShowService.addShow(show);
			Assert.fail("Duplicate entry for Show id");
		} catch (OMTSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void deleteShowTest() throws OMTSException {
		int rowsDeleted = 0;
		int showId = 75483;
		rowsDeleted = screenShowService.deleteShow(showId);
		boolean actualRowsDeleted = false;
		if(rowsDeleted > 0) {
			actualRowsDeleted = true;
		}
		boolean expectedRowsDeleted = true;
		assertEquals(expectedRowsDeleted, actualRowsDeleted);
	}
	
	@Test
	public void deleteShowTest2() throws OMTSException {
		int noRowsDeleted=0;
		int showId = 90493;
		noRowsDeleted = screenShowService.deleteShow(showId);
		boolean actualNoRowDeleted = false;
		if(noRowsDeleted == 0 ) {
			actualNoRowDeleted = true;
		}
		boolean expectedNoRowDeleted = true;
		assertEquals(expectedNoRowDeleted,actualNoRowDeleted);
	}
	
	@Test
	public void getShowByNameTest() throws OMTSException {
		String showName = "Morning";
		List<Show> showList = screenShowService.getShowByName(showName);
		boolean actualShowList = false;
		if(showList.size() > 0) {
			actualShowList = true;
		}
		boolean expectedShowList = true;
		assertEquals(expectedShowList, actualShowList);
	}
	
	@Test
	public void getShowByNameTest2() throws OMTSException {
		String showName = "MidNight";
		List<Show> showList = screenShowService.getShowByName(showName);
		boolean actualShowList = false;
		if(showList.size() == 0) {
			actualShowList = true;
		}
		boolean expectedShowList = true;
		assertEquals(expectedShowList, actualShowList);
	}
	
	@Test
	public void addMovieTest() throws OMTSException {
		try {
			
			Date movieReleaseDate = Date.valueOf("2020-03-01");
			Movie movie = new Movie(2, "SeventhSense", "action", "mani", 180, "Telugu", movieReleaseDate);
			boolean isAdded = movieTheatreService.addMovie(movie);
			assertTrue(isAdded);
		} catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	
	@Test
	public void getMovieDetailsToDeleteTest() throws OMTSException {
		try {
			ArrayList<Movie> movieDetails = movieTheatreService.getMovieDetailsToDelete();
			assertNotNull(movieDetails);
		} catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	
	@Test
	public void deleteMovieTest() throws OMTSException {
		try {
			int movieId = 2;
			int rowDeleted = movieTheatreService.deleteMovie(movieId);
			assertTrue(rowDeleted > 0);
		} catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	
	@Test
	public void getTheatreDetailsMovieTest() throws OMTSException {
		try {
			String theatreCity = "Hyderabad";
			ArrayList<Theatre> theatreDetails = movieTheatreService.getTheatreDetails(theatreCity);
			assertNotNull(theatreDetails);
		} catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	
	@Test
	public void addScreenTest() throws OMTSException {
		try {
			int theatreId = 1;
			Screen screen = new Screen(1, "Screen1",  50, 10);
			boolean isAdded = screenShowService.addScreen(screen, theatreId);
			assertTrue(isAdded);
		} catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}	
			
	}
	
	@Test
	public void deleteScreenTest() throws OMTSException {
		try {
			int screenId = 1;
			boolean isDeleted = screenShowService.deleteScreen(screenId);
			assertTrue(isDeleted);
		} catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	
	@Test
	public void getScreenDetailsToDeleteTest() throws OMTSException {
		try {
			ArrayList<Screen> screenList = screenShowService.getScreenDetailsToDelete();
			assertNotNull(screenList);
		} catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	
	
}
