
package net.mcreator.mso.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import net.mcreator.mso.itemgroup.MsoitemsItemGroup;
import net.mcreator.mso.MsoModElements;

import java.util.List;

@MsoModElements.ModElement.Tag
public class FusedustItem extends MsoModElements.ModElement {
	@ObjectHolder("mso:fusedust")
	public static final Item block = null;

	public FusedustItem(MsoModElements instance) {
		super(instance, 25);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(MsoitemsItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("fusedust");
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

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("\u00A79Rarity: \u00A75\u00A7lEpic"));
			list.add(new StringTextComponent("\u00A79Type: \u00A7a\u00A7lCrafting material"));
		}
	}
}
