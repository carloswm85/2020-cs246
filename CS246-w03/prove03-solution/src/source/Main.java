package source;

/**
 * This is the driver function that calls the other experiments.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Single City Experiments:");
        new SingleCityExperimenter().singleCityForcast();

        System.out.println("\n\nMultiple City Experiments:");
        new MultipleCityExperimenter().compareCityList();
    }


}