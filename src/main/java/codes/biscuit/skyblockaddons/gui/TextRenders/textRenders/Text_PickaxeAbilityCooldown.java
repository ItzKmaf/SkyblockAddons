package codes.biscuit.skyblockaddons.gui.TextRenders.textRenders;

import codes.biscuit.skyblockaddons.SkyblockAddons;
import codes.biscuit.skyblockaddons.core.Feature;
import codes.biscuit.skyblockaddons.event.EventHandler;
import codes.biscuit.skyblockaddons.event.io.ChatReceivedEvent;
import codes.biscuit.skyblockaddons.event.io.SkyblockJoinEvent;
import codes.biscuit.skyblockaddons.event.io.TickEvent;
import codes.biscuit.skyblockaddons.gui.TextRenders.TextRender;
import codes.biscuit.skyblockaddons.gui.titles.Title_MiningAbilityAvailable;
import codes.biscuit.skyblockaddons.misc.ChromaManager;
import codes.biscuit.skyblockaddons.utils.ItemUtils;
import codes.biscuit.skyblockaddons.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import codes.biscuit.skyblockaddons.event.EventListener;

import java.util.List;

public class Text_PickaxeAbilityCooldown implements TextRender, EventListener {
	
	private Minecraft mc = Minecraft.getMinecraft();
	private long lastHeld = -1;
	private long cooldownTime = -1;
	private long abilityTime = -1;
	private boolean shownWarn, deletedWarn = false;
	private Title_MiningAbilityAvailable title = new Title_MiningAbilityAvailable();
	
	public Text_PickaxeAbilityCooldown() {
		SkyblockAddons.getInstance().getEventBus().register(this);
	}
	
	@EventHandler
	public void onSkyblockJoin(SkyblockJoinEvent skyblockJoinEvent) {
		lastHeld = -1;
		cooldownTime = System.currentTimeMillis() + 60000;
		abilityTime = -1;
		shownWarn = deletedWarn = false;
	}
	
	@EventHandler
	public void onChatReceived(ChatReceivedEvent chatReceivedEvent) {
		if (chatReceivedEvent.getChatMessage().equals("§r§aYou used your §r§6Mining Speed Boost §r§aPickaxe Ability!§r")) {
			if (!deletedWarn) {
				SkyblockAddons.getInstance().getRenderListener().clearTitle(title, false);
				deletedWarn = true;
			}
			ItemStack item = mc.thePlayer.getHeldItem();
			ItemAbility itemAbility = getHeldTool(item);
			abilityTime = System.currentTimeMillis() + (itemAbility.getAbilityTime(ItemUtils.getItemLore(item)) * 1000);
			cooldownTime = System.currentTimeMillis() + (itemAbility.getCooldown(ItemUtils.getItemLore(item)) * 1000);
		} else if (chatReceivedEvent.getChatMessage().equals("§r§cYour Mining Speed Boost has expired!§r")) {
			ItemStack item = mc.thePlayer.getHeldItem();
			ItemAbility itemAbility = getHeldTool(item);
			abilityTime = System.currentTimeMillis();
			cooldownTime = System.currentTimeMillis() +
					((itemAbility.getCooldown(ItemUtils.getItemLore(item)) - itemAbility.getAbilityTime(ItemUtils.getItemLore(item))) * 1000);
		} else if (chatReceivedEvent.getChatMessage().equals("§r§6Mining Speed Boost §r§ais now available!§r")) {
			ItemStack item = mc.thePlayer.getHeldItem();
			ItemAbility itemAbility = getHeldTool(item);
			abilityTime = System.currentTimeMillis() - (itemAbility.getAbilityTime(ItemUtils.getItemLore(item)) * 1000);
			cooldownTime = System.currentTimeMillis();
			shownWarn = true;
			deletedWarn = false;
			SkyblockAddons.getInstance().getRenderListener().setDisplayedTitle(title);
		}
		
		
	}
	
	@EventHandler
	public void onTick(TickEvent tickEvent) {
		if (mc.thePlayer == null) {
			return;
		}
		ItemAbility itemAbility = getHeldTool(mc.thePlayer.getHeldItem());
		if (itemAbility == null) {
			return;
		}
		lastHeld = System.currentTimeMillis();
		// Clear Warning if it has been displayed for 2 seconds
		if (cooldownTime + 2000 < System.currentTimeMillis() && !deletedWarn && shownWarn) {
			deletedWarn = true;
			SkyblockAddons.getInstance().getRenderListener().clearTitle(title, false);
		}
	}
	
	@Override
	public String getText() {
		// If a tool with ability was held over 10 seconds ago and the cooldown expired over 10 seconds ago do not show.
		if (System.currentTimeMillis() - lastHeld > 5000 && cooldownTime + 10000 < System.currentTimeMillis()) {
			return null;
		}
		// If ability is currently active
		if (abilityTime > System.currentTimeMillis()) {
			return "Mining ability active for: " + ((abilityTime - System.currentTimeMillis()) /1000) + "s";
		}
		// If cooldown is currently in progress
		if (cooldownTime > System.currentTimeMillis()) {
			return "Mining Ability ready in: " + ((cooldownTime - System.currentTimeMillis()) /1000) + "s";
		}
		// Mining ability available
		return "Mining Ability Available!";
	}
	
	@Override
	public int getWidth(int existingWidth) {
		return existingWidth;
	}
	
	@Override
	public int getHeight(int existingHeight) {
		return existingHeight;
	}
	
	@Override
	public void render(String text, float x, float y, int color) {
		ChromaManager.renderingText(getOwner());
		SkyblockAddons.getInstance().getUtils().drawTextWithStyle(text, x, y, color);
		ChromaManager.doneRenderingText();
	}
	
	@Override
	public Feature getOwner() {
		return Feature.PICKAXE_ABILITY_COOLDOWN;
	}
	
	public ItemAbility getHeldTool(ItemStack item) {
		if (item == null) {
			return null;
		}
		List<String> lore = ItemUtils.getItemLore(item);
		if (lore.contains("§6Item Ability: Mining Speed Boost §e§lRIGHT CLICK")) {
			return ItemAbility.SPEED_BOOST;
		}
		return null;
	}
	
	enum ItemAbility {
		SPEED_BOOST("Mining Speed Boost"),
		PICKOBULUS("Pickobulus");
		
		String name;
		
		ItemAbility(String name) {
			this.name = name;
		}
		
		int getCooldown(List<String> lore) {
			for (String loreLine: lore) {
				if (loreLine.startsWith("§8Cooldown: §a")) {
					loreLine = loreLine.replace("§8Cooldown: §a", "");
					loreLine = loreLine.replace("s", "");
					try {
						return Integer.parseInt(loreLine);
					} catch (NumberFormatException numberFormatException) {
						break;
					}
				}
			}
			return -1;
		}
		
		int getAbilityTime(List<String> lore) {
			for (String loreLine: lore) {
				if (loreLine.startsWith("§6Speed §7for §a")) {
					loreLine = loreLine.replace("§6Speed §7for §a", "");
					loreLine = loreLine.replace("s§7.", "");
					try {
						return Integer.parseInt(loreLine);
					} catch (NumberFormatException numberFormatException) {
						break;
					}
				}
			}
			return -1;
		}
	}
}
