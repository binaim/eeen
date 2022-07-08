import java.util.List;

public class MultiplicationOperation implements IOperation<Integer>{
    private int value;
    @Override
    public void compute(List<ICell<Integer>> iCells) {
        value = 1;
        for (ICell<Integer> cell : iCells){
            value = value * cell.getValue();
        }
    }

    @Override
    public Integer getValue() {
        return value;
    }
}
