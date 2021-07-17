import groovy.lang.Binding;
import groovy.lang.GroovyShell;

import java.util.HashMap;
import java.util.Map;

public class GroovyShellSpeed {

    public static void main(String[] args) {


        Binding shareData = new Binding();
        GroovyShell shell = new GroovyShell(shareData);
//
//        shareData.setVariable("step_no", 2);
//        shareData.setVariable("pay_time", 111);
//        shareData.setVariable("confirm_time", 333);

        HashMap<String, String> testMap = new HashMap();
        testMap.put("step_no","2");
        testMap.put("pay_time","111");
        testMap.put("confirm_time","333");

        String script = "if (step_no ==1){pay_time<0} else {confirm_time<0};";
        final long startTime = System.currentTimeMillis();
        for (Map.Entry entry: testMap.entrySet()){
            shareData.setVariable(entry.getKey().toString(), Integer.parseInt(entry.getValue().toString()));
        }
        Object res = "unknown";
        for (int i =1; i< 10000; i++){
            res = shell.evaluate(script);
        }

        System.out.println("result: " + res.toString() );
        final long endTime = System.currentTimeMillis();
        System.out.println("Engine: "+ "GroovyShell" + " --Total execution time: " + (endTime- startTime));

        // 10000 times
        // Engine: GroovyShell --Total execution time: 71727
    }


}
