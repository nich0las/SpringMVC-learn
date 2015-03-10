package com.ljq.test;

import java.lang.reflect.Array;
import java.time.*;

import static  java.lang.System.*;
import java.time.Clock;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;


public class adasd {
    public static void main(String []  a ){
        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Brazil/East");

        LocalTime now1 = LocalTime.now(zone1);
        LocalTime now2 = LocalTime.now(zone2);
        out.println(now1.isBefore(now2));

        long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
        long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);
        System.out.println(hoursBetween);       // -3
        System.out.println(minutesBetween);     // -239

        LocalTime lt  = LocalTime.of(23,22,58) ;

        LocalDate ld = LocalDate.now() ;

        LocalDate tomorrow = ld.plus(1, ChronoUnit.DAYS).plusDays(4);

        LocalDateTime  ldt =  LocalDateTime.of(2004, Month.APRIL, 20, 18, 30, 20) ;

        DayOfWeek dw =  ldt.getDayOfWeek() ;


        out.println(ldt) ;
        out.println(dw) ;

        Stream.generate(Math::random).limit(10).forEach(System.out::println);

        Runnable r =  ()->{out.println(Thread.currentThread());};
        new Thread(r).start();

        new  Thread(()->out.println(Thread.currentThread())).start();
        out.println(Thread.currentThread());
        List<Integer> list = Arrays.asList(1,2) ;
        Function<Integer ,String > f  = (x)->{return  x*x+"" ;} ;
        out.println(f.apply(9));
        out.println(list.stream().map((x)->{return  x*x+"" ;}).reduce((x, y)->x+ y).get());

        new Thread(new adasd()::sayHello).start();
    }

    private  void sayHello(){
        out.println("helo:"+Thread.currentThread());
    }

}
