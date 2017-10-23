package service.demo.Model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Parametr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String Key;
    String Value;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id")
    Product product;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getKey() {
        return Key;
    }
    public void setKey(String key) {
        Key = key;
    }
    public String getValue() {
        return Value;
    }
    public void setValue(String value) {
        Value = value;
    }

}
