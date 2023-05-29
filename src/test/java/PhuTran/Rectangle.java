package PhuTran;

/* class Rectangle extends Shape{
    void draw (){
        System.out.println("Ve hinh chu nhat");
    }
}
class Circle extends Shape{
     void draw(){
         System.out.println("ve hinh tron");
     }
}
class practicce{
    public static void main(String args[]){
        Shape s = new Circle();
        s.draw();

    }
}*/

class Rectangle extends Shape {
    @Override
    void draw() {
        System.out.println("ve hinh chu nhat ne");
    }
}
class Circle extends Shape{
    @Override
    void draw() {
        System.out.println("ve hinh tron ne");
    }
}
class Practice {
    public static void main(String[] args){
        Shape s = new Rectangle();
        Shape s2 = new Circle();
        s2.draw();
        s.draw();

    }
}