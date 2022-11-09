
package net.mcreator.mso.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.mso.block.SmelteryBlock;
import net.mcreator.mso.MsoModElements;

@MsoModElements.ModElement.Tag
public class MsoblocksItemGroup extends MsoModElements.ModElement {
	public MsoblocksItemGroup(MsoModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabmsoblocks") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(SmelteryBlock.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
