
package net.mcreator.mso;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import net.minecraft.item.ItemStack;

import net.mcreator.mso.item.ManapotionItem;
import net.mcreator.mso.item.ManadustItem;
import net.mcreator.mso.item.FiercepotionItem;

@MsoModElements.ModElement.Tag
public class ManapotionrecipaBrewingRecipe extends MsoModElements.ModElement {
	public ManapotionrecipaBrewingRecipe(MsoModElements instance) {
		super(instance, 88);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BrewingRecipeRegistry.addRecipe(new CustomBrewingRecipe());
	}

	public static class CustomBrewingRecipe implements IBrewingRecipe {
		@Override
		public boolean isInput(ItemStack input) {
			return input.getItem() == FiercepotionItem.block;
		}

		@Override
		public boolean isIngredient(ItemStack ingredient) {
			return ingredient.getItem() == ManadustItem.block;
		}

		@Override
		public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
			if (isInput(input) && isIngredient(ingredient)) {
				return new ItemStack(ManapotionItem.block);
			}
			return ItemStack.EMPTY;
		}
	}
}
