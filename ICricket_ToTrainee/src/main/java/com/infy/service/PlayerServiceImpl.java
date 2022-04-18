package com.infy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.infy.dto.PlayerDTO;
import com.infy.entity.Player;
import com.infy.exception.InfyPlayerException;
import com.infy.repository.PlayerRepository;

@Service(value="playerService")
@Transactional
public class PlayerServiceImpl implements PlayerService {
	
	@Autowired
	private PlayerRepository playerRepository;
	
	@Override
	public List<PlayerDTO> getFirstSevenPlayers(int pageNo, int pageSize) throws InfyPlayerException {
		Pageable pageable=PageRequest.of(pageNo, pageSize);
		Page<Player> page=playerRepository.findAll(pageable);
		if(page.isEmpty()) {
			throw new InfyPlayerException("Service.NO_PLAYERS_IN_THIS_PAGE");
		}
		List<Player> entityList=page.getContent();
		List<PlayerDTO> result;
		result=entityList.stream().map(t -> new PlayerDTO(t.getPlayerId(),t.getBattingStyle(),t.getRanking(),t.getBowlingStyle(),t.getCountry(),t.getDebutDate(),t.getPlayerName())).collect(Collectors.toList());
		return result;
	}

	@Override
	public List<PlayerDTO> getAllPlayersByDebutDateAfter(String debutDate, int i, int j) throws InfyPlayerException {
		Pageable pageable=PageRequest.of(i, j);
		List<Player> entityList=playerRepository.findByDebutDateAfter(debutDate, pageable);
		if(entityList.isEmpty()) {
			throw new InfyPlayerException("Service.NO_PLAYERS_IN_THIS_PAGE");
		}
		List<PlayerDTO> result;
		result=entityList.stream().map(t -> new PlayerDTO(t.getPlayerId(),t.getBattingStyle(),t.getRanking(),t.getBowlingStyle(),t.getCountry(),t.getDebutDate(),t.getPlayerName())).collect(Collectors.toList());
		return result;
	}

	@Override
	public List<PlayerDTO> getAllPlayersSortedByRanking(Sort sort) throws InfyPlayerException {
		Iterable<Player> entity=playerRepository.findAll(sort);
		List<PlayerDTO> result=new ArrayList<>();
		entity.forEach(player -> {
			PlayerDTO p=new PlayerDTO(player.getPlayerId(),player.getBattingStyle(),player.getRanking(),player.getBowlingStyle(),player.getCountry(),player.getDebutDate(),player.getPlayerName());
			result.add(p);
		});
		if(result.isEmpty()) {
			throw new InfyPlayerException("Service.NO_PLAYERS_IN_THIS_PAGE");
		}
		return result;
	}

	@Override
	public List<PlayerDTO> getAllPlayersOfCountrySortedByRanking(String country, Sort sort) throws InfyPlayerException {
		Iterable<Player> entity=playerRepository.findByRanking(country, sort);
		List<PlayerDTO> result=new ArrayList<>();
		entity.forEach(player -> {
			PlayerDTO p=new PlayerDTO(player.getPlayerId(),player.getBattingStyle(),player.getRanking(),player.getBowlingStyle(),player.getCountry(),player.getDebutDate(),player.getPlayerName());
			result.add(p);
		});
		if(result.isEmpty()) {
			throw new InfyPlayerException("Service.NO_PLAYERS_IN_THIS_PAGE");
		}
		return result;
	}

}