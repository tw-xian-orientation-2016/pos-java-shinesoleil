import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class GetCartItemsTest {
  public String[] tags =
    {
      "ITEM000001",
      "ITEM000001",
      "ITEM000001",
      "ITEM000001",
      "ITEM000001",
      "ITEM000003-2",
      "ITEM000005",
      "ITEM000005",
      "ITEM000005"
    };

  public Item item1 = new Item("ITEM000001", "雪碧", "瓶", 3.00);
  public Item item2 = new Item("ITEM000003", "荔枝", "斤", 15.00);
  public Item item3 = new Item("ITEM000005", "方便面", "袋", 4.50);

  public CartItem cartItem1 = new CartItem(item1, 5);
  public CartItem cartItem2 = new CartItem(item2, 2);
  public CartItem cartItem3 = new CartItem(item3, 3);


  @Test
  public void getCorrectCartItems() {
    Pos pos = new Pos();

    List<CartItem> cartItems = pos.getCartItems(tags, Item.loadAllItems());

    assertThat(cartItems.size(), is(3));
  }

  @Test
  public void getCorrectReceiptItems() {
    Pos pos = new Pos();

    List<CartItem> cartItems = new ArrayList<CartItem>();
    cartItems.add(cartItem1);
    cartItems.add(cartItem2);
    cartItems.add(cartItem3);

    pos.getReceiptItems(cartItems, Promotion.loadPromotions());

    assertThat(cartItems.size(), is(3));
  }
}
