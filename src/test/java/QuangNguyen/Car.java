package QuangNguyen;

public abstract class Car {
    private String brandname;
    private String type;

    public String getBrandname() {
        return brandname;
    }

    public String getType() {
        return type;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }

    public void setType(String type) {
        this.type = type;
    }

    //Declare the abstract class (does not have a body)
    public abstract void carLooks();
}
