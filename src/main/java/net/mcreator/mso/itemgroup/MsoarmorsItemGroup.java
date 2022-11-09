
package net.mcreator.mso.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.mso.item.ThermostealItem;
import net.mcreator.mso.MsoModElements;

@MsoModElements.ModElement.Tag
public class MsoarmorsItemGroup extends MsoModElements.ModElement {
	public MsoarmorsItemGroup(MsoModElements instance) {
		super(instance, 66);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabmsoarmors") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(ThermostealItem.body);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
