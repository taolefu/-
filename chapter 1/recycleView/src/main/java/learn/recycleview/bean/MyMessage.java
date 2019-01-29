package learn.recycleview.bean;

public class MyMessage {

    private int id;
    private String title;
    private String content;
    private String time;
    private String icon;
    private String isOfficial;

    public MyMessage() {}

    public MyMessage(int id, String title, String content, String time, String icon, String isOfficial) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.time = time;
        this.icon = icon;
        this.isOfficial = isOfficial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIsOfficial() {
        return isOfficial;
    }

    public void setIsOfficial(String isOfficial) {
        this.isOfficial = isOfficial;
    }

    @Override
    public String toString() {
        return "MyMessage{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                ", icon='" + icon + '\'' +
                ", isOfficial='" + isOfficial + '\'' +
                '}';
    }
}
