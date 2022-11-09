
package net.mcreator.mso.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.mso.item.ThornslogbowItem;
import net.mcreator.mso.MsoModElements;

@MsoModElements.ModElement.Tag
public class MsotoolsItemGroup extends MsoModElements.ModElement {
	public MsotoolsItemGroup(MsoModElements instance) {
		super(instance, 80);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabmsotools") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(ThornslogbowItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
