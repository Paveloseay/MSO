// Made with Blockbench 4.4.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modeljawfish extends EntityModel<Entity> {
	private final ModelRenderer body;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer tail;
	private final ModelRenderer teths;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;
	private final ModelRenderer teths2;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r12;

	public Modeljawfish() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.setTextureOffset(0, 0).addBox(-3.0F, -6.0F, -4.0F, 6.0F, 6.0F, 4.0F, 0.0F, false);
		body.setTextureOffset(0, 17).addBox(-2.5F, -5.5F, 0.0F, 5.0F, 5.0F, 2.0F, 0.0F, false);
		body.setTextureOffset(20, 0).addBox(-1.0F, -7.0F, -6.0F, 2.0F, 1.0F, 5.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(-0.1F, -6.0F, 0.3F);
		body.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, -2.7489F);
		cube_r1.setTextureOffset(0, 19).addBox(-2.2F, 0.0F, -6.3F, 0.0F, 3.0F, 5.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-0.1F, -6.0F, 0.3F);
		body.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, 2.6616F);
		cube_r2.setTextureOffset(16, 6).addBox(1.8F, 0.0F, -6.3F, 0.0F, 3.0F, 5.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(0.0F, 1.0F, 0.3F);
		body.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.0F, 0.6545F);
		cube_r3.setTextureOffset(54, 6).addBox(-2.2F, -1.0F, -6.3F, 0.0F, 4.0F, 5.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(0.0F, 1.0F, 0.3F);
		body.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 0.0F, -0.6545F);
		cube_r4.setTextureOffset(34, 19).addBox(1.8F, -1.0F, -6.3F, 0.0F, 4.0F, 5.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(0.0F, 0.0F, 0.3F);
		body.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, 0.2182F, 0.0F);
		cube_r5.setTextureOffset(14, 12).addBox(3.8F, -5.5F, -3.3F, 0.0F, 5.0F, 5.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(0.0F, 0.0F, 0.3F);
		body.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, -0.2182F, 0.0F);
		cube_r6.setTextureOffset(14, 17).addBox(-3.85F, -5.5F, -3.5F, 0.0F, 5.0F, 5.0F, 0.0F, false);

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(tail);
		tail.setTextureOffset(24, 17).addBox(-1.5F, -4.5F, 1.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		tail.setTextureOffset(20, 23).addBox(-0.5F, -4.0F, 4.0F, 1.0F, 2.0F, 4.0F, 0.0F, false);
		tail.setTextureOffset(23, 33).addBox(-0.5F, -3.5F, 8.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		tail.setTextureOffset(21, 45).addBox(0.2F, -6.5F, 6.0F, 0.0F, 3.0F, 3.0F, 0.0F, false);
		tail.setTextureOffset(33, 41).addBox(0.2F, -2.5F, 6.0F, 0.0F, 3.0F, 3.0F, 0.0F, false);

		teths = new ModelRenderer(this);
		teths.setRotationPoint(0.0F, 24.0F, 0.0F);
		teths.setTextureOffset(28, 29).addBox(2.75F, -3.5F, -4.5F, 0.0F, 2.0F, 1.0F, 0.0F, false);
		teths.setTextureOffset(6, 29).addBox(2.75F, -3.5F, -6.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);
		teths.setTextureOffset(24, 28).addBox(-2.25F, -3.5F, -6.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);
		teths.setTextureOffset(22, 0).addBox(2.75F, -3.5F, -7.5F, 0.0F, 2.0F, 1.0F, 0.0F, false);
		teths.setTextureOffset(22, 2).addBox(-2.25F, -3.5F, -7.5F, 0.0F, 2.0F, 1.0F, 0.0F, false);
		teths.setTextureOffset(26, 28).addBox(-2.25F, -3.5F, -4.5F, 0.0F, 2.0F, 1.0F, 0.0F, false);
		teths.setTextureOffset(0, 10).addBox(-3.0F, -6.0F, -8.0F, 6.0F, 3.0F, 4.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(-1.0F, -4.5F, 2.25F);
		teths.addChild(cube_r7);
		setRotationAngle(cube_r7, 1.1781F, 0.0F, 0.0F);
		cube_r7.setTextureOffset(28, 27).addBox(1.95F, -9.0F, -6.75F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r7.setTextureOffset(26, 11).addBox(-0.95F, -9.0F, -6.75F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(-1.0F, -4.5F, 2.25F);
		teths.addChild(cube_r8);
		setRotationAngle(cube_r8, 1.3963F, 0.0F, 0.0F);
		cube_r8.setTextureOffset(0, 2).addBox(1.95F, -10.25F, -5.65F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r8.setTextureOffset(0, 0).addBox(-0.95F, -10.25F, -5.65F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(0.0F, 0.0F, -4.0F);
		teths.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.0F, -1.5708F, 0.0F);
		cube_r9.setTextureOffset(0, 29).addBox(-3.75F, -3.5F, 1.75F, 0.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r9.setTextureOffset(2, 29).addBox(-3.75F, -3.5F, 0.25F, 0.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r9.setTextureOffset(29, 2).addBox(-3.75F, -3.5F, -1.25F, 0.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r9.setTextureOffset(4, 29).addBox(-3.75F, -3.5F, -2.75F, 0.0F, 2.0F, 1.0F, 0.0F, false);

		teths2 = new ModelRenderer(this);
		teths2.setRotationPoint(0.0F, 20.0F, 0.0F);
		setRotationAngle(teths2, 0.0F, 0.0F, -3.1416F);
		teths2.setTextureOffset(22, 28).addBox(2.85F, -3.5F, -5.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);
		teths2.setTextureOffset(20, 28).addBox(2.85F, -3.5F, -6.55F, 0.0F, 2.0F, 1.0F, 0.0F, false);
		teths2.setTextureOffset(12, 16).addBox(-2.75F, -3.5F, -6.55F, 0.0F, 2.0F, 1.0F, 0.0F, false);
		teths2.setTextureOffset(12, 28).addBox(2.95F, -3.5F, -8.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);
		teths2.setTextureOffset(0, 16).addBox(-2.75F, -3.5F, -8.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);
		teths2.setTextureOffset(26, 22).addBox(-2.75F, -3.5F, -5.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);
		teths2.setTextureOffset(16, 6).addBox(-3.0F, -4.0F, -8.0F, 6.0F, 1.0F, 4.0F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(0.0F, 4.0F, 0.0F);
		teths2.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.2182F, 0.0F, 0.0F);
		cube_r10.setTextureOffset(29, 0).addBox(-2.95F, -9.0F, -6.75F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r10.setTextureOffset(8, 29).addBox(1.95F, -9.0F, -6.75F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(0.0F, 4.0F, 0.0F);
		teths2.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.4363F, 0.0F, 0.0F);
		cube_r11.setTextureOffset(0, 10).addBox(-2.95F, -10.25F, -5.65F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r11.setTextureOffset(0, 12).addBox(1.95F, -10.25F, -5.65F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(0.0F, 0.0F, 0.0F);
		teths2.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.0F, -1.5708F, 0.0F);
		cube_r12.setTextureOffset(10, 23).addBox(-7.85F, -3.5F, 2.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r12.setTextureOffset(24, 16).addBox(-7.85F, -3.5F, 0.4F, 0.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r12.setTextureOffset(26, 10).addBox(-7.85F, -3.5F, -1.4F, 0.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r12.setTextureOffset(18, 26).addBox(-7.85F, -3.5F, -3.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		teths.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		teths2.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}