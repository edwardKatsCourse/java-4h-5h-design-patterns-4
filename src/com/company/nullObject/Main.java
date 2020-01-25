package             com.company.nullObject;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        String firstName = null;

        String print = Optional.ofNullable(firstName)
                .map(x-> x.toUpperCase())
                .orElse(null);

        System.out.println(print);
    }
}


//class Node<T> {
//    private Node<T> previous;
//    private T value;
//    private Node<T> next;
//}

/**

 private static volatile Singleton singleton = null;


 public static Singleton getInstance() {
    if (singleton == null) {
        synchronized(Singleton.class) {
            if (singleton == null) {
                singleton = new Singleton();
            }
        }
    }

 }

 */