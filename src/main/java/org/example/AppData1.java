package org.example;

import java.util.*;

public class AppData1 {
    public static void main(String[] args) {
        //private Map<String,List<Integer>>

        Map<String,List<Integer>> map = new TreeMap<>();

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(100);
        list1.add(200);
        map.put("Value 1",list1);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(300);
        list2.add(400);
        map.put("Value 2",list2);

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(50);
        list3.add(600);
        map.put("Value 3",list3);

        ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(50);
        list4.add(600);
        map.put("Value 4",list4);

        System.out.println(map);


    }}