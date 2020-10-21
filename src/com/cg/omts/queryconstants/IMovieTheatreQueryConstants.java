package com.cg.omts.queryconstants;

public interface IMovieTheatreQueryConstants {

	String ADD_MOVIE = "insert into movie values(?, ?, ?, ?, ?, ?, ?)";

	String DELETE_MOVIE = "delete from movie where movieId = ?";

	String DISPLAY_ALL_MOVIES_DELETE = "select movieId, movieName, movieGenre, movieDirector, language from movie";

	String GET_THEATRE_DETAILS = "select theatreId, theatreName from theatre where theatreCity = ?";

	String VALIDATE_MOVIE_ID = "select movieId, movieName from movie where movieId = ?";

	String VALIDATE_THEATRE_ID = "select theatreId, theatreName from theatre where theatreId = ?";

	String CHECK_ID_IN_CITY = "select theatreId from theatre where theatreCity = ? and theatreId = ?";

	String THEATRE_MOVIE_ID_ALREADY_EXISTS = "select movieId from movietheatre where theatreId = ? and movieId = ?";

	String ADD_MOVIE_TO_THEATRE = "insert into movietheatre values(?, ?)";

	String GET_MOVIE_NAME_ID = "select movieId, movieName from movie";

	String GET_THEATREID = "select theatreId from theatre WHERE theatreCity=?";

	String GET_THEATRE_BY_ID = "select * from theatre where theatreId = ?";

	String GET_THEATRE_NAME_BY_ID = "select theatreName from theatre where theatreId = ?";

	String GET_THEATRES_BY_MOVIE = "select theatreId from movietheatre where movieId = ?";

	String GET_THEATRE_NAME = "select theatreName from theatre where theatreId = ?";

	String GET_MOVIES_BY_THEATRE_ID = "select movieId from movietheatre where theatreId=?";

	String GET_MOVIES_BY_ID = "select * from movie where movieId = ?";

	String GET_ALL_MOVIES = "select * from movie";

	String GET_MOVIE_DETAILS = "select * from movie where movieId = ?";

	String GET_THEATRE_DETAILS_DISPLAY = "select * from theatre";

	String ADD_THEATRE = "insert into theatre values(?,?,?,?,?)";

	String DELETE_THEATRE = "delete from theatre where theatreId = ?";

	String GET_THEATRE_BY_NAME = "select * from theatre where theatreName = ?";

	String GET_MOVIELENGTH = "select movieLength from movie where movieId = ?";

	String GET_MOVIENAME_FROM_MOVIE = "select movieName from movie where movieId = ?";

}