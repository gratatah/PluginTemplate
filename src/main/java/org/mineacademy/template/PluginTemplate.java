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

		//Below is a loop that states the starting number is one and doesnt stop the loop until it is < 10
		for (int number = 1; number < 10; number++) {
			System.out.println("THE NUMBER IS: " + number);
		}

		//Below the number of apples is declared to be 1, then it adds 1 until it gets to 10 apples then once its 10 apples it prints "We have 10 apples now"
		int apples = 1;
		while (apples < 10) {
			System.out.println("Less than 10 apples! Adding 1: " + apples);
			++apples;
			if (apples == 10) {
				System.out.println("Okay we have 10 apples now, we can chill");
			}
		}

		//Below makes a new list of player ids.
		int[] playerIds = new int[]{1, 2, 3, 4};
		//Below is a loop for listing all the player ids. Once it lists all playerIds, it stops the loop
		for (int playerId : playerIds) {
			System.out.println("ID: " + playerId);
		}
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
		// Villager
		if (event.getRightClicked().getType() == EntityType.VILLAGER)
			event.getRightClicked().setGravity(false);

	}

}