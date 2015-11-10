package com.bitquest.bitquest;

import com.google.gson.JsonObject;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.World;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.meta.FireworkMeta;

/**
 * Created by explodi on 11/7/15.
 */
public class EntityEvents implements Listener {
    BitQuest bitQuest;
    StringBuilder welcome = new StringBuilder();

    public EntityEvents(BitQuest plugin) {
        bitQuest = plugin;

        for(String line : bitQuest.getConfig().getStringList("welcomeMessage")) {
        	for (ChatColor color : ChatColor.values()) {
        		line.replaceAll("<"+color.name()+">", color.toString());
        	}
        	welcome.append(line);
    	}
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        User user=new User(event.getPlayer());
    	if(!event.getPlayer().hasPlayedBefore()) {
        	// welcomes new player(maybe add a tutorial?)
        	Firework work = (Firework) event.getPlayer().getWorld().spawnEntity(event.getPlayer().getLocation(), EntityType.FIREWORK);
        	FireworkMeta workMeta = work.getFireworkMeta();
        	FireworkEffect effect = FireworkEffect.builder().flicker(true).withColor(Color.YELLOW).withFade(Color.YELLOW).with(Type.BALL_LARGE).trail(true).build();
        	workMeta.addEffect(effect);
        	workMeta.setPower(0);
        	work.setFireworkMeta(workMeta);
    	}
    	event.getPlayer().sendMessage(welcome.toString());
    	for(String test : bitQuest.getConfig().getStringList("welcomeMessage")) {
    		event.getPlayer().sendMessage("output: " + test);
    	}
    }
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        // announce new area
        World world = event.getPlayer().getWorld();
        if (world.getName().endsWith("_nether") == false && world.getName().endsWith("_the_end") == false) {
            JsonObject newarea = bitQuest.areaForLocation(event.getTo());
            JsonObject oldarea = bitQuest.areaForLocation(event.getFrom());
            if ((oldarea==null && newarea!=null)||(oldarea!=null&&newarea==null)) {
                if (newarea == null) {
                    event.getPlayer().sendMessage(ChatColor.YELLOW + "[ the wilderness ]");
                } else {
                    event.getPlayer().sendMessage(ChatColor.YELLOW + "[ " + newarea.get("name").getAsString() + " ]");
                }
            }
        }
    }
}