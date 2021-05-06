import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;

public class RPC {

    static DiscordRPC lib = DiscordRPC.INSTANCE;
    static String applicationId = "774944504041570344";
    static String steamId = "";
    static DiscordEventHandlers handlers = new DiscordEventHandlers();
    static DiscordRichPresence presence = new DiscordRichPresence();



    public static void start() {

        presence.startTimestamp = System.currentTimeMillis() / 1000;

        lib.Discord_Initialize(applicationId, handlers, true, steamId);

        new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                lib.Discord_RunCallbacks();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ignored) {}
            }
        }, "RPC-Callback-Handler").start();
        Debug.printStacktrace("Discord Rich Presence hooked successfully.");
    }


    public static void update() {
        presence.state = "Max: " + Main.hcps + " | Total: " + Main.count + " | Current: " + Main.cps + "c/s";
        lib.Discord_UpdatePresence(presence);
        Debug.printStacktrace("Discord Rich Presence updated.");
    }


}
