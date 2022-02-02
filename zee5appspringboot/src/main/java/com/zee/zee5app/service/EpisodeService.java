package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Episode;
import com.zee.zee5app.exception.IdNotFoundException;

@Repository

public interface EpisodeService {

	public String addEpisode(Episode epi);
	public Optional<Episode> getEpisodeById(String id); 
	public Episode[] getAllEpisodes() ;
	public String deleteEpisodeById(String id) throws IdNotFoundException ;
	public Optional<List<Episode>> getAllEpisodeDetails() ;
}
