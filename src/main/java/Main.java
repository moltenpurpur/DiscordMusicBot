import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.Map;

public class Main extends ListenerAdapter{


    public static void main(String[] args) throws LoginException, IOException {

        Map<String, String> env = System.getenv();
        String token = env.get("DsToken");
        JDA api = JDABuilder.createDefault(token).build();
        api.addEventListener(new Main());
    }


    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        try {
            if (event.getAuthor().isBot()) return;

            Bot.reply(event.getMessage().getContentRaw(), new SendHandler(event));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }


}