import java.util.List;

public class SubtractionOperation implements IOperation<Integer>{
    private int value;
    @Override
    public void compute(List<ICell<Integer>> iCells) {
        value = iCells.get(0).getValue()*2;
        for (ICell<Integer> iCell : iCells){
            value -= iCell.getValue();
        }
    }

    @Override
    public Integer getValue() {
        return value;
    }
}
