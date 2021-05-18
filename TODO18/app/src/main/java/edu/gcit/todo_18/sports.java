package edu.gcit.todo_18;

public class sports {
    private String title;
    private String info;
    private final int imageResourse;

    sports(String title, String info, int imageResourse){
        this.title = title;
        this.info = info;
        this.imageResourse = imageResourse;
    }
    String getTitle(){
        return title;
    }
    String getInfo(){
        return info;
    }
    public int getImageResourse(){
        return imageResourse;
    }
}
