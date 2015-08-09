package nz.geek.nicholasparry.fitpet.saves;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

import nz.geek.nicholasparry.fitpet.AppInfo;
import nz.geek.nicholasparry.fitpet.FitPetMain;
import nz.geek.nicholasparry.fitpet.Player;
import nz.geek.nicholasparry.fitpet.PlayerCard;
import nz.geek.nicholasparry.fitpet.Settings;
import nz.geek.nicholasparry.fitpet.Screen.NewGameScreen;
import nz.geek.nicholasparry.fitpet.pets.Pet;
import nz.geek.nicholasparry.fitpet.pets.Tools.PetFactory;
import nz.geek.nicholasparry.fitpet.pets.Tools.PetTypes;

public class SaveManager {
	Preferences fpSave = Gdx.app.getPreferences("FitPetSave");
	
	
	/**
	 * Saves game
	 * @param player object to save
	 * @return false if it fucked up (Hopefully?)
	 */
	public boolean saveGame(Player player){
		
		PlayerCard pc = player.getPlayerCard();
		
		fpSave.putInteger("PlayerAge", pc.getAge());
		fpSave.putInteger("DailyStepGoal", pc.getDailyStepGoal());
		fpSave.putInteger("FitPoints", pc.getFitPoints());
		fpSave.putInteger("LastPlayed",pc.getLastPlayed());
		fpSave.putString("PlayerName", pc.getName());
		fpSave.putInteger("PlayerID", pc.getPlayerID());
		fpSave.putInteger("StepsToday", pc.getStepsToday());
		fpSave.putInteger("TotalSteps", pc.getTotalSteps());
		

		//Pet pet = PetFactory.makePet(getPetTypeByName(fpSave.getString("PetType")), pc);
		
		Pet pet = player.getPet();
		fpSave.putString("PetType", pet.getType().toString());
		fpSave.putBoolean("PetAlive", pet.isAlive());
		fpSave.putInteger("Happy", pet.getHappy());
		fpSave.putInteger("PetHungery", pet.getHunger());
		fpSave.putInteger("PetHealth", pet.getHP());
		fpSave.putString("PetName", pet.getName());
		
		fpSave.putBoolean("SaveExsists", true);
		fpSave.putFloat("SaveVersion", AppInfo.SaveVersion);
		
		fpSave.putBoolean("MusicOn", Settings.music);
		fpSave.putBoolean("SFXOn", Settings.sfx);
		
		fpSave.flush();
		
		Gdx.app.log("save", "Saved Game");
		return true;
	}
	
	/**
	 * Loads saved data into a Player object
	 * 
	 * Note: data is not updated.
	 * 
	 * @return Player object with all data exact as save (NOT UPDATED)
	 */
	public Player loadGame(){

		Player player = new Player();
		PlayerCard pc = new PlayerCard();
		boolean failed = false;
		
		Gdx.app.log("SaveManager", "Loading Save");
		try{ 
			
			if(fpSave.getFloat("SaveVersion") != AppInfo.SaveVersion || (fpSave.getFloat("SaveVersion") == 0.000f)){
				if(fpSave.getFloat("SaveVersion") == 0.001f){
					Gdx.app.log("save","Save Version out of date, updateing from 0.001 to 0.003");
					
					fpSave.putBoolean("MusicOn", Settings.music);
					fpSave.putBoolean("SFXOn", Settings.sfx);
					return loadGame();
					
				}
				Gdx.app.log("save","Save Version out of date, unable to update save file");
				//FitPetMain.fitPetMain.setScreen(new NewGameScreen(FitPetMain.fitPetMain)); //beautiful
				return null;  //even more beautiful
			}
			
			pc.setAge(fpSave.getInteger("PlayerAge"));
			pc.setDailyStepGoal(fpSave.getInteger("DailyStepGoal"));
			pc.setFitPoints(fpSave.getInteger("FitPoints"));
			pc.setLastPlayed(fpSave.getInteger("LastPlayed"));
			pc.setName(fpSave.getString("PlayerName"));
			pc.setPlayerID(fpSave.getInteger("PlayerID"));
			pc.setStepsToday(fpSave.getInteger("StepsToday"));
			pc.setTotalSteps(fpSave.getInteger("TotalSteps"));
			
			
			Pet pet = PetFactory.makePet(PetTypes.valueOf(fpSave.getString("PetType")), pc);
			
			pet.setAlive(fpSave.getBoolean("PetAlive"));
			pet.setHappy(fpSave.getInteger("Happy"));
			pet.setHunger(fpSave.getInteger("PetHungery"));
			pet.setHealth(fpSave.getInteger("PetHealth"));
			pet.setName(fpSave.getString("PetName"));
			
			Settings.music = fpSave.getBoolean("MusicOn");
			
			player.setPlayerCard(pc);
			player.setPet(pet);
		}  catch (Exception ex){
			Gdx.app.error("Save Data", "Unspecified Corruption");
			Gdx.app.log("Save Data", "Unspecified Corruption");
			failed = true;
			
		} finally {
			if(failed){
				//TODO: Display error message on screen
				Gdx.app.log("SaveManager", "Save Manager Was unable to load a save, Switching state to new game");
				FitPetMain.fitPetMain.setScreen(new NewGameScreen(FitPetMain.fitPetMain));
			}
			
		}
		Gdx.app.log("save", "Sucsessfully Loaded");
		return player;
	}
	
	
	/**
	 * Tests to see if valid save game exsists
	 * 
	 * NOTE: Currently does not test for validity just if it exsistes
	 * 
	 * @return true if valid save game exsistes
	 */
	public Boolean savedGameExsistes(){
		return fpSave.getBoolean("SaveExsists", false);
		//TODO: validate
	}
	
	
}
