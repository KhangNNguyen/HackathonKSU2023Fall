import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int orderNum = 1;
        int totalOrders;

        int batteries;
        int rotors;
        int filters;

        ArrayList<Integer> batteryArray = new ArrayList<>();
        ArrayList<Integer> rotorArray = new ArrayList<>();
        ArrayList<Integer> filterArray = new ArrayList<>();

        ArrayList<Double> batteryVolumeArray = new ArrayList<>();
        ArrayList<Double> rotorsVolumeArray = new ArrayList<>();
        ArrayList<Double> filtersVolumeArray = new ArrayList<>();

        double battVolume = 0;
        double rotorsVolume = 0;
        double filtersVolume = 0;

        double totalBattVolume = 0;
        double totalRotorsVolume = 0;
        double totalFiltersVolume = 0;

        double totalVolume = 0;

        double boxTruckVolume = 18432;
        double shippingContainerVolume = 32640;
        double storageUnitVolume = 19200;
        double palletVolume = 66.66;

        double trucks=0;
        double units=0;
        double container=0;

        do{
            System.out.print("Enter total number of orders: ");
            totalOrders = scan.nextInt();
            for (int i = 0; i < totalOrders; i++){
                System.out.println("Order #"+orderNum);
                System.out.print("Enter number of car batteries: ");
                batteries = scan.nextInt();
                batteryArray.add(batteries);
                battVolume =  567.1875 * batteries;
                batteryVolumeArray.add(battVolume);

                System.out.print("Enter number of brake rotors: ");
                rotors = scan.nextInt();
                rotorArray.add(rotors);
                rotorsVolume = 290.2366 * rotors;
                rotorsVolumeArray.add(rotorsVolume);

                System.out.print("Enter number of air filters: ");
                filters = scan.nextInt();
                filterArray.add(filters);
                filtersVolume = 290.2366 * filters;
                filtersVolumeArray.add(filtersVolume);
                orderNum++;
            }
            for (Double num: batteryVolumeArray){
                totalBattVolume += num;
            }
            for (Double num: rotorsVolumeArray ){
                totalRotorsVolume += num;
            }
            for (Double num: filtersVolumeArray){
                totalFiltersVolume += num;
            }
            totalVolume = totalBattVolume + totalRotorsVolume + totalFiltersVolume;
            System.out.println(totalVolume+" inches cubed");

            if (totalVolume < boxTruckVolume){
                System.out.println("Your shipment will need one box truck");
            }
            else if (totalVolume < storageUnitVolume){
                System.out.println("Your shipment will need one storage unit");
            }
            else if (totalVolume < shippingContainerVolume){
                System.out.println("Your shipment will need one shipping container");
            }
            else {
                trucks = totalVolume / boxTruckVolume ;
                units = totalVolume / storageUnitVolume ;
                container = totalVolume / shippingContainerVolume;

                if (trucks > units){
                    if (units > container){
                        System.out.println("Your shipment will be optimal when using "+(int)Math.ceil(container)+ " shipping containers");
                    }
                    else {
                        System.out.println("Your shipment will be optimal when using "+(int)Math.ceil(units)+ " storage units");
                    }

                }
                else {
                    System.out.println("Your shipment will be optimal when using "+(int)Math.ceil(trucks)+ " box trucks");
                }

            }


        } while (orderNum <= totalOrders);
    }
}
