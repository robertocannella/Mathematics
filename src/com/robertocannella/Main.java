package com.robertocannella;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

     //   80 X 5 400
     //   20 X 2 40
        // 888 X 5 4440
        // 60 X 74 = 4440
  // 63 X 7054673721340388 = 444444444444444444
  // 62 X 7168458781362 = 444444444444444

 //       list.add(80);
  //      list.add(62);
 //      list.add(67);
//        list.add(90306);
        list.add(60);
//       list.add(81);
 //       list.add(888);
 //       list.add(80);

        for(int num : list)
            System.out.println(EasyMath.binaryCounter(200,num));

    }
}
