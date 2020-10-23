package com.cg.omts.testing;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.cg.omts.dto.Movie;
import com.cg.omts.dto.Theatre;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.service.IMovieTheatreService;
import com.cg.omts.service.MovieTheatreServiceImpl;

public class MovieTheatreModuleTesting {
	IMovieTheatreService movieTheatreService = new MovieTheatreServiceImpl();

	@Test
	public void addMovieTest1() throws OMTSException {
		try {

			Date movieReleaseDate = Date.valueOf("2020-03-01");
			Movie movie = new Movie(3006, "SeventhSense", "action", "mani", 180, "Telugu", movieReleaseDate);
			boolean isAdded = movieTheatreService.addMovie(movie);
			assertTrue(isAdded);
		} catch (OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}

	@Test
	public void addMovieTest2() throws OMTSException {
		try {

			Date movieReleaseDate = Date.valueOf("2020-04-05");
			Movie movie = new Movie(3005, "Tagore", "action", "mani", 180, "Telugu", movieReleaseDate);
			boolean isAdded = movieTheatreService.addMovie(movie);
			assertFalse(isAdded);
		} catch (OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}

	@Test
	public void getMovieDetailsToDeleteTest1() throws OMTSException {
		try {
			ArrayList<Movie> movieDetails = movieTheatreService.getMovieDetailsToDelete();
			assertNotNull(movieDetails);
		} catch (OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}

	@Test
	public void deleteMovieTest1() throws OMTSException {
		try {
			int movieId = 3006;
			int rowDeleted = movieTheatreService.deleteMovie(movieId);
			assertTrue(rowDeleted > 0);
		} catch (OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}

	@Test
	public void deleteMovieTest2() throws OMTSException {
		try {
			int movieId = 3010;
			int rowDeleted = movieTheatreService.deleteMovie(movieId);
			assertFalse(rowDeleted > 0);
		} catch (OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}

	@Test
	public void getTheatreDetailsMovieTest1() throws OMTSException {
		try {
			String theatreCity = "Hyderabad";
			ArrayList<Theatre> theatreDetails = movieTheatreService.getTheatreDetails(theatreCity);
			boolean actualResult = false, expectedResult = true;
			if (theatreDetails.size() != 0)
				actualResult = true;
			assertEquals(actualResult, expectedResult);
		} catch (OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}

	@Test
	public void getTheatreDetailsMovieTest2() throws OMTSException {
		try {
			String theatreCity = "Jagityal";
			ArrayList<Theatre> theatreDetails = movieTheatreService.getTheatreDetails(theatreCity);
			boolean actualResult = false, expectedResult = false;
			if (theatreDetails.size() != 0)
				actualResult = true;
			assertEquals(actualResult, expectedResult);
		} catch (OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}

	@Test
	public void addMovieToTheatreTest1() throws OMTSException {
		int movieId = 3001;
		int theatreId = 2001;
		boolean actualResult = movieTheatreService.addMovieToTheatre(movieId, theatreId);
		assertFalse(actualResult);
	}

	@Test
	public void addMovieToTheatreTest2() throws OMTSException {
		int movieId = 3002;
		int theatreId = 2001;
		boolean actualResult = movieTheatreService.addMovieToTheatre(movieId, theatreId);
		boolean expectedResult = true;
		assertEquals(actualResult, expectedResult);
	}

	@Test
	public void getMovieIdNameTest() throws OMTSException {
		ArrayList<Movie> getMovieDetails = movieTheatreService.getMovieIdName();
		assertNotNull(getMovieDetails);
	}

	@Test
	public void getMovieDetailsToDeleteTest() throws OMTSException {
		ArrayList<Movie> getMovieDetails = movieTheatreService.getMovieDetailsToDelete();
		assertNotNull(getMovieDetails);
	}

	@Test
	public void isMovieIdExistsTest1() throws OMTSException {
		int movieId = 3001;
		boolean actualResult = movieTheatreService.isMovieIdExists(movieId);
		boolean expectedResult = true;
		assertEquals(actualResult, expectedResult);
	}

	@Test
	public void isMovieIdExistsTest2() throws OMTSException {
		int movieId = 3010;
		boolean actualResult = movieTheatreService.isMovieIdExists(movieId);
		boolean expectedResult = false;
		assertEquals(actualResult, expectedResult);
	}

	@Test
	public void isTheatreIdExistsTest1() throws OMTSException {
		int theatreId = 2001;
		boolean actualResult = movieTheatreService.isTheatreIdExists(theatreId);
		boolean expectedResult = true;
		assertEquals(actualResult, expectedResult);

	}

	@Test
	public void isTheatreIdExistsTest2() throws OMTSException {
		int theatreId = 2009;
		boolean actualResult = movieTheatreService.isTheatreIdExists(theatreId);
		boolean expectedResult = false;
		assertEquals(actualResult, expectedResult);

	}

	@Test
	public void checkTheatreIdInCityTest1() throws OMTSException {
		int theatreId = 2001;
		String theatreCity = "Hyderabad";
		boolean actualResult = movieTheatreService.checkTheatreIdInCity(theatreId, theatreCity);
		boolean expectedResult = true;
		assertEquals(actualResult, expectedResult);
	}

	@Test
	public void checkTheatreIdInCityTest2() throws OMTSException {
		int theatreId = 2001;
		String theatreCity = "Jagityal";
		boolean actualResult = movieTheatreService.checkTheatreIdInCity(theatreId, theatreCity);
		boolean expectedResult = false;
		assertEquals(actualResult, expectedResult);
	}

	@Test
	public void checkTheatreIdInCityTest3() throws OMTSException {
		int theatreId = 2011;
		String theatreCity = "Hyderabad";
		boolean actualResult = movieTheatreService.checkTheatreIdInCity(theatreId, theatreCity);
		assertFalse(actualResult);
	}

	@Test
	public void checkTheatreIdInCityTest4() throws OMTSException {
		int theatreId = 2011;
		String theatreCity = "Jagityal";
		boolean actualResult = movieTheatreService.checkTheatreIdInCity(theatreId, theatreCity);
		assertFalse(actualResult);
	}

	@Test
	public void checkIdTheatreMovieAlreadyExistsTest1() throws OMTSException {
		int theatreId = 2001;
		int movieId = 3001;
		boolean actualResult = movieTheatreService.checkIdTheatreMovieAlreadyExists(theatreId, movieId);
		assertTrue(actualResult);
	}

	@Test
	public void checkIdTheatreMovieAlreadyExistsTest2() throws OMTSException {
		int theatreId = 2001;
		int movieId = 3006;
		boolean actualResult = movieTheatreService.checkIdTheatreMovieAlreadyExists(theatreId, movieId);
		assertFalse(actualResult);
	}

	@Test
	public void getTheatreDetailsTest() throws OMTSException {
		boolean actualTheatreList = false;
		boolean expectedTheatreList = true;
		try {
			List<Theatre> theatreList = movieTheatreService.getTheatreDetails();
			if (theatreList.size() > 0) {
				actualTheatreList = true;
			}
		} catch (OMTSException e) {
			throw new OMTSException("error retrieving data from Theatre table");
		}
		assertEquals(expectedTheatreList, actualTheatreList);
	}

	@Test
	public void addTheatreTest() throws OMTSException {
		int rowsInserted = 0;
		boolean actualRowsInserted = false;
		boolean expectedRowsInserted = true;
		try {
			Theatre theatre = new Theatre();
			theatre.setTheatreId(2416);
			theatre.setTheatreName("Glitz");
			theatre.setTheatreCity("Vizag");
			theatre.setManagerName("Ram");
			theatre.setManagerContact("90333216");
			rowsInserted = movieTheatreService.addTheatre(theatre);
			if (rowsInserted != 0) {
				actualRowsInserted = true;
			}
		} catch (OMTSException e) {
			throw new OMTSException("error while inserting data");
		}

		assertEquals(expectedRowsInserted, actualRowsInserted);
	}

	@Test
	public void addTheatreTest2() throws OMTSException {
		Theatre theatre = new Theatre();
		theatre.setTheatreId(2000);
		theatre.setTheatreName("Charm");
		theatre.setTheatreCity("Singapore");
		theatre.setManagerName("Zen Lee");
		theatre.setManagerContact("9444402216");
		try {
			int noRowsInserted = movieTheatreService.addTheatre(theatre);
			Assert.fail("Duplicate entry for Theatre id");
		} catch (OMTSException e) {
//expected
		}
	}

	@Test
	public void deleteTheatreTest() throws OMTSException {

		int theatreId = 2809;
		boolean expectedRowsDeleted = true;
		boolean actualRowsDeleted = false;
		try {
			int rowsDeleted = movieTheatreService.deleteTheatre(theatreId);
			if (rowsDeleted != 0) {
				actualRowsDeleted = true;
			}
		} catch (OMTSException e) {
			throw new OMTSException("Problem while deleting data from Theatre table");
		}

		assertEquals(expectedRowsDeleted, actualRowsDeleted);
	}

	@Test
	public void deleteTheatreTest2() throws OMTSException {
		int theatreId = 2443;
		int noRowsDeleted = movieTheatreService.deleteTheatre(theatreId);
		boolean actualNoRowsDeleted = false;
		if (noRowsDeleted == 0) {
			actualNoRowsDeleted = true;
		}
		boolean expectedNoRowsDeleted = true;
		assertEquals(expectedNoRowsDeleted, actualNoRowsDeleted);

	}

	@Test
	public void getTheatreByNameTest() throws OMTSException {
		String theatreName = "IMAX";
		boolean actualTheatreList = false;
		boolean expectedTheatreList = true;
		try {
			List<Theatre> theatreList = movieTheatreService.getTheatreByName(theatreName);

			if (theatreList.size() > 0) {
				actualTheatreList = true;
			}
		} catch (OMTSException e) {
			throw new OMTSException("Problem while retrieving theatres on particular name");
		}
		assertEquals(expectedTheatreList, actualTheatreList);
	}

	@Test
	public void getTheatreByNameTest2() throws OMTSException {
		String theatreName = "Pip";
		boolean noActualTheatreList = false;
		boolean noExpectedTheatreList = true;
		try {
			List<Theatre> theatreList = movieTheatreService.getTheatreByName(theatreName);
			if (theatreList.size() == 0) {
				noActualTheatreList = true;
			}
		} catch (OMTSException e) {
			throw new OMTSException("Problem while searching theatreName");
		}
		assertEquals(noExpectedTheatreList, noActualTheatreList);
	}

	@Test
	public void getMovieLengthTest() throws OMTSException {
		int movieId = 3001;
		boolean actualMovieLength = false;
		boolean expectedMovieLength = true;
		try {
			int movieLength = movieTheatreService.getMovieLength(movieId);

			if (movieLength > 0) {
				actualMovieLength = true;
			}
		} catch (OMTSException e) {
			throw new OMTSException("Problem while getting movie length from movie");
		}
		assertEquals(expectedMovieLength, actualMovieLength);

	}

	@Test
	public void getMovieLengthTest2() throws OMTSException {
		int movieId = 3056;
		boolean noActualMovieLength = false;
		boolean noExpectedMovieLength = true;
		try {
			int movieLength = movieTheatreService.getMovieLength(movieId);

			if (movieLength == 0) {
				noActualMovieLength = true;
			}
		} catch (OMTSException e) {
			throw new OMTSException("Problem while getting no movie length from movie");
		}

		assertEquals(noExpectedMovieLength, noActualMovieLength);
	}

	@Test
	public void getMovieNameByIdTest() throws OMTSException {
		int movieId = 3001;
		boolean actualMovieName = false;
		boolean expectedMovieName = true;
		String movieName = "";
		try {
			movieName = movieTheatreService.getMovieNameById(movieId);

			if (movieName.length() > 0) {
				actualMovieName = true;
			}
		} catch (OMTSException e) {
			throw new OMTSException("Problem while getting movie name from movie");
		}
		assertEquals(expectedMovieName, actualMovieName);

	}

	@Test
	public void getMovieNameByIdTest2() throws OMTSException {
		int movieId = 3078;
		boolean actualNoMovieName = false;
		boolean expectedNoMovieName = true;
		String movieName="";
		try {
			movieName = movieTheatreService.getMovieNameById(movieId);

			if(movieName.length()==0) {
				actualNoMovieName = true;
			}
		} catch(OMTSException e) {
			throw new OMTSException("Problem while getting no movie name from movie");
		}
		assertEquals(expectedNoMovieName, actualNoMovieName);

	}
}
