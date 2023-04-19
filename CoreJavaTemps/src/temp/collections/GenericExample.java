package temp.collections;

import java.util.Arrays;
import java.util.List;

/**
 * this is not part of collection framework but a small and related topic that's why I have included this in this package.
 */
public class GenericExample {

    public static void main(String[] args) {
        DataList<Integer> integerDataList = new DataList<>(Arrays.asList(1,2,3,4,5,6));
        integerDataList.printData();

        DataList<String> stringDataList = new DataList<>(Arrays.asList("ABC", "DEF", "JKL"));
        stringDataList.printData();

        DataList<?> unknownDataList = new DataList<>(Arrays.asList(1,2,3.14,true,"DJ"));
        unknownDataList.printData();

        DataList<? extends Number> numberDataList = new DataList<>(Arrays.asList(1,3,4,5,6));
        numberDataList.printData();
    }

}

class DataList<T>{
   private List<T> data;

    public DataList(List<T> data) {
        this.data = data;
    }

    public void printData(){
        data.forEach(System.out::println);
    }

    public void printUnknownDataType(List<?> unknownTypeData){
        unknownTypeData.forEach(System.out::println);
    }

    public void printSubTypeData(List<? extends T> subTypeData){
        subTypeData.forEach(System.out::println);
    }

    public List<T> getData() {
        return data;
    }

}
