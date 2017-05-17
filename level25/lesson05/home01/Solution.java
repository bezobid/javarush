package com.javarush.test.level25.lesson05.home01;

/* Мониторинг состояния нити
В отдельном классе создать нить LoggingStateThread,
которая будет выводить в консоль все состояния (State) переданной в конструктор нити.
Нить LoggingStateThread должна сама завершаться после остановки переданной в конструктор нити.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Thread target = new Thread(){
            public void run(){
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        LoggingStateThread loggingStateThread = new LoggingStateThread(target);
        loggingStateThread.start();

        target.start();  //NEW
        Thread.sleep(100); //RUNNABLE
        target.join(100);
        Thread.sleep(400);
        target.interrupted(); //TERMINATED
        Thread.sleep(500);

    }

    public static void print(Thread thread){
        System.out.println(thread.getState().toString());
    }
}
