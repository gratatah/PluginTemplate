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

	}

}