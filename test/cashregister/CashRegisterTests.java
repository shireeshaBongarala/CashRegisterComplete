package cashregister;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class CashRegisterTests {

    @Mock
    Printer mockPrinter;

    @Mock
    Purchase mockPurchase;

    @Before
    public void setUp() {
        initMocks(this);
    }
    @Test
    public void shouldPrintThePurchaseInformation() {
        CashRegister cashRegister = new CashRegister(mockPrinter);

        when(mockPurchase.asString()).thenReturn("Hello");
        
        cashRegister.process(mockPurchase);
        verify(mockPrinter).print(mockPurchase.asString());
    }

    @Test
    public void shouldPrintThePurchaseInformationWithoutTestingPurchaseAsStringMethod(){
        CashRegister cashRegister = new CashRegister(mockPrinter);

        cashRegister.process(mockPurchase);

        verify(mockPrinter).print(mockPurchase.asString());
    }
}
