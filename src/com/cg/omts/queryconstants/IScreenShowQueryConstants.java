package com.cg.omts.queryconstants;

public interface IScreenShowQueryConstants {

	String VALIDATE_SCREEN_ID = "select screenId, screenName from screen where screenId = ?";

	String ADD_SCREEN = "insert into screen values(?, ?, ?, ?, ?)";

	String DELETE_SCREEN = "delete from screen where screenId = ?";

	String DISPLAY_ALL_SCREEN_DELETE = "select s.screenId, s.screenName, s.theatreId, t.theatreName, t.theatreCity from screen s, theatre t where s.theatreId = t.theatreId;";

	String ADD_SCREEN_SEAT_PRICE = "insert into screenseatprice values(?, ?)";

	String GET_SHOW_DETAILS = "select * from showdetails";

	String ADD_SHOW = "insert into showdetails values(?,?,?,?,?,?,?,?)";

	String DELETE_SHOW = "delete from showdetails where showId = ?";

	String GET_SHOW_BY_NAME = "select * from showdetails where showName = ?";

	String GET_SCREEN_FROM_MOVIE_AND_THEATRE = "select screenId, theatreId from screen where theatreId =(select theatreId from movietheatre where movieId = ? and theatreId = ?)";

	String CHECK_SHOWNAME_AND_SCREENID = "select showName,screenId from showdetails where showName=? and screenId=?";
}