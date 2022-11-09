
package net.mcreator.mso.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.mso.block.DryGrassBlock;
import net.mcreator.mso.MsoModElements;

@MsoModElements.ModElement.Tag
public class MsoplantsItemGroup extends MsoModElements.ModElement {
	public MsoplantsItemGroup(MsoModElements instance) {
		super(instance, 11);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabmsoplants") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(DryGrassBlock.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
