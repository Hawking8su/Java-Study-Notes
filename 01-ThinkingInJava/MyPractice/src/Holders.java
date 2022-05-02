public class Holders {
}

class AutoMobile{}
// Exact type
class Holder1{
    private AutoMobile a;
    public Holder1(AutoMobile a){
        this.a = a;
    }
    AutoMobile get(){
        return a;
    }
}
// Object type
class Holder2{
    private Object a;
    public Holder2(Object a){
        this.a = a;
    }
    public Object get(){
        return a;
    }
    public void set(Object a){
        this.a = a;
    }

    public static void main(String[] args) {
        // pass a Automobile object
        Holder2 h2 = new Holder2(new AutoMobile());
        AutoMobile a = (AutoMobile) h2.get();
        // pass a String object
        h2.set("Not an Automobile");
        String s = (String) h2.get();
        h2.set(1); // Autoboxes to Integer
        Integer x = (Integer) h2.get();
    }
}
// Generic type
class Holder3<T>{
    private T a;
    public Holder3(T a){
        this.a = a;
    }
    public void set(T a){
        this.a = a;
    }
    public T get() {
        return a;
    }

    public static void main(String[] args) {
        Holder3<AutoMobile> h3 = new Holder3<>(new AutoMobile());
        AutoMobile a = h3.get(); // No cast needed.
//        h3.set("Not an Automobile"); // Error
    }
}