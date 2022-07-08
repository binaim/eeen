import java.util.ArrayList;
import java.util.List;

public class FormulaCell implements IFormulaCell<Integer>{

    private List<ICell<Integer>> cells;
    private int value;
    private IOperation<Integer> operation;
    private List<ICellObserver> observers;

    public FormulaCell(List<ICell<Integer>> cells, IOperation<Integer> operation) {
        this.cells = cells;
        this.observers = new ArrayList<>();

        for (ICell<Integer> cell : this.cells){
            cell.addObserver(this);
        }

        this.operation = operation;
        this.operation.compute(this.cells);
        this.value = this.operation.getValue();
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public void update() {
        this.operation.compute(cells);
        this.value = operation.getValue();
        notifyObservers();
    }

    @Override
    public void addCell(ICell<Integer> cell) {
        cell.addObserver(this);
        this.cells.add(cell);
        this.operation.compute(this.cells);
        this.value = this.operation.getValue();

    }

    @Override
    public IFormulaCell<Integer> addFormula(IOperation<Integer> operation, ICell<Integer> cell) {

        List<ICell<Integer>> newCells = new ArrayList<>();
        IFormulaCell<Integer> cell1 = new FormulaCell(this.cells, this.operation);
        newCells.add(cell1);
        newCells.add(cell);

        this.cells = newCells;
        this.operation = operation;

        this.operation.compute(this.cells);
        this.value = this.operation.getValue();
        this.observers = new ArrayList<>();

        for (ICell<Integer> c : this.cells){
            c.addObserver(this);
        }

        return this;
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
        return "FormulaCell{" +
                "value=" + getValue() +
                '}';
    }
}
