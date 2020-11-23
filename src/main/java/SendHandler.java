import Music.GuildMusicManager;
import Music.PlayerManager;
import com.sedmelluq.discord.lavaplayer.container.adts.AdtsAudioTrack;
import com.sedmelluq.discord.lavaplayer.player.*;
import com.sedmelluq.discord.lavaplayer.source.youtube.YoutubeAudioTrack;
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException;
import com.sedmelluq.discord.lavaplayer.track.AudioItem;
import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist;
import com.sedmelluq.discord.lavaplayer.track.AudioReference;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import com.sedmelluq.discord.lavaplayer.source.youtube.YoutubeAudioSourceManager;
import com.sun.source.doctree.AuthorTree;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.managers.AudioManager;

public class SendHandler {
    private GuildMessageReceivedEvent event;

    public SendHandler(GuildMessageReceivedEvent event) {

        this.event = event;
    }

    public void sendMessage(String message) {
        event.getChannel().sendMessage(message).queue();
    }

    public void startPlayMusic(String track) {
        Guild guild = event.getGuild();
        VoiceChannel channel = guild.getVoiceChannelsByName("Основной", true).get(0);
        AudioManager managerQ = guild.getAudioManager();
        managerQ.openAudioConnection(channel);

        PlayerManager manager = PlayerManager.getInstance();
        manager.loadAndPlay(event.getChannel(), track);
        manager.getGuildMusicManager(event.getGuild()).player.setVolume(10);

    }

    public void stopPlayMusic() {
        PlayerManager manager = PlayerManager.getInstance();
        manager.getGuildMusicManager(event.getGuild()).scheduler.clear();
    }

    public void nextTrack() {
        PlayerManager manager = PlayerManager.getInstance();
        manager.getGuildMusicManager(event.getGuild()).scheduler.nextTrack();
    }
}
