import net.dv8tion.jda.api.audio.AudioSendHandler;

import java.nio.ByteBuffer;

public class MusicSendingHandler implements AudioSendHandler {
    private int i = 300;

    @Override
    public boolean canProvide() {
        if (i > 0) {
            i--;
            return true;
        } else
            return false;
    }

    @Override
    public ByteBuffer provide20MsAudio() {
        return ByteBuffer.wrap(new byte[]{
                120, 120, 120, 120, 120, 120, 120, 120, 120, 120
        });
    }

    @Override
    public boolean isOpus() {
        return true;
    }

}
