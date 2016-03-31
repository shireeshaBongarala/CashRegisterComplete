package cashregister;

import static org.junit.Assert.assertEquals;

class MockPrinter extends Printer {
    private String purchaseString = "";

    @Override
    public void print(String printThis) {
        purchaseString = printThis;
    }

    public void verifyThatPrintIsCalledWithString(String s) {
        assertEquals("print is expected to be called with " + s, s, purchaseString);
    }
}