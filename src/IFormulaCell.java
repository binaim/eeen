public interface IFormulaCell <T> extends IReference <T>, ICellObserver{
    void addCell(ICell<T> cell);

   IFormulaCell<T> addFormula(IOperation<T> operation, ICell<T> cell);
}
