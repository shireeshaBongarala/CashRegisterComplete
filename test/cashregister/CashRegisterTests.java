package cashregister;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class CashRegisterTests {

    @Mock
    Printer mockPrinter;

    @Before
    public void setUp() {
        initMocks(this);
    }
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
        CashRegister cashRegister = new CashRegister(mockPrinter);
        PurchaseStub purchaseStub = new PurchaseStub();

        cashRegister.process(purchaseStub);

        verify(mockPrinter).print(purchaseStub.asString());
    }
}
