import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Date;

public class LogBot {
    public void logUser (Update update) {
        //System.out.println("123");
        Date date = new Date(update.getMessage().getDate());

        System.out.println( update.getMessage().getDate()  + '\n' + " " +
                date.toString() + '\n' +
                "FirstName: " +update.getMessage().getFrom().getFirstName() + '\n' +
                " LastName: " + update.getMessage().getFrom().getLastName() + '\n' +
                " UserName: " + update.getMessage().getFrom().getUserName() + '\n' +
                "Mess User ################################" + '\n' +
                "Mess: " + update.getMessage().getText());
        System.out.println("#######################################################");
        //System.out.println("Bot:" + sendMessage.getText());
    }
    public void logBot (SendMessage sendMessage) {
        System.out.println("Bot:" + sendMessage.getText());
        System.out.println("------------------------------------------------------");
    }
}
