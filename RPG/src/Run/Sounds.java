package Run;

    
    import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.*;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sounds{
    public static Clip[] storage = new Clip[2];
    public static Clip[] button = new Clip[20];
    public Clip clip;
    public static int type;
    public String fileName;
    public Sounds(String fileName,int t) {
        // specify the sound to play
        // (assuming the sound can be played by the audio system)
        // from a wave File
       
        type = t;
       try {
            //File file = new File(fileName);
              AudioInputStream sound = AudioSystem.getAudioInputStream(Sounds.class.getResource(fileName));
            		
                System.out.print(sound);
             // load the sound into memory (a Clip)
              clip = AudioSystem.getClip();
            if(type < 0)
            {
              if(type == -2)
              {
              storage[0] = clip;
               storage[0].open(sound);
             }
             else
              {
              storage[1] = clip;
               storage[1].open(sound);
             }
            }else if(type == 5) {
            	clip.open(sound);
            }
            	
            else
            {
                button[type] = clip;
                button[type].open(sound);
                
            }
               if(type == -1)
              {
               FloatControl gainControl = (FloatControl) storage[1].getControl(FloatControl.Type.MASTER_GAIN);
               gainControl.setValue(6.0f);
            }
               
            if(fileName.equals("/sounds/Casino.wav"))
            {
               FloatControl gainControl = (FloatControl) storage[0].getControl(FloatControl.Type.MASTER_GAIN);
               gainControl.setValue(-10.0f); 
            }
            
            
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("Sound: Malformed URL: " + e);
        }
        catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
            throw new RuntimeException("Sound: Unsupported Audio File: " + e);
        }
        catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Sound: Input/Output Error: " + e);
        }
        catch (LineUnavailableException e) {
            e.printStackTrace();
            throw new RuntimeException("Sound: Line Unavailable Exception Error: " + e);
        }
        catch (java.lang.NullPointerException e) {
            e.printStackTrace();
            throw new RuntimeException("Sound: Resource Error :/ " + e);
        }

    // play, stop, loop the sound clip
    
    
    }
    public void play(int t){
        storage[t].setFramePosition(0);  // Must always rewind!
        storage[t].start();
    }
    public void loop(int t){
        storage[t].loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(int t){
            storage[t].stop();
            storage[t].close();

        }
    public void playButton(int t) {
        button[t].setFramePosition(0);
        button[t].start();
    }
    
    
        
     public  static void enterStart() {
      
     Playlist.startButton("/sounds/Enter.wav");
     Playlist.closeButton(Playlist.ind);
}

    
public  static void cancelStart() {

  Playlist.startButton("/sounds/Cancel.wav");
  Playlist.closeButton(Playlist.ind);
}

    
    
    
 public static void cursorStart()
 {
	// Playlist.startButton("/sounds/Cursor.wav");
   Playlist.playCursor();
}
    
    
    

    }
    
    
    
    
    
    
    

    
    
    
    
    
    
    
    
    
    
    
    
    
