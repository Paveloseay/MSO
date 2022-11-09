
package net.mcreator.mso;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;

import net.mcreator.mso.item.FusedustItem;
import net.mcreator.mso.item.FiercepotionItem;

@MsoModElements.ModElement.Tag
public class FiercepotionrecipaBrewingRecipe extends MsoModElements.ModElement {
	public FiercepotionrecipaBrewingRecipe(MsoModElements instance) {
		super(instance, 62);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BrewingRecipeRegistry.addRecipe(new CustomBrewingRecipe());
	}

	public static class CustomBrewingRecipe implements IBrewingRecipe {
		@Override
		public boolean isInput(ItemStack input) {
			return input.getItem() == Items.POTION;
		}

		@Override
		public boolean isIngredient(ItemStack ingredient) {
			return ingredient.getItem() == FusedustItem.block;
		}

		@Override
		public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
			if (isInput(input) && isIngredient(ingredient)) {
				return new ItemStack(FiercepotionItem.block);
			}
			return ItemStack.EMPTY;
		}
	}
}
