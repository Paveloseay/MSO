// Made with Blockbench 4.4.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modellongbowshot extends EntityModel<Entity> {
	private final ModelRenderer bone;

	public Modellongbowshot() {
		textureWidth = 16;
		textureHeight = 16;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 23.5F, 0.0F);
		setRotationAngle(bone, 1.5708F, 0.0F, -3.1416F);
		bone.setTextureOffset(-2, 6).addBox(-1.0F, -1.0F, -5.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);
		bone.setTextureOffset(2, 6).addBox(-1.0F, 1.0F, -3.0F, 2.0F, 2.0F, 4.0F, 0.0F, true);
		bone.setTextureOffset(2, 6).addBox(-1.0F, -3.0F, -3.0F, 2.0F, 2.0F, 4.0F, 0.0F, false);
		bone.setTextureOffset(8, 6).addBox(-1.0F, -4.0F, 1.0F, 2.0F, 2.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(6, 6).addBox(-1.0F, 2.0F, 1.0F, 2.0F, 2.0F, 5.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bone.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
	}
}