public class Bot {
    public static void reply(String message, SendHandler sendHandler) {
        if (message.equals("!play"))
            sendHandler.StartPlayMusic(new MusicSendingHandler());
        if (message.equals("!stop"))
            sendHandler.StopPlayMusic();
    }
}
