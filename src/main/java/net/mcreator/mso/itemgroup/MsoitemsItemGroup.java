
package net.mcreator.mso.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.mso.item.CompactedcoalItem;
import net.mcreator.mso.MsoModElements;

@MsoModElements.ModElement.Tag
public class MsoitemsItemGroup extends MsoModElements.ModElement {
	public MsoitemsItemGroup(MsoModElements instance) {
		super(instance, 5);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabmsoitems") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(CompactedcoalItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
