package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.exception.IdInvalidLengthException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.MoviesRepository;
import com.zee.zee5app.service.MovieService;
@Service
public class MoviesServiceImpl implements MovieService {
	@Autowired
	private MoviesRepository moviesrepository ;
	@Override
	public String addMovie(Movies movie) {
		// TODO Auto-generated method stub
		Movies movie2 = moviesrepository.save(movie);
		if(movie2!=null) {
			return "Success";
		}
		else return "Failed";
	}

	

	@Override
	public Optional<Movies> getMovieById(String id)
			throws IdNotFoundException, InvalidNameException, IdInvalidLengthException {
		// TODO Auto-generated method stub
		return moviesrepository.findById(id);
	}

	@Override
	public Movies[] getAllMovies() throws InvalidNameException, IdInvalidLengthException {
		// TODO Auto-generated method stub
		List<Movies> list = moviesrepository.findAll();
		Movies [] array = new Movies[list.size()];
		return list.toArray(array);
	}

	@Override
	public String deleteMovieById(String id)
			throws IdNotFoundException, InvalidNameException, IdInvalidLengthException {
		// TODO Auto-generated method stub
		try {
			Optional<Movies> optional = this.getMovieById(id);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("record not found");
			}
			else {
				moviesrepository.deleteById(id);
				return "Success";
			}
		} catch (InvalidNameException | IdNotFoundException | IdInvalidLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
	}

	@Override
	public Optional<List<Movies>> getAllMoviesDetails() throws InvalidNameException, IdNotFoundException,
			InvalidPasswordException, InvalidEmailException, IdInvalidLengthException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(moviesrepository.findAll());
	}

}
