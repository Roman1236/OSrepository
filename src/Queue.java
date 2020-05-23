public class Queue {
    private int n;
    private Application[] queue;
    private int P1;

    public Queue(int P1, int n) {
        this.P1 = P1;
        this.n=n;
        queue = new Application[n];
    }
    public void addRequest(Application application) {
        int i=n;
        do  {i--;}
        while ((i>0)&(queue[i]!=null));
        if ((i==0)&(queue[i]!=null)) {
            newQueue(2*n);
            i=n/2-1;
        }
        queue[i]= application;
    }

    public String getQueue() {
        String str = "";
        for (int i=n-1;i>=0;i--) {
            if (queue[i]!=null) {
                str=str+queue[i].getIn_process()+"/"+queue[i].getWeight()+ " ";
            }
        }
        return str;
    }
    public boolean isEmpty() {
        if (queue[n-1]==null) {
            return true;
        }
        else{return false;}
    }
    public Application ExtractRequest() {
        Application application;
        application =queue[n-1];
        for (int i=n-2;i>=0; i--) {
            queue[i+1]=queue[i];
        }
        queue[0]=null;
        return application;
    }
    public void newQueue(int n) {
        Application[] newQueue = new Application[n];
        for (int i=this.n-1; i>=0;i--) {
            newQueue[i+n-this.n]=queue[i];
        }
        queue=newQueue;
        this.n=n;
    }

}
