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

  public List<ReceiptItem> getReceiptItems(List<CartItem> cartItems, List<Promotion> promos) {
    List<ReceiptItem> receiptItems = new ArrayList<ReceiptItem>();

    for (CartItem cartItem : cartItems) {
      String barcode = cartItem.getBarcode();

      Promotion promo1 = promos.get(0);


      double price = cartItem.getPrice();
      double count = cartItem.count;
      double originalSubtotal = price * count;
      double subtotal = originalSubtotal;

      for (String barcodePromo : promo1.barcodes) {
        if (barcode.equals(barcodePromo)) {
          double countToPay = count - (int) (count / 3);
          subtotal = countToPay * price;
          break;
        }
      }
      double savedMoney = originalSubtotal - subtotal;

      receiptItems.add(new ReceiptItem(cartItem, subtotal, savedMoney));
    }
    return receiptItems;
  }

  public String printDetail(List<ReceiptItem> receiptItems) {
    String text = "***<没钱赚商店>收据***\n";
    double total = 0;
    double saveTotal = 0;

    for (int i = 0; i < receiptItems.size(); i++) {
      String name = receiptItems.get(i).cartItem.getName();
      double count = receiptItems.get(i).cartItem.getCount();
      double price = receiptItems.get(i).cartItem.getPrice();
      String unit = receiptItems.get(i).cartItem.getUnit();
      double subtotal = receiptItems.get(i).subtotal;

      total += subtotal;
      saveTotal += receiptItems.get(i).savedMoney;

      text += "名称：" + name +
        "，数量：" + count + unit + "，单价：" +
        price + "(元)，小计：" + subtotal + "(元)\n";

    }

    text+="----------------------\n" +
      "总计："+ total +"(元)\n"+
      "节省："+ saveTotal +"(元)\n" +
      "**********************";

    return text;
  }
}
