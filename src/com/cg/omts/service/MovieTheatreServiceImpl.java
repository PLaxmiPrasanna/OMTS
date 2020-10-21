package com.cg.omts.service;

import java.util.ArrayList;
import java.util.List;

import com.cg.omts.dao.IMovieTheatreDao;
import com.cg.omts.dao.MovieTheatreDaoImpl;
import com.cg.omts.dto.Movie;
import com.cg.omts.dto.Theatre;
import com.cg.omts.exceptions.OMTSException;

public class MovieTheatreServiceImpl implements IMovieTheatreService {
	IMovieTheatreDao movieTheatreDao = null;

	@Override
	public boolean addMovie(Movie movie) throws OMTSException {
		movieTheatreDao = new MovieTheatreDaoImpl();
		Boolean isAdded = movieTheatreDao.addMovie(movie);
		return isAdded;
	}

	@Override
	public ArrayList<Movie> getMovieDetailsToDelete() throws OMTSException {
		movieTheatreDao = new MovieTheatreDaoImpl();
		ArrayList<Movie> movieList = movieTheatreDao.getMovieDetailsToDelete();
		return movieList;
	}

	@Override
	public ArrayList<Theatre> getTheatreDetails(String theatreCity) throws OMTSException {
		movieTheatreDao = new MovieTheatreDaoImpl();
		ArrayList<Theatre> getTheatreDetails = movieTheatreDao.getTheatreDetails(theatreCity);
		return getTheatreDetails;
	}

	@Override
	public int deleteMovie(Integer movieId) throws OMTSException {
		movieTheatreDao = new MovieTheatreDaoImpl();
		int rowsAffected = movieTheatreDao.deleteMovie(movieId);
		return rowsAffected;
	}

	@Override
	public boolean addMovieToTheatre(int movieId, int theatreId) throws OMTSException {
		movieTheatreDao = new MovieTheatreDaoImpl();
		boolean isAdded = movieTheatreDao.addMovieToTheatre(movieId, theatreId);
		return isAdded;
	}

	@Override
	public ArrayList<Movie> getMovieIdName() throws OMTSException {
		movieTheatreDao = new MovieTheatreDaoImpl();
		ArrayList<Movie> movieList = movieTheatreDao.getMovieIdName();
		return movieList;
	}

	@Override
	public boolean isMovieIdExists(int movieId) throws OMTSException {
		movieTheatreDao = new MovieTheatreDaoImpl();
		boolean isExists = movieTheatreDao.isMovieIdExists(movieId);
		return isExists;
	}

	@Override
	public boolean isTheatreIdExists(int theatreId) throws OMTSException {
		movieTheatreDao = new MovieTheatreDaoImpl();
		boolean isExists = movieTheatreDao.isTheatreIdExists(theatreId);
		return isExists;
	}

	@Override
	public boolean checkTheatreIdInCity(int theatreId, String theatreCity) throws OMTSException {
		movieTheatreDao = new MovieTheatreDaoImpl();
		boolean isCorrect = movieTheatreDao.checkTheatreIdInCity(theatreId, theatreCity);
		return isCorrect;
	}

	@Override
	public boolean checkIdTheatreMovieAlreadyExists(int theatreId, int movieId) throws OMTSException {
		movieTheatreDao = new MovieTheatreDaoImpl();
		boolean isExists = movieTheatreDao.checkIdTheatreMovieAlreadyExists(theatreId, movieId);
		return isExists;
	}

	@Override
	public List<Integer> getTheatresByCity(String city) throws OMTSException {
		movieTheatreDao = new MovieTheatreDaoImpl();
		List<Integer> theatreIdList = movieTheatreDao.getTheatresByCity(city);
		return theatreIdList;
	}

	@Override
	public List<Theatre> getTheatres(List<Integer> theatreIdList) throws OMTSException {
		movieTheatreDao = new MovieTheatreDaoImpl();
		List<Theatre> theatresList = movieTheatreDao.getTheatres(theatreIdList);
		return theatresList;
	}

	@Override
	public List<String> getTheatreNames(List<Integer> theatreIdList) throws OMTSException {
		movieTheatreDao = new MovieTheatreDaoImpl();
		List<String> theatreNamesList = movieTheatreDao.getTheatreNames(theatreIdList);
		return theatreNamesList;
	}

	@Override
	public List<Integer> getTheatresByMovie(int movieId) throws OMTSException {
		movieTheatreDao = new MovieTheatreDaoImpl();
		List<Integer> theatreIdList = movieTheatreDao.getTheatresByMovie(movieId);
		return theatreIdList;
	}

	@Override
	public String getTheatreNames(int theatreId) throws OMTSException {
		movieTheatreDao = new MovieTheatreDaoImpl();
		String theatreName = movieTheatreDao.getTheatreNames(theatreId);
		return theatreName;
	}

	@Override
	public List<Integer> getMoviesByTheatre(List<Integer> theatreIdList) throws OMTSException {
		movieTheatreDao = new MovieTheatreDaoImpl();
		List<Integer> movieIdList = movieTheatreDao.getMoviesByTheatre(theatreIdList);
		return movieIdList;
	}

	@Override
	public List<Movie> getMoviesById(List<Integer> movieIdList) throws OMTSException {
		movieTheatreDao = new MovieTheatreDaoImpl();
		List<Movie> movieList = movieTheatreDao.getMoviesById(movieIdList);
		return movieList;
	}

	@Override
	public List<Movie> getAllMovies() throws OMTSException {
		movieTheatreDao = new MovieTheatreDaoImpl();
		List<Movie> movieList = movieTheatreDao.getAllMovies();
		return movieList;
	}

	@Override
	public Movie getMovieDetails(int movieId) throws OMTSException {
		movieTheatreDao = new MovieTheatreDaoImpl();
		Movie movie = movieTheatreDao.getMovieDetails(movieId);
		return movie;
	}

	@Override
	public List<Theatre> getTheatreDetails() throws OMTSException {
		movieTheatreDao = new MovieTheatreDaoImpl();
		List<Theatre> theatreList = movieTheatreDao.getTheatreDetails();
		return theatreList;
	}

	@Override
	public int addTheatre(Theatre theatre) throws OMTSException {
		movieTheatreDao = new MovieTheatreDaoImpl();
		return movieTheatreDao.addTheatre(theatre);
	}

	@Override
	public int deleteTheatre(int theatreId) throws OMTSException {
		movieTheatreDao = new MovieTheatreDaoImpl();
		return movieTheatreDao.deleteTheatre(theatreId);

	}

	@Override
	public List<Theatre> getTheatreByName(String theatreName) throws OMTSException {
		movieTheatreDao = new MovieTheatreDaoImpl();
		return movieTheatreDao.getTheatreByName(theatreName);
	}

	@Override
	public int getMovieLength(int movieId) throws OMTSException {
		movieTheatreDao = new MovieTheatreDaoImpl();
		return movieTheatreDao.getMovieLength(movieId);
	}

	@Override
	public String getMovieNameById(int movieId) throws OMTSException {
		movieTheatreDao = new MovieTheatreDaoImpl();
		return movieTheatreDao.getMovieNameById(movieId);
	}

}