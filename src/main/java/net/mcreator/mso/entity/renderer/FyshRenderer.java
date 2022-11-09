
package net.mcreator.mso.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.mso.entity.FyshEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class FyshRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(FyshEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelfysh(), 0.3f) {

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("mso:textures/fysh.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 4.4.3
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelfysh extends EntityModel<Entity> {
		private final ModelRenderer butt;
		private final ModelRenderer scales;
		private final ModelRenderer scales2;
		private final ModelRenderer scales3;
		private final ModelRenderer scales4;
		private final ModelRenderer scales5;
		private final ModelRenderer scales6;
		private final ModelRenderer scales7;
		private final ModelRenderer scales8;
		private final ModelRenderer scales9;
		private final ModelRenderer scales10;
		private final ModelRenderer scales11;
		private final ModelRenderer scales12;
		private final ModelRenderer bb_main;

		public Modelfysh() {
			textureWidth = 32;
			textureHeight = 32;
			butt = new ModelRenderer(this);
			butt.setRotationPoint(0.0F, 24.0F, 0.0F);
			butt.setTextureOffset(12, 10).addBox(0.0F, -2.0F, 4.0F, 0.0F, 1.0F, 3.0F, 0.0F, false);
			butt.setTextureOffset(12, 7).addBox(0.0F, -4.0F, 4.0F, 0.0F, 1.0F, 3.0F, 0.0F, false);
			butt.setTextureOffset(4, 14).addBox(0.0F, -5.0F, 5.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
			butt.setTextureOffset(0, 14).addBox(0.0F, -1.0F, 5.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
			butt.setTextureOffset(12, 6).addBox(0.0F, -3.0F, 2.5F, 0.0F, 1.0F, 3.0F, 0.0F, false);
			scales = new ModelRenderer(this);
			scales.setRotationPoint(0.25F, 24.0F, -1.0F);
			setRotationAngle(scales, 0.0F, 0.2182F, 0.0F);
			scales.setTextureOffset(6, 12).addBox(0.0F, -2.0F, 3.5F, 0.0F, 1.0F, 3.0F, 0.0F, false);
			scales.setTextureOffset(0, 12).addBox(0.0F, -4.0F, 3.5F, 0.0F, 1.0F, 3.0F, 0.0F, false);
			scales.setTextureOffset(16, 14).addBox(0.0F, -3.0F, 2.5F, 0.0F, 1.0F, 2.0F, 0.0F, false);
			scales2 = new ModelRenderer(this);
			scales2.setRotationPoint(-0.25F, 24.0F, -1.0F);
			setRotationAngle(scales2, 0.0F, -0.2182F, 0.0F);
			scales2.setTextureOffset(6, 11).addBox(0.0F, -2.0F, 3.5F, 0.0F, 1.0F, 3.0F, 0.0F, false);
			scales2.setTextureOffset(0, 11).addBox(0.0F, -4.0F, 3.5F, 0.0F, 1.0F, 3.0F, 0.0F, false);
			scales2.setTextureOffset(12, 16).addBox(0.0F, -3.0F, 2.5F, 0.0F, 1.0F, 2.0F, 0.0F, false);
			scales3 = new ModelRenderer(this);
			scales3.setRotationPoint(-0.25F, 24.0F, -3.0F);
			setRotationAngle(scales3, 0.0F, -0.2182F, 0.0F);
			scales3.setTextureOffset(8, 16).addBox(0.0F, -2.0F, 3.5F, 0.0F, 1.0F, 2.0F, 0.0F, false);
			scales3.setTextureOffset(16, 6).addBox(0.0F, -4.0F, 3.5F, 0.0F, 1.0F, 2.0F, 0.0F, false);
			scales3.setTextureOffset(16, 5).addBox(0.0F, -3.0F, 2.5F, 0.0F, 1.0F, 2.0F, 0.0F, false);
			scales4 = new ModelRenderer(this);
			scales4.setRotationPoint(-0.25F, 24.0F, -5.0F);
			setRotationAngle(scales4, 0.0F, -0.2182F, 0.0F);
			scales4.setTextureOffset(6, 10).addBox(0.0F, -2.0F, 3.5F, 0.0F, 1.0F, 3.0F, 0.0F, false);
			scales4.setTextureOffset(10, 2).addBox(0.0F, -4.0F, 3.5F, 0.0F, 1.0F, 3.0F, 0.0F, false);
			scales4.setTextureOffset(16, 4).addBox(0.0F, -3.0F, 2.5F, 0.0F, 1.0F, 2.0F, 0.0F, false);
			scales5 = new ModelRenderer(this);
			scales5.setRotationPoint(0.25F, 24.0F, -3.0F);
			setRotationAngle(scales5, 0.0F, 0.2182F, 0.0F);
			scales5.setTextureOffset(4, 16).addBox(0.0F, -2.0F, 3.5F, 0.0F, 1.0F, 2.0F, 0.0F, false);
			scales5.setTextureOffset(16, 3).addBox(0.0F, -4.0F, 3.5F, 0.0F, 1.0F, 2.0F, 0.0F, false);
			scales5.setTextureOffset(16, 2).addBox(0.0F, -3.0F, 2.5F, 0.0F, 1.0F, 2.0F, 0.0F, false);
			scales6 = new ModelRenderer(this);
			scales6.setRotationPoint(0.25F, 24.0F, -5.0F);
			setRotationAngle(scales6, 0.0F, 0.2182F, 0.0F);
			scales6.setTextureOffset(10, 1).addBox(0.0F, -2.0F, 3.5F, 0.0F, 1.0F, 3.0F, 0.0F, false);
			scales6.setTextureOffset(10, 0).addBox(0.0F, -4.0F, 3.5F, 0.0F, 1.0F, 3.0F, 0.0F, false);
			scales6.setTextureOffset(16, 1).addBox(0.0F, -3.0F, 2.5F, 0.0F, 1.0F, 2.0F, 0.0F, false);
			scales7 = new ModelRenderer(this);
			scales7.setRotationPoint(-2.5F, 20.75F, -5.0F);
			setRotationAngle(scales7, 0.0F, -0.2182F, 1.5708F);
			scales7.setTextureOffset(0, 10).addBox(0.0F, -2.0F, 3.5F, 0.0F, 1.0F, 3.0F, 0.0F, false);
			scales7.setTextureOffset(8, 9).addBox(0.0F, -4.0F, 3.5F, 0.0F, 1.0F, 3.0F, 0.0F, false);
			scales7.setTextureOffset(16, 0).addBox(0.0F, -3.0F, 2.5F, 0.0F, 1.0F, 2.0F, 0.0F, false);
			scales8 = new ModelRenderer(this);
			scales8.setRotationPoint(-2.5F, 20.75F, -3.0F);
			setRotationAngle(scales8, 0.0F, -0.2182F, 1.5708F);
			scales8.setTextureOffset(0, 16).addBox(0.0F, -2.0F, 3.5F, 0.0F, 1.0F, 2.0F, 0.0F, false);
			scales8.setTextureOffset(12, 15).addBox(0.0F, -4.0F, 3.5F, 0.0F, 1.0F, 2.0F, 0.0F, false);
			scales8.setTextureOffset(8, 15).addBox(0.0F, -3.0F, 2.5F, 0.0F, 1.0F, 2.0F, 0.0F, false);
			scales9 = new ModelRenderer(this);
			scales9.setRotationPoint(-2.5F, 20.75F, -1.0F);
			setRotationAngle(scales9, 0.0F, -0.2182F, 1.5708F);
			scales9.setTextureOffset(8, 8).addBox(0.0F, -2.0F, 3.5F, 0.0F, 1.0F, 3.0F, 0.0F, false);
			scales9.setTextureOffset(6, 7).addBox(0.0F, -4.0F, 3.5F, 0.0F, 1.0F, 3.0F, 0.0F, false);
			scales9.setTextureOffset(4, 15).addBox(0.0F, -3.0F, 2.5F, 0.0F, 1.0F, 2.0F, 0.0F, false);
			scales10 = new ModelRenderer(this);
			scales10.setRotationPoint(-2.5F, 22.25F, -1.0F);
			setRotationAngle(scales10, 0.0F, 0.2182F, 1.5708F);
			scales10.setTextureOffset(6, 6).addBox(0.0F, -2.0F, 3.5F, 0.0F, 1.0F, 3.0F, 0.0F, false);
			scales10.setTextureOffset(0, 2).addBox(0.0F, -4.0F, 3.5F, 0.0F, 1.0F, 3.0F, 0.0F, false);
			scales10.setTextureOffset(0, 15).addBox(0.0F, -3.0F, 2.5F, 0.0F, 1.0F, 2.0F, 0.0F, false);
			scales11 = new ModelRenderer(this);
			scales11.setRotationPoint(-2.5F, 22.25F, -3.0F);
			setRotationAngle(scales11, 0.0F, 0.2182F, 1.5708F);
			scales11.setTextureOffset(14, 13).addBox(0.0F, -2.0F, 3.5F, 0.0F, 1.0F, 2.0F, 0.0F, false);
			scales11.setTextureOffset(14, 12).addBox(0.0F, -4.0F, 3.5F, 0.0F, 1.0F, 2.0F, 0.0F, false);
			scales11.setTextureOffset(14, 10).addBox(0.0F, -3.0F, 2.5F, 0.0F, 1.0F, 2.0F, 0.0F, false);
			scales12 = new ModelRenderer(this);
			scales12.setRotationPoint(-2.5F, 22.25F, -5.0F);
			setRotationAngle(scales12, 0.0F, 0.2182F, 1.5708F);
			scales12.setTextureOffset(0, 1).addBox(0.0F, -2.0F, 3.5F, 0.0F, 1.0F, 3.0F, 0.0F, false);
			scales12.setTextureOffset(0, 0).addBox(0.0F, -4.0F, 3.5F, 0.0F, 1.0F, 3.0F, 0.0F, false);
			scales12.setTextureOffset(14, 9).addBox(0.0F, -3.0F, 2.5F, 0.0F, 1.0F, 2.0F, 0.0F, false);
			bb_main = new ModelRenderer(this);
			bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
			bb_main.setTextureOffset(0, 0).addBox(-1.0F, -4.0F, -3.0F, 2.0F, 3.0F, 6.0F, 0.0F, false);
			bb_main.setTextureOffset(10, 14).addBox(-0.5F, -2.25F, -4.5F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 9).addBox(-1.0F, -3.75F, -5.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			bb_main.setTextureOffset(10, 0).addBox(-0.25F, -4.5F, -2.6F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(-0.25F, -4.5F, 0.4F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			bb_main.setTextureOffset(16, 17).addBox(-0.25F, -4.75F, -1.6F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(14, 0).addBox(-0.25F, -4.75F, 1.4F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			butt.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			scales.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			scales2.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			scales3.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			scales4.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			scales5.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			scales6.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			scales7.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			scales8.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			scales9.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			scales10.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			scales11.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			scales12.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.butt.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.butt.rotateAngleX = f4 / (180F / (float) Math.PI);
		}
	}

}
