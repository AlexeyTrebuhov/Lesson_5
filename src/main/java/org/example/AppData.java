package org.example;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.function.BiConsumer;

public class AppData {
    public static void main(String args[]){


        // создали файл  test.csv  для наполнения его строками sb с помощью писателя PrintWriter
        try (PrintWriter writer = new PrintWriter(new File("test1.csv"))) {

            StringBuilder sb = new StringBuilder(); // набиваем строку информацией
            sb.append("Value1");
            sb.append(';');
            sb.append("Value2");
            sb.append(';');
            sb.append("Value3");
            sb.append('\n');

            sb.append("1001");
            sb.append(";");
            sb.append("300");
            sb.append(';');
            sb.append("250");
            sb.append('\n');

            sb.append("312");
            sb.append(";");
            sb.append("17");
            sb.append(';');
            sb.append("19");
            sb.append('\n');

            writer.write(sb.toString());// создали объект и наполнили созданными строками (sb).
            writer.close();// метод закрываем
            System.out.println("Table created");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        AppData testCSV =  new AppData();// в классе AppData создали экземпляр этого класса
        testCSV.readCSVFile();// метод readCSVFile вызывается на только что созданном экземпляре
    }

    public void readCSVFile(){
        List<List<String>> records = new ArrayList<>();


        // В классе Scaner создаем экземпляр класса, даные для которого берем из файла test1.csv
        try (Scanner scanner = new Scanner(new File("test1.csv"));) {
            while (scanner.hasNextLine()) { // считывает данные из файла и проверяет, есть ли следующая строка ввода.
                // если такая строка есть, читает ее. Если строки нет - срабатывает catch и печатаем результат
                records.add(getRecordFromLine(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(records.toString());
    }
    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }

}