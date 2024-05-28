

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Oper {

    //вывод результата
    void printStr(String str) {
        System.out.println(str);
    }

    //запись в файл
    String writeToFile(String fileName, String text) {
        String str = null;
        StandardOpenOption constOption = StandardOpenOption.APPEND;
        if (text==""){
            constOption = StandardOpenOption.TRUNCATE_EXISTING;
        }
        try {
            Files.write(Paths.get(fileName), text.getBytes(), constOption);
        } catch (IOException e) {
            str = e.toString();
        }
        return str;
    }

}
