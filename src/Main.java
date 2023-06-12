import List.StringList;
import List.impl.CustomStringList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        StringList list = new CustomStringList();

        System.out.println("Начальный размер списка = " + list.size());
        System.out.println("Список пустой ? " +list.isEmpty());


        list.add("str1");
        list.add("str2");
        list.add("str3");
        System.out.println("Список после трех вставок: " + list);

        list.add(1,"str4");
        System.out.println("Список после вставки на индекс: " + list);
        System.out.println("Размер списка = " + list.size());

        list.remove("str4");
        System.out.println("Список после удаления: " + list);
        System.out.println("Размер списка = " + list.size());

        list.remove(0);
        System.out.println("Список после удаления по индексу: " + list);
        System.out.println("Размер списка = " + list.size());

        System.out.println("contains от str1: " + list.contains("str1"));
        System.out.println("contains от str2: " + list.contains("str2"));
    }
}