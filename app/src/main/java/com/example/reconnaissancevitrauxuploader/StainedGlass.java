package com.example.reconnaissancevitrauxuploader;

public class StainedGlass {

    String filename;
    String artist;
    String yearBirth;
    String yearPassing;
    String artistRef;
    String glassDate;
    String dateRef;
    String iconography;
    String churchName;
    String url;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        if (filename.equals("")) {
            this.filename = "not available";
        } else {
            this.filename = filename;
        }
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        if (artist.equals("")){
            this.artist = "not available";
        }else{
            this.artist = artist;
        }
    }

    public String getYearBirth() {
        return yearBirth;
    }

    public void setYearBirth(String yearBirth) {
        if (yearBirth.equals("")){
            this.yearBirth = "not available";
        }else{
            this.yearBirth = yearBirth;
        }
    }

    public String getYearPassing() {
        return yearPassing;
    }

    public void setYearPassing(String yearPassing) {
        if (yearPassing.equals("")){
            this.yearPassing = "not available";
        }else{
            this.yearPassing = yearPassing;
        }
    }

    public String getArtistRef() {
        return artistRef;
    }

    public void setArtistRef(String artistRef) {
        if (artistRef.equals("")){
            this.artistRef = "not available";
        }else{
            this.artistRef = artistRef;
        }
    }

    public String getGlassDate() {
        return glassDate;
    }

    public void setGlassDate(String glassDate) {
        if (glassDate.equals("")){
            this.glassDate = "not available";
        }else{
            this.glassDate = glassDate;
        }
    }

    public String getDateRef() {
        return dateRef;
    }

    public void setDateRef(String dateRef) {
        if (dateRef.equals("")){
            this.dateRef = "not available";
        }else{
            this.dateRef = dateRef;
        }
    }

    public String getIconography() {
        return iconography;
    }

    public void setIconography(String iconography) {
        if (iconography.equals("")){
            this.iconography = "not available";
        }else{
            this.iconography = iconography;
        }
    }

    public String getChurchName() {
        return churchName;
    }

    public void setChurchName(String churchName) {
        if (churchName.equals("")){
            this.churchName = "not available";
        }else{
            this.churchName = churchName;
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        if (url.equals("")){
            this.url = "not available";
        }else{
            this.url = url;
        }
    }

}
