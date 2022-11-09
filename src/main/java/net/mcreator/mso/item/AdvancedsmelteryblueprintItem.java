
package net.mcreator.mso.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.mso.itemgroup.MsoitemsItemGroup;
import net.mcreator.mso.MsoModElements;

@MsoModElements.ModElement.Tag
public class AdvancedsmelteryblueprintItem extends MsoModElements.ModElement {
	@ObjectHolder("mso:advancedsmelteryblueprint")
	public static final Item block = null;

	public AdvancedsmelteryblueprintItem(MsoModElements instance) {
		super(instance, 30);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(MsoitemsItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
			setRegistryName("advancedsmelteryblueprint");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public boolean hasContainerItem() {
			return true;
		}

		@Override
		public ItemStack getContainerItem(ItemStack itemstack) {
			return new ItemStack(this);
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
