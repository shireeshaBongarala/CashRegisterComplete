package cashregister;

class CashRegister {

    private Printer printer;

    public CashRegister(Printer printer) {

        this.printer = printer;
    }

    public void process(Purchase purchase) {
        printer.print(purchase.asString());
    }
}
