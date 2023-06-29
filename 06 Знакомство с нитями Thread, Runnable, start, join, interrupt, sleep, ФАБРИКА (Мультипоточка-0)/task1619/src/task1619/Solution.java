//Complete

package task1619;

/* 
А без interrupt слабо?
Разберись, как работает программа.
Реализуй метод ourInterruptMethod таким образом, чтобы он прерывал нить TestThread. Исправь остальной код программы, если это необходимо. Нельзя использовать метод interrupt.


Requirements:
1. В классе Solution должен быть публичный статический метод ourInterruptMethod без параметров.
2. Метод run должен выводить надпись "he-he" каждые пол секунды, пока не будет вызван метод ourInterruptMethod.
3. Необходимо изменить условие цикла while в методе run.
4. Метод main должен создавать объект типа Thread передавая в конструктор объект типа TestThread.
5. Метод main должен вызывать метод start у объекта типа Thread.
6. Метод main должен вызывать метод ourInterruptMethod.*/

public class Solution {
    private static TestThread testThread;

    public static void main(String[] args) throws InterruptedException {
        testThread = new TestThread();
        Thread t = new Thread(testThread);
        t.start();
        Thread.sleep(3000);
        ourInterruptMethod();
    }

    public static void ourInterruptMethod() {
        testThread.setInterrupted(true);
    }

    public static class TestThread implements Runnable {
        private volatile boolean isInterrupted = false;

        public void setInterrupted(boolean interrupted) {
            isInterrupted = interrupted;
        }

        public void run() {
            while (!isInterrupted) {
                try {
                    System.out.println("he-he");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
