public class Puppy {
    public static void PuppySound() {
        System.out.println("arf...");
    }

    public static int MinValue(int[] puppies) {
        
        // find the smallest
        int currMin = puppies[0];
        // loop it
        for(int i = 0; i < puppies.length; i++) {
            if(puppies[i] < currMin) {
                currMin = puppies[i];
            }
        }
        return currMin;
    }
}