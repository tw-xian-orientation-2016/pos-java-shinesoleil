public class BarcodeCount {
  String barcode;
  float count;

  public BarcodeCount(String barcode, float count) {
    this.barcode = barcode;
    this.count = count;
  }

  public void addCount(float count) {
    this.count += count;
  }
}
