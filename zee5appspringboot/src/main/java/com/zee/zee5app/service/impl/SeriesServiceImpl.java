package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdInvalidLengthException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.SeriesRepository;
import com.zee.zee5app.service.SeriesService;
@Service
public class SeriesServiceImpl implements SeriesService {
	@Autowired
	private SeriesRepository seriesrepository ;
	@Override
	public String addSeries(Series series) {
		// TODO Auto-generated method stub
		Series series2 = seriesrepository.save(series);
		if(series2!=null) {
			return "Success";
		}
		else return "Failed";
	}

	

	@Override
	public Optional<Series> getSeriesById(String id)
			throws IdNotFoundException, InvalidNameException, IdInvalidLengthException {
		// TODO Auto-generated method stub
		return seriesrepository.findById(id);
	}

	@Override
	public Series[] getAllSeries() throws InvalidNameException, IdInvalidLengthException {
		// TODO Auto-generated method stub
		List<Series> list = seriesrepository.findAll();
		Series [] array = new Series[list.size()];
		return list.toArray(array);
	}

	@Override
	public String deleteSeriesById(String id)
			throws IdNotFoundException, InvalidNameException, IdInvalidLengthException {
		// TODO Auto-generated method stub
		try {
			Optional<Series> optional = this.getSeriesById(id);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("record not found");
			}
			else {
				seriesrepository.deleteById(id);
				return "Success";
			}
		} catch (InvalidNameException | IdNotFoundException | IdInvalidLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
	}



	@Override
	public Optional<List<Series>> getAllSeriesDetails() throws InvalidNameException, IdNotFoundException,
			InvalidPasswordException, InvalidEmailException, IdInvalidLengthException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(seriesrepository.findAll());
	}

}
