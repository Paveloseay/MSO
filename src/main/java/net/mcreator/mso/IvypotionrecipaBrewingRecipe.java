
package net.mcreator.mso;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import net.minecraft.item.ItemStack;

import net.mcreator.mso.item.IvypotionItem;
import net.mcreator.mso.item.FiercepotionItem;
import net.mcreator.mso.block.PoisonivyBlock;

@MsoModElements.ModElement.Tag
public class IvypotionrecipaBrewingRecipe extends MsoModElements.ModElement {
	public IvypotionrecipaBrewingRecipe(MsoModElements instance) {
		super(instance, 58);
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
			return ingredient.getItem() == PoisonivyBlock.block.asItem();
		}

		@Override
		public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
			if (isInput(input) && isIngredient(ingredient)) {
				return new ItemStack(IvypotionItem.block);
			}
			return ItemStack.EMPTY;
		}
	}
}
