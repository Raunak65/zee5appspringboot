package com.zee.zee5app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Movies;
@Repository
public interface MoviesRepository extends JpaRepository<Movies, String> {

}
