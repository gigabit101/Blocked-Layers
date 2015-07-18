package mrriegel.blockedlayers.utility;

import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class Hashmaps {

	public static HashMap<String, Item> ItemHash = new HashMap<String, Item>();
	public static HashMap<String, Block> BlockHash = new HashMap<String, Block>();
	public static HashMap<String, Class> EntityHash = new HashMap<String, Class>();

	public static void initItem() {
		ItemHash.put("iron_shovel", Items.iron_shovel);
		ItemHash.put("iron_pickaxe", Items.iron_pickaxe);
		ItemHash.put("iron_axe", Items.iron_axe);
		ItemHash.put("flint_and_steel", Items.flint_and_steel);
		ItemHash.put("apple", Items.apple);
		ItemHash.put("bow", Items.bow);
		ItemHash.put("arrow", Items.arrow);
		ItemHash.put("coal", Items.coal);
		ItemHash.put("diamond", Items.diamond);
		ItemHash.put("iron_ingot", Items.iron_ingot);
		ItemHash.put("gold_ingot", Items.gold_ingot);
		ItemHash.put("iron_sword", Items.iron_sword);
		ItemHash.put("wooden_sword", Items.wooden_sword);
		ItemHash.put("wooden_shovel", Items.wooden_shovel);
		ItemHash.put("wooden_pickaxe", Items.wooden_pickaxe);
		ItemHash.put("wooden_axe", Items.wooden_axe);
		ItemHash.put("stone_sword", Items.stone_sword);
		ItemHash.put("stone_shovel", Items.stone_shovel);
		ItemHash.put("stone_pickaxe", Items.stone_pickaxe);
		ItemHash.put("stone_axe", Items.stone_axe);
		ItemHash.put("diamond_sword", Items.diamond_sword);
		ItemHash.put("diamond_shovel", Items.diamond_shovel);
		ItemHash.put("diamond_pickaxe", Items.diamond_pickaxe);
		ItemHash.put("diamond_axe", Items.diamond_axe);
		ItemHash.put("stick", Items.stick);
		ItemHash.put("bowl", Items.bowl);
		ItemHash.put("mushroom_stew", Items.mushroom_stew);
		ItemHash.put("golden_sword", Items.golden_sword);
		ItemHash.put("golden_shovel", Items.golden_shovel);
		ItemHash.put("golden_pickaxe", Items.golden_pickaxe);
		ItemHash.put("golden_axe", Items.golden_axe);
		ItemHash.put("string", Items.string);
		ItemHash.put("feather", Items.feather);
		ItemHash.put("gunpowder", Items.gunpowder);
		ItemHash.put("wooden_hoe", Items.wooden_hoe);
		ItemHash.put("stone_hoe", Items.stone_hoe);
		ItemHash.put("iron_hoe", Items.iron_hoe);
		ItemHash.put("diamond_hoe", Items.diamond_hoe);
		ItemHash.put("golden_hoe", Items.golden_hoe);
		ItemHash.put("wheat_seeds", Items.wheat_seeds);
		ItemHash.put("wheat", Items.wheat);
		ItemHash.put("bread", Items.bread);
		ItemHash.put("leather_helmet", Items.leather_helmet);
		ItemHash.put("leather_chestplate", Items.leather_chestplate);
		ItemHash.put("leather_leggings", Items.leather_leggings);
		ItemHash.put("leather_boots", Items.leather_boots);
		ItemHash.put("chainmail_helmet", Items.chainmail_helmet);
		ItemHash.put("chainmail_chestplate", Items.chainmail_chestplate);
		ItemHash.put("chainmail_leggings", Items.chainmail_leggings);
		ItemHash.put("chainmail_boots", Items.chainmail_boots);
		ItemHash.put("iron_helmet", Items.iron_helmet);
		ItemHash.put("iron_chestplate", Items.iron_chestplate);
		ItemHash.put("iron_leggings", Items.iron_leggings);
		ItemHash.put("iron_boots", Items.iron_boots);
		ItemHash.put("diamond_helmet", Items.diamond_helmet);
		ItemHash.put("diamond_chestplate", Items.diamond_chestplate);
		ItemHash.put("diamond_leggings", Items.diamond_leggings);
		ItemHash.put("diamond_boots", Items.diamond_boots);
		ItemHash.put("golden_helmet", Items.golden_helmet);
		ItemHash.put("golden_chestplate", Items.golden_chestplate);
		ItemHash.put("golden_leggings", Items.golden_leggings);
		ItemHash.put("golden_boots", Items.golden_boots);
		ItemHash.put("flint", Items.flint);
		ItemHash.put("porkchop", Items.porkchop);
		ItemHash.put("cooked_porkchop", Items.cooked_porkchop);
		ItemHash.put("painting", Items.painting);
		ItemHash.put("golden_apple", Items.golden_apple);
		ItemHash.put("sign", Items.sign);
		ItemHash.put("wooden_door", Items.wooden_door);
		ItemHash.put("bucket", Items.bucket);
		ItemHash.put("water_bucket", Items.water_bucket);
		ItemHash.put("lava_bucket", Items.lava_bucket);
		ItemHash.put("minecart", Items.minecart);
		ItemHash.put("saddle", Items.saddle);
		ItemHash.put("iron_door", Items.iron_door);
		ItemHash.put("redstone", Items.redstone);
		ItemHash.put("snowball", Items.snowball);
		ItemHash.put("boat", Items.boat);
		ItemHash.put("leather", Items.leather);
		ItemHash.put("milk_bucket", Items.milk_bucket);
		ItemHash.put("brick", Items.brick);
		ItemHash.put("clay_ball", Items.clay_ball);
		ItemHash.put("reeds", Items.reeds);
		ItemHash.put("paper", Items.paper);
		ItemHash.put("book", Items.book);
		ItemHash.put("slime_ball", Items.slime_ball);
		ItemHash.put("chest_minecart", Items.chest_minecart);
		ItemHash.put("furnace_minecart", Items.furnace_minecart);
		ItemHash.put("egg", Items.egg);
		ItemHash.put("compass", Items.compass);
		ItemHash.put("fishing_rod", Items.fishing_rod);
		ItemHash.put("clock", Items.clock);
		ItemHash.put("glowstone_dust", Items.glowstone_dust);
		ItemHash.put("fish", Items.fish);
		ItemHash.put("cooked_fish", Items.cooked_fished);
		ItemHash.put("dye", Items.dye);
		ItemHash.put("bone", Items.bone);
		ItemHash.put("sugar", Items.sugar);
		ItemHash.put("cake", Items.cake);
		ItemHash.put("bed", Items.bed);
		ItemHash.put("repeater", Items.repeater);
		ItemHash.put("cookie", Items.cookie);
		ItemHash.put("filled_map", Items.filled_map);
		ItemHash.put("shears", Items.shears);
		ItemHash.put("melon", Items.melon);
		ItemHash.put("pumpkin_seeds", Items.pumpkin_seeds);
		ItemHash.put("melon_seeds", Items.melon_seeds);
		ItemHash.put("beef", Items.beef);
		ItemHash.put("cooked_beef", Items.cooked_beef);
		ItemHash.put("chicken", Items.chicken);
		ItemHash.put("cooked_chicken", Items.cooked_chicken);
		ItemHash.put("rotten_flesh", Items.rotten_flesh);
		ItemHash.put("ender_pearl", Items.ender_pearl);
		ItemHash.put("blaze_rod", Items.blaze_rod);
		ItemHash.put("ghast_tear", Items.ghast_tear);
		ItemHash.put("gold_nugget", Items.gold_nugget);
		ItemHash.put("nether_wart", Items.nether_wart);
		ItemHash.put("potionitem", Items.potionitem);
		ItemHash.put("glass_bottle", Items.glass_bottle);
		ItemHash.put("spider_eye", Items.spider_eye);
		ItemHash.put("fermented_spider_eye", Items.fermented_spider_eye);
		ItemHash.put("blaze_powder", Items.blaze_powder);
		ItemHash.put("magma_cream", Items.magma_cream);
		ItemHash.put("brewing_stand", Items.brewing_stand);
		ItemHash.put("cauldron", Items.cauldron);
		ItemHash.put("ender_eye", Items.ender_eye);
		ItemHash.put("speckled_melon", Items.speckled_melon);
		ItemHash.put("spawn_egg", Items.spawn_egg);
		ItemHash.put("experience_bottle", Items.experience_bottle);
		ItemHash.put("fire_charge", Items.fire_charge);
		ItemHash.put("writable_book", Items.writable_book);
		ItemHash.put("written_book", Items.written_book);
		ItemHash.put("emerald", Items.emerald);
		ItemHash.put("item_frame", Items.item_frame);
		ItemHash.put("flower_pot", Items.flower_pot);
		ItemHash.put("carrot", Items.carrot);
		ItemHash.put("potato", Items.potato);
		ItemHash.put("baked_potato", Items.baked_potato);
		ItemHash.put("poisonous_potato", Items.poisonous_potato);
		ItemHash.put("map", Items.map);
		ItemHash.put("golden_carrot", Items.golden_carrot);
		ItemHash.put("skull", Items.skull);
		ItemHash.put("carrot_on_a_stick", Items.carrot_on_a_stick);
		ItemHash.put("nether_star", Items.nether_star);
		ItemHash.put("pumpkin_pie", Items.pumpkin_pie);
		ItemHash.put("fireworks", Items.fireworks);
		ItemHash.put("firework_charge", Items.firework_charge);
		ItemHash.put("enchanted_book", Items.enchanted_book);
		ItemHash.put("comparator", Items.comparator);
		ItemHash.put("netherbrick", Items.netherbrick);
		ItemHash.put("quartz", Items.quartz);
		ItemHash.put("tnt_minecart", Items.tnt_minecart);
		ItemHash.put("hopper_minecart", Items.hopper_minecart);
		ItemHash.put("iron_horse_armor", Items.iron_horse_armor);
		ItemHash.put("golden_horse_armor", Items.golden_horse_armor);
		ItemHash.put("diamond_horse_armor", Items.diamond_horse_armor);
		ItemHash.put("lead", Items.lead);
		ItemHash.put("name_tag", Items.name_tag);
		ItemHash.put("command_block_minecart", Items.command_block_minecart);
		ItemHash.put("record_13", Items.record_13);
		ItemHash.put("record_cat", Items.record_cat);
		ItemHash.put("record_blocks", Items.record_blocks);
		ItemHash.put("record_chirp", Items.record_chirp);
		ItemHash.put("record_far", Items.record_far);
		ItemHash.put("record_mall", Items.record_mall);
		ItemHash.put("record_mellohi", Items.record_mellohi);
		ItemHash.put("record_stal", Items.record_stal);
		ItemHash.put("record_strad", Items.record_strad);
		ItemHash.put("record_ward", Items.record_ward);
		ItemHash.put("record_11", Items.record_11);
		ItemHash.put("record_wait", Items.record_wait);

	}

	public static void initBlock() {
		BlockHash.put("air", Blocks.air);
		BlockHash.put("stone", Blocks.stone);
		BlockHash.put("grass", Blocks.grass);
		BlockHash.put("dirt", Blocks.dirt);
		BlockHash.put("cobblestone", Blocks.cobblestone);
		BlockHash.put("planks", Blocks.planks);
		BlockHash.put("sapling", Blocks.sapling);
		BlockHash.put("bedrock", Blocks.bedrock);
		BlockHash.put("flowing_water", Blocks.flowing_water);
		BlockHash.put("water", Blocks.water);
		BlockHash.put("flowing_lava", Blocks.flowing_lava);
		BlockHash.put("lava", Blocks.lava);
		BlockHash.put("sand", Blocks.sand);
		BlockHash.put("gravel", Blocks.gravel);
		BlockHash.put("gold_ore", Blocks.gold_ore);
		BlockHash.put("iron_ore", Blocks.iron_ore);
		BlockHash.put("coal_ore", Blocks.coal_ore);
		BlockHash.put("log", Blocks.log);
		BlockHash.put("log2", Blocks.log2);
		BlockHash.put("leaves", Blocks.leaves);
		BlockHash.put("leaves2", Blocks.leaves2);
		BlockHash.put("sponge", Blocks.sponge);
		BlockHash.put("glass", Blocks.glass);
		BlockHash.put("lapis_ore", Blocks.lapis_ore);
		BlockHash.put("lapis_block", Blocks.lapis_block);
		BlockHash.put("dispenser", Blocks.dispenser);
		BlockHash.put("sandstone", Blocks.sandstone);
		BlockHash.put("noteblock", Blocks.noteblock);
		BlockHash.put("bed", Blocks.bed);
		BlockHash.put("golden_rail", Blocks.golden_rail);
		BlockHash.put("detector_rail", Blocks.detector_rail);
		BlockHash.put("sticky_piston", Blocks.sticky_piston);
		BlockHash.put("web", Blocks.web);
		BlockHash.put("tallgrass", Blocks.tallgrass);
		BlockHash.put("deadbush", Blocks.deadbush);
		BlockHash.put("piston", Blocks.piston);
		BlockHash.put("piston_head", Blocks.piston_head);
		BlockHash.put("wool", Blocks.wool);
		BlockHash.put("piston_extension", Blocks.piston_extension);
		BlockHash.put("yellow_flower", Blocks.yellow_flower);
		BlockHash.put("red_flower", Blocks.red_flower);
		BlockHash.put("brown_mushroom", Blocks.brown_mushroom);
		BlockHash.put("red_mushroom", Blocks.red_mushroom);
		BlockHash.put("gold_block", Blocks.gold_block);
		BlockHash.put("iron_block", Blocks.iron_block);
		BlockHash.put("double_stone_slab", Blocks.double_stone_slab);
		BlockHash.put("stone_slab", Blocks.stone_slab);
		BlockHash.put("brick_block", Blocks.brick_block);
		BlockHash.put("tnt", Blocks.tnt);
		BlockHash.put("bookshelf", Blocks.bookshelf);
		BlockHash.put("mossy_cobblestone", Blocks.mossy_cobblestone);
		BlockHash.put("obsidian", Blocks.obsidian);
		BlockHash.put("torch", Blocks.torch);
		BlockHash.put("fire", Blocks.fire);
		BlockHash.put("mob_spawner", Blocks.mob_spawner);
		BlockHash.put("oak_stairs", Blocks.oak_stairs);
		BlockHash.put("chest", Blocks.chest);
		BlockHash.put("redstone_wire", Blocks.redstone_wire);
		BlockHash.put("diamond_ore", Blocks.diamond_ore);
		BlockHash.put("diamond_block", Blocks.diamond_block);
		BlockHash.put("crafting_table", Blocks.crafting_table);
		BlockHash.put("wheat", Blocks.wheat);
		BlockHash.put("farmland", Blocks.farmland);
		BlockHash.put("furnace", Blocks.furnace);
		BlockHash.put("lit_furnace", Blocks.lit_furnace);
		BlockHash.put("standing_sign", Blocks.standing_sign);
		BlockHash.put("wooden_door", Blocks.wooden_door);
		BlockHash.put("ladder", Blocks.ladder);
		BlockHash.put("rail", Blocks.rail);
		BlockHash.put("stone_stairs", Blocks.stone_stairs);
		BlockHash.put("wall_sign", Blocks.wall_sign);
		BlockHash.put("lever", Blocks.lever);
		BlockHash.put("stone_pressure_plate", Blocks.stone_pressure_plate);
		BlockHash.put("iron_door", Blocks.iron_door);
		BlockHash.put("wooden_pressure_plate", Blocks.wooden_pressure_plate);
		BlockHash.put("redstone_ore", Blocks.redstone_ore);
		BlockHash.put("lit_redstone_ore", Blocks.lit_redstone_ore);
		BlockHash.put("unlit_redstone_torch", Blocks.unlit_redstone_torch);
		BlockHash.put("redstone_torch", Blocks.redstone_torch);
		BlockHash.put("stone_button", Blocks.stone_button);
		BlockHash.put("snow_layer", Blocks.snow_layer);
		BlockHash.put("ice", Blocks.ice);
		BlockHash.put("snow", Blocks.snow);
		BlockHash.put("cactus", Blocks.cactus);
		BlockHash.put("clay", Blocks.clay);
		BlockHash.put("reeds", Blocks.reeds);
		BlockHash.put("jukebox", Blocks.jukebox);
		BlockHash.put("fence", Blocks.fence);
		BlockHash.put("pumpkin", Blocks.pumpkin);
		BlockHash.put("netherrack", Blocks.netherrack);
		BlockHash.put("soul_sand", Blocks.soul_sand);
		BlockHash.put("glowstone", Blocks.glowstone);
		BlockHash.put("portal", Blocks.portal);
		BlockHash.put("lit_pumpkin", Blocks.lit_pumpkin);
		BlockHash.put("cake", Blocks.cake);
		BlockHash.put("unpowered_repeater", Blocks.unpowered_repeater);
		BlockHash.put("powered_repeater", Blocks.powered_repeater);
		BlockHash.put("trapdoor", Blocks.trapdoor);
		BlockHash.put("monster_egg", Blocks.monster_egg);
		BlockHash.put("stonebrick", Blocks.stonebrick);
		BlockHash.put("brown_mushroom_block", Blocks.brown_mushroom_block);
		BlockHash.put("red_mushroom_block", Blocks.red_mushroom_block);
		BlockHash.put("iron_bars", Blocks.iron_bars);
		BlockHash.put("glass_pane", Blocks.glass_pane);
		BlockHash.put("melon_block", Blocks.melon_block);
		BlockHash.put("pumpkin_stem", Blocks.pumpkin_stem);
		BlockHash.put("melon_stem", Blocks.melon_stem);
		BlockHash.put("vine", Blocks.vine);
		BlockHash.put("fence_gate", Blocks.fence_gate);
		BlockHash.put("brick_stairs", Blocks.brick_stairs);
		BlockHash.put("stone_brick_stairs", Blocks.stone_brick_stairs);
		BlockHash.put("mycelium", Blocks.mycelium);
		BlockHash.put("waterlily", Blocks.waterlily);
		BlockHash.put("nether_brick", Blocks.nether_brick);
		BlockHash.put("nether_brick_fence", Blocks.nether_brick_fence);
		BlockHash.put("nether_brick_stairs", Blocks.nether_brick_stairs);
		BlockHash.put("nether_wart", Blocks.nether_wart);
		BlockHash.put("enchanting_table", Blocks.enchanting_table);
		BlockHash.put("brewing_stand", Blocks.brewing_stand);
		BlockHash.put("cauldron", Blocks.cauldron);
		BlockHash.put("end_portal", Blocks.end_portal);
		BlockHash.put("end_portal_frame", Blocks.end_portal_frame);
		BlockHash.put("end_stone", Blocks.end_stone);
		BlockHash.put("dragon_egg", Blocks.dragon_egg);
		BlockHash.put("redstone_lamp", Blocks.redstone_lamp);
		BlockHash.put("lit_redstone_lamp", Blocks.lit_redstone_lamp);
		BlockHash.put("double_wooden_slab", Blocks.double_wooden_slab);
		BlockHash.put("wooden_slab", Blocks.wooden_slab);
		BlockHash.put("cocoa", Blocks.cocoa);
		BlockHash.put("sandstone_stairs", Blocks.sandstone_stairs);
		BlockHash.put("emerald_ore", Blocks.emerald_ore);
		BlockHash.put("ender_chest", Blocks.ender_chest);
		BlockHash.put("tripwire_hook", Blocks.tripwire_hook);
		BlockHash.put("tripwire", Blocks.tripwire);
		BlockHash.put("emerald_block", Blocks.emerald_block);
		BlockHash.put("spruce_stairs", Blocks.spruce_stairs);
		BlockHash.put("birch_stairs", Blocks.birch_stairs);
		BlockHash.put("jungle_stairs", Blocks.jungle_stairs);
		BlockHash.put("command_block", Blocks.command_block);
		BlockHash.put("beacon", Blocks.beacon);
		BlockHash.put("cobblestone_wall", Blocks.cobblestone_wall);
		BlockHash.put("flower_pot", Blocks.flower_pot);
		BlockHash.put("carrots", Blocks.carrots);
		BlockHash.put("potatoes", Blocks.potatoes);
		BlockHash.put("wooden_button", Blocks.wooden_button);
		BlockHash.put("skull", Blocks.skull);
		BlockHash.put("anvil", Blocks.anvil);
		BlockHash.put("trapped_chest", Blocks.trapped_chest);
		BlockHash.put("light_weighted_pressure_plate",
				Blocks.light_weighted_pressure_plate);
		BlockHash.put("heavy_weighted_pressure_plate",
				Blocks.heavy_weighted_pressure_plate);
		BlockHash.put("unpowered_comparator", Blocks.unpowered_comparator);
		BlockHash.put("powered_comparator", Blocks.powered_comparator);
		BlockHash.put("daylight_detector", Blocks.daylight_detector);
		BlockHash.put("redstone_block", Blocks.redstone_block);
		BlockHash.put("quartz_ore", Blocks.quartz_ore);
		BlockHash.put("hopper", Blocks.hopper);
		BlockHash.put("quartz_block", Blocks.quartz_block);
		BlockHash.put("quartz_stairs", Blocks.quartz_stairs);
		BlockHash.put("activator_rail", Blocks.activator_rail);
		BlockHash.put("dropper", Blocks.dropper);
		BlockHash.put("stained_hardened_clay", Blocks.stained_hardened_clay);
		BlockHash.put("hay_block", Blocks.hay_block);
		BlockHash.put("carpet", Blocks.carpet);
		BlockHash.put("hardened_clay", Blocks.hardened_clay);
		BlockHash.put("coal_block", Blocks.coal_block);
		BlockHash.put("packed_ice", Blocks.packed_ice);
		BlockHash.put("acacia_stairs", Blocks.acacia_stairs);
		BlockHash.put("dark_oak_stairs", Blocks.dark_oak_stairs);
		BlockHash.put("double_plant", Blocks.double_plant);
		BlockHash.put("stained_glass", Blocks.stained_glass);
		BlockHash.put("stained_glass_pane", Blocks.stained_glass_pane);
	}

	public static void initEntity() {
		EntityHash.put("snowman", EntitySnowman.class);
		EntityHash.put("ironGolem", EntityIronGolem.class);
		EntityHash.put("enderman", EntityEnderman.class);
		EntityHash.put("pigZombie", EntityPigZombie.class);
		EntityHash.put("zombie", EntityZombie.class);
		EntityHash.put("skeleton", EntitySkeleton.class);
		EntityHash.put("spider", EntitySpider.class);
		EntityHash.put("creeper", EntityCreeper.class);
		EntityHash.put("slime", EntitySlime.class);
		EntityHash.put("caveSpider", EntityCaveSpider.class);
		EntityHash.put("silverfish", EntitySilverfish.class);
		EntityHash.put("ghast", EntityGhast.class);
		EntityHash.put("magmaCube", EntityMagmaCube.class);
		EntityHash.put("blaze", EntityBlaze.class);
		EntityHash.put("witch", EntityWitch.class);
		EntityHash.put("dragon", EntityDragon.class);
		EntityHash.put("wither", EntityWither.class);
		EntityHash.put("pig", EntityPig.class);
		EntityHash.put("sheep", EntitySheep.class);
		EntityHash.put("cow", EntityCow.class);
		EntityHash.put("chicken", EntityChicken.class);
		EntityHash.put("squid", EntitySquid.class);
		EntityHash.put("mooshroom", EntityMooshroom.class);
		EntityHash.put("bat", EntityBat.class);
		EntityHash.put("wolf", EntityWolf.class);
		EntityHash.put("horse", EntityHorse.class);
		EntityHash.put("ocelot", EntityOcelot.class);
		EntityHash.put("villager", EntityVillager.class);

	}
}