import java.util.ArrayList;
import java.util.List;

public class Pos {

  public List<CartItem> getCartItems(String[] tags, List<Item> items) {
    List<BarcodeCount> barcodeCounts = new ArrayList<BarcodeCount>();
    List<CartItem> cartItems = new ArrayList<CartItem>();

    for (String tag : tags) {
      String[] tagArray = tag.split("-");
      int count = tagArray.length > 1 ? Integer.parseInt(tagArray[1]) : 1;
      int index = -1;
      for (int i = 0; i < barcodeCounts.size(); i++) {
        if (barcodeCounts.get(i).barcode.equals(tagArray[0])) {
          index = i;
          barcodeCounts.get(i).addCount(count);
          break;
        }
      }
      if (index == -1) {
        barcodeCounts.add(new BarcodeCount(tagArray[0], count));
      }
    }

    for (int i = 0; i < barcodeCounts.size(); i++) {
      for (Item item : items) {
        if (barcodeCounts.get(i).barcode.equals(item.barcode)) {
          cartItems.add(new CartItem(item, barcodeCounts.get(i).count));
        }
      }
    }

    return cartItems;
  }
}
