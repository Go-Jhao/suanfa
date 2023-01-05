package test;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        HashSet<Object> objects = new HashSet<>();
        Student student1 = new Student(1,"aa");
        Student student2 = new Student(2,"aa");

        objects.add(student1);
        objects.add(student2);
        System.out.println(objects);

        student1.name = "gjh";
        System.out.println(objects);
        HashMap hashMap = new HashMap();
        Set set = hashMap.entrySet();
        System.out.println(set.getClass().getName());
    }
}
