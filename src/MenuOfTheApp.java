import utils.FileHandler;
import utils.TextParser;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MenuOfTheApp {
    public MenuOfTheApp() {
        System.out.println("Menu of the app");

        try {
            readContent();
            saveContent();
        } catch (IOException e) {
            System.out.println("🚨 Could not read or save file");
            throw new RuntimeException(e);
        }
    }

    private void saveContent() throws IOException {
        String simpleText = "Saving simple text to text file";

        FileHandler.saveTextToFile("dummy.txt", simpleText);
    }

    private void readContent() throws IOException {
        File dummyFile = FileHandler.loadFile("dummy.txt");

        List<String> text = TextParser.parseTextFile(dummyFile);
        List<String> english = TextParser.breakLineBySeparatorCharacter(text.get(0), ",");
        List<String> spanish = TextParser.breakLineBySeparatorCharacter(text.get(1), ",");

        System.out.println("🇬🇧 - " + english);
        System.out.println("🇪🇸 - " + spanish);
    }
}
