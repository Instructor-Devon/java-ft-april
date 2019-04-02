public class FizzBuzz {
    public static String fizzBuzz(int number) {
        // fizzbuzz logic here
        // if number is divizage by 3 and 5
        if(number % 3 == 0 && number % 5 == 0) {
            return "FizzBuzz";
        } else if (number % 5 == 0) {
            return "Buzz";
        } else if (number % 3 == 0) {
            return "Fizz";
        } else {
            return "Number is " + number;
        }
    }
}