package org.mineacademy.template;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.mineacademy.fo.plugin.SimplePlugin;
import org.mineacademy.fo.remain.CompMaterial;

import java.util.*;

public final class PluginTemplate extends SimplePlugin {

	private final List<Material> rewards = new ArrayList<>(Arrays.asList(
			Material.DIAMOND,
			Material.IRON_AXE,
			Material.NETHER_STAR
	));

	private final Map<String, String> lastPlayerMessage = new HashMap<>();

	@Override
	protected void onPluginStart() {

	}

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

		try {
			if (event.getClickedBlock().getType() == CompMaterial.GRASS_BLOCK.getMaterial()) {
				handleClickingGrass(event.getClickedBlock(), event.getPlayer());
			}
		} catch (NullPointerException ex) { //Hiding
		}
	}

	void handleClickingGrass(Block block, Player player) {
		block.setType(CompMaterial.DIAMOND_BLOCK.getMaterial());
		player.sendMessage("You've turned this grass block into a diamond!");
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		PlayerInventory inventory = player.getInventory();
		Collections.shuffle(this.rewards);
		inventory.addItem(new ItemStack(this.rewards.get(0)));
	}


	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		String playerName = player.getName();
		String message = event.getMessage();

		String lastMessage = this.lastPlayerMessage.get(playerName);

		if (lastMessage != null && lastMessage.equalsIgnoreCase(message)) {
			player.sendMessage(ChatColor.RED + "Please don't repeat the same message. " + message);

			event.setCancelled(true);
		} else
			this.lastPlayerMessage.put(playerName, message);

	}


}