package Run;
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import Ability.Passives.Scan;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.*;
import Monsters.MonsterManager;
import Main.Player;

public class MainFightPanel extends JPanel {
	public static int direction;
	public static boolean select,playerTurn,targetSelect;
	    public static JTextPane enemyStatOutput,user;
	    public FlowLayout layout;
	    public JLabel label;
	    public static JLabel picSpace;
	    public JPanel fightPanel;
	    public static JPanel picArea,enemy;
	    KeyHandler keyHandler = new KeyHandler(this);
	
	MainFightPanel(String pic) throws Exception{
		super();
		this.add(init(pic));
		this.setBackground(Color.BLACK);
	}
	
    
	public static int playerGUI() {
		user.setText("");
		playerTurn = true;
		clearDisplay();
		
	       direction = 1;
	         append(user,"\n===========\n",Color.WHITE,21,true);
	         append(user,  "  Attack  <   \n",Color.WHITE,21,true);
	         append(user,  "===========\n",Color.WHITE,21,true);
	           append(user,"===========\n",Color.WHITE,21,true);
	           append(user,"  Special    \n",Color.WHITE,21,true);
	           append(user,"===========\n",Color.WHITE,21,true);
	           append(user,"===========\n",Color.WHITE,21,true);
	           append(user,"   Items    \n",Color.WHITE,21,true);
	           append(user,"===========\n",Color.WHITE,21,true);
	           append(user,"===========\n",Color.WHITE,21,true);
	           append(user,"   Stats    \n",Color.WHITE,21,true);
	           append(user,"===========\n",Color.WHITE,21,true);
	           append(user,"===========\n",Color.WHITE,21,true);
	           append(user,"   Pass    \n",Color.WHITE,21,true);
	           append(user,"===========\n",Color.WHITE,21,true);
	           select = false;
	           while(select == false)
	       {
	        	   System.out.println("KeyHandler Looping");
	           if(direction == 1)
	           {
	        	   user.setText("");
	        	   clearDisplay();
	        	 append(user,"\n===========\n",Color.WHITE,21,true);
	  	         append(user,  "  Attack  <   \n",Color.WHITE,21,true);
	  	         append(user,  "===========\n",Color.WHITE,21,true);
	  	           append(user,"===========\n",Color.WHITE,21,true);
	  	           append(user,"  Special    \n",Color.WHITE,21,true);
	  	           append(user,"===========\n",Color.WHITE,21,true);
	  	           append(user,"===========\n",Color.WHITE,21,true);
	  	           append(user,"   Items    \n",Color.WHITE,21,true);
	  	           append(user,"===========\n",Color.WHITE,21,true);
	  	           append(user,"===========\n",Color.WHITE,21,true);
	  	           append(user,"   Stats    \n",Color.WHITE,21,true);
	  	           append(user,"===========\n",Color.WHITE,21,true);
	  	           append(user,"===========\n",Color.WHITE,21,true);
	  	           append(user,"   Pass    \n",Color.WHITE,21,true);
	  	           append(user,"===========\n",Color.WHITE,21,true);
	               direction = -5;
	            }
	           if(direction == 2)
	           {
	        	   user.setText("");
	        	   clearDisplay();
	        	 append(user,"\n===========\n",Color.WHITE,21,true);
	  	         append(user,  "  Attack     \n",Color.WHITE,21,true);
	  	         append(user,  "===========\n",Color.WHITE,21,true);
	  	           append(user,"===========\n",Color.WHITE,21,true);
	  	           append(user,"  Special <   \n",Color.WHITE,21,true);
	  	           append(user,"===========\n",Color.WHITE,21,true);
	  	           append(user,"===========\n",Color.WHITE,21,true);
	  	           append(user,"   Items    \n",Color.WHITE,21,true);
	  	           append(user,"===========\n",Color.WHITE,21,true);
	  	           append(user,"===========\n",Color.WHITE,21,true);
	  	           append(user,"   Stats    \n",Color.WHITE,21,true);
	  	           append(user,"===========\n",Color.WHITE,21,true);
	  	           append(user,"===========\n",Color.WHITE,21,true);
	  	           append(user,"   Pass    \n",Color.WHITE,21,true);
	  	           append(user,"===========\n",Color.WHITE,21,true);
	               direction = -4;
	            }
	           if(direction == 3)
	           {
	        	   user.setText("");
	        	   clearDisplay();
	        	 append(user,"\n===========\n",Color.WHITE,21,true);
	  	         append(user,  "  Attack     \n",Color.WHITE,21,true);
	  	         append(user,  "===========\n",Color.WHITE,21,true);
	  	           append(user,"===========\n",Color.WHITE,21,true);
	  	           append(user,"  Special     \n",Color.WHITE,21,true);
	  	           append(user,"===========\n",Color.WHITE,21,true);
	  	           append(user,"===========\n",Color.WHITE,21,true);
	  	           append(user,"   Items  <  \n",Color.WHITE,21,true);
	  	           append(user,"===========\n",Color.WHITE,21,true);
	  	           append(user,"===========\n",Color.WHITE,21,true);
	  	           append(user,"   Stats    \n",Color.WHITE,21,true);
	  	           append(user,"===========\n",Color.WHITE,21,true);
	  	           append(user,"===========\n",Color.WHITE,21,true);
	  	           append(user,"   Pass    \n",Color.WHITE,21,true);
	  	           append(user,"===========\n",Color.WHITE,21,true);
	               direction = -3;
	            }
	           if(direction == 4)
	           {
	        	   user.setText("");
	        	   clearDisplay();
	        	 append(user,"\n===========\n",Color.WHITE,21,true);
	  	         append(user,  "  Attack     \n",Color.WHITE,21,true);
	  	         append(user,  "===========\n",Color.WHITE,21,true);
	  	           append(user,"===========\n",Color.WHITE,21,true);
	  	           append(user,"  Special    \n",Color.WHITE,21,true);
	  	           append(user,"===========\n",Color.WHITE,21,true);
	  	           append(user,"===========\n",Color.WHITE,21,true);
	  	           append(user,"   Items    \n",Color.WHITE,21,true);
	  	           append(user,"===========\n",Color.WHITE,21,true);
	  	           append(user,"===========\n",Color.WHITE,21,true);
	  	           append(user,"   Stats  <  \n",Color.WHITE,21,true);
	  	           append(user,"===========\n",Color.WHITE,21,true);
	  	           append(user,"===========\n",Color.WHITE,21,true);
	  	           append(user,"   Pass    \n",Color.WHITE,21,true);
	  	           append(user,"===========\n",Color.WHITE,21,true);
	               direction = -2;
	            }
	           if(direction == 5)
	           {
	        	   user.setText("");
	        	   clearDisplay();
	        	 append(user,"\n===========\n",Color.WHITE,21,true);
	  	         append(user,  "  Attack     \n",Color.WHITE,21,true);
	  	         append(user,  "===========\n",Color.WHITE,21,true);
	  	           append(user,"===========\n",Color.WHITE,21,true);
	  	           append(user,"  Special    \n",Color.WHITE,21,true);
	  	           append(user,"===========\n",Color.WHITE,21,true);
	  	           append(user,"===========\n",Color.WHITE,21,true);
	  	           append(user,"   Items    \n",Color.WHITE,21,true);
	  	           append(user,"===========\n",Color.WHITE,21,true);
	  	           append(user,"===========\n",Color.WHITE,21,true);
	  	           append(user,"   Stats    \n",Color.WHITE,21,true);
	  	           append(user,"===========\n",Color.WHITE,21,true);
	  	           append(user,"===========\n",Color.WHITE,21,true);
	  	           append(user,"   Pass   < \n",Color.WHITE,21,true);
	  	           append(user,"===========\n",Color.WHITE,21,true);
	               direction = -1;
	            }
	        }
		
	        playerTurn = false;
		return direction;
	}
	
	public static void clearDisplay() {
		user.setText("");
		if(Player.health < 0)
			Player.health = 0;
		if(Player.health > Player.maxHealth)
			Player.health = Player.maxHealth;
		append(user,"Player Health: " + Player.health + "/" + Player.maxHealth + "\n");
		pHealthDisplay();
		if(Player.maxMana > 0 && Player.scene > 5) {
			if(Player.mana < 0)
				Player.mana = 0;
			if(Player.mana > Player.maxMana)
				Player.mana = Player.maxMana;
		append(user,"\n");
		append(user,"Player Mana: " + Player.mana + "/" + Player.maxMana + "\n");
		manaDisplay();
		}
	}
	
	public static void clearEnemyDisplay() {
		enemyStatOutput.setText("");
		Ability.Passives.Scan.use();
	}
	
	public static void pHealthDisplay() {
		if(Player.health < 0)
			Player.health = 0;
		if(Player.health > Player.maxHealth)
			Player.health = Player.maxHealth;
		int totalCount = 30;
		double percentHealth = (double)Player.health / (double)Player.maxHealth;
		int greenCount = (int)(totalCount * percentHealth);
			for(int i = 0;i < totalCount;i++) {
				if(i < greenCount)
					append(user,"-",Color.GREEN,30,true);
				else
					append(user,"-",Color.RED,30,true);
			}
	
	}
	
public static void manaDisplay() {
	if(Player.mana < 0)
		Player.mana = 0;
	if(Player.mana > Player.maxMana)
		Player.mana = Player.maxMana;
		int totalCount = 16;
		double percentHealth = (double)Player.mana / (double)Player.maxMana;
		int greenCount = (int)(totalCount * percentHealth);
			for(int i = 0;i < totalCount;i++) {
				if(i < greenCount)
					append(user,"-",Color.BLUE,30,true);
				else
					append(user,"-",Color.BLACK,30,true);
			}
	
	}
	
	public static void healthDisplay() {
		
		int totalCount = 30;
		double percentHealth = (double)MonsterManager.enemies.get(RPGRunner.target).getHealth() / (double)MonsterManager.enemies.get(RPGRunner.target).getMaxHealth();
		int greenCount = (int)(totalCount * percentHealth);
			for(int i = 0;i < totalCount;i++) {
				if(i < greenCount)
					append(enemyStatOutput,"-",Color.GREEN,30,true);
				else
					append(enemyStatOutput,"-",Color.RED,30,true);
			}
	
	}

    
	 public static void append(JTextPane p,String n) {
	    	
	    	StyledDocument doc = p.getStyledDocument();

	    SimpleAttributeSet keyWord = new SimpleAttributeSet();
	    StyleConstants.setForeground(keyWord, Color.WHITE);
	       try
	    	{
	    	   doc.insertString(doc.getLength(),n, keyWord);
	    	} catch(Exception e) { 
	    		System.out.println(e);}
	    }
	
	  public static void append(JTextPane p, String n, Color c,int size, boolean bold) {
	    	
	    	StyledDocument doc = p.getStyledDocument();

	    SimpleAttributeSet keyWord = new SimpleAttributeSet();
	    StyleConstants.setForeground(keyWord,c);
	    StyleConstants.setBold(keyWord, bold);
	    if(size != 0)
	    	StyleConstants.setFontSize(keyWord, size);
	       try
	    	{
	    	   doc.insertString(doc.getLength(),n, keyWord);
	    	} catch(Exception e) { 
	    		System.out.println(e);}
	    }
	
	private JPanel init(String pic) throws Exception {
		    System.out.println("Running");
            fightPanel = new JPanel(true);
		    enemy = new JPanel();
	        enemy.setLayout(new BoxLayout(enemy, BoxLayout.PAGE_AXIS));
	        picArea = new JPanel();      
	        picArea.setLayout(new GridBagLayout());
	        picArea.setBackground(Color.BLACK);
	        user = new JTextPane();
	        enemy.setBackground(Color.BLACK);
	        user.setBackground(Color.BLACK);
	        enemy.setPreferredSize(new Dimension(570,580));
	        enemy.setMinimumSize(new Dimension(570,580));
	        enemy.setMaximumSize(new Dimension(570,580));
	        user.setPreferredSize(new Dimension(1270-enemy.getWidth()-600,580));
	        user.setMaximumSize(new Dimension(1270-enemy.getWidth()-600,580));
	        user.setMinimumSize(new Dimension(1270-enemy.getWidth()-600,580));
	        user.setFont(new Font("Monospaced", Font.PLAIN, 20));
	        user.addKeyListener(keyHandler);
	        user.setEditable(false);
	        
	        enemyStatOutput = new JTextPane();
	        enemyStatOutput.setEditable(false);
	        enemyStatOutput.setPreferredSize(new Dimension(570,50));
	        enemyStatOutput.setBackground(Color.BLACK);
	        enemyStatOutput.setForeground(Color.white);
	        enemyStatOutput.setFont(new Font("Monospaced", Font.PLAIN, 20));
	        enemyStatOutput.setEditable(false);
	        
	        picArea.setPreferredSize(new Dimension(570,enemy.getHeight() / 2 + 40));
	        picArea.setMinimumSize(new Dimension(570,enemy.getHeight() / 2 + 40));
	       BufferedImage image = ImageIO.read(new File("src/pics/" + pic));	
	         picSpace = new JLabel(new ImageIcon(image));
	        picArea.add(picSpace);
	        enemy.add(enemyStatOutput);
	        enemy.add(picArea);
	        
	        
	        fightPanel.setLayout(new FlowLayout());
	        
	        fightPanel.add(enemy);
	        fightPanel.add(user);
	        fightPanel.setBackground(Color.BLACK);
	        return fightPanel;
		
	}
	
	public static void changePic(String pic) throws IOException {
		enemy.remove(picArea);
		picArea.remove(picSpace);
		 BufferedImage image = ImageIO.read(new File("src/pics/" + pic));
		 picSpace = new JLabel(new ImageIcon(image));
		 picArea.add(picSpace);
		 enemy.add(picArea);
	}
	
	 public static void checkDirection(int min,int max,int d)
	    {
	    direction = direction + d + max;
	    if(direction < min)
	        direction = max - 1;
	    if(direction == (max))
	         direction = min;
	        
	 }
	 
	 public static boolean getTarget() throws IOException {  
	    	direction = 1;
	    	
	    	select = false;
	    	targetSelect = true;
	    	boolean back = false;
	    	int holder = 0;
	    	if(MonsterManager.enemies.size() == 1) {
	    		targetSelect = false;
	    		return true;
	    	}
	    	MainFightPanel.clearDisplay();
	    	

	    	while(select == false) {
	    		System.out.println(MonsterManager.enemies.size());
	    		if(holder != direction) {
	    			user.setText("");
	    			clearDisplay();

	    			MainFightPanel.append(MainFightPanel.user,"\n~Select Target~\n\n",Color.WHITE,30,false);
	    			for(int i = 0;i<=MonsterManager.enemies.size();i++) {
	    			  if(i<MonsterManager.enemies.size()) {
	    				if(direction == i+1) {
	    					append(user,MonsterManager.enemies.get(i).getName() + "\n",Color.WHITE,25,true);
	    						RPGRunner.target = i;
	    	    			
	    				}
	    				else
	    					append(user,MonsterManager.enemies.get(i).getName() + "\n",Color.GRAY,25,false);
	    			   }
	    			  }
	    			  if(direction == MonsterManager.enemies.size()+1) {
	    				  append(user,"<--Back",Color.WHITE,25,true);
	    				  back = true;
	    			   } else {
	    				  append(user,"<--Back",Color.GRAY,25,false);
	    				  changePic(MonsterManager.enemies.get(RPGRunner.target).getPic());
	    				  back = false;
	    			   }
	    			Scan.use();
	    			direction = direction - MonsterManager.enemies.size() - 2;
	    			holder = direction;
	    		}
	    		
	    	}
	    	MainFightPanel.clearDisplay();
	    	targetSelect = false;
	    	if(back == true)
	    		return false;
	    	return true;
	    }

	 public static void checkEnter(boolean b)
	 {
	    select = b;
	 }
	 
	 public static void textEffect(JTextPane p,String n,Color c,int s,boolean b)
	 {
	     for(int i = 0;i<n.length();i++)
	     {
	       append(p,n.substring(i,i+1),c,s,b);
	       Main.Story.pause(10);
	     }
	 }
	 
}
