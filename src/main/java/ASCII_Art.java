import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class ASCII_Art {
    public static String art = """
      ____        _        _____ _                                \s
     |  _ \\      | |      / ____| |                               \s
     | |_) | ___ | |__   | |    | |__  _   _ _ __   __ _ _   _ ___\s
     |  _ < / _ \\| '_ \\  | |    | '_ \\| | | | '_ \\ / _` | | | / __|
     | |_) | (_) | |_) | | |____| | | | |_| | | | | (_| | |_| \\__ \\
     |____/ \\___/|_.__/   \\_____|_| |_|\\__,_|_| |_|\\__, |\\__,_|___/
                                                    __/ |         \s
                                                   |___/          \s⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
    """;




    public static void printArt() {
        try {
            System.out.write(art.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            System.err.println("Error printing ASCII Art: " + e.getMessage());
        }
    }



}


