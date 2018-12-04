package weapon;

import java.io.Serializable;

public class Weapon implements Serializable{
	public String modifier;
    public int dmg;
    public int bonusDmg;
    public int crit;
    public String aName;
    public String triggerMsg;
    public int price;
    public int[] ability = new int[4];
    public String name;
    public String desc;
    
    public Weapon(String n, int d, int c, int p,String dc,int[] a,String an,String tm) {
    	name = n;
        dmg = d;
        crit = c;
        price = p;
        desc = dc;
        ability = a;
        modifier= "";
        aName = an;
        triggerMsg = tm;
        name = n;
    }
}
