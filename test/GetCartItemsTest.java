import org.junit.Test;

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

  @Test
  public void getCorrectCartItems() {
    Pos pos = new Pos();

    List<CartItem> cartItems = pos.getCartItems(tags, Item.loadAllItems());

    assertThat(cartItems.size(), is(3));
  }
}
