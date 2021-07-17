import groovy.lang.GroovyShell;

public class GroovyScriptTest {


    public static void main(String[] args) {
        GroovyShell shell = new GroovyShell();
//        String script = "println 'Hello from Groovy script!'";
//
//        Object res = shell.evaluate(script);
        String script = "[11, 12, 13, 14].contains(12)";
        Object res = shell.evaluate(script);

        if(res instanceof Boolean){
            System.out.println("result: " + (Boolean) res);
        } else {
            System.out.println("else result: " +  res);
        }

    }


}
