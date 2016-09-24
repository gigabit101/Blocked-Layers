package mrriegel.blockedlayers.handler;

import mrriegel.blockedlayers.api.BlockedLayersApi;
import mrriegel.blockedlayers.api.core.Quest;
import mrriegel.blockedlayers.api.core.Reward;
import mrriegel.blockedlayers.old.entity.PlayerInformation;
import mrriegel.blockedlayers.stuff.Statics;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerPickupXpEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.Map.Entry;

public class QuestHandler {

	boolean questValid(PlayerInformation pro, Quest q) {
		if (!ConfigurationHandler.hard)
			return true;
		for (Entry<Integer, Boolean> e : pro.getLayerBools().entrySet()) {
			if (q.getLayer() < e.getKey() && !e.getValue())
				return false;
		}
		return true;
	}

	public void finish(EntityPlayer player, Quest q) {
		PlayerInformation pro = PlayerInformation.get(player);
		String name = q.getName();
		pro.getQuestBools().put(name, true);
		pro.getQuestNums().put(name + "Num", q.getNumber());
		player.addChatMessage(new TextComponentString(I18n.format("bl.quest.done falnfiansfi", name)));
	}

//	@SubscribeEvent
//	public void eatItem(PlayerUseItemEvent.Finish event) {
//		if (event.entityPlayer.worldObj.isRemote)
//			return;
//		EntityPlayer player = event.entityPlayer;
//		PlayerInformation pro = PlayerInformation.get(player);
//		for (Quest q : BlockedLayersApi.questList) {
//			String name = q.getName();
//			if (!q.getActivity().equals("eat") || !questValid(pro, q)
//					|| pro.getQuestBools().get(name)
//					|| player.capabilities.isCreativeMode) {
//				continue;
//			}
//			ItemStack stack;
//			Item target = GameRegistry.findItem(q.getModID(), q.getObject());
//			if (q.getMeta() == -1)
//				stack = new ItemStack(target, 1, event.entityPlayer
//						.getCurrentEquippedItem().getItemDamage());
//			else
//				stack = new ItemStack(target, 1, q.getMeta());
//
//			int number = q.getNumber();
//			int dim = q.getDimentionID();
//
//			if (player.getCurrentEquippedItem().isItemEqual(stack)) {
//				pro.getQuestNums().put(name + "Num",
//						pro.getQuestNums().get(name + "Num") + 1);
//				if (pro.getQuestNums().get(name + "Num") >= number && event.entityPlayer.worldObj.provider.dimensionId == dim) {
//					finish(player, q);
//					Statics.syncTeams(pro.getTeam());
//				}
//			}
//		}
//	}

	@SubscribeEvent
	public void breakBlock(BreakEvent event) {
		if (event.getPlayer().worldObj.isRemote)
			return;
		EntityPlayer player = event.getPlayer();
		PlayerInformation pro = PlayerInformation.get(player);
		for (Quest q : BlockedLayersApi.questList) {
			String name = q.getName();
			if (!q.getActivity().equals("break")
					|| !questValid(pro, q)
					|| pro.getQuestBools().get(name)
					|| player.capabilities.isCreativeMode){}
//					|| (ConfigurationHandler.withoutSilk && EnchantmentHelper.getSilkTouchModifier(player))) {
//				continue;
//			}
//
//			Block target = GameRegistry.findBlock(q.getModID(), q.getObject());
//			int meta;
//			if (q.getMeta() == -1) {
//				meta = event.blockMetadata;
//			} else {
//				meta = q.getMeta();
//			}
//			int number = q.getNumber();
//			int dim = q.getDimentionID();
//
//			if (event.block.equals(target) && event.blockMetadata == meta)
//			{
//				pro.getQuestNums().put(name + "Num", pro.getQuestNums().get(name + "Num") + 1);
//				if (pro.getQuestNums().get(name + "Num") >= number && event.world.provider.dimensionId == dim)
//				{
//					finish(player, q);
//					Statics.syncTeams(pro.getTeam());
//				}
//			}
		}
	}

	@SubscribeEvent
	public void kill(LivingDeathEvent event) {
		if (event.getEntityLiving().worldObj.isRemote
				|| !(event.getSource().getEntity() instanceof EntityPlayer))
			return;
		EntityPlayer player = (EntityPlayer) event.getSource().getEntity();
		PlayerInformation pro = PlayerInformation.get(player);
		for (Quest q : BlockedLayersApi.questList) {
			String name = q.getName();
			if (!q.getActivity().equals("kill") || !questValid(pro, q)
					|| pro.getQuestBools().get(name)
					|| player.capabilities.isCreativeMode) {
				continue;
			}

//			Class target = (Class) EntityList.getIDFromString(q.getObject());

			int number = q.getNumber();
			int meta = q.getMeta();
			int dim = q.getDimentionID();
			Entity e = event.getEntity();

//			if (target.isInstance(e) && (!(e instanceof EntitySkeleton)))
//            {
//				pro.getQuestNums().put(name + "Num",
//						pro.getQuestNums().get(name + "Num") + 1);
//				if (pro.getQuestNums().get(name + "Num") >= number && event.getEntityLiving().worldObj.provider.getDimension() == dim) {
//					finish(player, q);
//					Statics.syncTeams(pro.getTeam());
//				}
//			}
		}
	}

	@SubscribeEvent
	public void harvest(HarvestDropsEvent event) {
		if (event.getWorld().isRemote)
			return;
		EntityPlayer player = event.getHarvester();
		if (player == null)
			return;
		PlayerInformation pro = PlayerInformation.get(player);
		for (Quest q : BlockedLayersApi.questList) {
			String name = q.getName();
			if (!q.getActivity().equals("harvest") || !questValid(pro, q)
					|| pro.getQuestBools().get(name)
					|| player.capabilities.isCreativeMode) {
				continue;
			}
			ItemStack target = null;
			Item targetItem = GameRegistry
					.findItem(q.getModID(), q.getObject());
			for (ItemStack stack : event.getDrops()) {
				if (q.getMeta() == -1)
					target = new ItemStack(targetItem, 1, stack.getItemDamage());
				else
					target = new ItemStack(targetItem, 1, q.getMeta());
				int number = q.getNumber();
				int dim = q.getDimentionID();

				if (target.isItemEqual(stack)) {
					pro.getQuestNums().put(
							name + "Num",
							pro.getQuestNums().get(name + "Num")
									+ stack.copy().stackSize);
					if (pro.getQuestNums().get(name + "Num") >= number && event.getWorld().provider.getDimension() == dim) {
						finish(player, q);
						Statics.syncTeams(pro.getTeam());
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void loot(LivingDropsEvent event) {
		if (event.getEntityLiving().worldObj.isRemote
				|| !(event.getSource().getEntity() instanceof EntityPlayer))
			return;
		EntityPlayer player = (EntityPlayer) event.getSource().getEntity();
		PlayerInformation pro = PlayerInformation.get(player);
		for (Quest q : BlockedLayersApi.questList) {
			String name = q.getName();
			if (!q.getActivity().equals("loot") || !questValid(pro, q)
					|| pro.getQuestBools().get(name)
					|| player.capabilities.isCreativeMode) {
				continue;
			}

			ItemStack target = null;
			Item targetItem = GameRegistry
					.findItem(q.getModID(), q.getObject());
			for (EntityItem item : event.getDrops()) {
				ItemStack stack = item.getEntityItem().copy();
				if (q.getMeta() == -1)
					target = new ItemStack(targetItem, 1, stack.getItemDamage());
				else
					target = new ItemStack(targetItem, 1, q.getMeta());
				int number = q.getNumber();
				int dim = q.getDimentionID();

				if (target.isItemEqual(stack)) {
					pro.getQuestNums().put(
							name + "Num",
							pro.getQuestNums().get(name + "Num")
									+ stack.stackSize);
					if (pro.getQuestNums().get(name + "Num") >= number && event.getEntityLiving().worldObj.provider.getDimension() == dim) {
						finish(player, q);
						Statics.syncTeams(pro.getTeam());
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void own(PlayerInteractEvent event) {
		if (event.getWorld().isRemote)
			return;
		EntityPlayer player = event.getEntityPlayer();
		PlayerInformation pro = PlayerInformation.get(player);
		for (Quest q : BlockedLayersApi.questList) {
			String name = q.getName();
			if ((!q.getActivity().equals("own") && !q.getActivity().equals(
					"consume"))
					|| !questValid(pro, q)
					|| pro.getQuestBools().get(name)
					|| player.capabilities.isCreativeMode) {
				continue;
			}
			ItemStack target = null;
			Item targetItem = GameRegistry
					.findItem(q.getModID(), q.getObject());
			int meta = 0;
			int num = 0;
			for (int i = 0; i < player.inventory.mainInventory.length; i++) {
				if (player.inventory.mainInventory[i] == null)
					continue;
				ItemStack stack = player.inventory.mainInventory[i].copy();
				if (q.getMeta() == -1) {
					meta = OreDictionary.WILDCARD_VALUE;
					if (targetItem.equals(stack.getItem()))
						num += stack.stackSize;
				} else {
					meta = q.getMeta();
					if (stack.isItemEqual(new ItemStack(targetItem, 1, q
							.getMeta())))
						num += stack.stackSize;
				}
			}

			if (num >= q.getNumber()) {
				if (q.getActivity().equals("consume")) {
					consumeInventoryItem(player.inventory, targetItem, meta,
							q.getNumber());
					player.inventoryContainer.detectAndSendChanges();
				}
				finish(player, q);
				Statics.syncTeams(pro.getTeam());
			}
		}
	}

	private boolean consumeInventoryItem(IInventory inv, Item item, int meta,
			int num) {
		Integer[] i = getSlotsWith(inv, item, meta);
		for (int s : i) {
			ItemStack stack = inv.getStackInSlot(s);
			if (stack.stackSize > num) {
				return decrStackSize(inv, s, num);
			} else if (stack.stackSize == num) {
				inv.setInventorySlotContents(s, null);
				return true;
			} else {
				if (s != i[i.length - 1])
					inv.setInventorySlotContents(s, null);
				num -= stack.stackSize;
			}
		}
		return false;
	}

	private Integer[] getSlotsWith(IInventory inv, Item item, int meta) {
		ArrayList<Integer> ar = new ArrayList<Integer>();
		for (int i = 0; i < inv.getSizeInventory()
				- ((inv instanceof InventoryPlayer) ? 4 : 0); ++i) {
			ItemStack stack = inv.getStackInSlot(i);
			if (stack != null
					&& stack.getItem().equals(item)
					&& (stack.getItemDamage() == meta || meta == OreDictionary.WILDCARD_VALUE)) {
				ar.add(i);
			}
		}
		return ar.toArray(new Integer[ar.size()]);
	}

	private boolean decrStackSize(IInventory inv, int slot, int num) {
		ItemStack stack = inv.getStackInSlot(slot);
		if (stack == null || stack.stackSize < num)
			return false;
		if (stack.stackSize == num) {
			inv.setInventorySlotContents(slot, null);
			inv.markDirty();
			return true;
		} else {
			stack.stackSize -= num;
			inv.setInventorySlotContents(slot, stack);
			inv.markDirty();
			return true;
		}
	}

	@SubscribeEvent
	public void xp(PlayerPickupXpEvent event) {
		if (event.getEntityPlayer().worldObj.isRemote)
			return;
		EntityPlayer player = event.getEntityPlayer();
		PlayerInformation pro = PlayerInformation.get(player);
		for (Quest q : BlockedLayersApi.questList) {
			String name = q.getName();
			if (!q.getActivity().equals("xp") || !questValid(pro, q)
					|| pro.getQuestBools().get(name)
					|| player.capabilities.isCreativeMode) {
				continue;
			}

			int number = q.getNumber();

			pro.getQuestNums().put(name + "Num",
					pro.getQuestNums().get(name + "Num") + event.getOrb().xpValue);
			if (pro.getQuestNums().get(name + "Num") >= number) {
				finish(player, q);
				Statics.syncTeams(pro.getTeam());
			}
		}
	}

	@SubscribeEvent
	public void find(PlayerInteractEvent event) {
		if (event.getEntityPlayer().worldObj.isRemote)
			return;
		EntityPlayer player = event.getEntityPlayer();
		PlayerInformation pro = PlayerInformation.get(player);
//		String currentBiom = event.getWorld().getWorldChunkManager().getBiomeGenAt(
//				event.x, event.z).biomeName;
		for (Quest q : BlockedLayersApi.questList) {
			String name = q.getName();
			if (!q.getActivity().equals("find") || !questValid(pro, q)
					|| pro.getQuestBools().get(name)
					|| player.capabilities.isCreativeMode) {
				continue;
			}
			String biom = q.getObject();
//			if (biom.equalsIgnoreCase(currentBiom)) {
//				finish(player, q);
//				Statics.syncTeams(pro.getTeam());
//			}
		}
	}

	//TODO shift click fix
	@SubscribeEvent
	public void craft(PlayerEvent.ItemCraftedEvent event) {
		if (event.player.worldObj.isRemote)
			return;
		EntityPlayer player = event.player;
		PlayerInformation pro = PlayerInformation.get(player);
		ItemStack oriStack = event.crafting.copy();
		for (Quest q : BlockedLayersApi.questList) {
			String name = q.getName();
			if (!q.getActivity().equals("craft") || !questValid(pro, q)
					|| pro.getQuestBools().get(name)
					|| player.capabilities.isCreativeMode) {
				continue;
			}
			craftNsmelt(player, q, oriStack);
		}
	}

	//TODO shift click fix
	@SubscribeEvent
	public void smelt(PlayerEvent.ItemSmeltedEvent event) {
		if (event.player.worldObj.isRemote)
			return;
		EntityPlayer player = event.player;
		PlayerInformation pro = PlayerInformation.get(player);
		ItemStack oriStack = event.smelting.copy();
		for (Quest q : BlockedLayersApi.questList) {
			String name = q.getName();
			if (!q.getActivity().equals("craft") || !questValid(pro, q)
					|| pro.getQuestBools().get(name)
					|| player.capabilities.isCreativeMode) {
				continue;
			}
			craftNsmelt(player, q, oriStack);
		}
	}

	public void craftNsmelt(EntityPlayer player, Quest q, ItemStack oriStack) {
		ItemStack stack;
		Item target = GameRegistry.findItem(q.getModID(), q.getObject());
		if (q.getMeta() == -1)
			stack = new ItemStack(target, 1, oriStack.getItemDamage());
		else
			stack = new ItemStack(target, 1, q.getMeta());

		int number = q.getNumber();
		PlayerInformation pro = PlayerInformation.get(player);
		String name = q.getName();
		if (oriStack.isItemEqual(stack)) {
			pro.getQuestNums()
					.put(name + "Num",
							pro.getQuestNums().get(name + "Num")
									+ (oriStack.stackSize == 0 ? 1
											: oriStack.stackSize));
			if (pro.getQuestNums().get(name + "Num") >= number) {
				finish(player, q);
				Statics.syncTeams(pro.getTeam());
			}
		}
	}

	@SubscribeEvent
	public void release(PlayerInteractEvent event) {
		if (event.getWorld().isRemote)
			return;
		EntityPlayer player = event.getEntityPlayer();
		PlayerInformation pro = PlayerInformation.get(player);
		for (Entry<Integer, Boolean> entry : pro.getLayerBools().entrySet()) {
			boolean ll = true;
			for (Quest q : BlockedLayersApi.questList) {
				if (q.getLayer() == entry.getKey()) {
					if (!pro.getQuestBools().get(q.getName())) {
						ll = false;
						break;
					}
				}
			}
			if (!pro.getLayerBools().get(entry.getKey()) && ll) {
				pro.getLayerBools().put(entry.getKey(), true);
				player.addChatMessage(new TextComponentString(I18n
						.format("bl.layer.done",
								entry.getKey())));
				if (!ConfigurationHandler.reward)
					continue;
				for (Reward r : BlockedLayersApi.rewardList) {
					if (r.getLayer() == entry.getKey()) {
						ArrayList<ItemStack> tmp = new ArrayList<ItemStack>();
						for (String s : r.getRewards()) {
//							if (Statics.string2Stack(s) != null)
//								tmp.add(Statics.string2Stack(s));
						}
						for (ItemStack s : tmp) {
							if (!player.inventory.addItemStackToInventory(s)) {
								EntityItem entityitem = new EntityItem(
										player.worldObj, player.posX + 0.5D,
										player.posY + 0.5D, player.posZ + 0.5D,
										s);
								event.getWorld().spawnEntityInWorld(entityitem);
							}

						}
						player.openContainer.detectAndSendChanges();
					}
				}
			}
		}
	}
}
