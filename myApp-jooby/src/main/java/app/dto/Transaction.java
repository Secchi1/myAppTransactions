package app.dto;

public class Transaction {


    private Long id;
    private Double amount;
    private String type;
    private Long parent_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getParentId() {
        return parent_id;
    }

    public void setParentId(Long parentId) {
        this.parent_id = parentId;
    }
}
