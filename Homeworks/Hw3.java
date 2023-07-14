package Homeworks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;

public class Hw3 {

    public static void main(String[] args) {
        killDuplicates(planetCounter(15));
        ArrayList<Integer> arr = generateNums(10, 100);
        System.out.println(arr);
        int min = Collections.min(arr);
        int max = Collections.max(arr);
        double average = arr.stream().mapToDouble(a -> a).average().orElse(0.0);
        System.out.printf("Минимальное значение: %s; Максимальное значение: %s; Среднее значение: %s.", min, max, average);
        System.out.println();
        System.out.println(killEven(arr));
    }

    static ArrayList<Integer> generateNums(int size, int maxValue){
        ArrayList<Integer> nums = new ArrayList<>(size);
        Random rand = new Random();   

        for (int i = 0; i < size; i++){
            nums.add(rand.nextInt(maxValue));
        }

        return nums;
    }

    static ArrayList<Integer> killEven(ArrayList<Integer> array){
        for (int i = array.size() - 1; i >= 0 ; i--) {
            if((array.get(i) % 2) == 0){
                array.remove(i);
            }
        }
        return array;
    }

    static void killDuplicates(List<String> sample){
        LinkedHashSet<String> res = new LinkedHashSet<String>(sample);
        System.out.println(res);
    }

    static List<String> planetCounter(int n){
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

        for (String planet : randPlanets) {
            counts[listPlanets.indexOf(planet)]++;
        }
        
        for (int i = 0; i < counts.length; i++) {
            System.out.printf("%s - %s\n", listPlanets.get(i), counts[i]);
        }
        return randPlanets;
    }
    
}
