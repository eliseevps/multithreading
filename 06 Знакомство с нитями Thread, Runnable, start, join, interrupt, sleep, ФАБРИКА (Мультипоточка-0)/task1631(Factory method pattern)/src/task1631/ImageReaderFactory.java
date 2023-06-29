package task1631;

import task1631.common.*;

public class ImageReaderFactory {
    static ImageReader imageReader = null;

    public static ImageReader getImageReader(ImageTypes type) {
        if (type != null) {
            switch (type) {
                case JPG -> imageReader = new JpgReader();
                case PNG -> imageReader = new PngReader();
                case BMP -> imageReader = new BmpReader();
                default -> throw new IllegalArgumentException("Неизвестный тип картинки");
            }
        } else throw new IllegalArgumentException("Неизвестный тип картинки");
        return imageReader;
    }
}

