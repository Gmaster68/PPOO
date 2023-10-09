import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MultimediaFileScanner {
    private static final String[] EXTENSIONS = {".mp3", ".wav", ".jpg", ".png"};

    public static List<String> scanDirectory(String location) {
        List<String> multimediaFiles = new ArrayList<>();
        File directory = new File(location);
        if (directory.isDirectory()) {
            for (File file : directory.listFiles()) {
                for (String extension : EXTENSIONS) {
                    if (file.getName().endsWith(extension)) {
                        multimediaFiles.add(file.getAbsolutePath());
                        break;
                    }
                }
            }
        }
        return multimediaFiles;
    }
}
