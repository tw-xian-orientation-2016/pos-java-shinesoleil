import java.util.ArrayList;
import java.util.List;

public class Promotion {
  String type;
  String[] barcodes;

  public Promotion(String type, String[] barcodes) {
    this.type = type;
    this.barcodes = barcodes;
  }

  public static List<Promotion> loadPromotions() {
    List<Promotion> promos = new ArrayList<Promotion>();

    String[] barcodes = {"ITEM000000", "ITEM000001", "ITEM000005"};
    promos.add(new Promotion("BUY_TWO_GET_ONE_FREE", barcodes));

    return promos;
  }
}
