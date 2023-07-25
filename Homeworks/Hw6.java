package Homeworks;
import static Homeworks.Cat.catConclusion;
import static Homeworks.Cat.catFBMI;

public class Hw6 {
    public static void main(String[] args) {
        Cat firstCat = new Cat();
        firstCat.name = "Simba";
        firstCat.breed = "Abissinian";
        firstCat.goodBoy = true;
        firstCat.male = true;
        firstCat.color = "Golden";
        firstCat.weight = 5;
        firstCat.age = 6;
        firstCat.ribCage = 45.3;
        firstCat.leg = 22.9;
        System.out.println(firstCat);
        catConclusion(firstCat.goodBoy, firstCat.male, firstCat.name);
        catFBMI(firstCat.ribCage, firstCat.leg);

        Cat secondCat = new Cat();
        secondCat.name = "Kurama";
        secondCat.breed = "Persian";
        secondCat.goodBoy = false;
        secondCat.male = false;
        secondCat.color = "Red";
        secondCat.weight = 4;
        secondCat.age = 9;
        secondCat.ribCage = 42.3;
        secondCat.leg = 20.9;
        System.out.println(secondCat);
        catConclusion(secondCat.goodBoy, secondCat.male, secondCat.name);
        catFBMI(secondCat.ribCage, secondCat.leg);
    }    
}
