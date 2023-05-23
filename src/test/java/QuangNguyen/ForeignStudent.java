package QuangNguyen;

public class ForeignStudent extends Student{
    private String nation;
    private String language;

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public static void studentSpeak()
    {
        System.out.println("We - foreign students speak English.");
    }
}
