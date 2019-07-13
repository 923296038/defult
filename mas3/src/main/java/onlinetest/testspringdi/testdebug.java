package onlinetest.testspringdi;

public class testdebug {
    int a=1;


    public static void main(String[] args) {
        int b=1;
        int c=1;
        int d =1;
        b=c+d;
        c=b+d;
        d=b+c;
        b=b+c;
        c=c+d;
        d=d+c;
        System.out.println(b + c +d );
    }
}
