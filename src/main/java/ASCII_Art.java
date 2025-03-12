import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class ASCII_Art {
    public static String art = """
      ____        _        _____ _                                
     |  _ \\      | |      / ____| |                               
     | |_) | ___ | |__   | |    | |__  _   _ _ __   __ _ _   _ ___
     |  _ < / _ \\| '_ \\  | |    | '_ \\| | | | '_ \\ / _` | | | / __|
     | |_) | (_) | |_) | | |____| | | | |_| | | | | (_| | |_| \\__ \\
     |____/ \\___/|_.__/   \\_____|_| |_|\\__,_|_| |_|\\__, |\\__,_|___/
                                                    __/ |         
                                                   |___/""";




    public static void printArt() {
        try {
            System.out.println(art);
        } catch (Exception e) {
            System.err.println("Error printing ASCII Art: " + e.getMessage());
        }
    }



}


