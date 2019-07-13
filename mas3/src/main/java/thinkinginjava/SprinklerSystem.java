package thinkinginjava;

class WaterSouce {
    private String s;
    //watersource方法,赋值,打印
    WaterSouce(){
        System.out.println("WaterSource()");
        s = "Constructed";
    }
    public String toString(){return s;}
}

public class SprinklerSystem{
    private String valve1,valve2,valve3,valve4;
    //将对象引用至于新的类中
    private WaterSouce souce = new WaterSouce();
    //new一个watersource对象
    private int i ;
    private float f;
    public String toString(){
        return
                "valve1="+valve1+
                ";valve2="+valve2+"i="+i+"  " +
                "f="+f+" "+"source:" +souce;

    }

    public static void main(String[] args) {
        SprinklerSystem sprinklers = new SprinklerSystem();
        System.out.println(sprinklers);
    }
}
