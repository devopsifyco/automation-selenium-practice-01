package QuangNguyen;

public class Student {
    private int id;
    private String name;
    private int age;
    private String gender;

    private String faculty;

/*    public static void getStudentName(String[] args)
    {
        Student std = new Student();
        System.out.println(std.name);
    }*/

    //This is an abstract method (does not have a body)
    //public abstract void getStudentPersonalTrait(String faculty);

    public static void studentSpeak()
    {
        System.out.println("Students speak one mother language.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
