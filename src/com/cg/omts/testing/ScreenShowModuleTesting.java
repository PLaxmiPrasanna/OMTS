package com.cg.omts.testing;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.cg.omts.dto.Screen;
import com.cg.omts.dto.Show;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.service.IScreenShowService;
import com.cg.omts.service.ScreenShowServiceImpl;

public class ScreenShowModuleTesting {
	IScreenShowService screenShowService = new ScreenShowServiceImpl();

	@Test
	public void addScreenTest1() throws OMTSException {
		try {
			int theatreId = 2001;
			int screenId = 4004;
			Screen screen = new Screen(screenId, "Screen1", 50, 10);
			boolean isAdded = screenShowService.addScreen(screen, theatreId);
			assertTrue(isAdded);
		} catch (OMTSException e) {
			throw new OMTSException("Exception in testing");
		}

	}

	@Test
	public void addScreenTest2() throws OMTSException {
		try {
			int theatreId = 2003;
			int screenId = 4002;
			Screen screen = new Screen(screenId, "Screen2", 50, 10);
			boolean isAdded = screenShowService.addScreen(screen, theatreId);
			assertFalse(isAdded);
		} catch (OMTSException e) {
			throw new OMTSException("Exception in testing");
		}

	}

	@Test
	public void deleteScreenTest1() throws OMTSException {
		try {
			int screenId = 4004;
			boolean isDeleted = screenShowService.deleteScreen(screenId);
			assertTrue(isDeleted);
		} catch (OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}

	@Test
	public void deleteScreenTest2() throws OMTSException {
		try {
			int screenId = 4005;
			boolean isDeleted = screenShowService.deleteScreen(screenId);
			assertFalse(isDeleted);
		} catch (OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}

	@Test
	public void getScreenDetailsToDeleteTest() throws OMTSException {
		try {
			ArrayList<Screen> screenList = screenShowService.getScreenDetailsToDelete();
			assertNotNull(screenList);
		} catch (OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}

	@Test
	public void isScreenIdExistsTest1() throws OMTSException {
		try {
			int screenId = 4002;
			boolean isExists = screenShowService.isScreenIdExists(screenId);
			assertTrue(isExists);
		} catch (OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}

	@Test
	public void isScreenIdExistsTest2() throws OMTSException {
		try {
			int screenId = 4007;
			boolean isExists = screenShowService.isScreenIdExists(screenId);
			assertFalse(isExists);
		} catch (OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}

	@Test
	public void getShowDetails() throws OMTSException {
		boolean actualShowList = false;
		boolean expectedShowList = true;
		try {
			List<Show> showList = screenShowService.getShowDetails();
			if (showList.size() > 0) {
				actualShowList = true;
			}
		} catch (OMTSException e) {
			throw new OMTSException("Problem while getting show details");
		}
		assertEquals(expectedShowList, actualShowList);
	}

	@Test
	public void addShowTest() throws OMTSException, ParseException {
		int rowsInserted = 0;
		Show show = new Show();
		show.setShowId(5004);
		java.util.Date startTime = new SimpleDateFormat("hh:mm").parse("08:00:00");
		java.sql.Time showStartTime = new java.sql.Time(startTime.getTime());
		java.util.Date endTime = new SimpleDateFormat("hh:mm").parse("10:00:00");
		java.sql.Time showEndTime = new java.sql.Time(endTime.getTime());
		show.setShowStartTime(showStartTime);
		show.setShowEndTime(showEndTime);
		show.setShowName("Morning show");
		show.setScreenId(4004);
		show.setTheatreId(2002);
		show.setMovieId(3002);
		show.setMovieName("Ala Vaikuntapuram");
		rowsInserted = screenShowService.addShow(show);
		boolean actualRowsInserted = false;
		if (rowsInserted > 0) {
			actualRowsInserted = true;
		}
		boolean expectedRowsInserted = true;
		assertEquals(expectedRowsInserted, actualRowsInserted);
	}

	@Test
	public void addShowTest2() throws OMTSException, ParseException {
		Show show = new Show();
		show.setShowId(5001);
		java.util.Date startTime = new SimpleDateFormat("hh:mm").parse("08:00:00");
		java.sql.Time showStartTime = new java.sql.Time(startTime.getTime());
		java.util.Date endTime = new SimpleDateFormat("hh:mm").parse("10:00:00");
		java.sql.Time showEndTime = new java.sql.Time(endTime.getTime());
		show.setShowStartTime(showStartTime);
		show.setShowEndTime(showEndTime);
		show.setShowName("Morning");
		show.setScreenId(4004);
		show.setTheatreId(2002);
		show.setMovieId(3002);
		try {
			screenShowService.addShow(show);
			Assert.fail("Duplicate entry for Show id");
		} catch (OMTSException e) {
			// TODO Auto-generated catch block
		}
	}

	@Test
	public void deleteShowTest() throws OMTSException {
		int rowsDeleted = 0;
		int showId = 5001;
		boolean actualRowsDeleted = false;
		boolean expectedRowsDeleted = true;
		try {
			rowsDeleted = screenShowService.deleteShow(showId);

			if (rowsDeleted > 0) {
				actualRowsDeleted = true;
			}
		} catch (OMTSException e) {
			throw new OMTSException("problem while deleting show");
		}
		assertEquals(expectedRowsDeleted, actualRowsDeleted);
	}

	@Test
	public void deleteShowTest2() throws OMTSException {
		int noRowsDeleted = 0;
		int showId = 5093;
		boolean actualNoRowDeleted = false;
		boolean expectedNoRowDeleted = true;
		try {
			noRowsDeleted = screenShowService.deleteShow(showId);

			if (noRowsDeleted == 0) {
				actualNoRowDeleted = true;
			}
		} catch (OMTSException e) {
			throw new OMTSException("problem while deleting show");
		}
		assertEquals(expectedNoRowDeleted, actualNoRowDeleted);
	}

	@Test
	public void getShowByNameTest() throws OMTSException {
		String showName = "Morning Show";
		boolean actualShowList = false;
		boolean expectedShowList = true;
		try {
			List<Show> showList = screenShowService.getShowByName(showName);
			if (showList.size() > 0) {
				actualShowList = true;
			}
		} catch (OMTSException e) {
			throw new OMTSException("Problem while getting show details of particular show");
		}
		assertEquals(expectedShowList, actualShowList);
	}

	@Test
	public void getShowByNameTest2() throws OMTSException {
		String showName = "MidNight";
		boolean actualNoShowList = false;
		boolean expectedNoShowList = true;
		try {
			List<Show> showList = screenShowService.getShowByName(showName);
			if (showList.size() == 0) {
				actualNoShowList = true;
			}
		} catch (OMTSException e) {
			throw new OMTSException("Problem while getting no show details of particular show");
		}
		assertEquals(expectedNoShowList, actualNoShowList);
	}

	@Test
	public void getScreenFromMovieAndTheatreTest() throws OMTSException {
		int theatreId = 2001;
		int movieId = 3001;
		boolean actualScreenList = false;
		boolean expectedScreenList = true;
		try {
			List<Integer> screenList = screenShowService.getScreenFromMovieAndTheatre(theatreId, movieId);
			if (screenList.size() > 0) {
				actualScreenList = true;
			}
		} catch (OMTSException e) {
			throw new OMTSException("Problem while getting screen  from theatre and movie");
		}
		assertEquals(expectedScreenList, actualScreenList);
	}

	@Test
	public void getScreenFromMovieAndTheatreTest2() throws OMTSException {
		int theatreId = 2004;
		int movieId = 3004;
		boolean actualNoScreenList = false;
		boolean expectedNoScreenList = true;
		try {
			List<Integer> screenList = screenShowService.getScreenFromMovieAndTheatre(theatreId, movieId);
			if (screenList.size() == 0) {
				actualNoScreenList = true;
			}
		} catch (OMTSException e) {
			throw new OMTSException("Problem while getting no screen  from theatre and movie");
		}
		assertEquals(expectedNoScreenList, actualNoScreenList);
	}

	@Test
	public void checkShowNameandScreenIdTest() throws OMTSException {
		String showName = "first show";
		int screenId = 4004;
		boolean actualShowScreenName = false;
		boolean expectedShowScreenName = true;
		String showScreenName = "";
		try {
			showScreenName = screenShowService.checkShowNameandScreenId(showName, screenId);
			if (showScreenName.length() > 0) {
				actualShowScreenName = true;
			}
		} catch (OMTSException e) {
			throw new OMTSException("Problem while getting screen  from theatre and movie");
		}
		assertEquals(expectedShowScreenName, actualShowScreenName);
	}

	@Test
	public void  checkShowNameandScreenIdTest2() throws OMTSException {
		String showName = "first show";
		int screenId = 4006;
		boolean actualNoShowScreenName = false;
		boolean expectedNoShowScreenName = true;
		String showScreenName = "";
		try {
			showScreenName = screenShowService.checkShowNameandScreenId(showName, screenId);
			if(showScreenName.length() == 0) {
				actualNoShowScreenName = true;
			}
		}catch(OMTSException e) {
			throw new OMTSException("Problem while getting screen  from theatre and movie");
		}
		assertEquals(expectedNoShowScreenName, actualNoShowScreenName);
	}
}
