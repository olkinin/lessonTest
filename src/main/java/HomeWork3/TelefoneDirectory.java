package main.java.HomeWork3;

import java.util.*;

public class TelefoneDirectory {
    Map<String, String> telefoneDirectory = new HashMap<>();


    public void add(String number, String name) {
        telefoneDirectory.put(number, name);

    }

    public void set(String name) {
        for (Map.Entry<String, String> o : telefoneDirectory.entrySet()) {
            if (o.getValue().equals(name)) {
                System.out.println(o.getKey() + " " + o.getValue());
            }
        }
}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelefoneDirectory that = (TelefoneDirectory) o;
        return Objects.equals(telefoneDirectory, that.telefoneDirectory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(telefoneDirectory);
    }
}
