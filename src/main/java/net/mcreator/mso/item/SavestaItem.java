
package net.mcreator.mso.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.BipedModel;

import net.mcreator.mso.procedures.SavestaBodyTickEventProcedure;
import net.mcreator.mso.itemgroup.MsoarmorsItemGroup;
import net.mcreator.mso.MsoModElements;

import java.util.stream.Stream;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.AbstractMap;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@MsoModElements.ModElement.Tag
public class SavestaItem extends MsoModElements.ModElement {
	@ObjectHolder("mso:savesta_helmet")
	public static final Item helmet = null;
	@ObjectHolder("mso:savesta_chestplate")
	public static final Item body = null;
	@ObjectHolder("mso:savesta_leggings")
	public static final Item legs = null;
	@ObjectHolder("mso:savesta_boots")
	public static final Item boots = null;

	public SavestaItem(MsoModElements instance) {
		super(instance, 77);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			@Override
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 384;
			}

			@Override
			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{0, 0, 10, 0}[slot.getIndex()];
			}

			@Override
			public int getEnchantability() {
				return 0;
			}

			@Override
			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_leather"));
			}

			@Override
			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}

			@OnlyIn(Dist.CLIENT)
			@Override
			public String getName() {
				return "savesta";
			}

			@Override
			public float getToughness() {
				return 1f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0.05f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(MsoarmorsItemGroup.tab)) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
				BipedModel armorModel = new BipedModel(1);
				armorModel.bipedBody = new Modelomaga().bone;
				armorModel.bipedLeftArm = new Modelomaga().left;
				armorModel.bipedRightArm = new Modelomaga().right;
				armorModel.isSneak = living.isSneaking();
				armorModel.isSitting = defaultModel.isSitting;
				armorModel.isChild = living.isChild();
				return armorModel;
			}

			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("\u00A79Rarity: \u00A75\u00A7lEpic"));
				list.add(new StringTextComponent("\u00A79Type: \u00A7f\u00A7lArmor"));
				list.add(new StringTextComponent("\u00A79Perk: \u00A77\u00A7l[None]"));
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "mso:textures/savesta.png";
			}

			@Override
			public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				SavestaBodyTickEventProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}.setRegistryName("savesta_chestplate"));
	}

	// Made with Blockbench 4.3.1
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelomaga extends EntityModel<Entity> {
		private final ModelRenderer left;
		private final ModelRenderer left_r1;
		private final ModelRenderer bone;
		private final ModelRenderer cube_r2;
		private final ModelRenderer cube_r4_r1;
		private final ModelRenderer cube_r3;
		private final ModelRenderer right;

		public Modelomaga() {
			textureWidth = 64;
			textureHeight = 64;
			left = new ModelRenderer(this);
			left.setRotationPoint(0.0F, 24.0F, 0.0F);
			left_r1 = new ModelRenderer(this);
			left_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
			left.addChild(left_r1);
			setRotationAngle(left_r1, 0.0F, 3.1416F, 0.0F);
			left_r1.setTextureOffset(38, 37).addBox(-3.0F, 7.25F, -2.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
			bone = new ModelRenderer(this);
			bone.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone.setTextureOffset(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);
			bone.setTextureOffset(40, 4).addBox(-4.5F, 5.25F, -2.5F, 9.0F, 7.0F, 1.0F, 0.0F, false);
			bone.setTextureOffset(40, 4).addBox(-4.5F, 5.25F, 1.5F, 9.0F, 7.0F, 1.0F, 0.0F, false);
			bone.setTextureOffset(41, 2).addBox(3.5F, 5.25F, -1.5F, 1.0F, 7.0F, 3.0F, 0.0F, false);
			bone.setTextureOffset(41, 2).addBox(-4.5F, 5.25F, -1.5F, 1.0F, 7.0F, 3.0F, 0.0F, false);
			bone.setTextureOffset(29, 47).addBox(4.0F, 10.0F, 0.25F, 1.0F, 3.0F, 2.0F, 0.0F, false);
			bone.setTextureOffset(29, 47).addBox(4.0F, 10.0F, -2.25F, 1.0F, 3.0F, 2.0F, 0.0F, false);
			bone.setTextureOffset(50, 57).addBox(3.5F, 8.75F, -2.0F, 1.0F, 5.0F, 2.0F, 0.0F, false);
			bone.setTextureOffset(50, 57).addBox(3.5F, 8.75F, 0.5F, 1.0F, 5.0F, 2.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
			bone.addChild(cube_r2);
			cube_r2.setTextureOffset(0, 0).addBox(-2.5F, -0.7F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			cube_r2.setTextureOffset(0, 50).addBox(-2.5F, -0.7F, 1.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);
			cube_r2.setTextureOffset(0, 50).addBox(-2.5F, -0.7F, -2.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);
			cube_r2.setTextureOffset(0, 36).addBox(-1.5F, 1.3F, -2.5F, 3.0F, 4.0F, 1.0F, 0.0F, false);
			cube_r4_r1 = new ModelRenderer(this);
			cube_r4_r1.setRotationPoint(0.0F, -1.0F, 0.0F);
			cube_r2.addChild(cube_r4_r1);
			setRotationAngle(cube_r4_r1, 0.0F, 3.1416F, 0.0F);
			cube_r4_r1.setTextureOffset(0, 36).addBox(-1.5F, 2.3F, -2.5F, 3.0F, 4.0F, 1.0F, 0.0F, false);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
			bone.addChild(cube_r3);
			cube_r3.setTextureOffset(0, 0).addBox(1.5F, -0.7F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			cube_r3.setTextureOffset(0, 50).addBox(1.5F, -0.7F, 1.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);
			cube_r3.setTextureOffset(0, 50).addBox(1.5F, -0.7F, -2.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);
			right = new ModelRenderer(this);
			right.setRotationPoint(0.0F, 24.0F, 0.0F);
			right.setTextureOffset(38, 37).addBox(-3.0F, 7.25F, -2.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			left.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			bone.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			right.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
		}
	}

	// Made with Blockbench 4.1.5
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelthermostealleggings extends EntityModel<Entity> {
		private final ModelRenderer bone;
		private final ModelRenderer leftarm2;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer cube_r3;
		private final ModelRenderer cube_r4;
		private final ModelRenderer cube_r5;
		private final ModelRenderer cube_r6;
		private final ModelRenderer cube_r7;
		private final ModelRenderer cube_r8;
		private final ModelRenderer cube_r9;
		private final ModelRenderer bone3;
		private final ModelRenderer body;
		private final ModelRenderer cube_r10;
		private final ModelRenderer cube_r11;
		private final ModelRenderer cube_r12;
		private final ModelRenderer cube_r13;
		private final ModelRenderer cube_r14;
		private final ModelRenderer cube_r15;
		private final ModelRenderer cube_r16;
		private final ModelRenderer cube_r17;
		private final ModelRenderer bone2;
		private final ModelRenderer rightarm3;
		private final ModelRenderer cube_r18;
		private final ModelRenderer cube_r19;
		private final ModelRenderer cube_r20;
		private final ModelRenderer cube_r21;
		private final ModelRenderer cube_r22;
		private final ModelRenderer cube_r23;
		private final ModelRenderer cube_r24;
		private final ModelRenderer cube_r25;
		private final ModelRenderer cube_r26;

		public Modelthermostealleggings() {
			textureWidth = 64;
			textureHeight = 72;
			bone = new ModelRenderer(this);
			bone.setRotationPoint(0.5F, 24.0F, 0.0F);
			leftarm2 = new ModelRenderer(this);
			leftarm2.setRotationPoint(-14.0F, 0.5F, 3.0F);
			bone.addChild(leftarm2);
			setRotationAngle(leftarm2, 0.0F, 3.1416F, 0.0F);
			leftarm2.setTextureOffset(48, 53).addBox(-16.0F, -1.75F, 1.0F, 4.0F, 7.0F, 4.0F, 0.0F, false);
			leftarm2.setTextureOffset(30, 29).addBox(-14.5F, -1.75F, 4.5F, 2.0F, 9.0F, 1.0F, 0.0F, false);
			leftarm2.setTextureOffset(24, 29).addBox(-14.5F, -1.75F, 0.5F, 2.0F, 9.0F, 1.0F, 0.0F, false);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(0.0F, 1.0F, 2.0F);
			leftarm2.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.0F, 0.0F, -0.3927F);
			cube_r1.setTextureOffset(0, 13).addBox(-11.2689F, -7.4296F, -1.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r1.setTextureOffset(19, 14).addBox(-11.2689F, -7.4296F, 2.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(0.0F, 1.0F, 2.0F);
			leftarm2.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.0F, 0.0F, 0.3927F);
			cube_r2.setTextureOffset(21, 45).addBox(-15.6654F, 2.928F, -1.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r2.setTextureOffset(45, 26).addBox(-15.6654F, 2.928F, 2.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(0.0F, 3.0F, 2.0F);
			leftarm2.addChild(cube_r3);
			setRotationAngle(cube_r3, 0.0F, 0.0F, -0.3927F);
			cube_r3.setTextureOffset(20, 0).addBox(-11.2689F, -7.4296F, -1.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r3.setTextureOffset(0, 48).addBox(-11.2689F, -7.4296F, 2.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(0.0F, 3.0F, 2.0F);
			leftarm2.addChild(cube_r4);
			setRotationAngle(cube_r4, 0.0F, 0.0F, 0.3927F);
			cube_r4.setTextureOffset(45, 37).addBox(-15.6654F, 2.928F, -1.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r4.setTextureOffset(46, 6).addBox(-15.6654F, 2.928F, 2.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(0.0F, 5.0F, 2.0F);
			leftarm2.addChild(cube_r5);
			setRotationAngle(cube_r5, 0.0F, 0.0F, -0.3927F);
			cube_r5.setTextureOffset(48, 0).addBox(-11.2689F, -7.4296F, -1.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r5.setTextureOffset(48, 3).addBox(-11.2689F, -7.4296F, 2.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(0.0F, 5.0F, 2.0F);
			leftarm2.addChild(cube_r6);
			setRotationAngle(cube_r6, 0.0F, 0.0F, 0.3927F);
			cube_r6.setTextureOffset(46, 9).addBox(-15.6654F, 2.928F, -1.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r6.setTextureOffset(46, 22).addBox(-15.6654F, 2.928F, 2.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r7 = new ModelRenderer(this);
			cube_r7.setRotationPoint(0.0F, 1.0F, 6.0F);
			leftarm2.addChild(cube_r7);
			setRotationAngle(cube_r7, 0.0F, 1.5708F, 0.0F);
			cube_r7.setTextureOffset(19, 23).addBox(0.5F, -3.5F, -16.5F, 5.0F, 1.0F, 5.0F, 0.0F, false);
			cube_r7.setTextureOffset(24, 0).addBox(0.5F, -3.0F, -12.5F, 5.0F, 6.0F, 1.0F, 0.0F, false);
			cube_r7.setTextureOffset(34, 7).addBox(0.5F, 3.75F, -16.5F, 5.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r7.setTextureOffset(34, 10).addBox(0.5F, 4.0F, -12.5F, 5.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r7.setTextureOffset(24, 14).addBox(0.5F, -3.25F, -16.5F, 5.0F, 6.0F, 1.0F, 0.0F, false);
			cube_r8 = new ModelRenderer(this);
			cube_r8.setRotationPoint(0.0F, 8.0F, 2.0F);
			leftarm2.addChild(cube_r8);
			setRotationAngle(cube_r8, 0.0F, 0.0F, -0.3927F);
			cube_r8.setTextureOffset(4, 48).addBox(-11.2689F, -7.4296F, -1.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r8.setTextureOffset(21, 48).addBox(-11.2689F, -7.4296F, 2.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r9 = new ModelRenderer(this);
			cube_r9.setRotationPoint(0.0F, 8.0F, 2.0F);
			leftarm2.addChild(cube_r9);
			setRotationAngle(cube_r9, 0.0F, 0.0F, 0.3927F);
			cube_r9.setTextureOffset(46, 29).addBox(-15.6654F, 2.928F, -1.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r9.setTextureOffset(46, 32).addBox(-15.6654F, 2.928F, 2.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);
			bone3 = new ModelRenderer(this);
			bone3.setRotationPoint(0.0F, 24.0F, 0.0F);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 0.0F, 0.0F);
			bone3.addChild(body);
			body.setTextureOffset(18, 29).addBox(-1.0F, 6.0F, 1.5F, 2.0F, 4.0F, 1.0F, 0.0F, false);
			body.setTextureOffset(0, 13).addBox(3.75F, 4.5F, -2.5F, 1.0F, 4.0F, 5.0F, 0.0F, false);
			body.setTextureOffset(12, 13).addBox(-4.75F, 4.5F, -2.5F, 1.0F, 4.0F, 5.0F, 0.0F, false);
			body.setTextureOffset(12, 28).addBox(-1.0F, 6.0F, -2.5F, 2.0F, 4.0F, 1.0F, 0.0F, false);
			cube_r10 = new ModelRenderer(this);
			cube_r10.setRotationPoint(0.0F, 31.0F, 1.5F);
			body.addChild(cube_r10);
			setRotationAngle(cube_r10, 0.0F, 0.0F, -0.3927F);
			cube_r10.setTextureOffset(36, 32).addBox(9.0F, -21.0F, -4.0F, 4.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r10.setTextureOffset(36, 17).addBox(9.0F, -21.0F, 0.0F, 4.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r11 = new ModelRenderer(this);
			cube_r11.setRotationPoint(0.0F, 31.0F, 1.5F);
			body.addChild(cube_r11);
			setRotationAngle(cube_r11, 0.0F, 0.0F, 0.3927F);
			cube_r11.setTextureOffset(36, 29).addBox(-13.0F, -21.0F, -4.0F, 4.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r11.setTextureOffset(7, 13).addBox(-13.0F, -21.0F, 0.0F, 4.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r12 = new ModelRenderer(this);
			cube_r12.setRotationPoint(0.0F, 27.0F, 5.5F);
			body.addChild(cube_r12);
			setRotationAngle(cube_r12, 0.0F, 0.0F, 0.3927F);
			cube_r13 = new ModelRenderer(this);
			cube_r13.setRotationPoint(0.0F, 27.0F, 5.5F);
			body.addChild(cube_r13);
			setRotationAngle(cube_r13, 0.0F, 0.0F, -0.3927F);
			cube_r14 = new ModelRenderer(this);
			cube_r14.setRotationPoint(0.0F, 25.0F, 5.5F);
			body.addChild(cube_r14);
			setRotationAngle(cube_r14, 0.0F, 0.0F, 0.3927F);
			cube_r15 = new ModelRenderer(this);
			cube_r15.setRotationPoint(0.0F, 25.0F, 5.5F);
			body.addChild(cube_r15);
			setRotationAngle(cube_r15, 0.0F, 0.0F, -0.3927F);
			cube_r16 = new ModelRenderer(this);
			cube_r16.setRotationPoint(0.0F, 23.0F, 5.5F);
			body.addChild(cube_r16);
			setRotationAngle(cube_r16, 0.0F, 0.0F, 0.3927F);
			cube_r16.setTextureOffset(40, 44).addBox(-10.7039F, -15.4567F, -4.0F, 4.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r16.setTextureOffset(0, 45).addBox(-10.7039F, -15.4567F, -8.0F, 4.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r17 = new ModelRenderer(this);
			cube_r17.setRotationPoint(0.0F, 23.0F, 5.5F);
			body.addChild(cube_r17);
			setRotationAngle(cube_r17, 0.0F, 0.0F, -0.3927F);
			cube_r17.setTextureOffset(30, 44).addBox(6.7039F, -15.4567F, -4.0F, 4.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r17.setTextureOffset(45, 19).addBox(6.7039F, -15.4567F, -8.0F, 4.0F, 2.0F, 1.0F, 0.0F, false);
			bone2 = new ModelRenderer(this);
			bone2.setRotationPoint(-0.5F, 24.0F, 0.0F);
			rightarm3 = new ModelRenderer(this);
			rightarm3.setRotationPoint(14.0F, 0.5F, 3.0F);
			bone2.addChild(rightarm3);
			setRotationAngle(rightarm3, 0.0F, -3.1416F, 0.0F);
			rightarm3.setTextureOffset(48, 53).addBox(12.0F, -1.75F, 1.0F, 4.0F, 7.0F, 4.0F, 0.0F, true);
			rightarm3.setTextureOffset(30, 29).addBox(12.5F, -1.75F, 4.5F, 2.0F, 9.0F, 1.0F, 0.0F, true);
			rightarm3.setTextureOffset(24, 29).addBox(12.5F, -1.75F, 0.5F, 2.0F, 9.0F, 1.0F, 0.0F, true);
			cube_r18 = new ModelRenderer(this);
			cube_r18.setRotationPoint(0.0F, 1.0F, 2.0F);
			rightarm3.addChild(cube_r18);
			setRotationAngle(cube_r18, 0.0F, 0.0F, 0.3927F);
			cube_r18.setTextureOffset(0, 13).addBox(10.2689F, -7.4296F, -1.5F, 1.0F, 2.0F, 1.0F, 0.0F, true);
			cube_r18.setTextureOffset(19, 14).addBox(10.2689F, -7.4296F, 2.5F, 1.0F, 2.0F, 1.0F, 0.0F, true);
			cube_r19 = new ModelRenderer(this);
			cube_r19.setRotationPoint(0.0F, 1.0F, 2.0F);
			rightarm3.addChild(cube_r19);
			setRotationAngle(cube_r19, 0.0F, 0.0F, -0.3927F);
			cube_r19.setTextureOffset(21, 45).addBox(13.6654F, 2.928F, -1.5F, 2.0F, 2.0F, 1.0F, 0.0F, true);
			cube_r19.setTextureOffset(45, 26).addBox(13.6654F, 2.928F, 2.5F, 2.0F, 2.0F, 1.0F, 0.0F, true);
			cube_r20 = new ModelRenderer(this);
			cube_r20.setRotationPoint(0.0F, 3.0F, 2.0F);
			rightarm3.addChild(cube_r20);
			setRotationAngle(cube_r20, 0.0F, 0.0F, 0.3927F);
			cube_r20.setTextureOffset(20, 0).addBox(10.2689F, -7.4296F, -1.5F, 1.0F, 2.0F, 1.0F, 0.0F, true);
			cube_r20.setTextureOffset(0, 48).addBox(10.2689F, -7.4296F, 2.5F, 1.0F, 2.0F, 1.0F, 0.0F, true);
			cube_r21 = new ModelRenderer(this);
			cube_r21.setRotationPoint(0.0F, 3.0F, 2.0F);
			rightarm3.addChild(cube_r21);
			setRotationAngle(cube_r21, 0.0F, 0.0F, -0.3927F);
			cube_r21.setTextureOffset(45, 37).addBox(13.6654F, 2.928F, -1.5F, 2.0F, 2.0F, 1.0F, 0.0F, true);
			cube_r21.setTextureOffset(46, 6).addBox(13.6654F, 2.928F, 2.5F, 2.0F, 2.0F, 1.0F, 0.0F, true);
			cube_r22 = new ModelRenderer(this);
			cube_r22.setRotationPoint(0.0F, 5.0F, 2.0F);
			rightarm3.addChild(cube_r22);
			setRotationAngle(cube_r22, 0.0F, 0.0F, 0.3927F);
			cube_r22.setTextureOffset(48, 0).addBox(10.2689F, -7.4296F, -1.5F, 1.0F, 2.0F, 1.0F, 0.0F, true);
			cube_r22.setTextureOffset(48, 3).addBox(10.2689F, -7.4296F, 2.5F, 1.0F, 2.0F, 1.0F, 0.0F, true);
			cube_r23 = new ModelRenderer(this);
			cube_r23.setRotationPoint(0.0F, 5.0F, 2.0F);
			rightarm3.addChild(cube_r23);
			setRotationAngle(cube_r23, 0.0F, 0.0F, -0.3927F);
			cube_r23.setTextureOffset(46, 9).addBox(13.6654F, 2.928F, -1.5F, 2.0F, 2.0F, 1.0F, 0.0F, true);
			cube_r23.setTextureOffset(46, 22).addBox(13.6654F, 2.928F, 2.5F, 2.0F, 2.0F, 1.0F, 0.0F, true);
			cube_r24 = new ModelRenderer(this);
			cube_r24.setRotationPoint(0.0F, 1.0F, 6.0F);
			rightarm3.addChild(cube_r24);
			setRotationAngle(cube_r24, 0.0F, -1.5708F, 0.0F);
			cube_r24.setTextureOffset(24, 14).addBox(-5.5F, -3.25F, -16.5F, 5.0F, 6.0F, 1.0F, 0.0F, true);
			cube_r24.setTextureOffset(19, 23).addBox(-5.5F, -3.5F, -16.5F, 5.0F, 1.0F, 5.0F, 0.0F, true);
			cube_r24.setTextureOffset(24, 0).addBox(-5.5F, -3.0F, -12.5F, 5.0F, 6.0F, 1.0F, 0.0F, true);
			cube_r24.setTextureOffset(34, 7).addBox(-5.5F, 3.75F, -16.5F, 5.0F, 2.0F, 1.0F, 0.0F, true);
			cube_r24.setTextureOffset(34, 10).addBox(-5.5F, 4.0F, -12.5F, 5.0F, 2.0F, 1.0F, 0.0F, true);
			cube_r25 = new ModelRenderer(this);
			cube_r25.setRotationPoint(0.0F, 8.0F, 2.0F);
			rightarm3.addChild(cube_r25);
			setRotationAngle(cube_r25, 0.0F, 0.0F, 0.3927F);
			cube_r25.setTextureOffset(4, 48).addBox(10.2689F, -7.4296F, -1.5F, 1.0F, 2.0F, 1.0F, 0.0F, true);
			cube_r25.setTextureOffset(21, 48).addBox(10.2689F, -7.4296F, 2.5F, 1.0F, 2.0F, 1.0F, 0.0F, true);
			cube_r26 = new ModelRenderer(this);
			cube_r26.setRotationPoint(0.0F, 8.0F, 2.0F);
			rightarm3.addChild(cube_r26);
			setRotationAngle(cube_r26, 0.0F, 0.0F, -0.3927F);
			cube_r26.setTextureOffset(46, 29).addBox(13.6654F, 2.928F, -1.5F, 2.0F, 2.0F, 1.0F, 0.0F, true);
			cube_r26.setTextureOffset(46, 32).addBox(13.6654F, 2.928F, 2.5F, 2.0F, 2.0F, 1.0F, 0.0F, true);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			bone.render(matrixStack, buffer, packedLight, packedOverlay);
			bone3.render(matrixStack, buffer, packedLight, packedOverlay);
			bone2.render(matrixStack, buffer, packedLight, packedOverlay);
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
