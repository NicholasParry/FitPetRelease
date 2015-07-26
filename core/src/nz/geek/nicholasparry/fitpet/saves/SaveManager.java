package nz.geek.nicholasparry.fitpet.saves;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

import nz.geek.nicholasparry.fitpet.FitPetMain;
import nz.geek.nicholasparry.fitpet.Player;
import nz.geek.nicholasparry.fitpet.PlayerCard;
import nz.geek.nicholasparry.fitpet.PlatformDependant.PlatformPackage;
import nz.geek.nicholasparry.fitpet.Screen.NewGameScreen;
import nz.geek.nicholasparry.fitpet.pets.Pet;
import nz.geek.nicholasparry.fitpet.pets.Tools.PetFactory;
import nz.geek.nicholasparry.fitpet.pets.Tools.PetTypes;

public class SaveManager {
	Preferences fpSave = Gdx.app.getPreferences("FitPetSave");
	
	
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
			
			if(fpSave.getInteger("SaveVersion") != 1.0){
				throw new SaveFileCorruptException("Save Version out of date, unable to update save file", false);
			}
			
			pc.setAge(fpSave.getInteger("PlayerAge"));
			pc.setDailyStepGoal(fpSave.getInteger("DailyStepGoal"));
			pc.setFitPoints(fpSave.getInteger("FitPoints"));
			pc.setLastPlayed(fpSave.getInteger("LastPlayed"));
			pc.setName(fpSave.getString("PlayerName"));
			pc.setPlayerID(fpSave.getInteger("PlayerID"));
			pc.setStepsToday(fpSave.getInteger("StepsToday"));
			pc.setTotalSteps(fpSave.getInteger("TotalSteps"));
			
			
			Pet pet = PetFactory.makePet(getPetTypeByName(fpSave.getString("PetType")), pc);
			
			pet.setAlive(fpSave.getBoolean("PetAlive"));
			pet.setHappy(fpSave.getInteger("Happy"));
			pet.setHunger(fpSave.getInteger("PetHungery"));
			pet.setHealth(fpSave.getInteger("PetHealth"));
			pet.setName(fpSave.getString("PetName"));
			
			player.setPlayerCard(pc);
			player.setPet(pet);
		} catch (SaveFileCorruptException sf){
			Gdx.app.error("SaveManager", sf.message + "    Recoverable: " + sf.recoverable);
			FitPetMain.platformPackage.getPlatformHandler().logFatal("SaveManager", sf.message + "    Recoverable: " + sf.recoverable);
			failed = true;
		} catch (Exception ex){
			Gdx.app.error("Save Data", "Unspecified Corruption");
			FitPetMain.platformPackage.getPlatformHandler().logFatal("Save Data", "Unspecified Corruption");
			failed = true;
			
		} finally {
			if(failed){
				//TODO: Display error message on screen
				Gdx.app.log("SaveManager", "Save Manager Was unable to load a save, Switching state to new game");
				FitPetMain.fitPetMain.setScreen(new NewGameScreen(FitPetMain.fitPetMain));
			}
			
			
			
		}
		return player;
	}
	
	
	/**
	 * Returns a pet type when specifieing a pet name
	 * @param petType String name of pet type
	 * @return PetTypes pet type object
	 */
	private PetTypes getPetTypeByName(String petType){
		
		return null;
	}
}
