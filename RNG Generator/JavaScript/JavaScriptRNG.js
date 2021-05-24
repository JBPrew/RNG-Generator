const readline = require('readline'); //imports readline package to scan user ibut
const fs = require('fs'); //allows for reading and writing to file

const rl = readline.createInterface({ //creates the file interface
    input: process.stdin,
    output: process.stdout
});


rl.question('File Name: ', (desiredFile) => { //promts user for input of file name and takes in user input
    rl.question('Number of Data Points: ', (trials) => {  //prompts user for input of trials number and takes in user input
        if (desiredFile == "") { //sets the default name if no name is given as a random string converted from an integer
            desiredFile = (Math.floor(Math.random() * 1001)).toString();
        }
        if (trials == 0) { //sets the default number of trials if 0 is given as a 6250000
            trials = 2500 * 2500;
        }
        console.log(`File Name: ${desiredFile}`); //confirms input of desiredFile by printing it out
        console.log(`Trials: ${trials}`); //confirms input of trials by printing it out
        var streamClear = fs.createWriteStream("C:/SciFair/txtFiles/" + "JavaScript" + desiredFile + ".txt"); //opens the file in order to clear the file if it already exists
        streamClear.write(""); //writes a blank file
        streamClear.close(); //closes the file writer
        var stream = fs.createWriteStream("C:/SciFair/txtFiles/" + "JavaScript" + desiredFile + ".txt", {flags:'a'}); //makes the file writer in append mode
        var i; //declares variable
        for (i = 0; i < trials; i++) { //for loops runs for the inputted number of trials and adds a random integer 0 or 1 to the file meaning 0s and 1s are added
            stream.write(((Math.floor(Math.random() * 2)).toString())); // writes the random integer (0 or 1) into the file
            if (i % 100000 == 0) { //prints status updates as the file is being written showing progress
                console.log(i);
            }
        }
        stream.close(); //closes the filewriter
        rl.close(); //closes the interface
    });
});
