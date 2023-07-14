package Seminars;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Seminar3 {

    public static void main(String[] args) {
        randomNumbers(5, 10);
        planetCounter(15);
        createTable(3);
    }

    //Генерация случайных чисел и их последующая сортировка
    static void randomNumbers(int size, int maxValue){
        ArrayList<Integer> nums = new ArrayList<>(size);
        Random rand = new Random();        

        for (int i = 0; i < size; i++){
            nums.add(rand.nextInt(maxValue));
        }
        for (Integer num : nums) {
           System.out.print(num + " ");
        }
        System.out.println();

        nums.sort(Comparator.naturalOrder());

        Iterator<Integer> iter = nums.iterator();

        while(iter.hasNext()){
            System.out.print(iter.next() + " ");
        }
    }

    // Заполнить список названиями планет солнечной системы
    // в произвольном порядке с повторениями, вывести название
    // каждой планеты и кол-во повторений.
    static void planetCounter(int n){
        List<String> listPlanets = List.of("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto");
        List<String> randPlanets = new ArrayList<String>(n);
        int[] counts = new int[listPlanets.size()];

        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            randPlanets.add(listPlanets.get(rand.nextInt(listPlanets.size())));
            System.out.print(randPlanets.get(i) + " ");
            counts[listPlanets.indexOf(randPlanets.get(i))]++;        
        }
        System.out.println();

        // for (String planet : randPlanets) {
        //     counts[listPlanets.indexOf(planet)]++;
        // }
        
        for (int i = 0; i < counts.length; i++) {
            System.out.printf("%s - %s\n", listPlanets.get(i), counts[i]);
        }

    }
    
    // Каталог товаров книжного магазина сохранен в виде двумерного списка
    // List ArrayList String. На нулевой позиции каждого внутреннего списка
    // содержится название жанра, а на остальных названия книг. Напишите
    // метод для заполнения данной структуры.
    static void createTable(int size){
        List<String> genres = List.of("Фантастика", "Комедия", "Хоррор", "Детектив");
        List<ArrayList<String>> table = new ArrayList<>(genres.size());
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < genres.size(); i++) {
            ArrayList<String> booksOfGenre = new ArrayList<>(size);
            booksOfGenre.add(genres.get(i));
            System.out.printf("Введите %d названий книг в жанре %s:\n", size, genres.get(i));
            for (int j = 0; j < size; j++) {
                booksOfGenre.add(input.nextLine());
            }
            table.add(booksOfGenre);
        }

        input.close();

        for (ArrayList<String> books : table) {
            for(String book : books){
                System.out.print(book + " ");
            }
            System.out.println();
        }
    }
}
