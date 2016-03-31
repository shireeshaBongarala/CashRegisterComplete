package cashregister;

import org.junit.Test;

public class CashRegisterTests {



    @Test
    public void shouldPrintThePurchaseInformation() {
        MockPrinter mockPrinter = new MockPrinter();
        CashRegister cashRegister = new CashRegister(mockPrinter);
        Item[] itemList = new Item[]{new Item("Book", 5)};
        Purchase purchase = new Purchase(itemList);

        cashRegister.process(purchase);

        mockPrinter.verifyThatPrintIsCalledWithString(purchase.asString());
    }

    @Test
    public void shouldPrintThePurchaseInformationWithoutTestingPurchaseAsStringMethod(){
        MockPrinter mockPrinter = new MockPrinter();
        CashRegister cashRegister = new CashRegister(mockPrinter);
        PurchaseStub purchaseStub = new PurchaseStub();

        cashRegister.process(purchaseStub);

        mockPrinter.verifyThatPrintIsCalledWithString(purchaseStub.asString());
    }
}
