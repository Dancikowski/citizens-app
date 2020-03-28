package com.mycompany.app.cli;
import com.mycompany.app.cli.fileMaker.FileMaker;

import java.io.IOException;
import java.util.TreeMap;


public class Cli {
    public void createCli() throws IOException {
        System.out.println("Hello in citizen App");
        System.out.println("Please enter your data: ");
        FileMaker fileMaker = new FileMaker("src/main/resources/citizens.txt");
        fileMaker.createFile();
        while (true) {
            CitizenReader citizenReader = new CitizenReader();
            TreeMap <String, String> citizenData = new TreeMap<String, String>();
            citizenData.put("city", citizenReader.readLine("city"));
            citizenData.put("fullName", citizenReader.readLine("fullName"));
            citizenData.put("personId", citizenReader.readLine("personId"));

            fileMaker.updateFile(citizenData);
        }
    }
}
