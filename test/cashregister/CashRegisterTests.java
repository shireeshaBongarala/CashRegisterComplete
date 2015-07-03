package cashregister;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CashRegisterTests {

    private String purchaseString = "";

    @Test
    public void shouldPrintThePurchaseInformation() {
        MockPrinter mockPrinter = new MockPrinter();
        CashRegister cashRegister = new CashRegister(mockPrinter);
        Item[] itemList = new Item[]{new Item("Book", 5)};
        Purchase purchase = new Purchase(itemList);

        cashRegister.process(purchase);

        assertEquals(purchaseString, purchase.asString());
    }

    class MockPrinter extends Printer{

        @Override
        public void print(String printThis) {
            purchaseString = printThis;
        }
    }
}
