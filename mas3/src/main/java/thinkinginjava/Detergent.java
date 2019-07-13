package thinkinginjava;

class Cleanser{
    private String s = "Cleanser";
    public void append(String a){s += a;}
    public void dilute(){append("dilute()");}
    public void apply(){append("apply()");}
    public void scrub(){append("scrub()");}

    public String toString(){return s;}

    public static void main(String[] args) {
        Cleanser x = new Cleanser();
        x.dilute(); x.apply(); x.scrub();
        System.out.println(x);
        System.out.println("........");
    }
}
public class Detergent extends Cleanser {
    public void scrub(){
        append("Detergent.srub***");
        super.scrub();
        //super.  调用父类的原scrub方法
    }
    public void foam(){append("foam()");}

    public static void main(String[] args) {
        Detergent x =new Detergent();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        System.out.println(x);
        System.out.println("testing base class:");
        Cleanser.main(args);
        //调用Cleanser的main方法

    }
}
