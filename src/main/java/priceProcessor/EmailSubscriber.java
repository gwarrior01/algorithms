package priceProcessor;

public class EmailSubscriber implements PriceProcessor {

    @Override
    public void onPrice(String ccyPair, double rate) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Sending email + " + ccyPair + " changed to rate " + rate);
    }

    @Override
    public void subscribe(PriceProcessor priceProcessor) {

    }

    @Override
    public void unsubscribe(PriceProcessor priceProcessor) {

    }
}