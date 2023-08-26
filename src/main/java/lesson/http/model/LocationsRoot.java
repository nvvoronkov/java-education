package lesson.http.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

@Data
public class LocationsRoot {
    @JsonProperty("Version")
    private int version;
    @JsonProperty("Key")
    private String key;
    @JsonProperty("Type")
    private String type;
    @JsonProperty("Rank")
    private int rank;
    @JsonProperty("LocalizedName")
    private String localizedName;
    @JsonProperty("EnglishName")
    private String englishName;
    @JsonProperty("PrimaryPostalCode")
    private String primaryPostalCode;
    @JsonProperty("Region")
    private Region region;
    @JsonProperty("Country")
    private Country country;
    @JsonProperty("AdministrativeArea")
    private AdministrativeArea administrativeArea;
    @JsonProperty("TimeZone")
    private TimeZone timeZone;
    @JsonProperty("GeoPosition")
    private GeoPosition geoPosition;
    @JsonProperty("IsAlias")
    private boolean isAlias;
    @JsonProperty("SupplementalAdminAreas")
    private ArrayList<SupplementalAdminArea> supplementalAdminAreas;
    @JsonProperty("DataSets")
    private ArrayList<String> dataSets;
}

@Data
class AdministrativeArea {
    @JsonProperty("ID")
    private String iD;
    @JsonProperty("LocalizedName")
    private String localizedName;
    @JsonProperty("EnglishName")
    private String englishName;
    @JsonProperty("Level")
    private int level;
    @JsonProperty("LocalizedType")
    private String localizedType;
    @JsonProperty("EnglishType")
    private String englishType;
    @JsonProperty("CountryID")
    private String countryID;
}

@Data
class Country {
    @JsonProperty("ID")
    private String iD;
    @JsonProperty("LocalizedName")
    private String localizedName;
    @JsonProperty("EnglishName")
    private String englishName;
}

@Data
class Elevation {
    @JsonProperty("Metric")
    private Metric metric;
    @JsonProperty("Imperial")
    private Imperial imperial;
}

@Data
class GeoPosition {
    @JsonProperty("Latitude")
    private double latitude;
    @JsonProperty("Longitude")
    private double longitude;
    @JsonProperty("Elevation")
    private Elevation elevation;
}

@Data
class Imperial {
    @JsonProperty("Value")
    private int value;
    @JsonProperty("Unit")
    private String unit;
    @JsonProperty("UnitType")
    private int unitType;
}

@Data
class Metric {
    @JsonProperty("Value")
    private int value;
    @JsonProperty("Unit")
    private String unit;
    @JsonProperty("UnitType")
    private int unitType;
}

@Data
class Region {
    @JsonProperty("ID")
    private String iD;
    @JsonProperty("LocalizedName")
    private String localizedName;
    @JsonProperty("EnglishName")
    private String englishName;
}

@Data
class SupplementalAdminArea {
    @JsonProperty("Level")
    private int level;
    @JsonProperty("LocalizedName")
    private String localizedName;
    @JsonProperty("EnglishName")
    private String englishName;
}

@Data
class TimeZone {
    @JsonProperty("Code")
    private String code;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("GmtOffset")
    private double gmtOffset;
    @JsonProperty("IsDaylightSaving")
    private boolean isDaylightSaving;
    @JsonProperty("NextOffsetChange")
    private Date nextOffsetChange;
}
