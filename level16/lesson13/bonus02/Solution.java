package com.javarush.test.level16.lesson13.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.SyncFailedException;
import java.util.ArrayList;
import java.util.List;

/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
Подсказка: Нить 4 можно проверить методом isAlive()
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<Thread>(5);

    static
    {
        threads.add(new Task1());
        threads.add(new Task2());
        threads.add(new Task3());
        threads.add(new Task4());
        threads.add(new Task5());
    }


    static class Task1 extends Thread
    {
        public void run()
        {
            while(true){}
        }
    }

    static class Task2 extends Thread
    {
        public void run()
        {
            try {
                while (true){
                sleep(1000);}
            }
            catch (InterruptedException e)
            {
                System.out.println("InterruptedException");
            }
        }
    }

    static class Task3 extends Thread
    {
        public void run()
        {
            try {
                while (!isInterrupted()) {
                    System.out.println("Ура");
                    sleep(500);
                }
            }catch (InterruptedException e){}
        }
    }

    static class Task4 extends Thread implements Message {
        public void run() {
            while(!isInterrupted()){}
        }

        public void showWarning() {
            try {
                this.interrupt();
                this.join();
            } catch (Exception e) {
            }
        }
    }


    static class Task5 extends Thread
    {
        public void run()
        {

            int sum = 0;
            try {
                BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
                while (true) {
                    String line = read.readLine();
                    if (line.equals("N"))
                        break;
                    sum += Integer.parseInt(line);
                }
                read.close();
            } catch(IOException e){}
            System.out.println(sum);
        }
    }

}
