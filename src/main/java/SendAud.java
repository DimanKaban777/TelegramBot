import org.telegram.telegrambots.meta.api.methods.send.SendAudio;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.HashMap;

public class SendAud {
    private HashMap<Integer,String> music = new HashMap<>();
    private HashMap<Integer,String> photo = new HashMap<>();
    public   SendAud() {
        this.music.put(1,"CQACAgIAAxkBAAIBTWPisbzqk9dS3GhCEjCfUI1spdnOAAJzKgAC4TMQSw_vA4nGTcnTLgQ");
        this.music.put(2,"CQACAgIAAxkBAAIBT2PismyeYvlcvWnHs9rLsF2DHzY8AAKAKgAC4TMQS8Y9yvk2r7ZWLgQ");
        this.music.put(3,"CQACAgIAAxkBAAIBUWPistuHNW804QabvR3hRdd_HOa-AAKJKgAC4TMQSzzFCZFjZBHZLgQ");
        //return this.music.get(numMusic);
        //cat1 AgACAgIAAxkBAAIDkWPn1VULTEMQRoHcvasUKSL0p0F3AALXwjEbrcdASzrv6Oc1S9pyAQADAgADeQADLgQ
//cat2 AgACAgIAAxkBAAIDk2Pn1X2fp4Awh4DBwVGifX2oBMwCAALawjEbrcdAS7lhk5pvhtFKAQADAgADcwADLgQ
        this.photo.put(1,"AgACAgIAAxkBAAIDkWPn1VULTEMQRoHcvasUKSL0p0F3AALXwjEbrcdASzrv6Oc1S9pyAQADAgADeQADLgQ");
        this.photo.put(2,"AgACAgIAAxkBAAIDk2Pn1X2fp4Awh4DBwVGifX2oBMwCAALawjEbrcdAS7lhk5pvhtFKAQADAgADcwADLgQ");

    }

    public void sendMusic(Update update, int numMusic) {
        SendAudio sendAudio = new SendAudio();
        sendAudio.setChatId(update.getMessage().getChatId().toString());
        sendAudio.setAudio(new InputFile(music.get(numMusic)));
        Bot bot = new Bot();
        try {
            bot.execute(sendAudio);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
        public void sendJPG (Update update, int numPhoto) {
            SendPhoto sendPhoto = new SendPhoto();
            sendPhoto.setChatId(update.getMessage().getChatId().toString());
            sendPhoto.setPhoto(new InputFile(photo.get(numPhoto)));
            Bot bot = new Bot();
            try {
                bot.execute(sendPhoto);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }

    }

}
