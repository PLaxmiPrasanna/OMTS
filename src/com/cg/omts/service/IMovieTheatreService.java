package com.cg.omts.service;

import java.util.ArrayList;
import java.util.List;

import com.cg.omts.dto.Movie;
import com.cg.omts.dto.Theatre;
import com.cg.omts.exceptions.OMTSException;

public interface IMovieTheatreService {
	
	/****
	 * @description Method to add the movie details to the given theatreID
	 * @author Jayanthi Shalmala
	 * 
	 * @param movie 
	 * @param theatreId
	 * @return boolean value
	 * @throws OMTSException
	 */
	
	public  boolean addMovie(Movie movie) throws OMTSException;
	
	/*****
	 * @description Method to get the movie details
	 * @author Jayanthi Shalmala
	 * 
	 * @return ArrayList<Movie>
	 * @throws OMTSException
	 */
	
	public  ArrayList<Movie> getMovieDetailsToDelete() throws OMTSException;
	
	
	/*****
	 * @description Method to delete the movie with the given movieId
	 * @author Jayanthi Shalmala
	 * 
	 * @param movieId
	 * @return int
	 * @throws OMTSException
	 */
	public  int deleteMovie(Integer movieId) throws OMTSException;
	
	
	/*****
	 * @description Method to get the theatre details that belong to the given city
	 * @author Jayanthi Shalmala
	 * 
	 * @param theatreCity
	 * @return ArrayList<Theatre>
	 * @throws OMTSException
	 */
	public  ArrayList<Theatre> getTheatreDetails(String theatreCity) throws OMTSException;

	
	/*****
	 * @description Method to add movie to the theatre
	 * @author Jayanthi Shalmala
	 * @param movieId
	 * @param theatreId
	 * @return boolean value
	 * @throws OMTSException
	 */
	public boolean addMovieToTheatre(int movieId, int theatreId) throws OMTSException;
	
	/*****
	 * @description Method to get the movie ID and movie Name
	 * @author Jayanthi Shalmala
	 * @return ArrayList<Movie>
	 * @throws OMTSException
	 */
	public ArrayList<Movie> getMovieIdName() throws OMTSException;
	
	/*****
	 * @description Method to check whether the movie with given ID exists or not
	 * @author Jayanthi Shalmala
	 * @param movieId
	 * @return boolean value
	 * @throws OMTSException
	 */
	public boolean isMovieIdExists(int movieId) throws OMTSException;
	
	/*****
	 * @description Method to check whether the screen with given ID exists or not
	 * @author Jayanthi Shalmala
	 * @param screenId
	 * @return boolean value
	 * @throws OMTSException
	 */
	
	public boolean isTheatreIdExists(int theatreId) throws OMTSException;
	
	/*****
	 * @description Method to check whether the given theatre ID is in the given city or not
	 * @author Jayanthi Shalmala
	 * @param theatreId
	 * @param theatreCity
	 * @return boolean value
	 * @throws OMTSException
	 */
	public boolean checkTheatreIdInCity(int theatreId, String theatreCity) throws OMTSException;
	
	/*****
	 * @description Method to check whether the given movie ID and theatre ID already exists or not
	 * @author Jayanthi Shalmala
	 * @param theatreId
	 * @param movieId
	 * @return boolean value
	 * @throws OMTSException
	 */
	public boolean checkIdTheatreMovieAlreadyExists(int theatreId, int movieId) throws OMTSException;
	
	/*****
	 * @description Method to add screen seat price
	 * @author Jayanthi Shalmala
	 * @param screenId
	 * @param seatPrice
	 * @return boolean value
	 * @throws OMTSException
	 */
	
	/*****
	 * @description Method to get TheatreId by city
	 * @author Supriya M
	 * @param city
	 * @return List<Integer>
	 * @throws OMTSException
	 */
	public List<Integer> getTheatresByCity(String city) throws OMTSException;
	
	/*****
	 * @description Method to return theatre details by theatreID
	 * @author Supriya M
	 * @param theatreIdList
	 * @return List<Theatre>
	 * @throws OMTSException
	 */
	public List<Theatre> getTheatres(List<Integer> theatreIdList) throws OMTSException;
	
	/*****
	 * @description Method to get theatre names by theatreId list
	 * @author Supriya M
	 * @param theatreIdList
	 * @return List<String>
	 * @throws OMTSException
	 */
	public List<String> getTheatreNames(List<Integer> theatreIdList) throws OMTSException;
	
	/*****
	 * @description Method to get theatreId by movieId
	 * @author Supriya M
	 * @param movieId
	 * @return List<Integer>
	 * @throws OMTSException
	 */
	public List<Integer> getTheatresByMovie(int movieId) throws OMTSException;
	
	/*****
	 * @description Method to return theatreNames by theatreId
	 * @author Supriya M
	 * @param theatreId
	 * @return String
	 * @throws OMTSException
	 */
	public String getTheatreNames(int theatreId) throws OMTSException;
	
	/*****
	 * @description Method to return movieId by theatreId List
	 * @author Supriya M
	 * @param theatreIdList
	 * @return List<Integer>
	 * @throws OMTSException
	 */
	public List<Integer> getMoviesByTheatre(List<Integer> theatreIdList) throws OMTSException;
	
	/*****
	 * @description Method to return movie details by movieIdList
	 * @author Supriya M
	 * @param movieIdList
	 * @return List<Movie>
	 * @throws OMTSException
	 */
	public List<Movie> getMoviesById(List<Integer> movieIdList) throws OMTSException;
	
	/*****
	 * @description Method to get all movie details
	 * @author Supriya M
	 * @return List<Movie>
	 * @throws OMTSException
	 */
	public List<Movie> getAllMovies() throws OMTSException;
	
	/*****
	 * @description Method to get movie details by movieId
	 * @author Supriya M
	 * @param movieId
	 * @return Movie
	 * @throws OMTSException
	 */
	public Movie getMovieDetails(int movieId) throws OMTSException;
	/***********
	 @Description : This methods returns all Theatres available
	 @author :  supraja
	 @return : List of Theatre type
	 @Exception: throws OMTSException
	***********/
	public List<Theatre> getTheatreDetails() throws OMTSException;
	
	/**********
	@Description: To add the newly registered Theatre
	@author : supraja
	@param1  : Theatre object
	@return : Number of theatres added
	@Exception : throws OMTSException
	*******/
	
	public  int addTheatre(Theatre theatre) throws OMTSException;

	/*******
	 @Description: To delete specified Theatre
	 @author : supraja
	 @param : Theatre Id
	 @return : No of theatres deleted
	 @Exception : throws OMTSException
	********/
	public int deleteTheatre(int id) throws OMTSException;

	/*********
	 @Description : To get the list of theatres by specified theatre name 
	 @author : supraja
	 @param : theatre name
	 @return : List of theatre of specified name 
	  @Exception : throws OMTSException
	*********/
	
	public List<Theatre> getTheatreByName(String theatreName) throws OMTSException;
	
	/**@Description : To get the movie length of requested movie
	 * @author  : supraja
	 * @param movieId
	 * @return
	 * @throws OMTSException
	 */
	public int getMovieLength(int movieId) throws OMTSException;
	/***
	 * @Description : To get movie name from movie 
	 * @author  : supraja
	 * @param movieId
	 * @return
	 * @throws OMTSException
	 */
	public String getMovieNameById(int movieId) throws OMTSException;

	
}