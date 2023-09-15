import java.util.*;
class Order {
  static ArrayList<TruckCompartments[]> trucksList = new ArrayList<TruckCompartments[]>();
  static ArrayList<TruckCompartments[]> containerList = new ArrayList<TruckCompartments[]>();
  static ArrayList<TruckCompartments[]> unitList = new ArrayList<TruckCompartments[]>();
  
  public static void main(String[] args) {
    TruckCompartments[] truck = Truck.createTruckCompartments();
    
    //Order is given and calculated
    OrderObject order = new OrderObject();


      
      /* for (int i = 0; i < batteryPallet.size(); i++) {
        PalletObject batteryPalletObject = new PalletObject(batteryPallet.get(i), batteryPalletVolume.get(i), batteryPalletWeight.get(i));
        order.orderPalleteArrayList.add(batteryPalletObject);
      } 
      */

    

    //Add all the pallets of an order to containers
    for (int i = 0; i < order.orderPalletArrayList.size() - 1; i++) {
      addPallet(truck, order.orderPalletArrayList.get(i));
    }

  
    
  }

  //Method to add pallet
  public static TruckCompartments[] addPallet(TruckCompartments[] compartmentsArray, PalletObject newPallet) {
    TruckCompartments[] truckCompartments = compartmentsArray;
    PalletObject pallet = newPallet;
      
      //If condition is met to add to compartment
      if (truckCompartments[0].getRemainingHeight() > pallet.totalPalletHeight) {
        compartmentsArray[0].compartmentPalletArrayList.add(newPallet);
      }

      else if (truckCompartments[1].getRemainingHeight() > pallet.totalPalletHeight) {
        compartmentsArray[1].compartmentPalletArrayList.add(newPallet);
      }
      
      else if (truckCompartments[2].getRemainingHeight() > pallet.totalPalletHeight) {
        compartmentsArray[2].compartmentPalletArrayList.add(newPallet);
      }
      
      else if (truckCompartments[3].getRemainingHeight() > pallet.totalPalletHeight) {
        compartmentsArray[3].compartmentPalletArrayList.add(newPallet);
      }
      
      else if (truckCompartments[4].getRemainingHeight() > pallet.totalPalletHeight) {
        compartmentsArray[4].compartmentPalletArrayList.add(newPallet);
      }
      
      else if (truckCompartments[5].getRemainingHeight() > pallet.totalPalletHeight) {
        compartmentsArray[5].compartmentPalletArrayList.add(newPallet);
      }
      
      else if (truckCompartments[6].getRemainingHeight() > pallet.totalPalletHeight) {
        compartmentsArray[6].compartmentPalletArrayList.add(newPallet);
      }
      
      else if (truckCompartments[7].getRemainingHeight() > pallet.totalPalletHeight) {
        compartmentsArray[7].compartmentPalletArrayList.add(newPallet);
      }
      
      else if (truckCompartments[7].getRemainingHeight() > pallet.totalPalletHeight) {
        compartmentsArray[7].compartmentPalletArrayList.add(newPallet);
      }
      
      else if (truckCompartments[8].getRemainingHeight() > pallet.totalPalletHeight) {
        compartmentsArray[8].compartmentPalletArrayList.add(newPallet);
      }
      
      else if (truckCompartments[9].getRemainingHeight() > pallet.totalPalletHeight) {
        compartmentsArray[9].compartmentPalletArrayList.add(newPallet);
      }
     
      else if (truckCompartments[10].getRemainingHeight() > pallet.totalPalletHeight) {
        compartmentsArray[10].compartmentPalletArrayList.add(newPallet);
      }
      
      else if (truckCompartments[11].getRemainingHeight() > pallet.totalPalletHeight) {
        compartmentsArray[11].compartmentPalletArrayList.add(newPallet);
      }
    
      //If there is no more space add truck to trucklist and start new truck
      else {
        trucksList.add(truckCompartments);
        truckCompartments = Truck.createTruckCompartments();
      }
    return truckCompartments;
    }
}


      //80 Pallets = 5 height
      //30 Pallets = 3 height

      /* WAY THE TRUCK IS SITUATED WITH NUMBERED COMPARTMENTS
        Front  11  9   7  5  3  1  Back
               12  10  8  6  4  2
      /*
    
      /*
        Assuming that pallet information is given
        EXAMPLE: PalletOne = height 4, length 5, width 5, Battery
                 PalletTwo = height 2, length 5, width 5, Air Filter

          

          if (truckCompartments[0].calculateRemainingHeight() > Pallet.height) {
            truckCompartments[0].compartmentSpaceList.add(Pallet);
          }

          else if (truckCompartments[1].calculateRemainingHeight() > Pallet.height) {
            CompartmentTwo.compartmentSpaceList.add(Pallet);
          }
          
          else if (truckCompartments[2].calculateRemainingHeight() > Pallet.height) {
            CompartmentThree.compartmentSpaceList.add(Pallet);
          }
          
          else if (truckCompartments[3].calculateRemainingHeight() > Pallet.height) {
            CompartmentFour.compartmentSpaceList.add(Pallet);
          }
          
          else if (truckCompartments[4].calculateRemainingHeight() > Pallet.height) {
            CompartmentFive.compartmentSpaceList.add(Pallet);
          }
          
          else if (truckCompartments[5].calculateRemainingHeight() > Pallet.height) {
            CompartmentSix.compartmentSpaceList.add(Pallet);
          }
          
          else if (truckCompartments[6].calculateRemainingHeight() > Pallet.height) {
            CompartmentSeven.compartmentSpaceList.add(Pallet);
          }
          
          else if (truckCompartments[7].calculateRemainingHeight() > Pallet.height) {
            CompartmentEight.compartmentSpaceList.add(Pallet);
          }
          
          else if (truckCompartments[8].calculateRemainingHeight() > Pallet.height) {
            CompartmentNine.compartmentSpaceList.add(Pallet);
          }
          
          else if (truckCompartments[9].calculateRemainingHeight() > Pallet.height) {
            CompartmentTen.compartmentSpaceList.add(Pallet);
          }
          
          else if (truckCompartments[10].calculateRemainingHeight() > Pallet.height) {
            CompartmentEleven.compartmentSpaceList.add(Pallet);
          }
          
          else if (truckCompartments[11].calculateRemainingHeight() > Pallet.height) {
            CompartmentTwelve.compartmentSpaceList.add(Pallet);
          }

          else {
            trucksList.add(truckCompartments);
            truckCompartments = Truck.createTruckCompartments();
          }
      */