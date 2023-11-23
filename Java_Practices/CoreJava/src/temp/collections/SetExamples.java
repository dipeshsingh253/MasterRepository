package temp.collections;

import temp.dateandtime.constants.Constants;

import java.util.*;
import java.util.stream.Collectors;
class CustomClass implements Comparable<CustomClass>{
    String name;
    int point;

    public CustomClass(String name, int point) {
        this.name = name;
        this.point = point;
    }

    @Override
    public int compareTo(CustomClass customClass) {
        return Integer.compare(customClass.point,this.point);
    }

    @Override
    public String toString() {
        return "[ "+this.name +" "+this.point +" ]";
    }
}

class CustomComparator implements Comparator<CustomClass> {

    @Override
    public int compare(CustomClass customClass, CustomClass t1) {
        return Integer.compare(customClass.point,t1.point);
    }
}
public class SetExamples {

    /**
     * this method implements union , intersection and difference operations using sets.
     */
    static void setExampleOne(){

        System.out.println("this method implements union , intersection and difference operations using sets.");

        HashSet<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        HashSet<Integer> set2 = new HashSet<>();
        set2.add(2);
        set2.add(3);
        set2.add(4);

        // Union of set1 and set2
        HashSet<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println(union); // Output: [1, 2, 3, 4]

        // Intersection of set1 and set2
        HashSet<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println(intersection); // Output: [2, 3]

        // Difference of set1 and set2
        HashSet<Integer> difference = new HashSet<>(set2);
        difference.removeAll(set1);
        System.out.println(difference); // Output: [1]


        System.out.println(Constants.METHOD_SEPARATOR);

    }

    /**
     * this method use default sorting for predefined classes like Integer using treeSet.
     */
    static void setExampleTwo(){

        System.out.println("this method use default sorting for predefined classes like Integer using treeSet.");

        TreeSet<Integer> integerSet = new TreeSet<>();
        integerSet.add(4);
        integerSet.add(3);
        integerSet.add(1);

        System.out.println(integerSet.toString());

        System.out.println(Constants.METHOD_SEPARATOR);
    }


    /**
     * this method implements shorting on custom objects using Comparator and Comparable with help of treeSet.
     */
    static void setExampleThree(){

        System.out.println("this method implements shorting on custom objects using Comparator and Comparable with help of treeSet.");

        CustomClass cc1 = new CustomClass("CC1",100);
        CustomClass cc2 = new CustomClass("CC2",120);
        CustomClass cc3 = new CustomClass("CC3",360);
        CustomClass cc4 = new CustomClass("CC4",58);
        CustomClass cc5 = new CustomClass("CC5",10);

        TreeSet<CustomClass> treeSet = new TreeSet<>(new CustomComparator());
        treeSet.add(cc1);
        treeSet.add(cc2);
        treeSet.add(cc3);
        treeSet.add(cc4);
        treeSet.add(cc5);

        treeSet.forEach(System.out::println);


        System.out.println(Constants.METHOD_SEPARATOR);

    }

    /**
     * this method implements sorting in reverseOrder with TreeSet.
     */
    static void setExampleFour(){

        System.out.println("this method implements sorting in reverseOrder with TreeSet.");

        HashSet<Integer> set = new HashSet<>();
        for (int i=0;i<5;i++) set.add(i+i*2+1);


        TreeSet<Integer> treeSet = new TreeSet<>(Collections.reverseOrder());
//        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.addAll(set);


        treeSet.forEach(System.out::println);

        System.out.println(Constants.METHOD_SEPARATOR);

    }

}



