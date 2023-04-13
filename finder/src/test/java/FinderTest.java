import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import com.company.Main;

public class FinderTest {

    @Test
    void test(){
        Assertions.assertEquals("C:\\Users\\happy\\IdeaProjects\\finder\\src\\main\\java\\lmao.txt", Main.find("find lmao.txt"));
        Assertions.assertEquals("C:\\Users\\happy\\IdeaProjects\\finder\\src\\main\\java\\test_folder\\bruh.txt", Main.find("find -r bruh.txt"));
        Assertions.assertEquals("C:\\Users\\happy\\IdeaProjects\\finder\\src\\main\\java\\test_folder\\test_folder_1\\meh.txt", Main.find("find -d test_folder/test_folder_1 meh.txt"));
        Assertions.assertNull(Main.find("filippov pidaras"));
        Assertions.assertEquals("File not found", Main.find("find bruh.txt"));
        }

    }

