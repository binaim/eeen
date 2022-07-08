public interface ISubject {
    void addObserver(ICellObserver Observer);
    void notifyObservers();
}
