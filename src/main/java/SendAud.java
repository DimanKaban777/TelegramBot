import org.telegram.telegrambots.meta.api.methods.send.SendAudio;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.HashMap;

public class SendAud {
    private HashMap<Integer,String> music = new HashMap<>();
    private String setMusic(int numMusic) {
        this.music.put(1,"CQACAgIAAxkBAAIBTWPisbzqk9dS3GhCEjCfUI1spdnOAAJzKgAC4TMQSw_vA4nGTcnTLgQ");
        this.music.put(2,"CQACAgIAAxkBAAIBT2PismyeYvlcvWnHs9rLsF2DHzY8AAKAKgAC4TMQS8Y9yvk2r7ZWLgQ");
        this.music.put(3,"CQACAgIAAxkBAAIBUWPistuHNW804QabvR3hRdd_HOa-AAKJKgAC4TMQSzzFCZFjZBHZLgQ");
        return this.music.get(numMusic);
    }

    public void sendMusic(Update update, int numMusic) {
        SendAudio sendAudio = new SendAudio();
        sendAudio.setChatId(update.getMessage().getChatId().toString());
        sendAudio.setAudio(new InputFile(setMusic(numMusic)));
        Bot bot = new Bot();
        try {
            bot.execute(sendAudio);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }


}
