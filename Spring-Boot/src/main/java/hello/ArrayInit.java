package hello;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayInit {
    public static void main1(String[] args) {

        //静态初始化数组：方法一
        String cats[] = new String[] { "Tom","Sam","Mimi" };

        //静态初始化数组：方法二
        String dogs[] = {"Jimmy","Gougou","Doggy"};

        //动态初始化数据
        String books[] = new String[2];
        books[0] = "Thinking in Java";
        books[1] = "Effective Java";

        cats = dogs;
        books = dogs;
        printArray(cats);
        printArray(dogs);
        printArray(books);
    }

    private static void printArray(String[] arr) {
        for(int i=0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {

    }

    public  void distinctPrimary(String... s ){
        //Primes.isPrime(10) ;
        List<String> list  = Arrays.asList(s ) ;
        List<Integer> lin =  list.stream()
                .map(e->new Integer(e))
                //.filter(e->Primes)
                .collect(Collectors.toList());
    }

}
