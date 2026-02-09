package com.example.csproject2;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JsonHandler {
    private static final String FILE_PATH = "inventory.json";
    private static final Gson gson = new Gson();

    public static void saveItems(List<Medicine> items) {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(items, writer);
        } catch (IOException e) {
            System.err.println("Error saving data: " + e.getMessage());
        }
    }

    public static List<Medicine> loadItems() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return new ArrayList<>();

        try (Reader reader = new FileReader(FILE_PATH)) {
            List<Medicine> loaded = gson.fromJson(reader, new TypeToken<List<Medicine>>(){}.getType());
            if (loaded != null) {

                for (Medicine m : loaded) {
                    m.initializeProperties();
                }
                return loaded;
            }
        } catch (Exception e) {
            System.err.println("Load Error: " + e.getMessage());
        }
        return new ArrayList<>();
    }
}