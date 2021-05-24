using System;

namespace CSharpRNG
{
  class Program
  {
    public static void Main(string[] args)
		{
      System.Random random = new System.Random(); 
      string desiredFile;
      Console.Write("File Name: "); //promts user for input of file name
      desiredFile = Console.ReadLine(); // Get user input from the keyboard
      if (desiredFile == "") { //sets the default name if no name is given as a random string converted from an integer
          desiredFile = random.Next(0,1001).ToString();
          Console.WriteLine(desiredFile);
      }

      string trialsStr;
      Console.Write("Number of Data Points: "); //prompts user for input of trials number
      trialsStr = Console.ReadLine(); // Get user input from the keyboard
      int trials = Convert.ToInt32(trialsStr); //converts the input of trials to an integer to be used in the for loop
      if (trialsStr == "") {   //sets the default number of trials if 0 is given as a 6250000
          trials = 2500 * 2500;
      }

      Console.WriteLine("You entered '{0}'", desiredFile); //confirms input of desiredFile by printing it out
      Console.WriteLine("You entered '{0}'", trials); //confirms input of trials by printing it out

      string fileLocation = "@C:/SciFair/txtFiles/" + "C#" + desiredFile + ".txt"; //stores the file location in a string, fileLocation
      using (System.IO.StreamWriter file = new System.IO.StreamWriter(@"C:/SciFair/txtFiles/" + "C#" + desiredFile + ".txt")) //overwrites and clears the file if it already exists
      {
        file.Write(""); //writes a blank file
      }

      using (System.IO.StreamWriter file = //makes the writer in append mode
      new System.IO.StreamWriter(@"C:/SciFair/txtFiles/" + "C#" + desiredFile + ".txt", true)) 
      {
        for (int i = 0; i < trials; i++)
        {
          file.Write(random.Next(0,2)); // writes the random integer (0 or 1) into the file
          if (i % 100000 == 0) {  //prints status updates as the file is being written showing progress
            Console.WriteLine(i);
          }
        }
      }
      Console.WriteLine("Successfully wrote to file"); // confirms the data was converted to a .txt file
    }
  }
}