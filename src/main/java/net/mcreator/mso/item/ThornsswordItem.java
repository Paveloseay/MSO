
package net.mcreator.mso.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.mso.procedures.ThornsswordLivingEntityIsHitWithToolProcedure;
import net.mcreator.mso.itemgroup.MsotoolsItemGroup;
import net.mcreator.mso.MsoModElements;

import java.util.stream.Stream;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.AbstractMap;

@MsoModElements.ModElement.Tag
public class ThornsswordItem extends MsoModElements.ModElement {
	@ObjectHolder("mso:thornssword")
	public static final Item block = null;

	public ThornsswordItem(MsoModElements instance) {
		super(instance, 82);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 384;
			}

			public float getEfficiency() {
				return 0f;
			}

			public float getAttackDamage() {
				return 4.5f;
			}

			public int getHarvestLevel() {
				return 0;
			}

			public int getEnchantability() {
				return 0;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -2.7999999999999998f, new Item.Properties().group(MsotoolsItemGroup.tab)) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("\u00A79Rarity: \u00A7a\u00A7lUncommon"));
				list.add(new StringTextComponent("\u00A79Type: \u00A7c\u00A7lSword"));
				list.add(new StringTextComponent("\u00A79Perk: \u00A7a\u00A7l[Thorn Binding]"));
				list.add(new StringTextComponent("\u00A72Traps the enemy with thorns"));
			}

			@Override
			public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				boolean retval = super.hitEntity(itemstack, entity, sourceentity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				World world = entity.world;

				ThornsswordLivingEntityIsHitWithToolProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
								new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}
		}.setRegistryName("thornssword"));
	}
}
