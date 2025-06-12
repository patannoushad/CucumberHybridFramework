package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class EnvReader {
    private static final Map<String,String> envVariables=new HashMap<>();

    static {
        try {
            Files.lines(Paths.get(".env"))
                    .filter(line -> line.contains("=") && !line.startsWith("#"))
                    .forEach(line -> {
                        String[] parts=line.split("=",2);
                        envVariables.put(parts[0].trim(),parts[1].trim());
                    });
        }catch (IOException e){
            throw new RuntimeException("Error reading .env file: "+e.getMessage(),e);
        }
    }
    public static String get(String key){
        return envVariables.get(key);
    }
}
