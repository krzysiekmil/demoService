package service.demo.Model;

public enum Type {
    FOR_REPAIR("LODOWKA"),DEAD("TELEWIZOR"),ACTIVE("TELEFON");
    private final String name;
    Type(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }
}