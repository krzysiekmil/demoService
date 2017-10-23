package service.demo.Model;

public enum State {
    FOR_REPAIR("FOR_REPAIR"),DEAD("DEAD"),ACTIVE("ACTIVE");
    private final String name;
    State(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }
}
