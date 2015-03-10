package com.ljq.test;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;



public class Primes {
    public static void mai1n(String[] args) {
        while (true) {
            Scanner scan = new Scanner(System.in);//获取键盘输入
            int a = scan.nextInt();//赋值s
            if (a <= 1) {  //质数不能小于1
                System.out.println("不是质数");
            } else if (a == 2 || a == 3) {  //单独判断，想不到怎么弄
                System.out.println("是质数");
            }
            int k = (int) Math.sqrt(a);  //取判断数的平方根的整数
            for (int i = 2; i <= k; i++) {
                if (a % i == 0) {     //判断
                    System.out.println("不是质数");
                } else {
                    System.out.println("是质数");
                }
            }
        }
    }

    public static void pridateTest(){
        Predicate<String> predicate = (s) -> s.length() > 0;
        predicate.test("foo");              // true
        predicate.negate().test("foo");     // false
        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;
        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();
        String foo = "predicate Test:" + (predicate.test("foo")) ;
        System.out.println(foo);
        Function<String, Integer> toInteger = Integer::valueOf;
        toInteger.apply("12");

        Supplier<String>  sp =  String::new;
        System.out.println("Supplier:" + sp.get());

        Consumer<String > consumer = c ->System.out.println(c);

        Optional<Person>  a = Optional.empty(); // Optional.of(new Person("sdf","sdfs"))  ;

        if(a.isPresent()){
            a.get().hello();
            System.out.println("isPresent");
        }
    }

    public static void main(String[] args) {
//        String someThing = "12" ;
//        pridateTest() ;
//        int num = 1;
//        Converter<Integer, String> stringConverter = (from) -> String.valueOf(from + num);
//        stringConverter.convert(2);     // 3
//
//        Converter<String, Boolean> converter2  ;
//        converter2 = someThing::startsWith ;
//
//        PersonFactory<Person > pfactory = Person::new ;
//        Person p =  pfactory.create("12","sdf") ;

//        System.out.println(converter2.convert("1"));
//        new Primes().distinctPrimary(new String[]{"12", "213", "2", "2", "7", "7"});

        f();
        f2();

    }

    private static void f2() {

        int max =  1000000  ;
        List <String >  values  =  new ArrayList<>()  ;
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }
        Vector<String >  v =  new Vector<String >();
        long t0 = System.nanoTime();
        long count = values.stream().sorted().count();
        System.out.println(count);
        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));
    }

    private static void f() {
        int max =  1000000  ;
        List <String >  values  =  new ArrayList<>()  ;
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }

        long t0 = System.nanoTime();
        long count = values.stream().sorted().count();
        System.out.println(count);
        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("parallel sort took: %d ms", millis));
    }


    public void distinctPrimary(String [] numbers) {
        List<String> l = Arrays.asList(numbers);
        List<Integer> r = l.stream()
                .map((s) -> new Integer(s))
                .filter(e -> Primes.isPrime(e))
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("distinctPrimary result is: " + r);
    }



    private static boolean isPrime(Object e) {
        Converter<String, Integer> converter =  Integer::valueOf;
        Integer a =  converter.convert(e.toString()) ;

        if (a <= 1) {  //质数不能小于1
            return false;
        } else if (a == 2 || a == 3) {  //单独判断，想不到怎么弄
            return true;
        }
        int k = (int) Math.sqrt(a);  //取判断数的平方根的整数
        for (int i = 2; i <= k; i++) {
            if (a % i == 0) {     //判断
                return false;
            } else {
                return true;
            }
        }
        return  false  ;
    }
}



class Person {
   public String firstName;
   public String lastName;
   public void  hello(){
        System.out.println("hello");
   }
   Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
   }
}


interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}

@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}
