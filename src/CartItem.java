public class CartItem {
  public Item item;
  public double count;

  public CartItem(Item item, double count) {
    this.item = item;
    this.count = count;
  }

  public String getBarcode() {
    return this.item.barcode;
  }

  public String getName() {
    return this.item.name;
  }

  public double getCount() {
    return this.count;
  }

  public String getUnit() {
    return this.item.unit;
  }

  public double getPrice() {
    return this.item.price;
  }
}
