
package net.mcreator.mso.block;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.mso.itemgroup.MsoblocksItemGroup;
import net.mcreator.mso.MsoModElements;

import java.util.List;
import java.util.Collections;

@MsoModElements.ModElement.Tag
public class PinkcoralBlock extends MsoModElements.ModElement {
	@ObjectHolder("mso:pinkcoral")
	public static final Block block = null;

	public PinkcoralBlock(MsoModElements instance) {
		super(instance, 182);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(MsoblocksItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.OCEAN_PLANT).sound(SoundType.CORAL).hardnessAndResistance(1f, 10f).setLightLevel(s -> 1));
			setRegistryName("pinkcoral");
		}

		@Override
		public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 15;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}
