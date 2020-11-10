import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.managers.AudioManager;

public class SendHandler {
    private GuildMessageReceivedEvent event;

    public SendHandler(GuildMessageReceivedEvent event) {
        this.event = event;
    }

    public void SendMessage(String message) {

    }

    public void StartPlayMusic(MusicSendingHandler musicSendingHandler) {
        Guild guild = event.getGuild();
        VoiceChannel channel = guild.getVoiceChannelsByName("Основной", true).get(0);
        AudioManager manager = guild.getAudioManager();
        manager.setSendingHandler(musicSendingHandler);
        manager.openAudioConnection(channel);
    }

    public void StopPlayMusic() {
        Guild guild = event.getGuild();
        AudioManager manager = guild.getAudioManager();
        manager.setSendingHandler(null);
    }
}
