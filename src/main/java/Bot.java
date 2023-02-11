import org.example.Main;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;

public class Bot extends TelegramLongPollingBot {
    boolean firstStart = true;
    @Override
    public void onUpdateReceived(Update update) {
        SendMessage sendMessage = new SendMessage();
        SetButtonRow setButtonRow = new SetButtonRow();
        MakeButtonRow makeButtonRow = new MakeButtonRow();
        LogBot logBot = new LogBot();
        SendTxt sendTxt = new SendTxt();
        SendAud sendAud = new SendAud();
        TryGetIdFile tryGetIdFile = new TryGetIdFile();
        //System.out.println(firstStart);
        //firstStart = true;

        logBot.logUser(update);
        //logBot.logBot(sendMessage); // логирование бота
        //System.out.println("Test");
        if (firstStart) {
            sendTxt.sendText(update, "Привет! " + update.getMessage().getFrom().getFirstName() +
                    " " + update.getMessage().getFrom().getLastName() +" " + update.getMessage().getFrom().getUserName()); // ответ бота
            setButtonRow.visibleKeyBoard("Что будем делать? ", update, makeButtonRow.getKeyboard("start"));
            firstStart = false;
        }
            //        try {
//            sendMessage.setChatId(update.getMessage().getChatId().toString());
//            if (firstStart) {
//                execute(sendMessage);
//                firstStart = false;
//            }
//
//            //sendTxt.sendText(update,"Что будем делать? ");
//            //sendMessage.setText("Что будем делать ?  " ); // ответ бота
////            //logBot.logUser(update); // логирование пользователя
////            execute(sendMessage);
////            //logBot.logBot(sendMessage); // логирование бота
////            //tryGetIdFile.getMusicFileId(update,sendMessage); // нужно только для получения ID файла музыки
////            //sendAud.sendMusic(update,1);
////            //for (int i = 1; i < 4; i++)
////            //    sendAud.sendMusic(update,i);
////            // logBot.logBot(sendMessage);
////            System.out.println("mark1");
//        } catch (TelegramApiException e) {
//            throw new RuntimeException(e);
//        }
    }

    @Override
    public String getBotUsername() {
        return "Solo_Diman_Bot";
    }
    @Override
    public String getBotToken() {
        return "6161633059:AAGY7-RNJe6Y0dEWFL663zEDkR8C6ZW1280";
    }
}
