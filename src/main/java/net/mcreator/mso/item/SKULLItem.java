
package net.mcreator.mso.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.BipedModel;

import net.mcreator.mso.itemgroup.MsoarmorsItemGroup;
import net.mcreator.mso.MsoModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@MsoModElements.ModElement.Tag
public class SKULLItem extends MsoModElements.ModElement {
	@ObjectHolder("mso:skull_helmet")
	public static final Item helmet = null;
	@ObjectHolder("mso:skull_chestplate")
	public static final Item body = null;
	@ObjectHolder("mso:skull_leggings")
	public static final Item legs = null;
	@ObjectHolder("mso:skull_boots")
	public static final Item boots = null;

	public SKULLItem(MsoModElements instance) {
		super(instance, 83);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			@Override
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 25;
			}

			@Override
			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{0, 0, 16, 6}[slot.getIndex()];
			}

			@Override
			public int getEnchantability() {
				return 0;
			}

			@Override
			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bone_block.place"));
			}

			@Override
			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}

			@OnlyIn(Dist.CLIENT)
			@Override
			public String getName() {
				return "skull";
			}

			@Override
			public float getToughness() {
				return 4f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0.2f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(MsoarmorsItemGroup.tab)) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
				BipedModel armorModel = new BipedModel(1);
				armorModel.bipedHead = new Modelaughmaga().skullmask;
				armorModel.isSneak = living.isSneaking();
				armorModel.isSitting = defaultModel.isSitting;
				armorModel.isChild = living.isChild();
				return armorModel;
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "mso:textures/skullmaska.png";
			}
		}.setRegistryName("skull_helmet"));
	}

	// Made with Blockbench 4.4.1
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelaughmaga extends EntityModel<Entity> {
		private final ModelRenderer skullmask;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer cube_r3;

		public Modelaughmaga() {
			textureWidth = 64;
			textureHeight = 64;
			skullmask = new ModelRenderer(this);
			skullmask.setRotationPoint(0.0F, 22.5F, 0.0F);
			skullmask.setTextureOffset(0, 32).addBox(-1.0F, -3.75F, -4.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);
			skullmask.setTextureOffset(0, 32).addBox(-4.0F, -2.0F, -4.5F, 8.0F, 2.0F, 1.0F, 0.0F, false);
			skullmask.setTextureOffset(0, 32).addBox(2.75F, -3.75F, -4.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			skullmask.setTextureOffset(0, 32).addBox(3.0F, -3.75F, -4.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			skullmask.setTextureOffset(0, 32).addBox(-3.75F, -3.75F, -4.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			skullmask.setTextureOffset(0, 32).addBox(-4.0F, -3.75F, -4.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			skullmask.setTextureOffset(0, 47).addBox(-4.0F, -4.5F, -4.5F, 8.0F, 1.0F, 1.0F, 0.0F, false);
			skullmask.setTextureOffset(0, 47).addBox(-3.5F, -5.0F, -4.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);
			skullmask.setTextureOffset(0, 47).addBox(-4.5F, -1.25F, -4.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);
			skullmask.setTextureOffset(0, 0).addBox(-4.0F, -6.75F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(0.0F, 1.5F, 0.0F);
			skullmask.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.0F, -0.7854F, 0.0F);
			cube_r1.setTextureOffset(3, 40).addBox(-4.15F, -3.25F, -4.15F, 1.0F, 3.0F, 2.0F, 0.0F, false);
			cube_r1.setTextureOffset(3, 40).addBox(-4.15F, -3.25F, -4.15F, 2.0F, 3.0F, 1.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(0.0F, 1.5F, 0.0F);
			skullmask.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.0F, 0.0F, -1.3963F);
			cube_r2.setTextureOffset(0, 47).addBox(1.75F, -5.25F, -4.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(0.0F, 1.5F, 0.0F);
			skullmask.addChild(cube_r3);
			setRotationAngle(cube_r3, 0.0F, 0.0F, 1.3963F);
			cube_r3.setTextureOffset(0, 47).addBox(-4.5F, -5.25F, -4.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			skullmask.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
		}
	}

}
