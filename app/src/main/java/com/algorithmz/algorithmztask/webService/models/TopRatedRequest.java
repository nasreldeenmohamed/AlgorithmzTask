package com.algorithmz.algorithmztask.webService.models;

public class TopRatedRequest {

    private String Region, Language;
    private int PageNumber;

    public TopRatedRequest(String language, int pageNumber, String region) {
        Region = region;
        Language = language;
        PageNumber = pageNumber;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public int getPageNumber() {
        return PageNumber;
    }

    public void setPageNumber(int pageNumber) {
        PageNumber = pageNumber;
    }
}
