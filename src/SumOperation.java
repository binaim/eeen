import java.util.List;

public class SumOperation implements IOperation<Integer>{
    private int value;
    @Override
    public void compute(List<ICell<Integer>> iCells) {
        this.value = 0;
        for (ICell<Integer> cell : iCells){
            value += cell.getValue();
        }
    }

    @Override
    public Integer getValue() {
        return value;
    }
}
