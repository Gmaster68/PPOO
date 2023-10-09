import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private static final String FILE_NAME = "locations.txt";
    private List<String> locations;

    public FileManager() {
        locations = new ArrayList<>();
        loadLocations();
    }

    private void loadLocations() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                locations.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveLocations() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String location : locations) {
                writer.write(location + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addLocation(String location) {
        locations.add(location);
        saveLocations();
    }

    public void removeLocation(String location) {
        locations.remove(location);
        saveLocations();
    }

    public List<String> getLocations() {
        return locations;
    }
}
