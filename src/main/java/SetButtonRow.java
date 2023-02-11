import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;

//показываем клавиатуру
public class SetButtonRow {
    public void visibleKeyBoard (String text, Update update, ArrayList list) {
        //String text передаем сюда текст так как нужно передать вопрос а update изменяется после каждой отправки сообщения боту
        // и дублируются сообщения поэтому нельзя использовать SendTxt для вывода клавиатуры.
        SendMessage sendMessage = new SendMessage();
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(list);
        //System.out.println(list.toString());
        sendMessage.setChatId(update.getMessage().getChatId().toString());
        sendMessage.setText(text);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        Bot bot = new Bot();
        try {
            bot.execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
        //return null;
    }
}
