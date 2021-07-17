import javax.script.*;
import java.util.*;

public class GroovyEngineTest {

    public static void main(String[] args) {
        ScriptEngineManager manager=new ScriptEngineManager();
        // 得到所有的脚本引擎工厂

        List<ScriptEngineFactory> factories=manager.getEngineFactories();

        for(ScriptEngineFactory factory:factories){
            // 打印脚本信息
            System.out.printf("Name: %s%n"+
                            "Version: %s%n"+
                            "Language name: %s%n"+
                            "Language version: %s%n"+
                            "Extensions: %s%n"+
                            "Mime types: %s%n"+
                            "Names: %s%n\n",
                    factory.getEngineName(),
                    factory.getEngineVersion(),
                    factory.getLanguageName(),
                    factory.getLanguageVersion(),
                    factory.getExtensions(),
                    factory.getMimeTypes(),
                    factory.getNames());

        }
    }
}
