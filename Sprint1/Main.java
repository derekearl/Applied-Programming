package Sprint1;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Integer> generatedNumbers = generateRandomNumbers();
        // Display numbers for 10 seconds
        displayNumbers(generatedNumbers, 10000);

        //The length can changed as well to make it smaller or larger as well in line 34 & 48
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        scanner.close();
        
        //User will enter in the numbers displayed
        List<Integer> userNumbers = parseUserInput(userInput);
        //If the input matches the random generated numbers then 
        //the output will say "Good Job"
        //If the input does not match the random generated number
        //the output will say "Try Again!"
        if (matchNumbers(generatedNumbers, userNumbers)) {
            System.out.println("Good job!");
        } else {
            System.out.println("Don't give up, try the program again!");
        }
    }
    //Displays 6 random generated numbers
    public static List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        Random random = new Random();
        //Change the 6 below to make it larger or smaller
        for (int i = 0; i < 6; i++) {
            int randomNumber = random.nextInt(10);
            randomNumbers.add(randomNumber);
        }
        //returns the random numbers
        return randomNumbers;
    }
    
    //Tells the user to memorize the random generated numbers
    public static void displayNumbers(List<Integer> numbers, int displayTime) {
        System.out.println("Memorize these numbers:");
        
        //Displays the numbers entered by the user
        //Be sure to change the 6 if you want a harder or easier challenge!
        for (int i = 0; i < 6; i++) {
            System.out.print(numbers.get(i) + "");
        }
        System.out.println();
        
        try {
            Thread.sleep(displayTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Below is a code that will make the numbers dissappear
        System.out.print("\033[H\033[2J");
        System.out.flush();
        //Tells the user to enter the numbers
        System.out.println("Enter the 6 random numbers you memorized:");
        System.out.println("The numbers are gone.");
    }

    //Input can be changed to inculde spaces if wanted by the user.
    public static List<Integer> parseUserInput(String input) {
        List<Integer> numbers = new ArrayList<>();
        String[] inputArray = input.split("");

        for (String number : inputArray) {
            try {
                int num = Integer.parseInt(number);
                numbers.add(num);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        return numbers;
    }

    //If the size of the random generated numbers does not match the input the value will return false.
    public static boolean matchNumbers(List<Integer> generatedNumbers, List<Integer> userNumbers) {
        if (generatedNumbers.size() != userNumbers.size()) {
            return false;
        }
        //If the input does not match the random generated numbers then the value will return false.
        for (int i = 0; i < generatedNumbers.size(); i++) {
            if (!generatedNumbers.get(i).equals(userNumbers.get(i))) {
                return false;
            }
        }

        return true;
    }
}
