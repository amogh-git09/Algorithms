import java.util.LinkedList;

public class Three_seven{
  public static void main(String[] args){
    AnimalQueue q = new AnimalQueue();
    q.enqueue(new Dog("dog1"));
    q.enqueue(new Cat("cat1"));
    q.enqueue(new Dog("dog2"));
    q.enqueue(new Cat("cat2"));
    q.enqueue(new Dog("dog3"));
    q.enqueue(new Dog("dog4"));
    System.out.println(q.dequeueCat().name);
    System.out.println(q.dequeueCat().name);
    System.out.println(q.dequeueDog().name);
    System.out.println(q.dequeueDog().name);
    System.out.println(q.dequeueDog().name);
  }
}

class AnimalQueue{
  LinkedList<Dog> dogQ = new LinkedList<Dog>();
  LinkedList<Cat> catQ = new LinkedList<Cat>();
  int count = 0;

  void enqueue(Dog d){
    d.tag = count++;
    dogQ.add(d);
  }

  void enqueue(Cat c){
    c.tag = count++;
    catQ.add(c);
  }

  Animal dequeueAny(){
    if(dogQ.isEmpty() && catQ.isEmpty())
      return null;

    if(dogQ.isEmpty())
      return catQ.remove();

    if(catQ.isEmpty())
      return dogQ.remove();

    if(dogQ.getFirst().tag < catQ.getFirst().tag){
      return dogQ.remove();
    }

    return catQ.remove();
  }

  Dog dequeueDog(){
    if(!dogQ.isEmpty())
      return dogQ.remove();
    return null;
  }

  Cat dequeueCat(){
    if(!catQ.isEmpty())
      return catQ.remove();
    return null;
  }
}

abstract class Animal{
  String name;
  int tag;
  Animal next;
}

class Dog extends Animal{
  public Dog(String name){
    this.name = name;
  }
}

class Cat extends Animal{
  public Cat(String name){
    this.name = name;
  }
}
