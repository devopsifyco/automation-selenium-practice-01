import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HandleDropdownlist {
    public void handleDropdownlist(WebDriver driver){

        //listboxes_dropdownlist.html");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("let url = document.URL;\n" +
                "document.getElementById(\"demo\").innerHTML = url;");

        Select listbox=  new Select(driver.findElement(By.name("multiSelectcars")));
        List<WebElement> options = listbox.getOptions();

        ArrayList<String> originalList = new ArrayList<>();
        ArrayList<String> tempList = new ArrayList<>();

        for (WebElement option : options) {
            originalList.add(option.getText());
            tempList.add(option.getText());
        }

        System.out.println("this is originalList before Sorting	:"+ originalList);
        System.out.println("this is tempList before Sorting		:"+ tempList);

        Collections.sort(tempList);

        System.out.println("this is originalList after Sorting	:"+ originalList);
        System.out.println("this is tempList after Sorting		:"+ tempList);

        if(originalList.equals(tempList))
        {
            System.out.println("List is sorted");
        }
        else
        {
            System.out.println("List is not sorted");
        }

        if (listbox.isMultiple()) {
            listbox.selectByIndex(1); //BMW
            listbox.selectByValue ("Ferrari");//Ferrari
            //List<WebElement> selectedOption = listbox.getAllSelectedOptions();
            List<WebElement> selectedOptions = listbox.getAllSelectedOptions();
            ArrayList<String> selOpt = new ArrayList<>();
            for(WebElement e:selectedOptions){
                selOpt.add(e.getText());
            }

            System.out.println("List selected options: "+ selOpt);
            System.out.println("The first selected option: "+ listbox.getFirstSelectedOption().getText());

            listbox.deselectByValue("Ferrari");
            listbox.selectByValue("Jaguar");

            List<WebElement> selectedOptionAfter = listbox.getAllSelectedOptions();
            selOpt.clear();
            for(WebElement e:selectedOptionAfter){
                selOpt.add(e.getText());
            }
            System.out.println("List selected options after: "+ selOpt);

            listbox.deselectAll();
            int i = listbox.getAllSelectedOptions().size();
            if(i==0){
                System.out.println("De-selected all options");
            }
            else{
                System.out.println("There are "+ i +" selected options");
            }
        }
        else {
            System.out.println("Listbox not allow to select multiple items");
        }

    }
    public void singleSelect(WebElement element,String selectedValue){
        Select dropdownlist = new Select(element);

        dropdownlist.selectByVisibleText(selectedValue);
        List<WebElement> listOptions =  dropdownlist.getOptions();
        for (WebElement ele:listOptions){
            System.out.println(ele.getText());
        }
    }
}
