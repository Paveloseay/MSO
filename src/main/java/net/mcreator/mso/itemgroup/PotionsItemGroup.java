
package net.mcreator.mso.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.mso.item.IvypotionItem;
import net.mcreator.mso.MsoModElements;

@MsoModElements.ModElement.Tag
public class PotionsItemGroup extends MsoModElements.ModElement {
	public PotionsItemGroup(MsoModElements instance) {
		super(instance, 57);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabpotions") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(IvypotionItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
