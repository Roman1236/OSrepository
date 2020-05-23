public class Application {
    private int weight;
    private int priority;
    private int in_process;
    private int comeIn;
    private int getOut;

    public Application(int weight, int priority, int comeIn) {
        this.weight = weight;
        this.priority = priority;
        this.comeIn = comeIn;
        in_process =0;
    }
    public int getWeight() {  return weight;}
    public int getPriority() { return priority; }
    public void incProcessed() {in_process++;}
    public int getIn_process() {return in_process;}
    public void setComeIn(int comeIn) { this.comeIn = comeIn;    }
    public void setGetOut(int getOut) { this.getOut = getOut;   }
    public int getComeIn() { return comeIn; }
    public int getGetOut() { return getOut; }
}
