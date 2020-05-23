public class PartQ {
    private Queue[] partQ;
    private int pos;
    private int minP;

    public PartQ(int n, int minP) {
        pos = n+1;
        this.minP = minP;
        partQ = new Queue[pos];
        initQ();
    }
    private void initQ() {
        for (int i = 0; i< pos; i++) {
            partQ[i] = new Queue(i+ minP,1);
        }
    }
    public void addRequestWithFilter(Application application) {
        partQ[application.getPriority()- minP].addRequest(application);
    }
    public void addRequestDirectly(Application application, int queueNumber) {
        partQ[queueNumber].addRequest(application);
    }
    public String getP() {
        String str = "";
        for (int i = 0; i< pos; i++) {
            str=str+("priority: "+(i+ minP)+" | ");
            str=str+ partQ[i].getQueue()+"\n";
        }
        return str;
    }
    public Application get_maxP_application() {
        int i = -1;
        do { i++;}
        while ((i< pos -1)&(partQ[i].isEmpty()));
        if (partQ[pos -1]!=null) {
            if (i!= pos -1){return partQ[i].ExtractRequest();}
            else{return partQ[pos -1].ExtractRequest();}
        }   else{return null;}
    }
    public int getMinP() {return minP;}
    public int getQ_pos() {return pos;}
}
