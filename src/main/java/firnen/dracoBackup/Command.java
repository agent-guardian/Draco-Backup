package firnen.dracoBackup;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;

import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.LiteralText;

public class Command {

	public static final Logger logger = LogManager.getLogger();
	
	public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
		LiteralArgumentBuilder<ServerCommandSource> lab = CommandManager.literal("backup")
				.executes((ctx) -> {
					ctx.getSource().sendFeedback(new LiteralText("Test"), false);
					logger.info("[" + ctx.getSource().getPlayer().getName().getString() + ": used the backup command.]");
					return 1;
				});
		dispatcher.register(lab);
	}
}
