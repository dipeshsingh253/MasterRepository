package temp.collections;

import temp.dateandtime.constants.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListExamples {

    static void listExampleOne(){

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        list.stream().filter(integer -> integer % 2 == 0).forEach(System.out::println);
        int ans = list.stream().filter(integer -> integer % 2 == 0).findFirst().get();
        System.out.println(ans);

        System.out.println(Constants.METHOD_SEPARATOR);
    }

    static void listExampleTwo(){
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));

        list.stream().map(integer -> integer * 2).forEach(System.out::println);
        System.out.println(Constants.METHOD_SEPARATOR);
    }


}
