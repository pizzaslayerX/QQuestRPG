package backpack;

import java.io.Serializable;

import gameplay.Shoppable;

public class Item implements Serializable,Shoppable{
		private String name,description;
		private int price;
		
		public Item(String n,String desc,int pr) {
			name = n;
			description = desc;
			price = pr;
		}

		
		@Override
		public int sell() {
			return (int)(price * 0.33);
		}

		@Override
		public int buy() {
			return price;
		}

		@Override
		public String getDesc() {
			// TODO Auto-generated method stub
			
			return description;
		}

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return name;
		}
		
		public static final class Material{
			public static final Item string() {
				return new Item("String","A strong and light substance produced by specific arachnids and worms.",20);
			}
			public static final Item darkGoo() {
				return new Item("Dark Goo","The left over essence of foul creatures.",10);
			}
			public static final Item darkDust() {
				return new Item("Dark Dust","Dark Goo that has been refined into an evil powder",70);
			}
			public static final Item teslaCoil() {
				return new Item("Tesla Coil","An ancient compact coil of advanced circuitry.",165);
			}
			public static final Item fireTear(){
				return new Item("Flaming Tear","A rare Item extracted from the eye ducts of fiery demons.",280);
			}
			public static final Item claw() {
				return new Item("Claw","Sharp claw made from bone.",50);

			}
			public static final Item lesserSoul() {
				return new Item("Lesser Soul","A weak soul that glows faintly.",15);
			}
			public static final Item greaterSoul() {
				return new Item("Greater Soul","A large soul that glows brightly.",50);
			}
			public static final Item uberSoul() {
				return new Item("Uber Soul","A very powerful soul that can hardly be contained.",120);
			}
		}
}
