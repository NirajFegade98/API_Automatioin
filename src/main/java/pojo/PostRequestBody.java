package pojo;

import java.util.ArrayList;
import java.util.List;

public class PostRequestBody {
    private static String name;
    private static String job;
    private List<String> languages;
    private List<CityRequest> cityRequests;

    public PostRequestBody(){
        //No arg constructor
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public String getName(){
        return name;
    }

    public void setJob(String job)
    {
        this.job = job;
    }

    public String getJob(){
        return job;
    }

    public List<CityRequest> getCityRequests() {
        return cityRequests;
    }

    public void setCityRequests(List<CityRequest> cityRequests) {
        this.cityRequests = cityRequests;
    }
}
