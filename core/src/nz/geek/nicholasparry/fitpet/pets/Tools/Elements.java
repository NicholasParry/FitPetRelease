package nz.geek.nicholasparry.fitpet.pets.Tools;

public enum Elements {
	FIRE,
	WATER,
	EARTH;
	
	private Elements() {
		// TODO Auto-generated constructor stub
	}
	 
	public double elementPenalty(Elements _otherElement){
		
		if(this.name().equals("FIRE")){
			switch(_otherElement.name()){
				case "WATER":
					return 0.75;
				case "EARTH":
					return 1.25;
			}
		} else if (this.name() == "Water"){
			switch(_otherElement.name()){
				case "EARTH":
					return 0.75;
				case "FIRE":
					return 1.25;
			}
		} else if (this.name().equals("EARTH")){
			switch(_otherElement.name()){
				case "FIRE":
					return 0.75;
				case "WATER":
					return 1.25;
			}
		}
		
		
		
		return 1.0;
	}
}
