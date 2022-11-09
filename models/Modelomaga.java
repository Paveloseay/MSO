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
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		left.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		bone.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		right.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
	}
}