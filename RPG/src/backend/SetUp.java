package backend;
import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JFileChooser;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;




public class SetUp implements Serializable{
	public static String directory;
	public static boolean dirDone;
	public static boolean censor;
	private String dirLoc;
	private boolean dirFin;
	private boolean dCensor;
	public SetUp(boolean dd,String d,boolean dc)
	 {
	    dirLoc = d;
	    dirFin = dd;
	    dCensor = dc;
	 }
	 public static void newDirectory()
	  {
		
			    JFileChooser chooser = null;
			    LookAndFeel previousLF = UIManager.getLookAndFeel();
			    try {
			        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			        chooser = new JFileChooser();
			        UIManager.setLookAndFeel(previousLF);
			    } catch ( ClassNotFoundException  e) {
                } catch (UnsupportedLookAndFeelException e){
                } catch (InstantiationException e){
                } catch (IllegalAccessException e){}




			   
				//Add whatever other settings you want to the method
			   
			
		 //JFileChooser fileChooser = new JFileChooser();
		    if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
		      File newDir = chooser.getSelectedFile();
		      System.out.print(newDir);
		      newDir.mkdir();
		      directory = newDir.getAbsolutePath();
		      System.out.print(newDir.getAbsolutePath());
		      dirDone = true;
		      File f = new File(SetUp.directory + "/saves");
	    	  f.mkdir();
		      // save to file
		    }
		    dirDone = true;
	   SetUp s = new SetUp(dirDone,directory,censor);
	      try {
	    	  String appData = System.getenv("APPDATA");
	      	
	    	  File f = new File(appData + "/.manaquest");
	    	  f.mkdir();
	       FileOutputStream fileOut = new FileOutputStream(f + "/setUp.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(s);
	         out.close();
	         fileOut.close();
	         System.out.printf("Directory saved.");
	      }catch(IOException i) {
	         i.printStackTrace();
	      }
	    }
	  public static void loadDirectory()
	  {
		  String appData = System.getenv("APPDATA");
	      SetUp s = null;
	      try {
	    	  FileInputStream fileIn = new FileInputStream(appData+ "/.manaquest/setUp.ser");
	    	 //InputStream fileIn = SetUp.class.getResourceAsStream("C:/Users/home/AppData/Roaming/.manaquest/setUp.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         s = (SetUp) in.readObject();
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
	      dirDone = s.dirFin;
	      System.out.println(dirDone);
	      directory = s.dirLoc;
	      censor = s.dCensor;
	    }
	
}
