package Dto;

public class CountryDto {
    public String country;
    public long confirmed;
    public long recovered;
    public long critical;
    public long deaths;
    public double latitude;
    public double longitude;

    public CountryDto(String country, long confirmed, long recovered, long critical, long deaths, double latitude, double longitude) {
        this.country = country;
        this.confirmed = confirmed;
        this.recovered = recovered;
        this.critical = critical;
        this.deaths = deaths;
        this.latitude = latitude;
        this.longitude = longitude;
    }

//   static public String getCountry() {
//        return country;
//    }
//
//    static  public long getConfirmed() {
//        return confirmed;
//    }
//
//    static public long getRecovered() {
//        return recovered;
//    }
//
//    static public long getCritical() {
//        return critical;
//    }
//
//    static public long getDeaths() {
//        return deaths;
//    }
//
//    static public double getLatitude() {
//        return latitude;
//    }
//
//    static public double getLongitude() {
//        return longitude;
//    }
}

