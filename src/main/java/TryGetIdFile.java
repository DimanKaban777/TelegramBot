import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
// Фиксики CQACAgIAAxkBAAIBTWPisbzqk9dS3GhCEjCfUI1spdnOAAJzKgAC4TMQSw_vA4nGTcnTLgQ
// ДДТ Что такое осень CQACAgIAAxkBAAIBT2PismyeYvlcvWnHs9rLsF2DHzY8AAKAKgAC4TMQS8Y9yvk2r7ZWLgQ
// 7b вечно молодой CQACAgIAAxkBAAIBUWPistuHNW804QabvR3hRdd_HOa-AAKJKgAC4TMQSzzFCZFjZBHZLgQ

public class TryGetIdFile {
    public void getMusicFileId (Update update, SendMessage sendMessage) {
        sendMessage.setText(String.valueOf(update.getMessage().getAudio().getFileId())); // отдает Id загруженного файла
    }
}
