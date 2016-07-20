public class ListElement<T> {
  private T data;
  private ListElement<T> next;

  public ListElement(T value){
    data = value;
  }
  public T value(){
    return data;
  }
  public void setNext(ListElement<T> next){
    this.next = next;
  }
  public void setValue(T value){
    this.data = value;
  }
}
