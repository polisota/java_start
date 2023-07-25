package Homeworks;

public class Cat {

    String name;
    String breed;
    Boolean goodBoy;
    Boolean male;
    String color;
    int weight;
    int age;
    Double ribCage;
    Double leg;

    static void catConclusion(Boolean goodBoy, Boolean male, String name){
        if(goodBoy == true && male == true){
            System.out.printf("%s is a goodboy!", name);
        } else if (goodBoy == false && male == true){
            System.out.printf("%s is a badboy!:(", name);
        } else if (goodBoy == true && male == false){
            System.out.printf("%s is a goodgirl!", name);
        } else{
            System.out.printf("%s is a badgirl!:(", name);
        }
    }

    static void catFBMI(Double ribCage, Double leg){
        Double fbmi = (((ribCage/0.706) - leg)/0.916) - leg;
        if (fbmi < 15){
            System.out.println("It is very small! Feed the cat!");
        } else if (fbmi > 15 & fbmi < 30){
            System.out.println("It is ok! Keep it up!");
        } else if (fbmi > 30 & fbmi < 42){
            System.out.println("It is big! Take its food back!");
        } else{
            System.out.println("You've got a problem. A huge one.");
        }
    }

    public String toString() {
        String gender = this.male ? "Male" : "Female";
        return "Name: " + name + "\n" +
                "Breed: " + breed + "\n" +
                "Colour: " + color + "\n" +
                "Gender: " + gender + "\n" +
                "Weight: " + weight + "\n" +
                "Age: " + age + "\n";
    }    
}
