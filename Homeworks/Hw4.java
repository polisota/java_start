package Homeworks;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Hw4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        Integer num1 = input.nextInt();
        System.out.print("Введите второе число: ");
        Integer num2 = input.nextInt();
        input.close();
        System.out.println("Сумма чисел = " + sumNum(makeDeQ(num1), makeDeQ(num2)));
        System.out.print("Произведение чисел = " + mulNum(makeDeQ(num1), makeDeQ(num2)));
    }    

    static Deque<Integer> makeDeQ(Integer num) {
        Deque<Integer> deque = new LinkedList<>();
        while (num > 0) {
            deque.addLast(num % 10);
            num = num / 10;
        }
        return deque;
    }

    static LinkedList<Integer> mulNum(Deque<Integer> deQ1, Deque<Integer> deQ2) {
        LinkedList<Integer> res = new LinkedList<>();
        String temp1 = "";
        while (deQ1.isEmpty() == false) {
            temp1 = deQ1.poll() + temp1;
        }
        String temp2 = "";
        while (deQ2.isEmpty() == false) {
            temp2 = deQ2.poll() + temp2;
        }
        Integer k = Integer.parseInt(temp1) * Integer.parseInt(temp2);
        while (k > 0) {
            res.addFirst(k % 10);
            k = k / 10;
        }        
        return res;
    }    

    static LinkedList<Integer> sumNum(Deque<Integer> deQ1, Deque<Integer> deQ2) {
        LinkedList<Integer> tmp = new LinkedList<>();
        int temp = 0;
         while (!deQ1.isEmpty() || !deQ2.isEmpty()) { 
            int sum = temp;
            if (!deQ1.isEmpty()) {
                sum += deQ1.removeFirst();
            }
            if (!deQ2.isEmpty()) {
                sum += deQ2.removeFirst();
            }
            tmp.addLast(sum % 10);
            temp = sum / 10; 
        }
        if (temp != 0) {
            tmp.addLast(temp);
        }
        LinkedList<Integer> result = new LinkedList<>();
        Iterator<Integer> iterator = tmp.descendingIterator();
        while (iterator.hasNext()) 
        {
            result.add(iterator.next());
        }
        return result;
    }
    
}
