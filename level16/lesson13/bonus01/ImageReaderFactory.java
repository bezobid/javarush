package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by bezobid on 23.12.2015.
 */
public class ImageReaderFactory {
    static ImageReader getReader(ImageTypes e)
    {
        if (e == ImageTypes.JPG)
            return new JpgReader();
        else if (e == ImageTypes.PNG)
            return new PngReader();
        else if (e == ImageTypes.BMP)
            return new BmpReader();
        else throw new IllegalArgumentException("Неизвестный тип картинки");
    }
    }

