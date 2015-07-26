package nz.geek.nicholasparry.fitpet;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

import nz.geek.nicholasparry.fitpet.Player;
import nz.geek.nicholasparry.fitpet.PlatformDependant.SaveManager;

public class AndroidSaveManager extends SaveManager {

	private Preferences prefs;
	
	public AndroidSaveManager() {
		prefs = Gdx.app.getPreferences("fitpetPrefs");
	}

	@Override
	public Player getPlayer() {
		prefs = Gdx.app.getPreferences("fitpetPrefs");
		Player player = null;
		try{
			ByteArrayInputStream bs = new ByteArrayInputStream(prefs.getString("save").getBytes("UTF_8"));
			ObjectInputStream in = new ObjectInputStream(bs);
			player = (Player) in.readObject();
			in.close();
			bs.close();
		}catch(ClassNotFoundException c){
			c.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (NullPointerException e){
			e.printStackTrace();
		}
		return player;
	}

	@Override
	public boolean savePlayer(Player _player) {
		try{
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(bos);
			
			out.writeObject(_player);
			String toSave = bos.toString();
			prefs.putString("save", toSave);
			
			out.close();
			bos.close();
		} catch (IOException i){
			System.out.println(i);
		}
		
		
		
		return false;
	}

	@Override
	public boolean autoLoad() {
		// TODO Auto-generated method stub
		return false;
	}

}
