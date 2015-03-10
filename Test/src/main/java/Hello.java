import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by Administrator on 2015/2/10.
 */

enum Color {
    RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);
    // 成员变量
    private String name;
    private int index;

    // 构造方法
    private Color(String name, int index) {
        this.name = name;
        this.index = index;
    }

    //覆盖方法
    @Override
    public String toString() {
        return this.index + "_" + this.name;
    }
}

public class Hello {
    public static void main(String[] args) {
        //Color c =  new  Color ();
    }
}
