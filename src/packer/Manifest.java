package packer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author I.M.Bad
 */
public class Manifest {
    
    // This tracks the quantity if each product in the manifest
    private Map<Product, Integer> quantities;
    // This keeps a list of all products ordered by weight
    private Set<Product> byWeight;

    /**
     *
     */
    public Manifest() {
        quantities = new HashMap<>();
        byWeight = new TreeSet<>(new ProductWeightComparator());
    }
    
    /**
     *
     * @param p
     */
    public void addProduct(Product p) {
        addProduct(p,1);
    }
    
    /**
     *
     * @param p
     * @param quantity
     */
    public void addProduct(Product p, int quantity) {
        if (quantities.containsKey(p)) {
            quantities.put(p,quantities.get(p)*quantity);
        }
        else {
            quantities.put(p,quantity);
            if(!byWeight.add(p)) {
                System.out.println("Couldn't add to Set");
            }
        }
    }
    
    /**
     *
     * @param p
     */
    public void removeProduct(Product p) {
        if (quantities.containsKey(p) && quantities.get(p) > 0) {
            quantities.put(p,quantities.get(p)-1);
        }
       /* if (quantities.get(p) == 0) { //trying to find the bug by commenting out patches of code to pinpoint the real issue
            quantities.remove(p);
        }*/
        if (quantities.containsKey(p)) {
            byWeight.remove(p);
        }
    }
    
    /**
     *
     * @return
     */
    public double getTotalWeight() {
        double weight = 0;
        for (Product p : quantities.keySet()) {
            weight = quantities.get(p) * p.getWeight();
        }
        return weight;
    }
    
    /**
     *
     * @param weight
     * @return
     */
    public Product getHeaviestUnder(double weight) {
        for (Product p : byWeight) {
            if (p.getWeight() <= weight) {
                return p;
            }
        }
        return null;
    }
    
    /**
     *
     * @return
     */
    public boolean isEmpty() {
        return byWeight.isEmpty();
    }
    
    /**
     *
     * @param p
     * @return
     */
    public boolean containsProduct(Product p) {
        return quantities.containsKey(p) && quantities.get(p) > 0;
    }
    
    /**
     *
     * @return
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Product p : quantities.keySet()) {
            result.append(p.getName());
            result.append(" x ");
            result.append(quantities.get(p));
            result.append("\n");
        }
        return result.substring(0, result.length()-1);
    }
    
    /**
     *
     * @return
     */
    public boolean hasFragileItems() {
        for (Product p : quantities.keySet()) {
            if (p.isFragile()) {
                return true;
            }
        }
        return false;
    }
} //adding the end so that the program can succeed in parsing till the end



