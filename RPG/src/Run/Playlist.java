package Run;

public class Playlist
{
  public static Sounds[] songBank = new Sounds[2];
  public static Sounds[] buttonBank = new Sounds[20];
  public static Sounds[] cursorBank = new Sounds[20];
  public static int ind = 0,cVal = 0;
  public static void playSong(String n)
  {
	  
      if(songBank[0] != null)
      {
          songBank[0].stop(0);
          Sounds.storage[0].stop();
          Main.Story.pause(100);
          Sounds.storage[0].close();
          Sounds chose = new Sounds(n,-2);
          songBank[0] = chose;
          songBank[0].play(0);
          songBank[0].loop(0);
        }
      else if(songBank[0] == null)
      {
          Sounds chose = new Sounds(n,-2);
          songBank[0] = chose;
          songBank[0].play(0);
          songBank[0].loop(0);
        }
        
    }
  
   public static void playEffect(String n)
  {
      
      if(songBank[1] != null)
      {
          songBank[1].stop(1);
          Sounds.storage[1].stop();
          Main.Story.pause(100);
          Sounds.storage[1].close();
          Sounds chose = new Sounds(n,-1);
          songBank[1] = chose;
          songBank[1].play(1);
        }
      else if(songBank[1] == null)
      {
          Sounds chose = new Sounds(n,-1);
          songBank[1] = chose;
          songBank[1].play(1);
        }
        
    }
    
  public static void startButton(String n)
  {
	  
      boolean done = false;
      for(int i = 0;i<20;i++)
      {
          if(buttonBank[i] == null && done == false)
          {
              ind = i;
          Sounds bing = new Sounds(n,i);
          buttonBank[i] = bing;
          buttonBank[i].playButton(i);
          done = true;
         }
         if(i == 19 && buttonBank[19] != null && done == false)
         {
             ind = i;
             for(int e = 0;e<20;e++)
            {
               buttonBank[e] = null;
            }
            Sounds bing = new Sounds(n,0);
            buttonBank[0] = bing;
            buttonBank[0].playButton(0);
            done = true;
            }
      }
      
    }
  
    public static void closeButton(int t)
    {
    	
        for(int i = 0;i<t;i++)
            {
               buttonBank[i] = null;
            }
        for(int i = 0;i<t;i++) {
            Sounds.button[i].stop();
            Main.Story.pause(100);
            Sounds.button[i].close();
        }
    }
    
    public static void playCursor() {
    	cursorBank[cVal].clip.setFramePosition(0);
    	cursorBank[cVal].clip.start();
    	cVal++;
    	cVal %= 19;
    }
    
    public static void init() {
    	for(int i = 0;i<cursorBank.length;i++) {
    		cursorBank[i] = new Sounds("/sounds/Cursor.wav",5);
    		cursorBank[i].clip.setFramePosition(cursorBank[i].clip.getFrameLength());
    		cursorBank[i].clip.start();
    	}
    }
    
  public static void stopSong() {
	  
      Sounds.storage[0].stop();
      Sounds.storage[0].close();
      
    }
    
}
