import java.util.ArrayList;
import java.util.List;

public class HelloWorld {
    // point of entry
    public static void main(String[] args) {
        // variables
        // value types
        int number = 5;
        long biggerPossibleInteger = 5;

        float f = 104.43f;
        double d = 104.4;
        char dee = 'd';
        boolean isCool = true;

        
        // object types
        String name = "Devon";
        name = null;
        
        Integer intObj = 5;
        
        // arrays
        int[] nums = { 10, 13, 104, -32 };
        int[] bigNumArray = new int[100];
        String[] stringArr = new String[10];
        boolean[] boolz = {false, true, false, false};
        
        int minVal = Puppy.MinValue(nums);
        System.out.println(minVal);

        // list
        List<Integer> numList = new ArrayList<Integer>();
        numList.add(5);
        numList.add(10);
        numList.remove(0);

    }
}