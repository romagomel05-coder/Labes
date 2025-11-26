import java.util.*;

public class Lab3{
	public static void main(String[] args){
	}
}


//package Films
class Film{

  public Film(String director, int duration, String audience) {
    this.director = director;
    this.duration = duration;
    this.audience = audience;
  }

  private String director;
  private int duration;
  private String audience;

  public String getDirector() {
    return director;
  }

  public void setDirector(String director) {
    if(!director.isBlank()){
      this.director = director;
    }
  }

  public int getDuration() {
    return duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  public String getAudience() {
    return audience;
  }

  public void setAudience(String audience) {
    if(!audience.isBlank()){
      this.audience = audience;
    }
  }

}

class Cartoon extends Film{

  private String author;
  private String style;

  public Cartoon(String director, int duration, String audience, String author, String style) {
    super(director, duration, audience);
    this.author = author;
    this.style = style;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    if(!author.isBlank()){
      this.author = author;
    }
  }

  public String getStyle() {
    return style;
  }

  public void setStyle(String style) {
    this.style = style;
  }
}

class Musical extends Film{
  private String music_tool;
  private int songCount;

  public Musical(String director, int duration, String audience, String music_tool, int songCount) {g
    super(director, duration, audience);
    this.music_tool = music_tool;
    this.songCount = songCount;
  }

  public String getMusic_tool() {
    return music_tool;
  }

  public void setMusic_tool(String music_tool) {
    if(!music_tool.isBlank()){
      this.music_tool = music_tool;
    }
  }

  public int getSongCount() {
    return songCount;
  }

  public void setSongCount(int songCount) {
    this.songCount = songCount;
  }
}

class Historical extends Film{
  private String period;
  private boolean isValid;

  public Historical(String director, int duration, String audience, String period, boolean isValid) {
    super(director, duration, audience);
    this.period = period;
    this.isValid = isValid;
  }

  public String getPeriod() {
    return period;
  }

  public void setPeriod(String period) {
    if(!period.isBlank()){
      this.period = period;
    }
  }

  public boolean isValid() {
    return isValid;
  }

  public void setValid(boolean valid) {
    isValid = valid;
  }
}