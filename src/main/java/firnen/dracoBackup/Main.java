package firnen.dracoBackup;

import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.fabric.api.registry.CommandRegistry;

public class Main implements DedicatedServerModInitializer {

	@Override
	public void onInitializeServer() {
		CommandRegistry.INSTANCE.register(true, dispatcher -> Command.register(dispatcher));
	}

}
