package com.teksystems;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SoftwareDeveloperClub {
    private final File file;
    ArrayList<ClubMember> members = new ArrayList<>();

    public SoftwareDeveloperClub(String fileName){
        file = new File(fileName);
    }

    public void readFile() throws IOException {
        if(file.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            String dudLine = reader.readLine();
            while((line = reader.readLine()) !=null) {
                String[] memberArr = line.split("\\*\\*");
                members.add(new ClubMember(memberArr[0], (memberArr[1]+", " +memberArr[2]), memberArr[3]));
            }
        } else{
            System.out.println("File does not exist or cannot be found" + file.exists());
        }
    }

    void displayMembers(){
        for (int i = 0; i < members.size(); i++) {
            ClubMember club = members.get(i);
            System.out.print(i + ") Name: " + club.getName()+" Location: " + club.getLocation()+" Language: " + club.getLanguage()+"\n");
        }

    }

    void addMembers(Scanner input) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

        System.out.println("How many members would you like to add: ");
        byte count = input.nextByte();

        for (int i = 0; i < count; i++) {
            System.out.println("Enter member's name:");
            input.nextLine();
            String name = input.nextLine();
            System.out.println("Enter member's city:");
            String city = input.nextLine();
            System.out.println("Enter member's state:");
            String state = input.nextLine();
            System.out.println("Enter member's favorite language:");
            String language = input.nextLine();

            members.add(new ClubMember(name, city+", " +state, language));
        }

        for(ClubMember club:members) {
            writer.write(club.getName()+"\\*\\*"+club.getLocation()+"\\*\\*"+club.getLanguage()+"\n");
        }
        writer.close();
    }

    void removeMembers(Scanner input) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        System.out.println("How many members would you like to remove: ");
        byte count = input.nextByte();

        for (int i = 0; i < count; i++) {
            displayMembers();
            System.out.println("Which member would you like to remove, please indicate using the index:");
            byte choice = input.nextByte();
            members.remove(choice);
            for(ClubMember club:members) {
                writer.write(club.getName()+"\\*\\*"+club.getLocation()+"\\*\\*"+club.getLanguage()+"\n");
            }
        }
        writer.close();
    }
}
