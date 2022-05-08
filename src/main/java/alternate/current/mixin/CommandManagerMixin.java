package alternate.current.mixin;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.mojang.brigadier.CommandDispatcher;

import alternate.current.command.AlternateCurrentCommand;

import net.minecraft.class_3915;
import net.minecraft.server.command.CommandManager;

@Mixin(CommandManager.class)
public class CommandManagerMixin {

	@Shadow @Final private CommandDispatcher<class_3915> field_19323;

	@Inject(
		method="<init>",
		at = @At(
			value = "INVOKE",
			shift = Shift.BEFORE,
			target = "Lcom/mojang/brigadier/CommandDispatcher;findAmbiguities(Lcom/mojang/brigadier/AmbiguityConsumer;)V"
		)
	)
	private void registerCommands(boolean isDedicatedServer, CallbackInfo ci) {
		AlternateCurrentCommand.register(field_19323);
	}
}
