import java.util.*;
public class TruckCompartments {
  TruckCompartments() {
    
  }
  
  //All the pallets in the compartment
  ArrayList<PalletObject> compartmentPalletArrayList = new ArrayList<PalletObject>();
  double remainingHeight = 8;
  int currentPalletCount = 0;

  
  public double getRemainingHeight() {
    return remainingHeight;
  }
  
  public double calculateRemainingHeight(ArrayList<PalletObject> compartmentPalletArrayList) {
    double remainingHeight = getRemainingHeight();
    for (int i = 0; i < compartmentPalletArrayList.size(); i++) {
      remainingHeight = 8 - compartmentPalletArrayList.get(i).totalPalletHeight;
    }
    return remainingHeight;
  }

  public int getCurrentPalletCount() {
    return currentPalletCount;
  }

  public int calculatePalletCount(ArrayList<PalletObject> compartmentPalletList) {
    int currentPalletCount = getCurrentPalletCount();
    for (int i = 0; i < compartmentPalletList.size(); i++) {
      currentPalletCount = currentPalletCount + 1;
    }
    return currentPalletCount;
  }
}