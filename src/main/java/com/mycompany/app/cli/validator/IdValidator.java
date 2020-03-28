package com.mycompany.app.cli.validator;

import java.util.ArrayList;

public class IdValidator {
    public String fieldToValidate;

    public IdValidator(String field) {
        this.fieldToValidate = field;
    }

    private boolean isNumber() {
        try {
            Double.parseDouble(this.fieldToValidate);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean hasElevenChars() {
        return this.fieldToValidate.length() == 11;
    }

    private boolean isControlNumberCorrect() {
        int controlNum = Integer.parseInt(this.fieldToValidate.substring(this.fieldToValidate.length() -1));
        int res = 0;
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (String field : this.fieldToValidate.split(""))
            numbers.add(Integer.parseInt(field));

        for (int i = 0; i < numbers.size(); i++) {
            switch(i) {
                case 0:
                    res = res + numbers.get(i) * 9;
                    break;
                case 1:
                    res = res + numbers.get(i) * 7;
                    break;
                case 2:
                    res = res + numbers.get(i) * 3;
                    break;
                case 3:
                    res = res + numbers.get(i) * 1;
                    break;
                case 4:
                    res = res + numbers.get(i) * 9;
                    break;
                case 5:
                    res = res + numbers.get(i) * 7;
                    break;
                case 6:
                    res = res + numbers.get(i) * 3;
                    break;
                case 7:
                    res = res + numbers.get(i) * 1;
                    break;
                case 8:
                    res = res + numbers.get(i) * 9;
                    break;
                case 9:
                    res = res + numbers.get(i) * 7;
                    break;
                default:
                    break;
            }
        }
        return res % 10 == controlNum;
    }

    public boolean validate() {
        return isNumber() && hasElevenChars() && isControlNumberCorrect();
    }


}
