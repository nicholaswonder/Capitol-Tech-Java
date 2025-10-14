public class Purchase {
    private final int id;
    private int PersonId;
    private int ProductId;

    public Purchase (int id, int personId, int productId) {
        this.id = id;
        this.PersonId = personId;
        this.ProductId = productId;
    }

    public int GetId(){
        return id;
    }

    // id cannot be changed in sql, so it shouldn't be changed in the object

    public int GetPersonId(){
        return PersonId;
    }

    public void SetPersonId(int personId){
        this.PersonId = personId;
    }

    public int GetProductId(){
        return ProductId;
    }

    public void SetProductId(int productId){
        this.ProductId = productId;
    }

    public String toString() {
        return id + ", " + PersonId + ", " + ProductId;
    }
}
