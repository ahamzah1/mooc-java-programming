package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class PartiesApplication extends Application{

    @Override
    public void start(Stage window) throws Exception{
        Map<String, Map<Integer,Integer>> values = getValues("partiesdata.tsv");
        
        NumberAxis xAxis = new NumberAxis(1968,2008,4);
        NumberAxis yAxis = new NumberAxis(0,30,5);
        
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Iniversity of Helsinki, Shanghai ranking");

        // go through the parties and add them to the chart
        values.keySet().stream().forEach(party -> {
            // a different data set for every party
            XYChart.Series data = new XYChart.Series();
            data.setName(party);

            // add the party's support numbers to the data set
            values.get(party).entrySet().stream().forEach(pair -> {
                data.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));
            });

            // and add the data set to the chart
            lineChart.getData().add(data);
        });
        
        Scene scene = new Scene(lineChart,1000,1000);
        window.setScene(scene);
        window.show();
    }
    
    
    public Map<String, Map<Integer, Integer>> getValues(String input) throws Exception {
        Map<String, Map<Integer, Integer>> res = new HashMap<>();
        Scanner scanner = new Scanner(Paths.get(input));
        
        // Read the first line containing column headers (years)
        String[] headers = scanner.nextLine().split("\t");
        List<Integer> years = new ArrayList<>();

        // Extract years from headers (ignoring the first column which is "Party")
        for (int i = 1; i < headers.length; i++) {
            years.add(Integer.parseInt(headers[i]));
        }

        // Read each subsequent line for party data
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split("\t");
            String party = line[0];
            Map<Integer, Integer> yearData = new HashMap<>();

            for (int i = 1; i < line.length; i++) {
                String value = line[i];

                // Convert numeric values to integer (rounding) and ignore "-"
                if (!value.equals("-")) {
                    yearData.put(years.get(i - 1), (int) Math.round(Double.parseDouble(value)));
                }
            }

            res.put(party, yearData);
        }

        scanner.close();
        return res;
    }
    
    public static void main(String[] args) throws Exception{
        launch(PartiesApplication.class);
    }

}
