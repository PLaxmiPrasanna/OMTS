package com.cg.omts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cg.omts.dto.Movie;
import com.cg.omts.dto.Theatre;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.queryconstants.IMovieTheatreQueryConstants;
import com.cg.omts.utility.DBConnection;

public class MovieTheatreDaoImpl implements IMovieTheatreDao, IMovieTheatreQueryConstants {

	static Connection connection = null;
	static Statement statement = null;
	static PreparedStatement prepareStatement = null;
	static ResultSet resultSet = null;

	@Override
	public boolean addMovie(Movie movie) throws OMTSException {
		connection = DBConnection.getConnection();
		int rows = 0;
		try {
			prepareStatement = connection.prepareStatement(ADD_MOVIE);
			prepareStatement.setInt(1, movie.getMovieId());
			prepareStatement.setString(2, movie.getMovieName());
			prepareStatement.setString(3, movie.getMovieGenre());
			prepareStatement.setString(4, movie.getMovieDirector());
			prepareStatement.setInt(5, movie.getMovieLength());
			prepareStatement.setString(6, movie.getLanguage());
			prepareStatement.setDate(7, movie.getMovieReleaseDate());
			// statement.setBlob(8, inputStream);

			rows = prepareStatement.executeUpdate();

			if (rows > 0)
				return true;

		} catch (SQLException e) {
			throw new OMTSException("Failed to add movie details!! " + e);

		} finally {
			try {
				connection.close();
				prepareStatement.close();
			} catch (SQLException e) {
				throw new OMTSException("Failed to close the database connection" + e);
			}
		}
		return false;
	}

	@Override
	public boolean addMovieToTheatre(int movieId, int theatreId) throws OMTSException {
		connection = DBConnection.getConnection();
		int rowsInserted = 0;
		try {
			prepareStatement = connection.prepareStatement(ADD_MOVIE_TO_THEATRE);
			prepareStatement.setInt(1, movieId);
			prepareStatement.setInt(2, theatreId);
			rowsInserted = prepareStatement.executeUpdate();
			if (rowsInserted > 0)
				return true;
		} catch (SQLException e) {
			throw new OMTSException("Failed to add movie details!! " + e);
		} finally {
			try {
				prepareStatement.close();
				connection.close();
			} catch (SQLException e) {
				throw new OMTSException("Failed to close the database connection" + e);
			}
		}
		return false;

	}

	@Override
	public int deleteMovie(Integer movieId) throws OMTSException {
		connection = DBConnection.getConnection();
		int rows = 0;
		try {
			prepareStatement = connection.prepareStatement(DELETE_MOVIE);
			prepareStatement.setInt(1, movieId);
			rows = prepareStatement.executeUpdate();
			return rows;
		} catch (SQLException e) {

			throw new OMTSException("Failed to delete the movie with Id: " + movieId);

		} finally {
			try {
				connection.close();
				prepareStatement.close();
			} catch (SQLException e) {
				throw new OMTSException("Failed to close the database connection" + e);
			}
		}
	}

	@Override
	public ArrayList<Movie> getMovieDetailsToDelete() throws OMTSException {
		connection = DBConnection.getConnection();
		Movie movie = null;
		ArrayList<Movie> movieList = null;
		try {
			prepareStatement = connection.prepareStatement(DISPLAY_ALL_MOVIES_DELETE);
			prepareStatement.executeQuery();
			resultSet = prepareStatement.getResultSet();
			movieList = new ArrayList<Movie>();

			while (resultSet.next()) {
				movie = new Movie();
				movie.setMovieId(resultSet.getInt(1));
				movie.setMovieName(resultSet.getString(2));
				movie.setMovieGenre(resultSet.getString(3));
				movie.setMovieDirector(resultSet.getString(4));
				movie.setLanguage(resultSet.getString(5));
				movieList.add(movie);
			}

			return movieList;
		} catch (SQLException e) {

			throw new OMTSException("Failed to get the movie details" + e);

		} finally {
			try {
				connection.close();
				prepareStatement.close();
			} catch (SQLException e) {

				throw new OMTSException("Failed to close the database connection" + e);

			}
		}

	}

	@Override
	public ArrayList<Theatre> getTheatreDetails(String theatreCity) throws OMTSException {
		connection = DBConnection.getConnection();

		ArrayList<Theatre> theatreDetails = null;
		Theatre theatre = null;
		try {
			prepareStatement = connection.prepareStatement(GET_THEATRE_DETAILS);
			prepareStatement.setString(1, theatreCity);
			prepareStatement.executeQuery();
			resultSet = prepareStatement.getResultSet();

			theatreDetails = new ArrayList<Theatre>();

			while (resultSet.next()) {
				theatre = new Theatre();
				theatre.setTheatreId(resultSet.getInt(1));
				theatre.setTheatreName(resultSet.getString(2));
				theatreDetails.add(theatre);
			}

			return theatreDetails;

		} catch (SQLException e) {

			throw new OMTSException("Failed to get the theatre details");

		} finally {
			try {
				connection.close();
				prepareStatement.close();
			} catch (SQLException e) {
				throw new OMTSException("Failed to close the database connection" + e);
			}
		}
	}

	@Override
	public ArrayList<Movie> getMovieIdName() throws OMTSException {
		connection = DBConnection.getConnection();
		ArrayList<Movie> movieList = null;

		try {
			prepareStatement = connection.prepareStatement(GET_MOVIE_NAME_ID);
			prepareStatement.executeQuery();
			resultSet = prepareStatement.getResultSet();
			Movie movie = null;
			movieList = new ArrayList<Movie>();
			while (resultSet.next()) {
				movie = new Movie();
				movie.setMovieId(resultSet.getInt(1));
				movie.setMovieName(resultSet.getString(2));
				movieList.add(movie);
			}
		} catch (SQLException e) {
			throw new OMTSException("Failed to get the movie ID and Name " + e);
		} finally {
			try {
				connection.close();
				prepareStatement.close();
			} catch (SQLException e) {
				throw new OMTSException("Failed to close the database connection" + e);
			}
		}
		return movieList;
	}

	@Override
	public boolean isMovieIdExists(int movieId) throws OMTSException {
		connection = DBConnection.getConnection();
		try {
			prepareStatement = connection.prepareStatement(VALIDATE_MOVIE_ID);
			prepareStatement.setInt(1, movieId);
			prepareStatement.executeQuery();
			resultSet = prepareStatement.getResultSet();
			if (resultSet.next()) {
				return true;
			}
		} catch (SQLException e) {
			throw new OMTSException("Failed to check whether the given movie ID exists or not " + e);
		} finally {
			try {
				connection.close();
				prepareStatement.close();
			} catch (SQLException e) {
				throw new OMTSException("Failed to close the database connection" + e);
			}
		}
		return false;
	}

	@Override
	public boolean isTheatreIdExists(int theatreId) throws OMTSException {
		connection = DBConnection.getConnection();
		try {
			prepareStatement = connection.prepareStatement(VALIDATE_THEATRE_ID);
			prepareStatement.setInt(1, theatreId);
			prepareStatement.executeQuery();
			resultSet = prepareStatement.getResultSet();
			if (resultSet.next())
				return true;
		} catch (SQLException e) {

			throw new OMTSException("Failed to check whether the given theatre ID exists or not " + e);
		} finally {
			try {
				connection.close();
				prepareStatement.close();
			} catch (SQLException e) {
				throw new OMTSException("Failed to close the database connection" + e);
			}
		}

		return false;
	}

	@Override
	public boolean checkTheatreIdInCity(int theatreId, String theatreCity) throws OMTSException {
		connection = DBConnection.getConnection();
		try {
			prepareStatement = connection.prepareStatement(CHECK_ID_IN_CITY);
			prepareStatement.setString(1, theatreCity);
			prepareStatement.setInt(2, theatreId);
			prepareStatement.executeQuery();
			resultSet = prepareStatement.getResultSet();
			if (resultSet.next()) {
				if (resultSet.getInt(1) == theatreId)
					return true;
			}
		} catch (SQLException e) {
			throw new OMTSException("Failed to check whether the given theatre ID is present in the given city " + e);
		} finally {
			try {
				connection.close();
				prepareStatement.close();
			} catch (SQLException e) {
				throw new OMTSException("Failed to close the database connection" + e);
			}
		}
		return false;
	}

	@Override
	public boolean checkIdTheatreMovieAlreadyExists(int theatreId, int movieId) throws OMTSException {
		connection = DBConnection.getConnection();
		try {
			prepareStatement = connection.prepareStatement(THEATRE_MOVIE_ID_ALREADY_EXISTS);
			prepareStatement.setInt(1, theatreId);
			prepareStatement.setInt(2, movieId);
			prepareStatement.executeQuery();
			resultSet = prepareStatement.getResultSet();

			if (resultSet.next()) {
				if (resultSet.getInt(1) == movieId)
					return true;
			}
		} catch (SQLException e) {
			throw new OMTSException("Failed to check whether given Theatre ID and movie ID exists " + e);
		} finally {
			try {
				connection.close();
				prepareStatement.close();
			} catch (SQLException e) {
				throw new OMTSException("Failed to close the database connection" + e);
			}
		}
		return false;
	}

	@Override
	public List<Theatre> getTheatreDetails() throws OMTSException {
		// TODO Auto-generated method stub
		List<Theatre> theatreList = new ArrayList<Theatre>();
		try {
			connection = DBConnection.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(GET_THEATRE_DETAILS_DISPLAY);

			while (resultSet.next()) {
				Theatre theatre = new Theatre();
				theatre.setTheatreId(resultSet.getInt(1));
				theatre.setTheatreName(resultSet.getString(2));
				theatre.setTheatreCity(resultSet.getString(3));
				theatre.setManagerName(resultSet.getString(4));
				theatre.setManagerContact(resultSet.getString(5));
				theatreList.add(theatre);
			}
		} catch (SQLException e) {
			throw new OMTSException("problem while displaying Theatre Data from Database");
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new OMTSException("problem while closing Database");
			}
		}

		return theatreList;
	}

	@Override
	public int addTheatre(Theatre theatre) throws OMTSException {
		// TODO Auto-generated method stub
		int isInserted = 0;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(ADD_THEATRE);
			prepareStatement.setInt(1, theatre.getTheatreId());
			prepareStatement.setString(2, theatre.getTheatreName());
			prepareStatement.setString(3, theatre.getTheatreCity());
			prepareStatement.setString(4, theatre.getManagerName());
			prepareStatement.setString(5, theatre.getManagerContact());
			isInserted = prepareStatement.executeUpdate();
		} catch (SQLException e) {
			throw new OMTSException("problem inserting Theatre Details into Database");
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new OMTSException("problem while closing Database");
			}
		}
		return isInserted;
	}

	@Override
	public int deleteTheatre(int theatreId) throws OMTSException {
		int isDeleted = 0;
		try {
			// TODO Auto-generated method stub
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(DELETE_THEATRE);
			prepareStatement.setInt(1, theatreId);
			isDeleted = prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// System.out.println(e);
			throw new OMTSException("problem while deleting Theatre Details from Database");
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new OMTSException("problem while closing Database");
			}
		}
		return isDeleted;
	}

	@Override
	public List<Theatre> getTheatreByName(String theatreName) throws OMTSException {
		// TODO Auto-generated method stub
		List<Theatre> theatreList = new ArrayList<Theatre>();
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(GET_THEATRE_BY_NAME);
			prepareStatement.setString(1, theatreName);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Theatre theatre = new Theatre();
				theatre.setTheatreId(resultSet.getInt(1));
				theatre.setTheatreName(resultSet.getString(2));
				theatre.setTheatreCity(resultSet.getString(3));
				theatre.setManagerName(resultSet.getString(4));
				theatre.setManagerContact(resultSet.getString(5));
				theatreList.add(theatre);
			}
		} catch (SQLException e) {
			throw new OMTSException("problem while displaying Theatre Data from Database");
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new OMTSException("problem while closing Database");
			}
		}

		return theatreList;
	}

	@Override
	public int getMovieLength(int movieId) throws OMTSException {
		// TODO Auto-generated method stub
		connection = DBConnection.getConnection();
		int movieLength = 0;
		try {
			prepareStatement = connection.prepareStatement(GET_MOVIELENGTH);
			prepareStatement.setInt(1, movieId);
			ResultSet resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				movieLength = resultSet.getInt(1);
				// System.out.println(rs.getInt(1)+" "+rs.getTime(2)+" "+rs.getTime(3)+"
				// "+rs.getString(4));
			}
		} catch (SQLException e) {
			System.out.println("Failed to retrieve movie length from movie " + movieId);
		} finally {
			try {
				connection.close();
				prepareStatement.close();
			} catch (SQLException e) {
				System.out.println("Failed to close the database connection" + e);
			}
		}
		return movieLength;
	}

	@Override
	public String getMovieNameById(int movieId) throws OMTSException {
		// TODO Auto-generated method stub
		String movieName = "";
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(GET_MOVIENAME_FROM_MOVIE);
			prepareStatement.setInt(1, movieId);
			ResultSet resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				movieName = resultSet.getString(1);
			}
		} catch (SQLException e) {
			System.out.println("Failed to retrieve screen Id  from movie and theatre");
		} finally {
			try {
				connection.close();
				prepareStatement.close();
			} catch (SQLException e) {
				System.out.println("Failed to close the database connection" + e);
			}
		}

		return movieName;
	}

	@Override
	public Movie getMovieDetails(int movieId) throws OMTSException {
		// TODO Auto-generated method stub
		Movie movie = null;
		Boolean isFound = false;
		try {
			connection = DBConnection.getConnection();

			prepareStatement = connection.prepareStatement(GET_MOVIE_DETAILS);
			prepareStatement.setInt(1, movieId);
			resultSet = prepareStatement.executeQuery();
			isFound = resultSet.next();
			if (isFound == true) {
				movie = new Movie();
				movie.setMovieId(resultSet.getInt(1));
				movie.setMovieName(resultSet.getString(2));
				movie.setMovieGenre(resultSet.getString(3));
				movie.setMovieDirector(resultSet.getString(4));
				movie.setMovieLength(resultSet.getInt(5));
				movie.setLanguage(resultSet.getString(6));
				movie.setMovieReleaseDate(resultSet.getDate(7));
			}
		} catch (SQLException e) {
			throw new OMTSException("problem while creating PS object");
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new OMTSException("problem while closing");
			}

		}
		return movie;
	}

	@Override
	public List<Movie> getAllMovies() throws OMTSException {
		List<Movie> movieList = new ArrayList<Movie>();
		Movie movie = null;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(GET_ALL_MOVIES);
			resultSet = prepareStatement.executeQuery();

			while (resultSet.next()) {
				movie = new Movie();
				movie.setMovieId(resultSet.getInt(1));
				movie.setMovieName(resultSet.getString(2));
				movie.setMovieGenre(resultSet.getString(3));
				movie.setMovieDirector(resultSet.getString(4));
				movie.setMovieLength(resultSet.getInt(5));
				movie.setLanguage(resultSet.getString(6));
				movie.setMovieReleaseDate(resultSet.getDate(7));
				movieList.add(movie);

			}
		} catch (SQLException e) {
			throw new OMTSException("problem occured while creating PS object" + e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new OMTSException("problem occured while closing connection");
			}
		}
		return movieList;
	}

	@Override
	public List<Movie> getMoviesById(List<Integer> movieIdList) throws OMTSException {
		List<Movie> movieList = new ArrayList<>();
		Movie movie = null;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(GET_MOVIES_BY_ID);
			for (Integer movieId : movieIdList) {
				prepareStatement.setInt(1, movieId);
				resultSet = prepareStatement.executeQuery();
				while (resultSet.next()) {
					movie = new Movie();
					movie.setMovieId(resultSet.getInt(1));
					movie.setMovieName(resultSet.getString(2));
					movie.setMovieGenre(resultSet.getString(3));
					movie.setMovieDirector(resultSet.getString(4));
					movie.setMovieLength(resultSet.getInt(5));
					movie.setLanguage(resultSet.getString(6));
					movie.setMovieReleaseDate(resultSet.getDate(7));
					movieList.add(movie);
				}
			}
		} catch (SQLException e) {
			throw new OMTSException("Problem occured while creating PS objetc");
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new OMTSException("Problem occured while closing connection");
			}
		}

		return movieList;
	}

	@Override
	public List<Integer> getMoviesByTheatre(List<Integer> theatreIdList) throws OMTSException {
		List<Integer> movieIdList = new ArrayList<>();
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(GET_MOVIES_BY_THEATRE_ID);
			for (Integer theatreId : theatreIdList) {
				prepareStatement.setInt(1, theatreId);
				resultSet = prepareStatement.executeQuery();
				while (resultSet.next()) {
					movieIdList.add(resultSet.getInt(1));
				}
			}
		} catch (SQLException e) {
			throw new OMTSException("Problem occured while creating PS objetc");
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new OMTSException("Problem occured while closing connection");
			}
		}

		return movieIdList;
	}

	@Override
	public String getTheatreNames(int theatreId) throws OMTSException {
		// TODO Auto-generated method stub
		String theatreName = null;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(GET_THEATRE_NAME);
			prepareStatement.setInt(1, theatreId);
			resultSet = prepareStatement.executeQuery();
			if (resultSet.next()) {
				theatreName = resultSet.getString(1);
			}

		} catch (SQLException e) {
			throw new OMTSException("problem occured while creating PS object");
		} finally {
			try {

				connection.close();
			} catch (SQLException e) {
				throw new OMTSException("problem occured while closing connection");
			}
		}

		return theatreName;
	}

	@Override
	public List<Integer> getTheatresByMovie(int movieId) throws OMTSException {
		List<Integer> theatreIdList = new ArrayList<Integer>();
		try {

			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(GET_THEATRES_BY_MOVIE);
			prepareStatement.setInt(1, movieId);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				theatreIdList.add(resultSet.getInt(1));
			}
		} catch (SQLException e) {
			throw new OMTSException("problem while creating PS object" + e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new OMTSException("problem while closing");
			}
		}

		return theatreIdList;
	}

	@Override
	public List<String> getTheatreNames(List<Integer> theatreIdList) throws OMTSException {
		List<String> theatreNamesList = new ArrayList<String>();
		try {

			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(GET_THEATRE_NAME_BY_ID);

			for (Integer theatreId : theatreIdList) {
				prepareStatement.setInt(1, theatreId);
				resultSet = prepareStatement.executeQuery();
				while (resultSet.next()) {
					theatreNamesList.add(resultSet.getString(1));
				}
			}
		} catch (SQLException e) {
			throw new OMTSException("problem while creating PS object");
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new OMTSException("problem while closing");
			}
		}
		return theatreNamesList;
	}

	@Override
	public List<Theatre> getTheatres(List<Integer> theatreIdList) throws OMTSException {
		// TODO Auto-generated method stub
		List<Theatre> theatresList = new ArrayList<Theatre>();
		Theatre theatre = null;
		try {

			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(GET_THEATRE_BY_ID);

			for (Integer theatreId : theatreIdList) {
				prepareStatement.setInt(1, theatreId);
				resultSet = prepareStatement.executeQuery();
				while (resultSet.next()) {
					theatre = new Theatre();
					theatre.setTheatreId(resultSet.getInt(1));
					theatre.setTheatreName(resultSet.getString(2));
					theatre.setTheatreCity(resultSet.getString(3));
					theatre.setManagerName(resultSet.getString(4));
					theatre.setManagerContact(resultSet.getString(5));
					theatresList.add(theatre);
				}
			}
		} catch (SQLException e) {
			throw new OMTSException("problem while creating PS object" + e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new OMTSException("problem while closing");
			}
		}
		return theatresList;
	}

	@Override
	public List<Integer> getTheatresByCity(String city) throws OMTSException {
		List<Integer> theatreIdList = new ArrayList<Integer>();

		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(GET_THEATREID);
			prepareStatement.setString(1, city);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				theatreIdList.add(resultSet.getInt(1));
			}
		} catch (SQLException e) {
			throw new OMTSException("problem occured while creating PS object");
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new OMTSException("problem occured while closing connection");
			}
		}
		return theatreIdList;
	}

}