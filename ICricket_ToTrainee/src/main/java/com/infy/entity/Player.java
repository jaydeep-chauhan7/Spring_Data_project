package com.infy.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="players")
public class Player {
	@Id
	private Integer playerId;
	private String playerName;
	private Integer ranking;
	private String battingStyle;
	private String bowlingStyle;
	private String debutDate;
	private String country;
	
	
	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", playerName=" + playerName + ", ranking=" + ranking
				+ ", battingStyle=" + battingStyle + ", bowlingStyle=" + bowlingStyle + ", debutDate=" + debutDate
				+ ", country=" + country + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(battingStyle, bowlingStyle, country, debutDate, playerId, playerName, ranking);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return Objects.equals(battingStyle, other.battingStyle) && Objects.equals(bowlingStyle, other.bowlingStyle)
				&& Objects.equals(country, other.country) && Objects.equals(debutDate, other.debutDate)
				&& Objects.equals(playerId, other.playerId) && Objects.equals(playerName, other.playerName)
				&& Objects.equals(ranking, other.ranking);
	}
	public Integer getPlayerId() {
		return playerId;
	}
	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public Integer getRanking() {
		return ranking;
	}
	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}
	public String getBattingStyle() {
		return battingStyle;
	}
	public void setBattingStyle(String battingStyle) {
		this.battingStyle = battingStyle;
	}
	public String getBowlingStyle() {
		return bowlingStyle;
	}
	public void setBowlingStyle(String bowlingStyle) {
		this.bowlingStyle = bowlingStyle;
	}
	public String getDebutDate() {
		return debutDate;
	}
	public void setDebutDate(String debutDate) {
		this.debutDate = debutDate;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
}