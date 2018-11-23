package Main;
import java.io.*;

import Run.SetUp;
public class Save implements Serializable

{
    private String[] saveInfo;
  public Save(String [] si)
  {
      saveInfo = si;
   }
  
  public static void saveFile(String[] n)
  {
   Save s = new Save(n);
      try {
    	  
       FileOutputStream fileOut = new FileOutputStream(SetUp.directory + "/saves/SaveScreen.ser");
    	  
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(s);
         out.close();
         fileOut.close();
         System.out.printf("Save screen saved.");
      }catch(IOException i) {
         i.printStackTrace();
      }
    }
  public static void loadFile()
  {
      Save s = null;
      try {
         FileInputStream fileIn = new FileInputStream(SetUp.directory + "/saves/SaveScreen.ser");
    	  //InputStream fileIn = Save.class.getResourceAsStream(SetUp.directory + "\\SaveScreen.ser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         s = (Save) in.readObject();
         in.close();
         fileIn.close();
      }catch(IOException i) {
         i.printStackTrace();
         return;
      }catch(ClassNotFoundException c) {
         System.out.println("Save Screen not found!!!");
         c.printStackTrace();
         return;
      }
      Player.saveGameInfo = s.saveInfo;
    }
}
