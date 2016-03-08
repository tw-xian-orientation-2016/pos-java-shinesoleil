public class ReceiptItem {
  public CartItem cartItem;
  public double subtotal;
  public double savedMoney;

  public ReceiptItem(CartItem cartItem, double subtotal, double savedMoney) {
    this.cartItem = cartItem;
    this.subtotal = subtotal;
    this.savedMoney = savedMoney;
  }
}
