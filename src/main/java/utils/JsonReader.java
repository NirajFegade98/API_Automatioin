package utils;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;

public class JsonReader {

    public static String getTestData(String input) throws IOException, ParseException {
        String testData;
       return testData = (String) getJsonData().get(input);
    }

    public static JSONObject getJsonData() throws IOException, ParseException {
        //path
        File filename = new File("resources//testData//testdata.json");
        //convert json file into string
        String json = FileUtils.readFileToString(filename,"UTF-8");
        //parse the string into object
        Object obj = new JSONParser().parse(json);
        //give jsonobject so that we can return
        JSONObject jsonObject = (JSONObject) obj;
        return jsonObject;


    }
}
