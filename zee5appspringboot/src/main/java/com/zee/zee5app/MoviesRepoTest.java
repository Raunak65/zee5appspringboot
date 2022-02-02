package com.zee.zee5app;

import java.util.List;

import javax.naming.InvalidNameException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.exception.IdInvalidLengthException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.service.MovieService;

import java.util.Optional;
@SpringBootApplication
public class MoviesRepoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigurableApplicationContext applicationContext = 
				SpringApplication.run(MoviesRepoTest.class, args);
		
		MovieService movieservice = applicationContext.getBean(MovieService.class);
		Movies movie = new Movies("movie@10", "End Game", 
				"https://www.youtube.com/watch?v=TcMBFSGVi1c&ab_channel=MarvelEntertainment",
				 "2022-09-02", "location10",
				"HINDI", "A,B,C",10, 10);
		movieservice.addMovie(movie);
		try {
			Movies[] movies = movieservice.getAllMovies();
			for(int i = 0 ; i < movies.length;i++) {
				System.out.println(movies[i]);
			}
			Optional<List<Movies>> optional = movieservice.getAllMoviesDetails();
			if (optional.isPresent()){
				optional.get().forEach(e->System.out.println(e));
			}
			else {
				System.out.println("No movies found.");
			}
			String res = movieservice.deleteMovieById("movie@10");
			System.out.println(res);
		} catch (InvalidNameException | IdInvalidLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidEmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		applicationContext.close();

	}

}
