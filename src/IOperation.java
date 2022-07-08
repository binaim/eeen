import java.util.List;

public interface IOperation <T>{
    void compute(List<ICell<T>> cells);
    T getValue();
}
