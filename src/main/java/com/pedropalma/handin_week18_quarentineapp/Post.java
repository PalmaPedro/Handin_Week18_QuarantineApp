package com.pedropalma.handin_week18_quarentineapp;
import com.google.gson.annotations.SerializedName;

public class Post {
    @SerializedName("Country")
    private String country;
    @SerializedName("CountryCode")
    private String countryCode;
    @SerializedName("Slug")
    private String slug;
    @SerializedName("NewConfirmed")
    private int newConfirmed;
    @SerializedName("TotalConfirmed")
    private int totalConfirmed;
    @SerializedName("NewDeaths")
    private int newDeaths;
    @SerializedName("TotalDeaths")
    private int totalDeaths;
    @SerializedName("NewRecovered")
    private int newRecovered;
    @SerializedName("TotalRecovered")
    private int totalRecovered;
    @SerializedName("Date")
    private String date;

    public String getCountry() {
        return country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getSlug() {
        return slug;
    }

    public int getNewConfirmed() {
        return newConfirmed;
    }

    public int getTotalConfirmed() {
        return totalConfirmed;
    }

    public int getNewDeaths() {
        return newDeaths;
    }

    public int getTotalDeaths() {
        return totalDeaths;
    }

    public int getNewRecovered() {
        return newRecovered;
    }

    public int getTotalRecovered() {
        return totalRecovered;
    }

    public String getDate() {
        return date;
    }
}

