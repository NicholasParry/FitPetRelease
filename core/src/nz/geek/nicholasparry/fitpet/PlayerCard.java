package nz.geek.nicholasparry.fitpet;

import java.io.Serializable;
import java.util.Date;



public class PlayerCard implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7669449835508815635L;
	private String name;
	private int age;
	private int lastPlayed; //as a unix time stamp please ladys and gentalmen
	private int totalSteps;
	private int stepsToday;
	private int dailyStepGoal;
	private int fitPoints;
	private int playerID;
	
	
	public PlayerCard() {
		name = "Mr. No Name";
		age = 18;
		lastPlayed = (int)(System.currentTimeMillis() / 1000l);
		totalSteps = 0;
		stepsToday = 0;
		dailyStepGoal = 0;
		fitPoints = 5;
		playerID = (int)(Math.random() * 999) + 1;

		
	}

	public String newPlayer(String _name, int _age, int _dailyStepGoal){
		name = _name;
		age = _age;
		lastPlayed = (int)(System.currentTimeMillis() / 1000l);
		totalSteps = 0;
		stepsToday = 0;
		dailyStepGoal = _dailyStepGoal;
		fitPoints = 5;
		playerID = 0;
		
		return"";
	}

	@Override
	public String toString() {
		return "name: " + name + "\n"
				+ "age: " + String.valueOf(age) + "\n"
				+ "total steps: " + String.valueOf(totalSteps) + "\n"
				+ "daily step goal: " + String.valueOf(dailyStepGoal);
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public boolean setName(String name) {
		if(name.length() < 12)
			this.name = name;
		return true;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public boolean setAge(int age) {
		this.age = age;
		return true; //TODO: validate properly
	}

	/**
	 * @return the lastPlayed
	 */
	public int getLastPlayed() {
		return lastPlayed;
	}

	/**
	 * @param lastPlayed the lastPlayed to set
	 */
	public boolean setLastPlayed(int lastPlayed) {
		this.lastPlayed = lastPlayed;
		return true; //TODO: validate properly
	}

	/**
	 * @return the totalSteps
	 */
	public int getTotalSteps() {
		return totalSteps;
	}

	/**
	 * @param totalSteps the totalSteps to set
	 */
	public boolean setTotalSteps(int totalSteps) {
		this.totalSteps = totalSteps;
		return true; //TODO: validate properly
	}

	/**
	 * @return the stepsToday
	 */
	public int getStepsToday() {
		return stepsToday;
	}

	/**
	 * @param stepsToday the stepsToday to set
	 */
	public boolean setStepsToday(int stepsToday) {
		this.stepsToday = stepsToday;
		return true; //TODO: validate properly
	}

	/**
	 * @return the dailyStepGoal
	 */
	public int getDailyStepGoal() {
		return dailyStepGoal;
	}

	/**
	 * @param dailyStepGoal the dailyStepGoal to set
	 */
	public boolean setDailyStepGoal(int dailyStepGoal) {
		this.dailyStepGoal = dailyStepGoal;
		return true; //TODO: validate properly
	}

	/**
	 * @return the playerID
	 */
	public int getPlayerID() {
		return playerID;
	}

	/**
	 * @param playerID the playerID to set
	 */
	public boolean setPlayerID(int playerID) {
		this.playerID = playerID;
		return true; //TODO: validate properly
	}
	
	public int getFitPoints() {/*
		if(fitPoints == Integer.isN){
			fitPoints = 5;
		}*/
		return fitPoints;
	}

	public void setFitPoints(int fitPoints) {
		this.fitPoints = fitPoints;
	}

	
	
	
	

}
