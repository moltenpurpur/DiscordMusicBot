public class Bot {
    public static void reply(String message, SendHandler sendHandler) {
        if (message.equals("!play1")) {
            String track = "C:\\Users\\КовтунЕкатеринаОлего\\Desktop\\Java\\DiscordMusicBot\\src\\main\\resources\\Мельница - Двери Тамерлана.mp3";
            sendHandler.startPlayMusic(track);
        }
        if (message.equals("!play2")) {
            String track = "C:\\Users\\КовтунЕкатеринаОлего\\Desktop\\Java\\DiscordMusicBot\\src\\main\\resources\\Мельница - Дракон.mp3";
            sendHandler.startPlayMusic(track);
        }
        if (message.equals("!play3")) {
            String track = "C:\\Users\\КовтунЕкатеринаОлего\\Desktop\\Java\\DiscordMusicBot\\src\\main\\resources\\Мельница - Ночная кобыла.mp3";
            sendHandler.startPlayMusic(track);
        }

        if (message.startsWith("!play url")) {
            String track = message.substring(10);
            sendHandler.startPlayMusic(track);
        }
        if (message.equals("!stop"))
            sendHandler.stopPlayMusic();
        if (message.equals("!next"))
            sendHandler.nextTrack();
        if (message.equals("!help"))
            sendHandler.sendMessage(getHelp());

    }

    private static String getHelp() {
        return "!play1 -первый трек \n" +
                "!play2 -второй трек \n" +
                "!play3 -третий трек \n" +
                "!play url [ссылка] - воспроизвести с ютуба \n" +
                "!stop - остоновить" +
                "!next - следующий трек";
    }
}
