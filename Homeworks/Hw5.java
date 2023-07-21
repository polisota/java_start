package Homeworks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Hw5 {

    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> phBook = new HashMap<>();
        addContact("Ivanov", 100, phBook);
        addContact("Petrov", 101, phBook);
        addContact("Petrov", 102, phBook);
        addContact("Petrov", 103, phBook);        
        addContact("Sidorov", 105, phBook);
        addContact("Ivanov", 106, phBook);
        addContact("Sergeev", 104, phBook);
        printPhBook(phBook);
        killContact(phBook);
        
    }
    // Реализуйте структуру телефонной книги с помощью HashMap.
    // Программа также должна учитывать, что во входной структуре будут
    // повторяющиеся имена с разными телефонами, их необходимо считать, как одного
    // человека с разными телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.

    public static void addContact(String name, int phone, Map<String, ArrayList<Integer>> contact){
        if (contact.containsKey(name)) {
            contact.get(name).add(phone);
        } else {
            ArrayList<Integer> phList = new ArrayList<>();
            phList.add(phone);
            contact.put(name, phList);
        }
    }

    public static void printPhBook(Map<String, ArrayList<Integer>> phBook){
        ArrayList<String> res = new ArrayList<>();    
        for(Map.Entry<String, ArrayList<Integer>> contact : phBook.entrySet()) {
            String phones = "";
            for(int phone: contact.getValue()){
                phones += phone + " ";
            }
            res.add(contact.getKey() + ": " +  phones);            
        }
        Collections.sort(res, Collections.reverseOrder());      
        System.out.println(res);        
    }

    static void killContact(Map<String, ArrayList<Integer>> phBook) {    
        Scanner input = new Scanner(System.in);
        System.out.print("Input a contact to kill: ");
        String name = input.nextLine();
        if (phBook.keySet().contains(name)){
            phBook.keySet().remove(name);
        } else {
        System.out.println("Error");
        }
        printPhBook(phBook);
        input.close();
    }
}
