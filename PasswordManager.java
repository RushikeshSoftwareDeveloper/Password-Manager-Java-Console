package com.PassWordManagement;

import java.io.*;
import java.util.Scanner;

public class PasswordManager {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while(true){

            System.out.println("\n1.Store Password");
            System.out.println("2.Retrieve Passwords");
            System.out.println("3.Exit");

            System.out.print("Choose Option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){

                case 1:
                    storePassword();
                    break;

                case 2:
                    retrievePasswords();
                    break;

                case 3:
                    System.exit(0);

                default:
                    System.out.println("Invalid Option");
            }
        }
    }

    public static void storePassword(){

        try{

            System.out.print("Enter Website: ");
            String website = sc.nextLine();

            System.out.print("Enter Username: ");
            String username = sc.nextLine();

            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            String encrypted = EncryptionUtil.encrypt(password);

            FileWriter fw = new FileWriter("passwords.txt", true);

            fw.write(website + "," + username + "," + encrypted + "\n");

            fw.close();

            System.out.println("Password Stored Successfully");

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void retrievePasswords(){

        try{

            BufferedReader br = new BufferedReader(new FileReader("passwords.txt"));

            String line;

            while((line = br.readLine()) != null){

                String[] data = line.split(",");

                String website = data[0];
                String username = data[1];
                String password = EncryptionUtil.decrypt(data[2]);

                System.out.println("Website: " + website);
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
                System.out.println("----------------------");
            }

            br.close();

        }catch(Exception e){
            System.out.println("No Passwords Stored Yet");
        }
    }
}