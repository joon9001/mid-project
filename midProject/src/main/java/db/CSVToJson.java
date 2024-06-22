package db;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CSVToJson {
    public static void main(String[] args) {
        String csvFile = "data.csv";
        String jsonFile = "data.json";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile));
             FileWriter fileWriter = new FileWriter(jsonFile)) {

            String line;
            String[] headers = br.readLine().split(","); // CSV 파일의 첫 줄은 헤더

            ObjectMapper objectMapper = new ObjectMapper();
            ArrayNode arrayNode = objectMapper.createArrayNode();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                ObjectNode objNode = objectMapper.createObjectNode();

                for (int i = 0; i < headers.length; i++) {
                    objNode.put(headers[i], values[i]);
                }

                arrayNode.add(objNode);
            }

            objectMapper.writerWithDefaultPrettyPrinter().writeValue(fileWriter, arrayNode);
            System.out.println("CSV file has been converted to JSON successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
