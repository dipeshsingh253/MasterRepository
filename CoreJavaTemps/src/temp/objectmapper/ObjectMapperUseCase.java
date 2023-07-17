package temp.objectmapper;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.UUID;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 *
 * This was a real world problem that I faced working on one of my projects.
 * The scenario I was in : Let say, I have two different object of same class. Where some properties in object 1 are null but are not null in object 2
 * and some properties which are null in object 2 but are not null in object 1. Now I want a new object third object 3 which will have all the not null properties from
 * both object 1 and object 2.
 *
 */


/**
 * As this is a simple java project without any buidl or framework tool we need to add manually jar files to use ObjectMapper.
 * Jars we need for this : 1 ) jackson-core 2 ) jackson-annotation 3 )jackson-databind
 */

public class ObjectMapperUseCase {

    PlanetData planetData;
    SimpleData simpleData;



    public ObjectMapperUseCase() {
        /**
         * As we can see here PlanetData have all the properties filled which are not available in SimpleData. And SimpleData have all the properties which are
         * available in PlanetData but are null.
         */
        this.planetData = new PlanetData();
        this.planetData.planetId = UUID.randomUUID().toString();
        this.planetData.civilizationLevel=1;
        this.planetData.planetName="Earth";
        this.planetData.mass=provideMass(5.6792,0.0006,24);
        this.planetData.distanceFromSun= (double) (152*1000000); //152 million km
        this.planetData.isLifePossible=true;


        this.simpleData = new SimpleData();
        this.simpleData.moonName="LUNA";
        this.simpleData.sunName="SOL";
        this.simpleData.galaxyName ="MILKY WAY";
        this.simpleData.sunType="YELLOW_DWARF_STAR";
    }

    public static void main(String[] args) throws IOException {

        /*
         * Using object mapper to solve this problem. Here if the two object are of same types and field names are same then it will work.
         * and if the two objects are of different class like this example then field name and respective datatype should be same.
         */

        ObjectMapperUseCase objectMapperUseCase = new ObjectMapperUseCase();

        System.out.println("Before Merging :=========================================================");
        System.out.println(objectMapperUseCase.planetData);


       objectMapperUseCase.mergeObjects(objectMapperUseCase.planetData, objectMapperUseCase.simpleData);

        System.out.println("After Merging : =========================================================");
        System.out.println(objectMapperUseCase.planetData);


        /*
         * Using more of a brute force way to solve the problem.
         */




    }

    public PlanetData mergeObjects(PlanetData planetData, SimpleData simpleData) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.readerForUpdating(planetData).readValue(objectMapper.writeValueAsString(simpleData));
        return planetData;
    }



    private BigDecimal provideMass(Double val,Double uncertainty,Integer powerOfTen) {

        BigDecimal value = new BigDecimal(val);
        BigDecimal uncertain = new BigDecimal(uncertainty);
        BigDecimal pow = BigDecimal.TEN.pow(powerOfTen);


        return value.add(uncertain).multiply(pow);

    }
}
