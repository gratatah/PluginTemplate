package org.mineacademy.template;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.mineacademy.fo.plugin.SimplePlugin;
import org.mineacademy.fo.remain.CompMaterial;

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
		if (event.getRightClicked().getType() == EntityType.SHEEP) {
			event.getRightClicked().getWorld().createExplosion(event.getRightClicked().getLocation(), 3);
		}
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


	@EventHandler
	public void onRightClickAnything(PlayerInteractEvent event) {
		System.out.println("We've started handling clicking event.");

		try {
			if (event.getClickedBlock().getType() == CompMaterial.GRASS_BLOCK.getMaterial()) {
				handleClickingGrass(event.getClickedBlock(), event.getPlayer());
			}
		} catch (NullPointerException ex) {
			System.out.println("Got an NPE");
		} finally {
			System.out.println("...and we're done!");
		}
	}

	void handleClickingGrass(Block block, Player player) {
		block.setType(CompMaterial.DIAMOND_BLOCK.getMaterial());
		player.sendMessage("You've turned this grass block into a diamond!");

		/*
		 *  Can't seem to figure out how to fire these blocks below whenever a player takes damage and I don't want to break anything.
		 *  But this function happens when it "handle's clicking grass" Maybe I need to create a new event, probably
		 *  something called "player taking damage" or something like that. Oh well, I tried. It kinda works lol. Can't wait to learn more!
		 */

		boolean lowOnHealth = player.getHealth() < 2;
		if (lowOnHealth) {
			player.sendMessage("You are low on health!");
		} else {
			player.sendMessage("You're healthy!");
		}
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		PlayerInventory inventory = player.getInventory();
		ItemStack[] contents = inventory.getContents();

		for (int slot = 0; slot < contents.length; slot++) {
			System.out.println("Player's slot " + slot + " has the item: " + contents[slot]);
			ItemStack item = contents[slot];
			boolean isDiamond = item != null && item.getType() == Material.DIAMOND;

			if (item == null || isDiamond) {
				int diamondAmount = isDiamond ? item.getAmount() : 0;
				contents[slot] = new ItemStack(Material.DIAMOND, diamondAmount + 1);
				player.sendMessage("1 Diamond has been added to your " + slot + " slot.");

				break;
			}
		}

		inventory.setContents(contents);

	}

}