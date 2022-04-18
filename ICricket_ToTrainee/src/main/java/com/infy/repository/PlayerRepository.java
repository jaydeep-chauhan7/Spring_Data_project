package com.infy.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.infy.entity.Player;

public interface PlayerRepository extends PagingAndSortingRepository<Player, Integer> {
	//public List<Transaction> findByTransactionDateAfter(LocalDate transactionDate, Pageable pageable);
	
	public List<Player> findByDebutDateAfter(String debutDate,Pageable pageable);
	
	public List<Player> findByRanking(String country, Sort sort);
}