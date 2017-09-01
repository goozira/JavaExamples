package com.goozira;

import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

// Writing data to a sequential text file with class Formatter.
public class CreateTextFile
{
    private Formatter output;  // object used to output text to file

    // enable user to open file
    public void openFile()
    {
        try
        {
            output = new Formatter("clients.txt");  // open the file
        }
        catch (SecurityException securityException)
        {
            System.err.println("You do not have write access to this file.");
            System.exit(1);  // terminate the program
        }
        catch (FileNotFoundException fileNotFoundException)
        {
            System.err.println("Error opening or creating file.");
            System.exit(1);  // terminate the program
        }
    }

    public void addRecords() {
        // object to be written to file
        AccountRecord record = new AccountRecord();
        Scanner input = new Scanner(System.in);

        System.out.printf("%s\n%s\n%s\n%s\n\n",
                "To terminate input, type the end-of-file indicator ",
                "when you are prompted to enter input.",
                "On UNIX/Linux/Mac OS X type <ctrl> d then press Enter",
                "On Windows type <ctrl> z then press Enter");

        System.out.printf("%s\n%s",
                "Enter account number (>0), first name, last name and balance.",
                "? ");

        while (input.hasNext())  // loop until end-of-file indicator
        {
            try {
                // retrieve data to be output
                record.setAccount(input.nextInt());
                record.setFirstName(input.next());
                record.setLastName(input.next());
                record.setBalance(input.nextDouble());

                if (record.getAccount() > 0) {
                    // write new record
                    output.format("%d %s %s %.2f\n", record.getAccount(),
                            record.getFirstName(), record.getLastName(),
                            record.getBalance());
                } else {
                    System.out.println("Account number must be greater than 0.");
                }
            } catch (FormatterClosedException formatterClosedException) {
                System.err.println("Error writing to file.");
                return;
            } catch (NoSuchElementException elementException) {
                System.err.println("Invalid input. Please try again.");
                input.nextLine();  // discard input so user can try again
            }

            System.out.printf("%s %s\n%s", "Enter account number(>0),",
                    "first name, last name and balance.", "? ");
        }
    }
        // close file
    public void closeFile()
    {
        if (output != null)
        {
            output.close();
        }
    }
}
