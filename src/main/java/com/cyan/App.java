package com.cyan;

public class App {
    public static void main( String[] args ) {
        App app = new App();
        String[] names = new String[] {"Aline zenon", "WALTER AZevedo", "lucas suzuki", "tatiana", "abel abelha"};
        for (String name : app.getNames(names))
            System.out.println(name);
    }

    public String[] getNames(String[] names) {
        String[] namesTransformed = new String[length(names)];
        int index = 0;
        for (String name : names) {
            int indexSpace = getIndexSpace(name);
            if (!verifyNoLastName(indexSpace)) {
                String firstName = name.substring(0, indexSpace);
                String lastName = name.substring(indexSpace + 1);
                namesTransformed[index] = transformName(lastName) + ", " + transformName(firstName);
            } else {
                namesTransformed[index] = transformName(name);
            }
            index++;
        }
        return namesTransformed;
    }

    public int getIndexSpace(String name) {
        int index = 0;
        while (index < name.length()) { 
            char character = name.charAt(index);
            if (character == ' ') {
                return index;
            }
            index++;
        }
        return -1;
    }

    public boolean verifyNoLastName(int index) {
        return index == -1;
    }

    public int length(String[] strings) {
        int length = 0;
        for (String s : strings) {
            length++;
        }
        return length;
    }

    public String transformName(String name) {
        String nameTransformed = "";
        int index = 1;
        String firstCharacter = name.substring(0,1).toUpperCase();
        nameTransformed += firstCharacter;
        while (index < name.length()) {
            String character = name.substring(index, index + 1).toLowerCase();
            nameTransformed += character;
            index++;
        }
        return nameTransformed;
    }

    public String[] getOrderedNames(String[] names) {
        String[] orderedNames = new String[length(names)];
        for (String name1 : names) {
            int index = 0;
            for (String name2 : names) {
                if (name1.compareTo(name2) > 0) {
                    orderedNames[index] = name1;
                } else {
                    orderedNames[index] = name2;
                }
                index++;
            }
        }
        return orderedNames;
    }
}