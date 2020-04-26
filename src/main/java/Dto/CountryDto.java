package Dto;

public class CountryDto {
    private String country;
    private long confirmed;
    private long recovered;
    private long critical;
    private long deaths;
    private double latitude;
    private double longitude;

    public CountryDto(String country, long confirmed, long recovered, long critical, long deaths, double latitude, double longitude) {
        this.country = country;
        this.confirmed = confirmed;
        this.recovered = recovered;
        this.critical = critical;
        this.deaths = deaths;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCountry() {
        return country;
    }

     public long getConfirmed() {
        return confirmed;
    }

     public long getRecovered() {
        return recovered;
    }

     public long getCritical() {
        return critical;
    }

     public long getDeaths() {
        return deaths;
    }

     public double getLatitude() {
        return latitude;
    }

     public double getLongitude() {
        return longitude;
    }
}

