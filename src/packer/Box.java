package packer;

/**
 *
 * @author I.M.Bad
 */
public class Box {
    
    
    private Manifest contents;
    private Customer customer;
    private Depot depot; 
    public Product product; 
   
//declaring the variable type product in order to add/remove/categorise and use the products in the box

    /**
     *
     * @param customer
     * @param depot
     */
    public Box(Customer customer, Depot depot) {
        this.customer = customer;
        this.depot = depot;
        contents = new Manifest();
    }

   /* Box(Depot d, Customer c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    /**
     *
     * @param product
     */

    
    public void addProduct(Product product) {
        if (canFit(product)) {
            contents.addProduct(product, 1);
        }
    }
    
    /**
     *
     * @param product
     * @param quantity
     */
    public void addProduct(Product product, int quantity) {
        if (canFit(product,quantity)); {
            contents.addProduct(product, quantity);
        }
    }
   
    /**
     *
     * @return
     */
    public String getLabel() {
        StringBuilder label = new StringBuilder();
        label.append(customer);
        label.append("\n");
        label.append(customer.getClosestAddressTo(depot));
        label.append("\n");
        label.append(contents.toString());
        label.append("\n");
        if (this.isFragile()) {
            label.append("FRAGILE\n");
        }
        return label.toString();
    }
    
    /**
     *
     * @return
     */
    public String toString() {
        return getLabel();
    }
    
    //changing the name of the method

    /**
     *
     * @return
     */
    public double getTotalWeight() {
        return contents.getTotalWeight();
    }
    
    //commenting out the following as it has already been declared and used at line:46
    /*public void addProduct(Product product) {
        if (canFit(product)) {
            contents.addProduct(product, 1);
        }
    }*/

    /**
     *
     * @param p
     * @return
     */

    
    public boolean canFit(Product p) {
       // return p.getWeight() < 40;
       return p.getWeight() < 20; //changing 40 to 20 as the max weight a box can hold is 20kgs and not 40kgs
    }
    
    /**
     *
     * @param p
     * @param quantity
     * @return
     */
    public boolean canFit(Product p, int quantity) {
        //return (p.getWeight() * quantity) < 40;
        return (p.getWeight() * quantity) < 20; //changing 40 to 20 as the max weight a box can hold is 20kgs and not 40kgs
    }
    
    /**
     *
     * @return
     */
    public double remainingCapacity() {
        //return 40 - this.getTotalWeight(); 
        return 20 - this.getTotalWeight();
//making necessary changes in reference to line 57 & changing 40 to 20 as the max weight a box can hold is 20kgs and not 40kgs
    }
    
    /**
     *
     * @return
     */
    public boolean isFragile() {
        return contents.hasFragileItems();
    }
    
    /**
     *
     * @return
     */
    public boolean isHazardous() {
        return false;
    }
}
