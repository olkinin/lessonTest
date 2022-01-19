package main.java.HomeWork3;

import java.util.*;

public class Homework {


    public static void main(String[] args) {

// Не придумала я, как исправить ошибку с тремя одинаковыми значениями
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("Понедельник",
                "Вторник", "Среда", "Четверг",
                "Пятница", "Суббота", "Воскресенье",
                "Понедельник", "Вторник", "Среда", "Среда"));
        Set<String> set = new HashSet<>();
        set.addAll(list);
        System.out.println(set);
        list.sort(String::compareTo);
        int k = 0;
        int counter = 1;
        for (int i = 0; i < list.size(); i++) {
            k++;
            counter = 1;
            if (k < list.size()) {
                if (!list.get(i).equals(list.get(k))) {
                } else {
                    i++;
                    k++;
                    ++counter;
                }
                System.out.println(list.get(i) + " - " + counter);
            }
        }


        TelefoneDirectory telefoneDirectory = new TelefoneDirectory();
        telefoneDirectory.add("324-55-55", "Иванов");
        telefoneDirectory.add("111-55-55", "Иванов");
        telefoneDirectory.add("222-15-55", "Петров");
        telefoneDirectory.add("111-25-15", "Васильев");
        telefoneDirectory.set("Иванов");
        telefoneDirectory.set("Петров");


    }

}





