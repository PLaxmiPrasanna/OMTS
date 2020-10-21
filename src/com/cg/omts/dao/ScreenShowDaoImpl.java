package com.cg.omts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cg.omts.dto.Screen;
import com.cg.omts.dto.Show;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.queryconstants.IScreenShowQueryConstants;
import com.cg.omts.utility.DBConnection;

public class ScreenShowDaoImpl implements IScreenShowDao, IScreenShowQueryConstants {
	static Connection connection = null;
	static Statement statement = null;
	static PreparedStatement prepareStatement = null;
	static ResultSet resultSet = null;

	@Override
	public Boolean addScreen(Screen screen, Integer theatreId) throws OMTSException {
		connection = DBConnection.getConnection();
		int rows = 0;
		try {
			prepareStatement = connection.prepareStatement(ADD_SCREEN);
			prepareStatement.setInt(1, screen.getScreenId());
			prepareStatement.setInt(2, theatreId);
			prepareStatement.setString(3, screen.getScreenName());
			prepareStatement.setInt(4, screen.getRows());
			prepareStatement.setInt(5, screen.getColumns());
			rows = prepareStatement.executeUpdate();
			if (rows > 0) {
				return true;
			}

		} catch (SQLException e) {

			throw new OMTSException("Failed to add the screen\n" + e);
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
	public Boolean deleteScreen(Integer screenId) throws OMTSException {
		connection = DBConnection.getConnection();
		int rows = 0;
		try {
			prepareStatement = connection.prepareStatement(DELETE_SCREEN);
			prepareStatement.setInt(1, screenId);
			rows = prepareStatement.executeUpdate();
			if (rows > 0)
				return true;
		} catch (SQLException e) {

			throw new OMTSException("Failed to delete the screen with Id: " + screenId);
		} finally {
			try {
				connection.close();
				prepareStatement.close();
			} catch (SQLException e) {

				throw new OMTSException("Failed to get the screen details" + e);
			}
		}
		return false;
	}

	@Override
	public ArrayList<Screen> getScreenDetailsToDelete() throws OMTSException {
		connection = DBConnection.getConnection();
		Screen screen = null;
		ArrayList<Screen> screenList = null;
		try {
			prepareStatement = connection.prepareStatement(DISPLAY_ALL_SCREEN_DELETE);
			prepareStatement.executeQuery();
			resultSet = prepareStatement.getResultSet();
			screenList = new ArrayList<Screen>();

			while (resultSet.next()) {
				screen = new Screen();
				screen.setScreenId(resultSet.getInt(1));
				screen.setScreenName(resultSet.getString(2));
				screen.setTheatreId(resultSet.getInt(3));
				screen.setTheatreName(resultSet.getString(4));
				screen.setTheatreCity(resultSet.getString(5));
				screenList.add(screen);
			}

			return screenList;
		} catch (SQLException e) {

			throw new OMTSException("Failed to get the screen details" + e);
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
	public boolean isScreenIdExists(int screenId) throws OMTSException {
		connection = DBConnection.getConnection();
		try {
			prepareStatement = connection.prepareStatement(VALIDATE_SCREEN_ID);
			prepareStatement.setInt(1, screenId);
			prepareStatement.executeQuery();
			resultSet = prepareStatement.getResultSet();
			if (resultSet.next())
				return true;
		} catch (SQLException e) {
			throw new OMTSException("Failed to check whether the given screen ID exists or not " + e);
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
	public boolean addScreenSeatPrice(int screenId, int seatPrice) throws OMTSException {
		connection = DBConnection.getConnection();
		System.out.println("Screen id and seat Price in dao are: " + screenId + " " + seatPrice);
		int rows = 0;
		try {
			prepareStatement = connection.prepareStatement(ADD_SCREEN_SEAT_PRICE);
			prepareStatement.setInt(1, screenId);
			prepareStatement.setInt(2, seatPrice);
			rows = prepareStatement.executeUpdate();
			if (rows > 0)
				return true;
		} catch (SQLException e) {
			throw new OMTSException("Failed to add the screen seat price" + e);
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
	public List<Show> getShowDetails() throws OMTSException {
		// TODO Auto-generated method stub
		List<Show> showList = new ArrayList<Show>();
		try {
			connection = DBConnection.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(GET_SHOW_DETAILS);

			while (resultSet.next()) {
				Show show = new Show();
				show.setShowId(resultSet.getInt(1));
				show.setShowStartTime(resultSet.getTime(2));
				show.setShowEndTime(resultSet.getTime(3));
				show.setShowName(resultSet.getString(4));
				show.setMovieName(resultSet.getString(5));
				show.setScreenId(resultSet.getInt(6));
				show.setTheatreId(resultSet.getInt(7));
				show.setMovieId(resultSet.getInt(8));
				showList.add(show);
			}
		} catch (SQLException e) {
			throw new OMTSException("problem while displaying Show Data from Database");
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new OMTSException("problem while closing Database");
			}
		}

		return showList;

	}

	@Override
	public int addShow(Show show) throws OMTSException {
		int isInserted = 0;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(ADD_SHOW);
			prepareStatement.setInt(1, show.getShowId());
			prepareStatement.setTime(2, show.getShowStartTime());
			prepareStatement.setTime(3, show.getShowEndTime());
			prepareStatement.setString(4, show.getShowName());
			prepareStatement.setString(5, show.getMovieName());
			prepareStatement.setInt(6, show.getScreenId());
			prepareStatement.setInt(7, show.getTheatreId());
			prepareStatement.setInt(8, show.getMovieId());
			isInserted = prepareStatement.executeUpdate();
		} catch (SQLException e) {
			throw new OMTSException("problem inserting Show Details into Database");
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
	public int deleteShow(int showId) throws OMTSException {
		// TODO Auto-generated method stub
		int isDeleted = 0;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(DELETE_SHOW);
			prepareStatement.setInt(1, showId);
			isDeleted = prepareStatement.executeUpdate();
		} catch (SQLException e) {
			throw new OMTSException("problem while deleting Show Details from Database");
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
	public List<Show> getShowByName(String showName) throws OMTSException {
		// TODO Auto-generated method stub
		List<Show> showList = new ArrayList<Show>();
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(GET_SHOW_BY_NAME);
			prepareStatement.setString(1, showName);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Show show = new Show();
				show.setShowId(resultSet.getInt(1));
				show.setShowStartTime(resultSet.getTime(2));
				show.setShowEndTime(resultSet.getTime(3));
				show.setShowName(resultSet.getString(4));
				show.setMovieName(resultSet.getString(5));
				show.setScreenId(resultSet.getInt(6));
				show.setTheatreId(resultSet.getInt(7));
				show.setMovieId(resultSet.getInt(8));
				showList.add(show);
			}
		} catch (SQLException e) {
			throw new OMTSException("problem while displaying Show Data from Database");
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new OMTSException("problem while closing Database");
			}
		}

		return showList;

	}

	@Override
	public List<Integer> getScreenFromMovieAndTheatre(int theatreId, int movieId) throws OMTSException {
		// TODO Auto-generated method stub
		List<Integer> screenList = new ArrayList<Integer>();
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(GET_SCREEN_FROM_MOVIE_AND_THEATRE);
			prepareStatement.setInt(1, movieId);
			prepareStatement.setInt(2, theatreId);
			ResultSet resultSet = prepareStatement.executeQuery();
			int screenId = 0;
			while (resultSet.next()) {
				screenId = resultSet.getInt(1);
				screenList.add(screenId);
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
		return screenList;
	}

	@Override
	public String checkShowNameandScreenId(String showName, int screenId) throws OMTSException {
		// TODO Auto-generated method stub
		String existShowName = "";
		int existScreenId = 0;
		String exist = "";
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(CHECK_SHOWNAME_AND_SCREENID);
			prepareStatement.setString(1, showName);
			prepareStatement.setInt(2, screenId);
			ResultSet resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				existShowName = resultSet.getString(1);
				existScreenId = resultSet.getInt(2);
				exist = existShowName + "" + existScreenId;
			}
		} catch (SQLException e) {
			System.out.println("Failed to retrieve screenId and showname  from showdetails");
		} finally {
			try {
				connection.close();
				prepareStatement.close();
			} catch (SQLException e) {
				System.out.println("Failed to close the database connection" + e);
			}
		}
		return exist;
	}

}