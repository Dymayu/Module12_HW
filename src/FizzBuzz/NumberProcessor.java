package FizzBuzz;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

public class NumberProcessor extends Thread{

    private AtomicBoolean isNumberProcessed = new AtomicBoolean(true);
    private int number;

    private Consumer<Integer> processor;

    public NumberProcessor(Consumer<Integer> processor) {
        this.processor = processor;
    }

    public void process(int number){
        this.number=number;
        this.isNumberProcessed.set(false);
    }
    public boolean isNumberProcessed(){
        return isNumberProcessed.get();
    }

    @Override
    public void run() {
        // перевірка щоб потік працював виводив числа до умови
        while(true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (isNumberProcessed.get()){
                continue;
            }

            processor.accept(number);

            isNumberProcessed.set(true);
        }
    }
}
