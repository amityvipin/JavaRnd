package sun.java.collections;

import java.util.Date;

public class Person {

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    Date birthday;
    Sex gender;
    String emailAddress;

    public int getAge() {
        return 4;
    }

    public void printPerson() {
        // ...
    }
}