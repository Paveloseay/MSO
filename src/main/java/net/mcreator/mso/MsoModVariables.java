package net.mcreator.mso;

import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Direction;
import net.minecraft.network.PacketBuffer;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;

public class MsoModVariables {
	public MsoModVariables(MsoModElements elements) {
		elements.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new,
				PlayerVariablesSyncMessage::handler);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::init);
	}

	private void init(FMLCommonSetupEvent event) {
		CapabilityManager.INSTANCE.register(PlayerVariables.class, new PlayerVariablesStorage(), PlayerVariables::new);
	}

	@CapabilityInject(PlayerVariables.class)
	public static Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = null;

	@SubscribeEvent
	public void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof PlayerEntity && !(event.getObject() instanceof FakePlayer))
			event.addCapability(new ResourceLocation("mso", "player_variables"), new PlayerVariablesProvider());
	}

	private static class PlayerVariablesProvider implements ICapabilitySerializable<INBT> {
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(PLAYER_VARIABLES_CAPABILITY::getDefaultInstance);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public INBT serializeNBT() {
			return PLAYER_VARIABLES_CAPABILITY.getStorage().writeNBT(PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new),
					null);
		}

		@Override
		public void deserializeNBT(INBT nbt) {
			PLAYER_VARIABLES_CAPABILITY.getStorage().readNBT(PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new), null,
					nbt);
		}
	}

	private static class PlayerVariablesStorage implements Capability.IStorage<PlayerVariables> {
		@Override
		public INBT writeNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side) {
			CompoundNBT nbt = new CompoundNBT();
			nbt.putDouble("Mana", instance.Mana);
			nbt.putDouble("maxmp", instance.maxmp);
			nbt.putDouble("ivydaggerskillselect", instance.ivydaggerskillselect);
			nbt.putDouble("thornslogbowskillselect", instance.thornslogbowskillselect);
			nbt.putDouble("thornsshieldskillselect", instance.thornsshieldskillselect);
			nbt.putDouble("commandshotcooldown", instance.commandshotcooldown);
			nbt.putDouble("waterfallskillselect", instance.waterfallskillselect);
			return nbt;
		}

		@Override
		public void readNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side, INBT inbt) {
			CompoundNBT nbt = (CompoundNBT) inbt;
			instance.Mana = nbt.getDouble("Mana");
			instance.maxmp = nbt.getDouble("maxmp");
			instance.ivydaggerskillselect = nbt.getDouble("ivydaggerskillselect");
			instance.thornslogbowskillselect = nbt.getDouble("thornslogbowskillselect");
			instance.thornsshieldskillselect = nbt.getDouble("thornsshieldskillselect");
			instance.commandshotcooldown = nbt.getDouble("commandshotcooldown");
			instance.waterfallskillselect = nbt.getDouble("waterfallskillselect");
		}
	}

	public static class PlayerVariables {
		public double Mana = 50.0;
		public double maxmp = 200.0;
		public double ivydaggerskillselect = 1.0;
		public double thornslogbowskillselect = 1.0;
		public double thornsshieldskillselect = 1.0;
		public double commandshotcooldown = 0;
		public double waterfallskillselect = 1.0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayerEntity)
				MsoMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) entity), new PlayerVariablesSyncMessage(this));
		}
	}

	@SubscribeEvent
	public void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void clonePlayer(PlayerEvent.Clone event) {
		PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new PlayerVariables()));
		PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
		clone.maxmp = original.maxmp;
		clone.ivydaggerskillselect = original.ivydaggerskillselect;
		clone.thornslogbowskillselect = original.thornslogbowskillselect;
		clone.thornsshieldskillselect = original.thornsshieldskillselect;
		clone.waterfallskillselect = original.waterfallskillselect;
		if (!event.isWasDeath()) {
			clone.Mana = original.Mana;
			clone.commandshotcooldown = original.commandshotcooldown;
		}
	}

	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;

		public PlayerVariablesSyncMessage(PacketBuffer buffer) {
			this.data = new PlayerVariables();
			new PlayerVariablesStorage().readNBT(null, this.data, null, buffer.readCompoundTag());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, PacketBuffer buffer) {
			buffer.writeCompoundTag((CompoundNBT) new PlayerVariablesStorage().writeNBT(null, message.data, null));
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new PlayerVariables()));
					variables.Mana = message.data.Mana;
					variables.maxmp = message.data.maxmp;
					variables.ivydaggerskillselect = message.data.ivydaggerskillselect;
					variables.thornslogbowskillselect = message.data.thornslogbowskillselect;
					variables.thornsshieldskillselect = message.data.thornsshieldskillselect;
					variables.commandshotcooldown = message.data.commandshotcooldown;
					variables.waterfallskillselect = message.data.waterfallskillselect;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
