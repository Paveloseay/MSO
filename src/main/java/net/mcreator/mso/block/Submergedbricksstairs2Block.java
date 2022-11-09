
package net.mcreator.mso.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.block.material.Material;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.mso.itemgroup.MsoblocksItemGroup;
import net.mcreator.mso.MsoModElements;

import java.util.List;
import java.util.Collections;

@MsoModElements.ModElement.Tag
public class Submergedbricksstairs2Block extends MsoModElements.ModElement {
	@ObjectHolder("mso:submergedbricksstairs_2")
	public static final Block block = null;

	public Submergedbricksstairs2Block(MsoModElements instance) {
		super(instance, 157);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(MsoblocksItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutoutMipped());
	}

	public static class CustomBlock extends StairsBlock {
		public CustomBlock() {
			super(() -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.BONE).hardnessAndResistance(1f, 10f).setLightLevel(s -> 0)
					.notSolid().setOpaque((bs, br, bp) -> false)).getDefaultState(),
					Block.Properties.create(Material.ROCK).sound(SoundType.BONE).hardnessAndResistance(1f, 10f).setLightLevel(s -> 0).notSolid()
							.setOpaque((bs, br, bp) -> false));
			setRegistryName("submergedbricksstairs_2");
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
