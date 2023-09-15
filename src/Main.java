import java.util.*;
public class Main {
    public static void main(String[] args){

        //Variables

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

        ArrayList<Double> batteryPallet = new ArrayList<>();
        ArrayList<Double> rotorsPallet = new ArrayList<>();
        ArrayList<Double> filtersPallet = new ArrayList<>();

        ArrayList<Double> batteryPalletVolume = new ArrayList<>();
        ArrayList<Double> rotorsPalletVolume = new ArrayList<>();
        ArrayList<Double> filtersPalletVolume = new ArrayList<>();

        ArrayList<Double> batteryPalletWeight = new ArrayList<>();
        ArrayList<Double> rotorsPalletWeight = new ArrayList<>();
        ArrayList<Double> filtersPalletWeight = new ArrayList<>();

        ArrayList<Double> batteryPalletHeight = new ArrayList<>();
        ArrayList<Double> rotorsPalletHeight = new ArrayList<>();
        ArrayList<Double> filtersPalletHeight = new ArrayList<>();

        //Math
        //batteryPalletWeight = (37 * 100);
        //rotorPalletWeight = (26.4 * 216);
        //filtersPalletWeight = (0.65 * 4560;

        //Do-While loop that will take input for # of products

        System.out.print("Enter total number of orders: ");
        totalOrders = scan.nextInt();
        System.out.println("Enter the orders from latest delivery to earliest delivery");
        do{

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

            //For each loop that add up the volume of all pallets

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


            // Conditional statement that finds what will be the most optimal way to ship


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

            // For each loop that calculate how many pallets will be needed

            for (Integer num: batteryArray){
                double temp = (double) num / 100;
                batteryPallet.add(temp);
            }
            for (Integer num: rotorArray){
                double temp = (double) num / 216;
                rotorsPallet.add(temp);
            }
            for (Integer num: filterArray){
                double temp = (double) num / 456;
                filtersPallet.add(temp);
            }

            for (int i = 0; i < totalOrders; i ++){
                System.out.println("For order "+(i+1)+ ", you will need "+batteryPallet.get(i)+ " pallets for batteries, "+rotorsPallet.get(i) +" pallets for rotors, and "+filtersPallet.get(i)+ " pallets for filters.");
            }

            // Total Pallet Volume Per Order

            for (int i = 0; i < totalOrders; i ++){
                double temp = batteryPallet.get(i) * (567.1875 * 100);
                batteryPalletVolume.add(temp);
                temp = rotorsPallet.get(i) * (369.54 * 216);
                rotorsPalletVolume.add(temp);
                temp = filtersPallet.get(i) * (159.9075 * 456);
                filtersPalletVolume.add(temp);
            }

           // for (int i = 0; i < totalOrders; i++){
             //   System.out.println(batteryPalletVolume.get(i) + " "+rotorsPalletVolume.get(i)+ " " +filtersPalletVolume.get(i));
            //}


            // Pallet weight for the leftovers
            for (int i = 0; i < totalOrders; i ++){
                double temp = batteryPallet.get(i) - Math.floor(batteryPallet.get(i));
                double tempWeight = temp * (37 * 100);
                batteryPalletWeight.add(tempWeight);
                temp = rotorsPallet.get(i) - Math.floor(rotorsPallet.get(i));
                tempWeight = temp * (26.4 * 216);
                rotorsPalletWeight.add(tempWeight);
                temp = filtersPallet.get(i) - Math.floor(filtersPallet.get(i));
                tempWeight = temp * (0.65 * 456);
                filtersPalletWeight.add(tempWeight);
            }

            /*for (int i = 0; i < totalOrders; i++){
                  System.out.println(batteryPalletWeight.get(i) + " "+rotorsPalletWeight.get(i)+ " " +filtersPalletWeight.get(i));
                } */


            // Pallet height for the leftovers
            for (int i = 0; i < totalOrders; i ++){
                double temp = batteryPallet.get(i) - Math.floor(batteryPallet.get(i));
                double tempHeight = temp * (7.5 * 100);
                batteryPalletHeight.add(tempHeight);
                temp = rotorsPallet.get(i) - Math.floor(rotorsPallet.get(i));
                tempHeight = temp * (2.19 * 216);
                rotorsPalletHeight.add(tempHeight);
                temp = filtersPallet.get(i) - Math.floor(filtersPallet.get(i));
                tempHeight = temp * (1.38 * 456);
                filtersPalletHeight.add(tempHeight);
            }

            /*for (int i = 0; i < totalOrders; i++){
                  System.out.println(batteryPalletHeight.get(i) + " "+rotorsPalletHeight.get(i)+ " " +filtersPalletHeight.get(i));
                }*/


        } while (orderNum <= totalOrders);
    }
}
