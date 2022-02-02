package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.naming.InvalidNameException;

import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.IdInvalidLengthException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidPasswordException;

public interface SeriesService {

	public String addSeries(Series series);
	public Optional<Series> getSeriesById(String id) throws IdNotFoundException, InvalidNameException, IdInvalidLengthException;
	public Series[] getAllSeries() throws InvalidNameException, IdInvalidLengthException;
	public String deleteSeriesById(String id) throws IdNotFoundException, InvalidNameException, IdInvalidLengthException;
	public Optional<List<Series>> getAllSeriesDetails() throws InvalidNameException, IdNotFoundException,
	InvalidPasswordException, InvalidEmailException, IdInvalidLengthException;
}
