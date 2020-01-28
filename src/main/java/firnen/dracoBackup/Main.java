package firnen.dracoBackup;

import java.util.Arrays;
import java.util.List;

import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.fabric.api.registry.CommandRegistry;

public class Main implements DedicatedServerModInitializer {

	public static List<String> operations = Arrays.asList("make", "list", "restore", "schedule");
	
	@Override
	public void onInitializeServer() {
		CommandRegistry.INSTANCE.register(true, dispatcher -> Command.register(dispatcher));
	}

}
