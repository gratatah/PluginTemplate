package org.mineacademy.template;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.mineacademy.fo.plugin.SimplePlugin;

/**
 * PluginTemplate is a simple template you can use every time you make
 * a new plugin. This will save you time because you no longer have to
 * recreate the same skeleton and features each time.
 * <p>
 * It uses Foundation for fast and efficient development process.
 */
public final class PluginTemplate extends SimplePlugin {

	/**
	 * Automatically perform login ONCE when the plugin starts.
	 */
	@Override
	protected void onPluginStart() {

		//int result = 4;
		//System.out.println(result); //This spits out 4

		//result = result + 5; //(using result as a reference)
		//System.out.println(result); //This spits out 9

		//result = 4 + 5;
		//System.out.println(result); //This spits out 9

		//System.out.println("Modulo: " + (15 % 4)); // 15/4 = 3.75 (take the 3 remove the .75) 3*4 = 12. 15-12 = 3

		int apples = 5;
		apples += 5; // adds 5
		++apples; // adds 1
		apples *= 4; // multiplies apples (11) by 4
		System.out.println(apples); //44
		apples /= 4; //divides it by 4
		System.out.println(apples); //sout apples again (11)

		int test = 999;
		int test2 = 991;

		if (test != test2) {
			System.out.println("999 does not equal 991 lol");
			System.out.println("test test test");
		} else if (5 == 5) {
			System.out.println("5 does equal 5");
			System.out.println("test2 test2 test2");
		} else {
			System.out.println("999 equals 991 dont ask me how");
			System.out.println("you should never see this message!!!");
		}

		boolean result1 = test == test2;
		boolean result2 = test != test2;
		boolean result3 = test > test2;
		boolean result4 = test < test2;
		boolean result5 = test >= test2;
		boolean result6 = test <= test2;


		// String testing123123 = "Hello";
		// testing123123 = "another testing123123";

		/*
		These lines will be printed out in the console when
		the server loads the plugin
		 */

		// System.out.println(1);
		// System.out.println("Hello " + 1 + " Knock, knock!");
		// System.out.println(1 + 1 + 100 / 10);

	}


	/* ------------------------------------------------------------------------------- */
	/* Events */
	/* ------------------------------------------------------------------------------- */

	/**
	 * An example event that checks if the right clicked entity is a cow, and makes an explosion.
	 * You can write your events to your main class without having to register a listener.
	 *
	 * @param event
	 */
	@EventHandler
	public void onRightClick(PlayerInteractEntityEvent event) {

		// Sheep
		if (event.getRightClicked().getType() == EntityType.SHEEP)
			event.getRightClicked().setInvulnerable(true);
		if (event.getRightClicked().getType() == EntityType.SHEEP)
			event.getRightClicked().getWorld().createExplosion(event.getRightClicked().getLocation(), 3);
		// Enderman
		if (event.getRightClicked().getType() == EntityType.ENDERMAN)
			event.getRightClicked().setCustomName("test");
		// Chicken
		if (event.getRightClicked().getType() == EntityType.CHICKEN)
			event.getRightClicked().setFireTicks(2 * 20);
		// Pig
		if (event.getRightClicked().getType() == EntityType.PIG)
			event.getRightClicked().setGlowing(true);
		// Squid
		if (event.getRightClicked().getType() == EntityType.SQUID)
			event.getRightClicked().setGravity(false);

	}

}