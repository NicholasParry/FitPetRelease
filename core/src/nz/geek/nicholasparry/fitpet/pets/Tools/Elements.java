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
			if(_otherElement.name().equals("WATER")){
				return 0.75;
			} else if (_otherElement.name().equals("EARTH")){
				return 1.25;
			}
		} else if (this.name().equals("Water")){
			if(_otherElement.name().equals("EARTH")){
				return 0.75;
			} else if(_otherElement.name().equals("FIRE")){
				return 1.25;
			}
		} else if (this.name().equals("EARTH")){
			if(_otherElement.name().equals("FIRE")){
				return 0.75;
			} else if(_otherElement.name().equals("WATER")){
				return 1.25;
			}
		}
		
		
		
		
		
		
		
		return 1.0;
	}
}
