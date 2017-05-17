package com.javarush.test.level18.lesson08.task03;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* AmigoOutputStream
1 Измените класс AmigoOutputStream так, чтобы он стал Wrapper-ом для класса FileOutputStream. Используйте наследование.
2 При вызове метода close() должны выполняться следующая последовательность действий:
2.1 вызвать метод flush()
2.2 дописать следующий текст [JavaRush © 2012-2013 All rights reserved.], используйте метод getBytes()
2.3 закрыть поток методом close()
*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:/tmp/result.txt";
    private FileOutputStream stream;

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

    public AmigoOutputStream (FileOutputStream stream) throws FileNotFoundException
    {
        super(fileName);
        this.stream = stream;
    }

    public void close()
    {
        try {
            stream.flush();
            String text = "JavaRush © 2012-2013 All rights reserved.";
            stream.write(text.getBytes());
            stream.close();
        }
        catch (IOException e){}
    }

    public void write(int data) throws IOException
    {
        stream.write(data);
    }

public void write(byte[] b) throws IOException
{
    stream.write(b);
}

    public void write(byte[] b, int off, int len) throws IOException
    {
        stream.write(b, off, len);
    }

    public void flush() throws IOException
    {
        stream.flush();
    }

}
