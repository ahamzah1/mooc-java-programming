/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;
import java.util.Map;
import java.util.Scanner;
import java.nio.file.Paths;
import java.io.FileWriter;
import java.io.IOException;


import java.util.HashMap;
/**
 *
 * @author ahmad
 */
public class SaveableDictionary {
    
    private HashMap<String,String> map;
    private String file;
    
    public SaveableDictionary(){
        this.map = new HashMap<>();
    }
    
    public SaveableDictionary(String file){
        this.map = new HashMap<>();
         this.file = Paths.get(file).toAbsolutePath().toString();
    }
    
    public boolean load() {
        try {
            Scanner scanner = new Scanner(Paths.get(file));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    this.map.put(parts[0], parts[1]);
                }
            }
            scanner.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error " + e);
            return false;
        }
    }

    public boolean save() {
        if (this.file == null) {
            return false; // No file provided
        }
        try (FileWriter writer = new FileWriter(file)) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue() + "\n");
            }
            return true;
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
            return false;
        }
    }

    public void add(String word, String translation) {
        if (!this.map.containsKey(word) && !this.map.containsValue(word)) {
            this.map.put(word, translation);
        }
    }

    public String translate(String word) {
        if (this.map.containsKey(word)) {
            return this.map.get(word);
        } else {
            for (Map.Entry<String, String> entry : this.map.entrySet()) {
                if (entry.getValue().equals(word)) {
                    return entry.getKey();
                }
            }
        }
        return null;
    }

    public void delete(String word) {
        if (this.map.containsKey(word)) {
            this.map.remove(word);
            return;
        }
        this.map.values().removeIf(value -> value.equals(word));
    }
}
