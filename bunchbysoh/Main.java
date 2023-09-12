package bunchbysoh;                                //denotes it is inside the folder named 'bunchbysoh'

public class Main {                                //Main class containing the main method
    static class CountsBySoH {
        public int healthy = 0;                    //initialisation of all the battery count values,in each domain to 0
        public int replace = 0;
        public int failed = 0;
    }

//First part of the Assignment, where we can calculate the SoH of the battery by the given formula and classify them
  
  
    static CountsBySoH countBatteriesByHealth(int[] presentCapacities) {    //static method to use methods without creation of objects explisitely
        CountsBySoH counts = new CountsBySoH();

        for (int capacity : presentCapacities) {
            double soh = (capacity * 100.0) / 120; // it calculates SoH as a percentage as givn

            if (soh > 80) {             // if SoH is greater than 80
                counts.healthy++;          //number of healthy batteries is increased
            } else if (soh >= 63) {     // if SoH is greater than 63
                counts.replace++;          //number of replacable batteries is increased
            } else {                    // if SoH is lesser than 63
                counts.failed++;            //number of failed batteries iss increased
            }
        }
        return counts;                  //returns the count of batteries in each domain, when the loop ends
    }

  //Second part of the Assignment, where we can decide 

    static void testBucketingByHealth() {      //called from Main method
        System.out.println("Counting batteries by SoH...\n");      //denotes the main intension of the program
        int[] presentCapacities = {115, 118, 80, 95, 91, 72};
        CountsBySoH counts = countBatteriesByHealth(presentCapacities);

        System.out.println("Number of Healthy Batteries: " + counts.healthy);
        System.out.println("Number of Replace Batteries: " + counts.replace);
        System.out.println("Number of Failed Batteries: " + counts.failed);
        
        System.out.println("Done counting :)\n");
    }

    public static void main(String[] args) {   //Execution of code starts from here
        testBucketingByHealth();              //main method call the function 'testBucketingByHealth()' to test each battery
    }
}
