package za.co.tamboer.sboottut.streams;

public class Country {

    private String id;
    private String description;

    public Country() {
    }

    public Country(String id) {
        this(id, null);
    }    
    
    public Country(String id, String description) {
        this.id = id;
        this.description = description;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
