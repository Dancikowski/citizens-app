package com.mycompany.app.cli.fileMaker;

import java.io.*;

import java.util.TreeMap;

public class FileMaker {
    String name;
    File file;

    public FileMaker(String name) {
        this.name = name;
    }

    public void createFile() throws IOException {
        try {
            file = new File(this.name);
            if (file.exists() && file.isFile()) {
                file.delete();
            }
            file.createNewFile();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void updateFile(TreeMap <String, String> citizenData) throws FileNotFoundException, IOException {
        String personId = citizenData.get("personId");
        StringBuilder s = new StringBuilder();
        s.append(citizenData.get("city")).append(" ").append(citizenData.get("fullName")).append(" ").append(citizenData.get("personId"));
        boolean isLineModified = false;
        try {
            BufferedReader file = new BufferedReader(new FileReader(this.name));
            StringBuffer inputBuffer = new StringBuffer();
            String line;

            while((line = file.readLine()) != null) {
                if (line.contains(personId)) {
                    inputBuffer.append(s).append(System.lineSeparator());
                    isLineModified = true;
                } else {
                    inputBuffer.append(line).append(System.lineSeparator());
                }
            }
            if (!isLineModified) {
                inputBuffer.append(s).append(System.lineSeparator());
            }
            file.close();
            FileOutputStream fileOut = new FileOutputStream(this.name);
            fileOut.write(inputBuffer.toString().getBytes());
            fileOut.close();
            System.out.println("Saved");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
