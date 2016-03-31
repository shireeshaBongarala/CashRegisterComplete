package cashregister;

public class PurchaseStub extends Purchase {

    public PurchaseStub() {
        super(null);
    }

    @Override
    public String asString(){
        return "hello";
    }
}
