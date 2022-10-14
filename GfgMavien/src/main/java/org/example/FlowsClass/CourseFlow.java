package org.example.FlowsClass;

public class CourseFlow {
    private String courses;
    private  String chapter;
    private String videoname;
    public CourseFlow(String arr[])
    {
        this.courses=arr[2];
        this.chapter=arr[3];
        this.videoname=arr[4];
    }

    public String getCourses() {
        return courses;
    }

    public String getChapter() {
        return chapter;
    }

    public String getVideoname() {
        return videoname;
    }
}
