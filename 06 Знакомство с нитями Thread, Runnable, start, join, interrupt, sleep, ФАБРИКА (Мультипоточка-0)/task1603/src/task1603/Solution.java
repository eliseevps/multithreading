//Complete

package task1603;

import java.util.ArrayList;
import java.util.List;

/* 
Список и нити
В методе main добавить в статический объект list 5 нитей. Каждая нить должна быть новым объектом класса Thread, работающим со своим объектом класса SpecialThread.


Requirements:
1. В методе main создай 5 объектов типа SpecialThread.
2. В методе main создай 5 объектов типа Thread.
3. Добавь 5 разных нитей в список list.
4. Каждая нить из списка list должна работать со своим объектом класса SpecialThread.
5. Класс SpecialThread изменять нельзя.*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<>(5);

    public static void main(String[] args) {
        SpecialThread specialThread1 = new SpecialThread();
        SpecialThread specialThread2 = new SpecialThread();
        SpecialThread specialThread3 = new SpecialThread();
        SpecialThread specialThread4 = new SpecialThread();
        SpecialThread specialThread5 = new SpecialThread();

        Thread thread1 = new Thread(specialThread1);
        Thread thread2 = new Thread(specialThread2);
        Thread thread3 = new Thread(specialThread3);
        Thread thread4 = new Thread(specialThread4);
        Thread thread5 = new Thread(specialThread5);

        list.add(thread1);
        list.add(thread2);
        list.add(thread3);
        list.add(thread4);
        list.add(thread5);

        for (Thread thread : list) {
            thread.start();
        }
    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}
