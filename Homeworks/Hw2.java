package Homeworks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.logging.Logger;

public class Hw2 {

    public static void main(String[] args) {
        System.out.print("1. Расширения файлов из текущей папки.");

        Path path = Paths.get(System.getProperty("user.dir"));
        List<String> namesOfFiles = listOfFilesNames(path);
        for (String file : namesOfFiles)
            System.out.println(file + " --> расширение файла --> " + fileExtention(file));

        System.out.println("2. Сортировка пузырьком с логгированием.");

        System.out.println("Введите размерность массива: ");
        int arrSize = Integer.parseInt(System.console().readLine());
        int[] numArray = new int[arrSize];
        Random random = new Random();
        for (int i = 0; i < arrSize; i++)
            numArray[i] = random.nextInt(100);
        System.out.println("Исходный массив: ");
        System.out.println(Arrays.toString(numArray));
        numArray = bubbleSort(numArray);
        System.out.println("Отсортированный массив: ");
        System.out.println(Arrays.toString(numArray));
    }

    static List<String> listOfFilesNames(Path path) {
        try (Stream<Path> walk = Files.walk(path)){
        return walk.filter(Files::isRegularFile).map(Path::getFileName).map(Path::toString).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Невозможно считать файлы " + path);
        }
    }   

    static String fileExtention(String name) {
        int i = name.lastIndexOf(".");
        if (i == -1) return "";
        return name.substring(i++);
    }

    public static int[] bubbleSort(int[] array){
        Logger logger = Logger.getAnonymousLogger();
        for (int j = array.length - 1; j > 0; j--) {
            for (int i = 0; i < j; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    logger.info(Arrays.toString(array));
                }
            }
        }
        return array;
    }
}
