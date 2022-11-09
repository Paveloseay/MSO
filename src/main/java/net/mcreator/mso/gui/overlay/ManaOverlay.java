
package net.mcreator.mso.gui.overlay;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;

import net.mcreator.mso.procedures.M9Procedure;
import net.mcreator.mso.procedures.M8Procedure;
import net.mcreator.mso.procedures.M7Procedure;
import net.mcreator.mso.procedures.M6Procedure;
import net.mcreator.mso.procedures.M5Procedure;
import net.mcreator.mso.procedures.M4Procedure;
import net.mcreator.mso.procedures.M40Procedure;
import net.mcreator.mso.procedures.M3Procedure;
import net.mcreator.mso.procedures.M39Procedure;
import net.mcreator.mso.procedures.M38Procedure;
import net.mcreator.mso.procedures.M37Procedure;
import net.mcreator.mso.procedures.M36Procedure;
import net.mcreator.mso.procedures.M35Procedure;
import net.mcreator.mso.procedures.M34Procedure;
import net.mcreator.mso.procedures.M33Procedure;
import net.mcreator.mso.procedures.M32Procedure;
import net.mcreator.mso.procedures.M31Procedure;
import net.mcreator.mso.procedures.M30Procedure;
import net.mcreator.mso.procedures.M2Procedure;
import net.mcreator.mso.procedures.M29Procedure;
import net.mcreator.mso.procedures.M28Procedure;
import net.mcreator.mso.procedures.M27Procedure;
import net.mcreator.mso.procedures.M26Procedure;
import net.mcreator.mso.procedures.M25Procedure;
import net.mcreator.mso.procedures.M24Procedure;
import net.mcreator.mso.procedures.M23Procedure;
import net.mcreator.mso.procedures.M22Procedure;
import net.mcreator.mso.procedures.M21Procedure;
import net.mcreator.mso.procedures.M20Procedure;
import net.mcreator.mso.procedures.M1Procedure;
import net.mcreator.mso.procedures.M19Procedure;
import net.mcreator.mso.procedures.M18Procedure;
import net.mcreator.mso.procedures.M17Procedure;
import net.mcreator.mso.procedures.M16Procedure;
import net.mcreator.mso.procedures.M15Procedure;
import net.mcreator.mso.procedures.M14Procedure;
import net.mcreator.mso.procedures.M13Procedure;
import net.mcreator.mso.procedures.M12Procedure;
import net.mcreator.mso.procedures.M11Procedure;
import net.mcreator.mso.procedures.M10Procedure;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber
public class ManaOverlay {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void eventHandler(RenderGameOverlayEvent.Post event) {
		if (event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
			int w = event.getWindow().getScaledWidth();
			int h = event.getWindow().getScaledHeight();
			int posX = w / 2;
			int posY = h / 2;
			World _world = null;
			double _x = 0;
			double _y = 0;
			double _z = 0;
			PlayerEntity entity = Minecraft.getInstance().player;
			if (entity != null) {
				_world = entity.world;
				_x = entity.getPosX();
				_y = entity.getPosY();
				_z = entity.getPosZ();
			}
			World world = _world;
			double x = _x;
			double y = _y;
			double z = _z;
			RenderSystem.disableDepthTest();
			RenderSystem.depthMask(false);
			RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
					GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
			RenderSystem.disableAlphaTest();
			if (true) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("mso:textures/manabarempty.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -100, posY + 115, 0, 0, 200, 5, 200, 5);

				if (M1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("mso:textures/manablockhalf.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -99, posY + 115, 0, 0, 10, 5, 10, 5);
				}
				if (M3Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("mso:textures/manablockhalf.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -90, posY + 115, 0, 0, 10, 5, 10, 5);
				}
				if (M5Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("mso:textures/manablockhalf.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -79, posY + 115, 0, 0, 10, 5, 10, 5);
				}
				if (M11Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("mso:textures/manablockhalf.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -49, posY + 115, 0, 0, 10, 5, 10, 5);
				}
				if (M7Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("mso:textures/manablockhalf.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -69, posY + 115, 0, 0, 10, 5, 10, 5);
				}
				if (M9Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("mso:textures/manablockhalf.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -59, posY + 115, 0, 0, 10, 5, 10, 5);
				}
				if (M4Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("mso:textures/manablockfill.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -89, posY + 115, 0, 0, 10, 5, 10, 5);
				}
				if (M6Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("mso:textures/manablockfill.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -79, posY + 115, 0, 0, 10, 5, 10, 5);
				}
				if (M8Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("mso:textures/manablockfill.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -69, posY + 115, 0, 0, 10, 5, 10, 5);
				}
				if (M10Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("mso:textures/manablockfill.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -59, posY + 115, 0, 0, 10, 5, 10, 5);
				}
				if (M12Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("mso:textures/manablockfill.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -49, posY + 115, 0, 0, 10, 5, 10, 5);
				}
				if (M2Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("mso:textures/manablockfill.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -99, posY + 115, 0, 0, 10, 5, 10, 5);
				}
				if (M13Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("mso:textures/manablockhalf.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -39, posY + 115, 0, 0, 10, 5, 10, 5);
				}
				if (M14Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("mso:textures/manablockfill.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -39, posY + 115, 0, 0, 10, 5, 10, 5);
				}
				if (M15Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("mso:textures/manablockhalf.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -29, posY + 115, 0, 0, 10, 5, 10, 5);
				}
				if (M16Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("mso:textures/manablockfill.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -29, posY + 115, 0, 0, 10, 5, 10, 5);
				}
				if (M17Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("mso:textures/manablockhalf.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -19, posY + 115, 0, 0, 10, 5, 10, 5);
				}
				if (M18Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("mso:textures/manablockfill.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -19, posY + 115, 0, 0, 10, 5, 10, 5);
				}
				if (M19Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("mso:textures/manablockhalf.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -9, posY + 115, 0, 0, 10, 5, 10, 5);
				}
				if (M20Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("mso:textures/manablockfill.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -9, posY + 115, 0, 0, 10, 5, 10, 5);
				}
				if (M21Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("mso:textures/manablockhalf.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 1, posY + 115, 0, 0, 10, 5, 10, 5);
				}
				if (M22Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("mso:textures/manablockfill.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 1, posY + 115, 0, 0, 10, 5, 10, 5);
				}
				if (M23Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("mso:textures/manablockhalf.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 11, posY + 115, 0, 0, 10, 5, 10, 5);
				}
				if (M24Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("mso:textures/manablockfill.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 11, posY + 115, 0, 0, 10, 5, 10, 5);
				}
				if (M25Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("mso:textures/manablockhalf.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 21, posY + 115, 0, 0, 10, 5, 10, 5);
				}
				if (M26Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("mso:textures/manablockfill.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 21, posY + 115, 0, 0, 10, 5, 10, 5);
				}
				if (M27Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("mso:textures/manablockhalf.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 31, posY + 115, 0, 0, 10, 5, 10, 5);
				}
				if (M28Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("mso:textures/manablockfill.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 31, posY + 115, 0, 0, 10, 5, 10, 5);
				}
				if (M29Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("mso:textures/manablockhalf.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 41, posY + 115, 0, 0, 10, 5, 10, 5);
				}
				if (M30Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("mso:textures/manablockfill.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 41, posY + 115, 0, 0, 10, 5, 10, 5);
				}
				if (M31Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("mso:textures/manablockhalf.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 51, posY + 115, 0, 0, 10, 5, 10, 5);
				}
				if (M32Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("mso:textures/manablockfill.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 51, posY + 115, 0, 0, 10, 5, 10, 5);
				}
				if (M33Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("mso:textures/manablockhalf.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 61, posY + 115, 0, 0, 10, 5, 10, 5);
				}
				if (M34Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("mso:textures/manablockfill.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 61, posY + 115, 0, 0, 10, 5, 10, 5);
				}
				if (M35Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("mso:textures/manablockhalf.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 71, posY + 115, 0, 0, 10, 5, 10, 5);
				}
				if (M36Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("mso:textures/manablockfill.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 71, posY + 115, 0, 0, 10, 5, 10, 5);
				}
				if (M37Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("mso:textures/manablockhalf.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 81, posY + 115, 0, 0, 10, 5, 10, 5);
				}
				if (M38Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("mso:textures/manablockfill.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 81, posY + 115, 0, 0, 10, 5, 10, 5);
				}
				if (M39Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("mso:textures/manablockhalf.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 91, posY + 115, 0, 0, 10, 5, 10, 5);
				}
				if (M40Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("mso:textures/manablockfill.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 91, posY + 115, 0, 0, 10, 5, 10, 5);
				}
			}
			RenderSystem.depthMask(true);
			RenderSystem.enableDepthTest();
			RenderSystem.enableAlphaTest();
			RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		}
	}
}
