package PhuTran;

 class Rectangle extends Shape{
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
}

