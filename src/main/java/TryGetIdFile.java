import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
// Фиксики CQACAgIAAxkBAAIBTWPisbzqk9dS3GhCEjCfUI1spdnOAAJzKgAC4TMQSw_vA4nGTcnTLgQ
// ДДТ Что такое осень CQACAgIAAxkBAAIBT2PismyeYvlcvWnHs9rLsF2DHzY8AAKAKgAC4TMQS8Y9yvk2r7ZWLgQ
// 7b вечно молодой CQACAgIAAxkBAAIBUWPistuHNW804QabvR3hRdd_HOa-AAKJKgAC4TMQSzzFCZFjZBHZLgQ
//cat1 AgACAgIAAxkBAAIDkWPn1VULTEMQRoHcvasUKSL0p0F3AALXwjEbrcdASzrv6Oc1S9pyAQADAgADeQADLgQ
//cat2 AgACAgIAAxkBAAIDk2Pn1X2fp4Awh4DBwVGifX2oBMwCAALawjEbrcdAS7lhk5pvhtFKAQADAgADcwADLgQ
public class TryGetIdFile {
    public void getMusicFileId (Update update, SendMessage sendMessage) {
        sendMessage.setText(String.valueOf(update.getMessage().getAudio().getFileId())); // отдает Id загруженного файла
    }

    public void getPhotoFileId (Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId().toString());
        sendMessage.setText(String.valueOf(update.getMessage().getPhoto()));
        Bot bot = new Bot();
        try {
            bot.execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
        // отдает Id загруженного файла
    }
}
