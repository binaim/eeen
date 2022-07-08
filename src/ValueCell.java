import java.util.ArrayList;
import java.util.List;

public class ValueCell<T> implements  IValueCell<Integer>{

    private int value;
    private List<ICellObserver> observers;

    public ValueCell(int operand) {
        this.value = operand;
        this.observers = new ArrayList<>();
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public void addObserver(ICellObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (ICellObserver observer : observers){
            observer.update();
        }

    }

    @Override
    public String toString() {
        return "ValueCell{" +
                "operand=" + getValue() +
                '}';
    }

    @Override
    public Integer setValue(Integer value) {
        return null;
    }
}
