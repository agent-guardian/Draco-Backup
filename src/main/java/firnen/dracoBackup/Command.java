package firnen.dracoBackup;

import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;

import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.LiteralText;

public class Command {

	public static final Logger logger = LogManager.getLogger();

	public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
		LiteralArgumentBuilder<ServerCommandSource> lab = CommandManager.literal("backup")
				.requires(source -> source.hasPermissionLevel(4))
				.then(CommandManager.argument("operation", StringArgumentType.word())
						.suggests(CommandSuggestion.getOperationSuggestions())
						.executes((ctx) -> {
							switch(Main.operations.indexOf(ctx.getArgument("operation", String.class).toLowerCase(Locale.ROOT))) {
							case 0: //make
								ctx.getSource().sendFeedback(new LiteralText("Making Backup"),true);
								break;
							case 1: //list
								ctx.getSource().sendFeedback(new LiteralText("List backups"), true);
								break;
							case 2: //restore
								ctx.getSource().sendFeedback(new LiteralText("Restore a Backup"), true);
								break;
							case 3: //schedule
								ctx.getSource().sendFeedback(new LiteralText("Schedule regular backups"), true);
							}
							return 1;
						}));
		dispatcher.register(lab);
	}
}
