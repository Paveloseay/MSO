// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modelcustom_model extends EntityModel<Entity> {
	private final ModelRenderer backpack;
	private final ModelRenderer body;
	private final ModelRenderer lefthand;
	private final ModelRenderer rightrand;
	private final ModelRenderer leftleg;
	private final ModelRenderer right_leg;
	private final ModelRenderer Head;

	public Modelcustom_model() {
		textureWidth = 64;
		textureHeight = 64;

		backpack = new ModelRenderer(this);
		backpack.setRotationPoint(0.0F, 21.0F, 7.0F);
		backpack.setTextureOffset(22, 3).addBox(-2.5F, -7.0F, -3.0F, 5.0F, 3.0F, 1.0F, 0.0F, false);
		backpack.setTextureOffset(0, 20).addBox(-3.0F, -9.5F, -5.5F, 6.0F, 6.0F, 3.0F, 0.0F, false);
		backpack.setTextureOffset(18, 0).addBox(-2.5F, -10.5F, -5.0F, 5.0F, 1.0F, 2.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.setTextureOffset(0, 0).addBox(-3.5F, -14.5F, -2.0F, 7.0F, 9.0F, 4.0F, 0.0F, false);

		lefthand = new ModelRenderer(this);
		lefthand.setRotationPoint(0.0F, 24.0F, 0.0F);
		lefthand.setTextureOffset(12, 34).addBox(3.5F, -14.0F, -1.5F, 3.0F, 7.0F, 3.0F, 0.0F, false);

		rightrand = new ModelRenderer(this);
		rightrand.setRotationPoint(0.0F, 24.0F, 0.0F);
		rightrand.setTextureOffset(0, 29).addBox(-6.5F, -14.0F, -1.5F, 3.0F, 7.0F, 3.0F, 0.0F, false);

		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(0.0F, 24.0F, 0.0F);
		leftleg.setTextureOffset(24, 34).addBox(0.25F, -6.0F, -1.5F, 3.0F, 6.0F, 3.0F, 0.0F, false);
		leftleg.setTextureOffset(20, 27).addBox(0.25F, -2.0F, -2.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		right_leg = new ModelRenderer(this);
		right_leg.setRotationPoint(0.0F, 24.0F, 0.0F);
		right_leg.setTextureOffset(20, 24).addBox(-3.25F, -2.0F, -2.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);
		right_leg.setTextureOffset(35, 21).addBox(-3.25F, -6.0F, -1.5F, 3.0F, 6.0F, 3.0F, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 24.0F, 0.0F);
		Head.setTextureOffset(26, 24).addBox(2.0F, -19.0F, -3.0F, 1.0F, 4.0F, 6.0F, 0.0F, false);
		Head.setTextureOffset(18, 14).addBox(-2.0F, -19.0F, -2.25F, 4.0F, 4.0F, 6.0F, 0.0F, false);
		Head.setTextureOffset(18, 7).addBox(-3.0F, -15.0F, -3.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);
		Head.setTextureOffset(12, 24).addBox(-3.0F, -19.0F, -3.0F, 1.0F, 4.0F, 6.0F, 0.0F, false);
		Head.setTextureOffset(0, 13).addBox(-3.0F, -20.0F, -3.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		backpack.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		lefthand.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		rightrand.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		leftleg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		Head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		this.lefthand.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.right_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.rightrand.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.leftleg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}