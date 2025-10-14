public class Purchase {
    private int id;
    private Person person;
    private Product product;
    private int quantity;

    public Purchase (int id, Person per, Product prod, int quantity){
        setId(id);
        setPerson(per);
        setProduct(prod);
        setQuantity(quantity);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString(){
        return person + " : " + product.getName() + " - $" + product.getPrice();
    }

    // No need for an equals method since multiple identical purchases can exist
}
