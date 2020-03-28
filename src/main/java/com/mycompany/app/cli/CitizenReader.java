package com.mycompany.app.cli;

import com.mycompany.app.cli.validator.IdValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CitizenReader {
    private String getTextToDisplay(String type) {
        if (type.equals("city")) {
            return "City";
        } else if (type.equals("fullName")) {
            return "First name and Last name";
        } else {
            return "Person ID";
        }
    }

    public String readLine(String type) throws IOException {
        while(true) {
            System.out.println(getTextToDisplay(type) + ":");
            System.out.print("> ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String str = reader.readLine();
            try {
                if (!(str.length() > 0)) {
                    throw new Error("Please enter " + getTextToDisplay(type));
                } else if (type.equals("personId")) {
                    IdValidator idValidator = new IdValidator(str);
                    if (idValidator.validate()) {
                        return str;
                    } else {
                        throw new Error("Please enter valid " + getTextToDisplay(type));
                    }
                } else {
                    return str;
                }
            } catch (Error e) {
                System.err.println(e.getLocalizedMessage());
            }
        }
    }
}
