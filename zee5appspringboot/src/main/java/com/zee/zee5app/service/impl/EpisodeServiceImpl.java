package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Episode;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.IdInvalidLengthException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.EpisodeRepository;
import com.zee.zee5app.service.EpisodeService;
@Service
public class EpisodeServiceImpl implements EpisodeService {
	@Autowired
	private EpisodeRepository episoderepository;
	
	
	@Override
	public String addEpisode(Episode epi) {
		// TODO Auto-generated method stub
		Episode episode = episoderepository.save(epi);
		if(episode!=null) {
			return "Success";
		}
		else return "Failed";
	}

	@Override
	public Optional<Episode> getEpisodeById(String id) {
		// TODO Auto-generated method stub
		return episoderepository.findById(id);
	}


	@Override
	public String deleteEpisodeById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		try {
			Optional<Episode> optional = this.getEpisodeById(id);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("record not found");
			}
			else {
				episoderepository.deleteById(id);
				return "Success";
			}
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
	}

	@Override
	public Optional<List<Episode>> getAllEpisodeDetails() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(episoderepository.findAll());
	}

	@Override
	public Episode[] getAllEpisodes() {
		// TODO Auto-generated method stub
		List<Episode> list = episoderepository.findAll();
		Episode [] array = new Episode[list.size()];
		return list.toArray(array);
	}

}
