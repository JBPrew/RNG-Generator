import java.io.File; //imports necessary packages
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;

public class JavaRNG {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); //activates the scanner
        System.out.print("File Name: "); //promts user for input of file name
        String desiredFile = s.nextLine(); // takes in input
        if (desiredFile.equals("")) { //sets the default name if no name is given as a random string converted from an integer
            desiredFile = Integer.toString((int) (Math.random() * 1001));
        }
        System.out.print("Number of Data Points: "); //prompts user for input of trials number
        int trials = s.nextInt(); // takes in input
        if (trials == 0) { //sets the default number of trials if 0 is given as a 6250000
            trials = 2500 * 2500;
        }
        s.close(); //closes the scanner

        System.out.println(desiredFile); //confirms input of desiredFile by printing it out
        System.out.println(trials); //confirms input of trials by printing it out
        
        File file = new File("C:/SciFair/txtFiles/" + "Java" + desiredFile + ".txt"); //opens the file within the java program
        
        if (file.exists()){ //overwrites and clears the file if it already exists
            try {
                FileWriter myWriter = new FileWriter(file, false); //writes to the file in non-append mode
                myWriter.write(""); //writes a blank file
                myWriter.close(); //closes the file writer
                System.out.println("Successfully cleared the file."); //confirmation of succesfull clearing 
            } catch (IOException e) { //catches an error if one occured and tells the user an error occured
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

        try (FileWriter myWriter = new FileWriter(file, true)) { //makes the writer in append mode
            for (int i = 0; i < trials; i++) { //for loops runs for the inputted number of trials and adds a random integer 0 or 1 to the file meaning 0s and 1s are added
                myWriter.write(Integer.toString((int) (Math.random() * 2))); // writes the random integer (0 or 1) into the file
                if (i % 100000 == 0) { //prints status updates as the file is being written showing progress
                    System.out.println(i);
                }
            }
            myWriter.close(); // closes the writer
        } catch (IOException e) { // catches an error and reports it
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("Successfully wrote to the file."); // confirms the data was converted to a .txt file
    }
}