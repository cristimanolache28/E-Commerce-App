package com.lov2code.newthings.Iterable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        Collection<String> collection = list;
        Iterable<String> iterable = collection;



    }
}


// Iterators can be returned and manipulated before the stored data is fully available, whereas a list,
// or an array for that matter, must be fully populated before it can safely be returned.





