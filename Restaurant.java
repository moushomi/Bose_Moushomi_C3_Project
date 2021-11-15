import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }



    public boolean isRestaurantOpen() {
        //return true;
        //DELETE ABOVE STATEMENT AND WRITE CODE HERE
        boolean open = false;
        if(openingTime.isBefore(LocalTime.now()))
            open = true;
        else if(closingTime.isAfter(LocalTime.now()))
            open = true;
        return open;

    }

    public LocalTime getCurrentTime(){ return  LocalTime.now(); }

    private List<Item> menuItems = new ArrayList<>();

    public Restaurant(){
        menuItems.add(new Item("Sweet Corn Soup",119));
    }

    public List<Item> getMenu() {
        //return null;
        //DELETE ABOVE RETURN STATEMENT AND WRITE CODE HERE
        return Collections.unmodifiableList(menu);
    }

    Item findItemByName(String itemName){
        for(Item item: menu) {
            if(item.getName().equals(itemName))
                return item;
        }
        return null;
    }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name,price);
        menu.add(newItem);
    }
    
    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }



    public void displayDetails(){
        System.out.println("Restaurant:"+ name + "\n"
                +"Location:"+ location + "\n"
                +"Opening time:"+ openingTime +"\n"
                +"Closing time:"+ closingTime +"\n"
                +"Menu:"+"\n"+getMenu());

    }

    public String getName() {
        return name;
    }
   /*orderValue added code*/
   public int findItemByOrderValue(String itemName){
       int totalOrderValue = 0;
       for(Item item:menu){
           if(item.getName().equals(itemName))
               totalOrderValue = totalOrderValue+item.getPrice();
       }
       return totalOrderValue;
   }


    /* Added class ends*/
}


