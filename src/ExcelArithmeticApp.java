import java.util.ArrayList;
import java.util.List;

public class ExcelArithmeticApp {
    public static void main(String[] args) {
        System.out.println("1)");
        IValueCell<Integer> cell1 = new ValueCell(7);
        IValueCell<Integer> cell2 = new ValueCell(4);
        List<ICell<Integer>> cells = new ArrayList<>();
        cells.add(cell1);
        cells.add(cell2);
        IFormulaCell<Integer> cell3 = new FormulaCell(cells, new SumOperation());

        System.out.println("cell1: " + cell1);
        System.out.println("cell2: " + cell2);
        System.out.println("cell3 (cell1 + cell2): " + cell3);

        System.out.println("\n2)");
        IFormulaCell<Integer> cell4 = new FormulaCell(cells, new SubtractionOperation());
        System.out.println("cell4 (cell1 - cell2): " + cell4);
        List<ICell<Integer>>  cells2 = new ArrayList<>();
        cells2.add(cell3);
        cells2.add(cell4);
        IFormulaCell<Integer> cell5 = new FormulaCell(cells2, new MultiplicationOperation());
        System.out.println("cell5 (cell3 * cell4): " + cell5);

        List<ICell<Integer>>  cells3 = new ArrayList<>();
        cells3.add(cell2);
        cells3.add(cell3);
        IFormulaCell<Integer> cell6 = new FormulaCell(cells3, new MultiplicationOperation());
        System.out.println("cell6 (cell2 * cell3): " + cell6);

        System.out.println("\n3)");
        IReference<Integer> cell7 = cell6;
        System.out.println("Reference of cell6: " + cell7);

        System.out.println("\n4)");
        cell1.setValue(10);
        System.out.println("cell1: " + cell1);
        System.out.println("cell2: " + cell2);
        System.out.println("cell3 (cell1 + cell2): " + cell3);
        System.out.println("cell4 (cell1 - cell2): " + cell4);
        System.out.println("cell5 (cell3 * cell4): " + cell5);
        System.out.println("cell6 (cell2 * cell3): " + cell6);

        System.out.println();
        cell6.addFormula(new SubtractionOperation(), cell3)
                .addFormula(new SubtractionOperation(), cell1)
                .addFormula(new MultiplicationOperation(), cell2);
        System.out.println("Chain Operation of (cell6 - cell3 - cell1) * cell2: " + cell6);

        System.out.println();
        cell1.setValue(4);
        System.out.println("Change value of cell1 to: " + cell1);
        System.out.println("cell1: " + cell1);
        System.out.println("cell2: " + cell2);
        System.out.println("cell3 (cell1 + cell2): " + cell3);
        System.out.println("cell4 (cell1 - cell2): " + cell4);
        System.out.println("cell5 (cell3 * cell4): " + cell5);
        System.out.println("cell6 (cell2 * cell3): " + cell6);
        cell6.addFormula(new SubtractionOperation(), cell3)
                .addFormula(new SubtractionOperation(), cell1)
                .addFormula(new MultiplicationOperation(), cell2);
        System.out.println("Chain Operation of (cell6 - cell3 - cell1) * cell2: " + cell6);

    }
}
