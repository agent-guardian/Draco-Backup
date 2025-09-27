package firnen.dracoBackup;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;

import com.mojang.brigadier.suggestion.SuggestionProvider;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;

import net.minecraft.server.command.ServerCommandSource;

public class CommandSuggestion {
	
	

	public static SuggestionProvider<ServerCommandSource> getOperationSuggestions(){
		return (ctx, builder) -> getSuggestionsBuilder(builder, Main.operations);
	}
	
	private static CompletableFuture<Suggestions> getSuggestionsBuilder(SuggestionsBuilder builder, List<String> list){
		String remaining = builder.getRemaining().toLowerCase(Locale.ROOT);
		
		if(list.isEmpty())
			return Suggestions.empty();
		
		for(String str : list) {
			if(str.toLowerCase(Locale.ROOT).startsWith(remaining))
				builder.suggest(str);
		}
		return builder.buildFuture();
	}
}
