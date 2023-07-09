package org.danikzhezmer;

import org.danikzhezmer.model.Command;


import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {


        Validator validator = new Validator();
        Parser parser = new Parser(validator);

        Storage storage = new Storage();
        Service service = new Service(storage);

        Scanner scanner = new Scanner(System.in);
        String line;

        while (true) {
            line = scanner.nextLine();
            if(line.equals("exit")){
                break;
            }

            try{
               Command command = parser.parse(line);
               service.execute(command);


            }catch(Exception e){
                System.out.println(e.getMessage());
            }


        }
    }
}