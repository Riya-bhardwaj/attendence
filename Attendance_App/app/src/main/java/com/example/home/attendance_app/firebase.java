package com.example.home.attendance_app;

public class firebase {
    int year;
    int section;
    float percentage;
    String name="Rajeev Sir(RCS 301)";


    public firebase( int year1,int section1,int percentage1 )
    {

        this.name="Rajeev Sir(RCS 301)";
        this.year=year1;
        this.section=section1;
        this.percentage=percentage1;
    }

    public int getYear() {
        return year;
    }

    public int getSection() {
        return section;
    }

    public float getPercentage() {
        return percentage;
    }

    public String getName() {
        return name;
    }
}
