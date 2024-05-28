import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.regex.*;

public class Dict {

    Map<String, String> map = new HashMap<String, String>();
    String fileName;
    Oper oper = new Oper();
    int tip;

    //условия добавления
    Boolean isDefWord(String key) {
        Pattern patlatletter = Pattern.compile("[a-zA-Z]+");
        Matcher matlatletter = patlatletter.matcher(key);

        Pattern patlatletter2 = Pattern.compile("[0-9]+");
        Matcher matlatletter2 = patlatletter2.matcher(key);



        if ((tip==1) && (key.length()==4) && matlatletter.matches()) {
            return true;
        }

        else if ((tip==2) && (key.length()==5) && matlatletter2.matches()) {
            return true;
        }

        else {
            return false;
        }

    }

    //конструктор


    Dict(int tip, String filename) {
        this.fileName = filename;
        this.tip = tip;
        try {
            File file = new File(filename);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = null;
            while ((line = reader.readLine()) != null) {
                try {
                    String[] parts = line.split(",");
                    map.put(parts[0], parts[1]);
                }
                catch (java.lang.ArrayIndexOutOfBoundsException e) {

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    //запись в файл


    //проверка наличия ключа
    Boolean isKeyInDict(String wordEng){
        if (map.containsKey(wordEng)) {
            return true;
        }
        else{
            return false;
        }
    }

    //добавление записи
    String setWord(String wordEng, String wordRus) {
        String str = null;
        if (isKeyInDict(wordEng)) {
            str ="\nThis key is already there! Please delete it before overwriting!";
        } else {
            if (isDefWord(wordEng)) {
                map.put(wordEng, wordRus);
                String text = "\n" + wordEng + "," + wordRus;
                oper.writeToFile(fileName, text);
                str = "\nAdd succes!";
            } else {
                str = "\nBad key";
            }
        }
        return str;
    }

    //удаление записи
    String removeWord(String wordEng) {
        map.remove(wordEng);
        
        String text =  "";
        oper.writeToFile(fileName, text);

        text = getAllWord();
        oper.writeToFile(fileName, text);

        return "\nWord remove succes!";
    }

    //поиск записи
    String getWord(String wordEng) {
        return map.get(wordEng);
    }

    //вывод всех пар ключ-значение
    String getAllWord() {
        String text = "";
        for(Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            text = text + "\n" + key+","+value;
        }
        return text;
    }
}

