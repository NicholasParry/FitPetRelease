package nz.geek.nicholasparry.fitpet.PlatformDependant;

public abstract class PlatformPackage {
	public abstract FitnessData getFitnessData();
	public abstract SaveManager getSaveData();
	public abstract PlatformHandler getPlatformHandler();
}
