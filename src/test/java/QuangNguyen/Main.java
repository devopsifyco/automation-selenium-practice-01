package QuangNguyen;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("Testing read and write");
        Student std = new Student();
        std.setName("Quang");
        System.out.println("Student name is: " + std.getName());
        ///////////////////////////////////////////////////
        System.out.println("Testing Inheritance");
        ForeignStudent std1 = new ForeignStudent();
        std1.setNation("United States");
        System.out.println("Student nationality is " + std1.getNation());
        std1.setName("Andy");
        System.out.println("Student name is: " + std1.getName());
        ///////////////////////////////////////////////////
        System.out.println("Testing Polymorphism");
        std.studentSpeak();
        std1.studentSpeak();
        ///////////////////////////////////////////////////
        System.out.println("Testing Abstraction");
        Mercedes mcd = new Mercedes();
        mcd.carLooks();
        Chevrolet crl = new Chevrolet();
        crl.carLooks();
    }
}
