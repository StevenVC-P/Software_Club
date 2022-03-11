package com.teksystems;

import java.io.IOException;
import java.util.Scanner;

public class ClubMemberApp {

    public static void clubMemberApp() throws IOException {
        SoftwareDeveloperClub club = new SoftwareDeveloperClub("src/com/teksystems/members.txt");

        club.readFile();

        Scanner input = new Scanner(System.in);
        byte action;
        do {
            System.out.println("Pick an action: \n 1) Display Member \n 2) Add Member \n 3) Remove Member \n 4) Quit\n");
            action = input.nextByte();
            if (action == 1) club.displayMembers();
            if (action == 2) club.addMembers(input);
            if (action == 3) club.removeMembers(input);
        } while (action != 4);
    }
}
