package com.partyroom.partyroomapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.partyroom.partyroomapi.model.Score;
import com.partyroom.partyroomapi.repository.ScoreRepository;

@Service
public class ScoreService {

	@Autowired
	private ScoreRepository scoreRepository;

	public List<Score> getAll() {
		return scoreRepository.getAll();
	}

	public Optional<Score> getScore(Integer id) {
		return scoreRepository.getScore(id);
	}

	public Score save(Score p) {
		if (p.getId() == null) {
			return scoreRepository.save(p);
		} else {
			Optional<Score> caux = scoreRepository.getScore(p.getId());
			if (caux.isEmpty()) {
				return scoreRepository.save(p);
			} else {
				return p;
			}
		}
	}
}
