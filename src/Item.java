import java.util.ArrayList;
import java.util.List;

public class Item {
  public String barcode;
  public String name;
  public String unit;
  public double price;

  public Item(String barcode, String name, String unit, double price) {
    this.barcode = barcode;
    this.name = name;
    this.unit = unit;
    this.price = price;
  }


  public static List<Item> loadAllItems() {
    List<Item> allItems = new ArrayList<Item>();
    allItems.add(new Item("ITEM000000","可口可乐", "瓶", 3.00 ));
    allItems.add(new Item("ITEM000001","雪碧", "瓶", 3.00 ));
    allItems.add(new Item("ITEM000002","苹果", "斤", 5.50 ));
    allItems.add(new Item("ITEM000003","荔枝", "斤", 15.00 ));
    allItems.add(new Item("ITEM000004","电池", "个", 2.00 ));
    allItems.add(new Item("ITEM000005","方便面", "袋", 4.50 ));

    return allItems;
  }
}
