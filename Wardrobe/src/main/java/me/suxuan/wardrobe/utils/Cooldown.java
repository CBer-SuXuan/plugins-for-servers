package me.suxuan.wardrobe.utils;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class Cooldown {
	public static HashMap<UUID, Double> cooldowns;

	public Cooldown() {
	}

	public static void setupCooldown() {
		cooldowns = new HashMap();
	}

	public static void setCooldown(Player player, double seconds) {
		double delay = (double) (System.currentTimeMillis() + (long) (seconds * 1000));
		cooldowns.put(player.getUniqueId(), delay);
	}

	public static boolean checkCooldown(Player player) {
		return !cooldowns.containsKey(player.getUniqueId()) || cooldowns.get(player.getUniqueId()) <= (double) System.currentTimeMillis();
	}
}
