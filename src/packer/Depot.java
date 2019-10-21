package packer;

/**
 *
 * @author I.M.Bad
 */
public class Depot {
    private String name;
    private Address address;

    /**
     *
     * @param name
     * @param address
     */
    public Depot(String name, Address address) {
        this.name = name;
        this.address = address;
    }
    
    /**
     *
     * @return
     */
    public String getName() {
        //return address.toString(); (returning the name to the get name method instead of asking for the address)
        return name.toString(); 
    }
    
    /**
     *
     * @return
     */
    public Coordinates getCoordinates() {
        return this.address.getCoordinates();
    }
    
    /**
     *
     * @return
     */
    public String toString() {
        return this.getName();
    }

}
