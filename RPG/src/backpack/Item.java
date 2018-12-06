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
			public static final Item lightGoo() {
				return new Item("Light Goo","The left over essence of holy creatures.",10);
			}
			public static final Item ligthDust() {
				return new Item("Light Dust","Light Goo that has been refined into an holy powder",70);
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
			public static final Item blueBall() {
				return new Item("BlueBall","A blue ball, that's about it.",20);
			}
			public static final Item redBall() {
				return new Item("RedBall","A red ball, no explanation needed.",30);
			}
			public static final Item greenBall() {
				return new Item("GreenBall","A green ball, no questions asked.",40);
			}
			public static final Item purpleBall() {
				return new Item("PurpleBall","A purple ball, slightly shinier than usual.",80);
			}
			public static final Item qCube() {
				return new Item("Q-Cube","Essence of God: Q-Type.",150);
			}
			public static final Item uCube() {
				return new Item("U-Cube","Essence of God: U-Type.",150);
			}
			public static final Item iCube() {
				return new Item("I-Cube","Essence of God: I-Type.",150);
			}
			public static final Item nCube() {
				return new Item("N-Cube","Essence of God: N-Type.",150);
			}
			public static final Item cCube() {
				return new Item("C-Cube","Essence of God: C-Type.",150);
			}
			public static final Item yCube() {
				return new Item("Y-Cube","Essence of God: Y-Type.",150);
			}
			public static final Item minotaurHorn() {
				return new Item("Minotaur Horn","Horn gathered from a fallen minotaur, very sturdy.",20);
			}
			public static final Item voidSalts() {
				return new Item("Void Salts","Solidified wind from the Void Dimension.",45);
			}
			public static final Item boneMeal() {
				return new Item("Bone Meal","Powdered monster bones.",45);
			}
			public static final Item ironIngot() {
				return new Item("Iron Ingot","Simple Iron Ingot.",10);
			}
			public static final Item copperIngot() {
				return new Item("Copper Ingot","Simple Copper Ingot.",40);
			}
			public static final Item steelIngot() {
				return new Item("Steel Ingot","Shiny Steel Ingot.",70);
			}
			public static final Item wood() {
				return new Item("Wood","Sturdy piece of Wood.",10);
			}
			public static final Item slugTooth() {
				return new Item("Slug Tooth","Very malleable tooth dropped by a slug.",20);
			}
			public static final Item clownAshes() {
				return new Item("Clown Ashes","The remenants of a fallen clown.",20);
			}
			public static final Item confetti() {
				return new Item("Confetti","Pieces of plastic gethered excusivley from Baloon Imps.",40);
			}
			public static final Item pokerChip() {
				return new Item("Poker Chip","No Actual Value, it's just a chip.",20);
			}
			public static final Item oil() {
				return new Item("Oil","Sticky black substance.",10);
			}
			public static final Item rustyNail() {
				return new Item("Rusty Nail","Nail found in the Dwarven Mine Shaft.",20);
			}
			public static final Item pristineNail() {
				return new Item("Pristine Nail","Shiny nail found in Dwarven Mine Shaft.",40);
			}
			public static final Item dwarvenIngot() {
				return new Item("Dwarven Ingot","Strong metal that only the dwarves can make.",70);
			}
			public static final Item coal() {
				return new Item("coal","black rock made of compressed animals.",20);
			}
			public static final Item archangelRune() {
				return new Item("Archangel Rune","Mysterious stone kept by all Archangels.",1000);
			}
			public static final Item dwarvenScrap() {
				return new Item("Dwarven Scrap","Metal junk, no real purpose by itself.",5);
			}
			public static final Item bottle() {
				return new Item("Bottle","Glass bottle, usually used to make potions.",70);
			}
			public static final Item circutBoard() {
				return new Item("Circuit Board","Ancient board consisting of complex circuitry.",200);
			}
			public static final Item demonSoul() {
				return new Item("Demon Soul","Pretty self explanatory, be careful with it.",250);
			}
			public static final Item phoenixFeathers() {
				return new Item("Phoenix Feathers","An eternally flaming feather taken from a Phoenix.",125);
			}
			public static final Item wolfHeart() {
				return new Item("Wolf Heart","The heart of a brave wolf.",60);
			}
			public static final Item jasmineFlower() {
				return new Item("Jasmine Flower","Harmless blue flower that is only lethal to rabbits.",20);
			}
			public static final Item penguinSkin() {
				return new Item("Penguin Skin","The skin of a warrior penguin.",20);
			}
			public static final Item polymer() {
				return new Item("Polymer","Thin metal sheet, extremley durable.",30);
			}
			public static final Item organicPolymer() {
				return new Item("Organic Polymer","Similar to actual polymer, but gathered from the insides of penguins",60);
			}
			public static final Item sacrificialKnife() {
				return new Item("Sacrificial Knife","Sacrifical knife used by the dwarves, no combat ability.",90);
			}
			public static final Item dwarvenCrystal() {
				return new Item("Dwarven Crystal","Mysterious crystal that is always glowing.",180);
			}
			public static final Item dragonEye() {
				return new Item("Dragon Eye","The eye of a lesser dragon.",100);
			}
			public static final Item spiderLeg() {
				return new Item("Spider Leg","One of the legs of a powerful cave spider.",45);
			}
			public static final Item stone() {
				return new Item("Stone","A combination of the minerals quartz, feldspar and biotite, in other words, a rock.",10);
			}
			public static final Item rubber() {
				return new Item("Rubber","Melted and reformed latex.",15);
			}
			public static final Item sulfur() {
				return new Item("Sulfur","Yellow crystaline solid with a very strong smell.",20);
			}
			public static final Item quartz() {
				return new Item("Quartz","Somewhat clear crystal structure, comes in many shapes.",45);
			}
			public static final Item feces() {
				return new Item("Feces","The droppings of animals found in the forest.",2);
			}
			public static final Item giantFungus() {
				return new Item("Giant Fungus","Weird fungus found between a giant's toes, magical properties.",80);
			}
			public static final Item glass() {
				return new Item("Glass","Reformed liquid sand.",60);
			}
			public static final Item perpetualGyro() {
				return new Item("Perpetual Gyro","A gyroscopic device that hasn't stopped turning for the past 100 years.",300);
			}
			
			
		}
}
