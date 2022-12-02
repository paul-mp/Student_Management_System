package StudentMangSys.Front;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class mainsys {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
       

        String filepath = "";

        System.out.print("Please copy and paste the file path of the file that you are trying to read: ");
        filepath = input.nextLine().replaceAll("\\\\", "/");

        String name = "";
        String name_array[] = {};
    
        System.out.print("What is the student's name that you are looking for? ");
        name = input.nextLine().replaceAll(" ", "").toLowerCase();
        name_array = name.split("");
        name_array = name.split(",");


        SearchFile(name_array, filepath);


        input.close();
    
    }


    public static void SearchFile(String[] name, String filepath) {
        
       try {

        BufferedReader reader = new BufferedReader(new FileReader(filepath));    
        String line = reader.readLine();
        int count = 1;

        while (line != null) {
			
            if(Arrays.asList(name).contains(line)) {
                System.out.println("The person you were looking for was found inside the database on line: " + count);
            }

            count++;
            line = reader.readLine();

            
        }

        reader.close();

       } catch (IOException ioException) {
        ioException.printStackTrace();
       }
       

    }
}
