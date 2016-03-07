public class ReceiptItem {
  public CartItem cartItem;
  public float subtotal;
  public float savedMoney;

  public ReceiptItem(CartItem cartItem, float subtotal, float savedMoney) {
    this.cartItem = cartItem;
    this.subtotal = subtotal;
    this.savedMoney = savedMoney;
  }
}
