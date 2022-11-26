package priceProcessor;

public class ConsoleSubscriber implements PriceProcessor {

    @Override
    public void onPrice(String ccyPair, double rate) {
        System.out.println("Console: " + ccyPair + " changed to rate " + rate);
    }

    @Override
    public void subscribe(PriceProcessor priceProcessor) {

    }

    @Override
    public void unsubscribe(PriceProcessor priceProcessor) {

    }
}