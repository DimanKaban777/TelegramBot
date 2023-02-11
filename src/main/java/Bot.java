import org.example.Main;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Bot extends TelegramLongPollingBot {
    boolean firstStart = true;
    private Map<String,Boolean> mapFirstStart = new HashMap<>();//можно было не выпедриваться с мапами а просто хранить сессию в массиве. если сессии нет то первый вход - если есть то явно не первый
    String userText = "df"; //текст пользователя
    @Override
    public void onUpdateReceived(Update update) {
        SendMessage sendMessage = new SendMessage();
        SendPhoto sendPhoto = new SendPhoto();
        SetButtonRow setButtonRow = new SetButtonRow();
        MakeButtonRow makeButtonRow = new MakeButtonRow();
        LogBot logBot = new LogBot();
        SendTxt sendTxt = new SendTxt();
        SendAud sendAud = new SendAud();
        TryGetIdFile tryGetIdFile = new TryGetIdFile();

        System.out.println("ID: " + update.getMessage().getChatId().toString());
        // Map <String, SetButtonRow> mapKeyBoard = new HashMap<>();
        //mapKeyBoard.put("Посмотрим котиков?",setButtonRow.visibleKeyBoard("Выбери котика: ", update, makeButtonRow.getKeyboard("photo")));
        //mapKeyBoard.put("Послушаем музыку?",setButtonRow.visibleKeyBoard("Выбери музыку: ", update, makeButtonRow.getKeyboard("music")));
        System.out.println(firstStart);
        //firstStart = true;

        logBot.logUser(update);
        //logBot.logBot(sendMessage); // логирование бота
        //System.out.println("Test");
        if (!mapFirstStart.containsKey(update.getMessage().getChatId().toString())) { //если первый раз то приветствие
            sendTxt.sendText(update, "Привет! " + update.getMessage().getFrom().getFirstName() +
                    " " + update.getMessage().getFrom().getLastName() +" " + update.getMessage().getFrom().getUserName()); // ответ бота
            setButtonRow.visibleKeyBoard("Что будем делать? ", update, makeButtonRow.getKeyboard("start"));
            //firstStart = false;
            mapFirstStart.put(update.getMessage().getChatId().toString(),true);
        }
        else {
            mapFirstStart.put(update.getMessage().getChatId().toString(),false);
            userText = update.getMessage().getText();
            System.out.println("test1 "+userText);
            switch (userText) {
                case "Посмотрим котиков?" : {setButtonRow.visibleKeyBoard("Выбери котика: ", update, makeButtonRow.getKeyboard("photo")); break; }
                case "Послушаем музыку?" : {setButtonRow.visibleKeyBoard("Выбери музыку: ", update, makeButtonRow.getKeyboard("music")); break; }
                case "Вернуться..." : {setButtonRow.visibleKeyBoard("Что будем делать? ", update, makeButtonRow.getKeyboard("start")); break; }
                case "Фиксики" : {sendAud.sendMusic(update,1);break;}
                case "ДДТ" : {sendAud.sendMusic(update,2);break;}
                case "7Б" : {sendAud.sendMusic(update,3);break;}
                case "Кот1" : {sendAud.sendJPG(update,1);break;}
                case "Кот2" : {sendAud.sendJPG(update,2);break;}
                case "Поговорим?" : {sendTxt.sendText(update, "не буду я с тобой разговаривать... ");break;}
                case "reloadsolo" : {sendTxt.sendText(update, "Бот ребутается ... ");
                    sendTxt.sendText(update, "Привет! " + update.getMessage().getFrom().getFirstName() +
                            " " + update.getMessage().getFrom().getLastName() +" " + update.getMessage().getFrom().getUserName()); // ответ бота
                    setButtonRow.visibleKeyBoard("Что будем делать? ", update, makeButtonRow.getKeyboard("start"));
                    break;
                }
                case "Reloadsolo" : {sendTxt.sendText(update, "Бот ребутается... ");
                    sendTxt.sendText(update, "Привет! " + update.getMessage().getFrom().getFirstName() +
                            " " + update.getMessage().getFrom().getLastName() +" " + update.getMessage().getFrom().getUserName()); // ответ бота
                    setButtonRow.visibleKeyBoard("Что будем делать? ", update, makeButtonRow.getKeyboard("start"));
                    break;
                }

            }
        }
        System.out.println(mapFirstStart.toString());





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
//tryGetIdFile.getPhotoFileId(update); // нужно только для получения ID файла музыки
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
