package temp.objectmapper;

import java.lang.reflect.Field;

public class BruteForceUsingReflection {

    public static void main(String[] args) {
        SimpleData object1 = new SimpleData();
        object1.setGalaxyName("Milky way");
        object1.setSunType("Yellow_Dwarf_Star");
        object1.setMoonName(null);
        object1.setSunName(null);

        SimpleData object2 = new SimpleData();
        object2.setSunName("SOL");
        object2.setMoonName("LINA");
        object2.setGalaxyName(null);
        object2.setSunType(null);

        SimpleData object3 = mergeObjects(object1, object2);
        System.out.println(object3);
    }

    public static SimpleData mergeObjects(SimpleData object1, SimpleData object2) {
        SimpleData object3 = new SimpleData();
        /*
         * Field belongs to java.lang.reflect : also known as reflection in java language.
         * It is not recommended to use reflection in java because it provides you to access method and fields of an object and allows you to change it which makes
         * you code vulnerable.
         */
        Field[] fields = SimpleData.class.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value1 = field.get(object1);
                Object value2 = field.get(object2);

                if (value1 != null) {
                    field.set(object3, value1);
                } else if (value2 != null) {
                    field.set(object3, value2);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return object3;
    }
}