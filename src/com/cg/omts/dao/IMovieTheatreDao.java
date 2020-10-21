package com.cg.omts.dao;

import java.util.ArrayList;
import java.util.List;

import com.cg.omts.dto.Movie;
import com.cg.omts.dto.Theatre;
import com.cg.omts.exceptions.OMTSException;

public interface IMovieTheatreDao {

public boolean addMovie(Movie movie) throws OMTSException;
	
	public ArrayList<Movie> getMovieIdName() throws OMTSException;
	
	public  ArrayList<Movie> getMovieDetailsToDelete() throws OMTSException;
	
	public  int deleteMovie(Integer movieId) throws OMTSException;
	
	public boolean isMovieIdExists(int movieId) throws OMTSException;
	
	public Movie getMovieDetails(int movieId) throws OMTSException;
	
	public List<Movie> getAllMovies() throws OMTSException;
	
	List<Movie> getMoviesById(List<Integer> movieIdList) throws OMTSException;
	
	List<Integer> getMoviesByTheatre(List<Integer> theatreIdList) throws OMTSException;
	
	public String getTheatreNames(int theatreId) throws OMTSException;
	
	public List<Integer> getTheatresByMovie(int movieId) throws OMTSException;
	
	public List<String> getTheatreNames(List<Integer> theatreIdList) throws OMTSException;
	
	public List<Theatre> getTheatres(List<Integer> theatreIdList) throws OMTSException;
	
	public List<Integer> getTheatresByCity(String city) throws OMTSException;
	
	public List<Theatre> getTheatreDetails() throws OMTSException;
	
	public  int addTheatre(Theatre theatre) throws OMTSException;

	public int deleteTheatre(int theatreId) throws OMTSException;
	
	public List<Theatre> getTheatreByName(String theatreName) throws OMTSException;
	
	public int getMovieLength(int movieId) throws OMTSException;
	
	public String getMovieNameById(int movieId) throws OMTSException;
	
	public boolean addMovieToTheatre(int movieId, int theatreId) throws OMTSException;
	
	public  ArrayList<Theatre> getTheatreDetails(String theatreCity) throws OMTSException;
	
	public boolean isTheatreIdExists(int theatreId) throws OMTSException;
	
	public boolean checkTheatreIdInCity(int theatreId, String theatreCity) throws OMTSException;
	
	public boolean checkIdTheatreMovieAlreadyExists(int theatreId, int movieId) throws OMTSException;
}
