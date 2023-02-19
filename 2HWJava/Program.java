// 1.Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, 
// используя StringBuilder. Данные для фильтрации приведены ниже в виде json строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

// 2.Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации 
// запишите в лог-файл.

// 3.** (Для преподавателя: если не успели выполнить задание 7, дать наводку из этого задания) 
// Дана json строка (можно сохранить в файл и читать из файла)
// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
// {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
// Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил 
// [оценка] по предмету [предмет].

// Пример вывода:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.

// 4*. Реализуйте простой калькулятор, с консольным интерфейсом. К калькулятору добавить логирование.

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.io.IOException;

public class Program {
    public static void main(String[] args) throws SecurityException, IOException {
        System.out.println(whereBuilder(parserJSONdict("{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}")));
        // System.out.println(parserJSONlist("[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]"));
        // System.out.println(parserJSONdict(readFile("JavaHomeWork/2HWJava/DataTask1.json")));
        // System.out.println(parserJSONlist(readFile("JavaHomeWork/2HWJava/DataTask3.json")));
        printTask3(parserJSONlist(readFile("JavaHomeWork/2HWJava/DataTask3.json")));
        int[] z = {1,5,3,8,3,5,9,2};
        for (int i : bubbleSort(z)) {
            System.out.print(i);
        }
        
    }

    // Функция составляет условие "WHERE" для SQL запроса
    public static String whereBuilder(Map dict) {       
        StringBuilder sb = new StringBuilder();
        if (!dict.isEmpty()){
            sb.append("WHERE ");
            ArrayList<Map.Entry> entries = new ArrayList<>(dict.entrySet());
            for (Map.Entry item : entries) { 
                if (item.getValue() != "null") {
                    sb.append(item.getKey() + "=" + item.getValue() + " AND ");
                }
            }
        }
        return sb.toString().substring(0, sb.length() - 4);
    }

    // Функция для вывода данных из задачи №3
    public static void printTask3(List<Map<String, String>> input) {
        for (Map<String, String> mapString : input) {
            System.out.println("Студент " + mapString.get("фамилия") + " получил " + mapString.get("оценка") + " по предмету " + mapString.get("предмет") + ".");
        }
    }

    // Функция парсит список строк
    public static Map parserJSONdict(String jsonString) {
        Map<String, String> result = new TreeMap<>();
        String temp = jsonString.replace("{", "").replace("}", "").replace("\"", "");
        for (String str : temp.split(",")) {
            result.put(str.split(":")[0].strip(), "\"" + str.split(":")[1].strip() + "\"");
        }
        return result;
    }

    // Функция парсит список списков строк из строки json формата
    public static List<Map<String, String>> parserJSONlist(String jsonString) {
        List<Map<String, String>> result = new ArrayList<Map<String, String>>();
        String[] tempList = jsonString.split("}");
        for (String string : tempList) {
            String[] temp = string.replace("{", "").replace("}", "").replace("[", "").replace("]", "").replace("\"", "").split(",");
            TreeMap<String, String> tempMap = new TreeMap<>();
            for (String item : temp) {
                if(item.contains(":")){
                    tempMap.put(item.split(":")[0].strip(), item.split(":")[1].strip());
                }
            }          
            if (!tempMap.isEmpty()) {
                result.add(tempMap);
            } 
        }
        return result;
    }

    // Функция чтения файлов
    public static String readFile(String path) {
        String result = ""; 
        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));)
        {            
            int i=-1;
            while((i=br.read())!=-1){             
                result += (char)i;
            }  
        }
        catch(IOException ex){            
            System.out.println(ex.getMessage());
        } 
        return result;
    }

    // Сортировка пузырьком
    public static int[] bubbleSort(int[] input) throws SecurityException, IOException {
        //Логирование работы метода
        Logger logger = Logger.getLogger(Program.class.getName());
        FileHandler fh = new FileHandler("JavaHomeWork/2HWJava/log.txt");
        logger.addHandler(fh);       
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);
        
        boolean flag = true;
        while (flag) { 
            flag = false;          
            for (int index = 0; index < input.length; index++) {
                if (index != input.length-1) {
                    if (input[index] > input[index+1]) {
                        int temp = input[index+1];
                        input[index+1] = input[index];
                        input[index] = temp;
                        flag = true;
                    } 
                }
            }
            String arrayLog = "";
            for (int i : input) {
                arrayLog += " " + i;
            }
            logger.info(arrayLog);
        }
        return input;
    }
}
