package nz.geek.nicholasparry.fitpet.PlatformDependant;

public abstract class PlatformHandler {
	
	/**
	 * Logs a message to the platform haNDLER. tHIS IS USED FOR SENDING A MESSAGE BACK TO THE DEVELOPER
	 * @param tag tag for message
	 * @param message the actual freaking message
	 */
	public abstract void logFatal(String tag, String message);
}
