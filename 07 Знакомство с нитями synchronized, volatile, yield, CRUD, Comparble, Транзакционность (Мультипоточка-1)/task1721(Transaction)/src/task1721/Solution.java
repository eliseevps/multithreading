//Complete

package task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла.
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines.
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines.
4. Если условие из п.3 не выполнено, то:
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
Не забудь закрыть потоки.




Requirements:
1. Класс Solution должен содержать public static поле allLines типа List<String>.
2. Класс Solution должен содержать public static поле forRemoveLines типа List<String>.
3. Класс Solution должен содержать public void метод joinData() который может бросать исключение CorruptedDataException.
4. Программа должна считывать c консоли имена двух файлов.
5. Программа должна считывать построчно данные из первого файла в список allLines.
6. Программа должна считывать построчно данные из второго файла в список forRemoveLines.
7. Метод joinData должен удалить в списке allLines все строки из списка forRemoveLines, если в allLines содержаться все строки из списка forRemoveLines.
8. Метод joinData должен очистить список allLines и выбросить исключение CorruptedDataException, если в allLines не содержаться все строки из списка forRemoveLines.
9. Метод joinData должен вызываться в main.

07 Знакомство с нитями synchronized, volatile, yield, CRUD, Comparble, Транзакционность (Мультипоточка-1)/task1721(Transaction)/files/allLines.txt
07 Знакомство с нитями synchronized, volatile, yield, CRUD, Comparble, Транзакционность (Мультипоточка-1)/task1721(Transaction)/files/forRemoveLines.txt

*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File file1 = new File(sc.nextLine());
        File file2 = new File(sc.nextLine());
        sc.close();

        try {
            readFiles(allLines, file1);
            readFiles(forRemoveLines, file2);
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден");
        } catch (IOException e) {
            System.err.println("Ошибка ввода вывода в файле");
        }

        System.out.println("До метода joinData(): ");
        printLists();

        try {
            new Solution().joinData();
            System.out.println("После метода joinData(): ");
            printLists();
        } catch (CorruptedDataException e) {
            System.err.println("Очистка данных в allLines, т.к. нет в нем не содержатся все строки forRemoveLines.");
        }


    }

    public static void readFiles(List<String> list, File file) throws IOException {
        BufferedReader readerFile = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        while (readerFile.ready()) {
            list.add(readerFile.readLine());
        }
        readerFile.close();
    }

    public static void printLists() {
        System.out.print("List allLines: ");
        for (String str : allLines) {
            System.out.print(str + " ");
        }
        System.out.print("\nList forRemoveLines: ");
        for (String str : forRemoveLines) {
            System.out.print(str + " ");
        }
        System.out.println();
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
