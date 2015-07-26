package engine.config;

public class Config {
	public static int VIEW_WIDTH = 640;
	public static int VIEW_HEIGHT = 360;
	public static boolean FULLSCREEN = true;
	
	public Config() {
		// TODO Auto-generated constructor stub
	}

	public static int getVIEW_WIDTH() {
		return VIEW_WIDTH;
	}

	public static int getVIEW_HEIGHT() {
		return VIEW_HEIGHT;
	}

	public static boolean isFULLSCREEN() {
		return FULLSCREEN;
	}

	public static void setVIEW_WIDTH(int _VIEW_WIDTH) {
		VIEW_WIDTH = _VIEW_WIDTH;
	}

	public static void setVIEW_HEIGHT(int _VIEW_HEIGHT) {
		VIEW_HEIGHT = _VIEW_HEIGHT;
	}

	public static void setFULLSCREEN(boolean _FULLSCREEN) {
		FULLSCREEN = _FULLSCREEN;
	}
}
