import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class MakeButtonRow {
    private KeyboardRow keyboardRowMusic = new KeyboardRow();
    private KeyboardRow keyboardRowMusic1 = new KeyboardRow();
    private KeyboardRow keyboardRowPhoto = new KeyboardRow();
    private KeyboardRow keyboardRowPhoto1 = new KeyboardRow();
    private KeyboardRow keyboardRowQuestion = new KeyboardRow();
    private KeyboardRow keyboardRowQuestion1 = new KeyboardRow();
    public MakeButtonRow() {
        this.keyboardRowMusic.add(new KeyboardButton("Фиксики"));
        this.keyboardRowMusic.add(new KeyboardButton("ДДТ"));
        this.keyboardRowMusic.add(new KeyboardButton("7Б"));
        this.keyboardRowMusic1.add(new KeyboardButton("Вернуться..."));

        this.keyboardRowPhoto.add(new KeyboardButton("Кот1"));
        this.keyboardRowPhoto.add(new KeyboardButton("Кот2"));
        this.keyboardRowPhoto1.add(new KeyboardButton("Вернуться..."));

        this.keyboardRowQuestion1.add(new KeyboardButton("Поговорим?"));
        this.keyboardRowQuestion.add(new KeyboardButton("Посмотрим котиков?"));
        this.keyboardRowQuestion.add(new KeyboardButton("Послушаем музыку?"));
    }
    public ArrayList getKeyboard (String str) {
        ArrayList <KeyboardRow> list = new ArrayList<>();
        switch (str){
            case "start":
                //System.out.println("Mark1");
                list.add(this.keyboardRowQuestion);
                list.add(this.keyboardRowQuestion1);
                break;
            case "photo":
                //System.out.println("Mark1");
                list.add(this.keyboardRowPhoto);
                list.add(this.keyboardRowPhoto1);
                break;
            case "music":
                //System.out.println("Mark1");
                list.add(this.keyboardRowMusic);
                list.add(this.keyboardRowMusic1);
                break;
        }
        return  list;
    }
}
