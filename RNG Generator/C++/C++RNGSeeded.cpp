#include <iostream> //imports necessary packages
#include <string>
#include <fstream>
#include <time.h>
using namespace std;

int main()
{
    srand(time(NULL)); //seeds the random with the current time so different random sequences are produced
    string desiredFile; //declares variable desiredFile as a string
    cout << "File Name: "; //promts user for input of file name
    getline (cin, desiredFile); // Get user input from the keyboard
    if (desiredFile == "") { //sets the default name if no name is given as a random string converted from an integer
        desiredFile = std::to_string(rand() % 1001);
    }

    string trialsStr; //declares variable trialsStr to get trial input from console as integers cannot be read from console
    cout << "Number of Data Points: "; //prompts user for input of trials number
    getline (cin, trialsStr); // Get user input from the keyboard
    int trials = stoi(trialsStr); //converts trials to string to be used in for loop
    if (trials == 0) {  //sets the default number of trials if 0 is given as a 6250000
        trials = 2500 * 2500;
    }

    cout << "Your File Name is: " << desiredFile; //confirms input of desiredFile by printing it out
    cout << "\nYour Number of Data Points: " << trials; //confirms input of trials by printing it out
    
    string fileLocation = "C:/SciFair/txtFiles/C++" + desiredFile + ".txt"; //stores the file location in a string, fileLocation

    //clears the file if there is an existing one
    ofstream fileCheck;
    fileCheck.open(fileLocation); //opens the file in non-append mode
    fileCheck << ""; //writes a blank file

    ofstream file;
    file.open(fileLocation, std::ios_base::app); //opens the file in append mode
    for (size_t i = 0; i < trials; i++) //for loops runs for the inputted number of trials and adds a random integer 0 or 1 to the file meaning 0s and 1s are added
    {
        file << std::to_string(rand() % 2); // writes the random integer (0 or 1) into the file
        if (i % 100000 == 0) { //prints status updates as the file is being written showing progress
            cout << "\n" + i;
        }
    }
    file.close(); //closes the file writer after data has been written
    return 0; //returns 0 to satisfy the main method arguments
}