package nz.geek.nicholasparry.fitpet.pets.Tools;


import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import engine.rendering.DisplayObject;
import nz.geek.nicholasparry.fitpet.PlayerCard;
import nz.geek.nicholasparry.fitpet.pets.Pet;

public class PetFactory {

	
	/*
	 * Welcome to the pet factory,
	 * where we produse pets, in an evil evil manner 
	 * Useing nothing but bad magic
	 */
	public PetFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static Pet makePet(PetTypes _petType, PlayerCard _owner){
		Pet pet = new Pet(_petType, _owner);
		pet.setPetType(_petType);
		pet.setAlive(true);
		pet.setAttack1(_petType.getAttack1());
		pet.setAttack2(_petType.getAttack2());
		pet.setHappy(80);
		pet.setHunger(80);
		pet.setHealth(100);
		pet.setPetType(_petType);
		pet.setElement(_petType.getElement());
		pet.setDisplayObject(new DisplayObject(_petType.getTexture()));
		//System.out.println(pet);
		return pet;
	}
	
	public static Pet makeRandomPet(){
		PetTypes[] allPetTypes = new PetTypes[PetTypes.values().length];
		for(int i = 0; i < allPetTypes.length; i++){
			allPetTypes[i] = PetTypes.values()[i];
		}
		PetTypes petType = allPetTypes[(int)(Math.random() * allPetTypes.length)];
		
		
		Pet pet = new Pet(petType, null);
		pet.setAlive(true);
		pet.setAttack1(petType.getAttack1());
		pet.setAttack2(petType.getAttack2());
		pet.setHappy(80);
		pet.setHunger(80);
		pet.setHealth(100);
		pet.setPetType(petType);
		pet.setElement(petType.getElement());
		return pet;
		
	}
	
	public static Pet loadPetFromString(String _petData){
		return null;
	}
	
	
	
	
	
	

}
