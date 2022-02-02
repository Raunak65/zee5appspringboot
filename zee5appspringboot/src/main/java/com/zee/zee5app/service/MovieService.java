package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;

import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.exception.IdInvalidLengthException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidPasswordException;

public interface MovieService {

	public String addMovie(Movies movie);
	public Optional<Movies> getMovieById(String id) 
			throws IdNotFoundException, InvalidNameException, 
			IdInvalidLengthException;
	public Movies[] getAllMovies() 
			throws InvalidNameException, IdInvalidLengthException;
	public String deleteMovieById(String id) 
			throws IdNotFoundException, InvalidNameException, 
			IdInvalidLengthException;
	public Optional<List<Movies>> getAllMoviesDetails() 
			throws InvalidNameException, IdNotFoundException,
			InvalidPasswordException, InvalidEmailException, 
			IdInvalidLengthException;
}
