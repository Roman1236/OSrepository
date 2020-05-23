public class Resource {
    private Application currentApplication;
    private int app_time;
    private int quant;
    private int down_time = 0;
    private boolean busy = false;
    private PartQ queue;
    private int count = 0;
    private Form form;
    private int[] priorities;
    private short[] num;
    public Resource(Form form, PartQ queue, int quant) {
        this.form = form;
        this.queue = queue;
        this.quant = quant;
        priorities = new int[queue.getMinP()+queue.getQ_pos()+1];
        num = new short[queue.getMinP()+queue.getQ_pos()+1];
        for (int i=0;i<priorities.length;i++) {
            priorities[i]=0;
            num[i] = 0;
        }
    }
    public void setApplication(Application application) {
        currentApplication = application;
        app_time = 0;
        if (application !=null) {busy = true;}
        else{busy = false;}
    }
    public void passTact() {
        if (busy) {
            currentApplication.incProcessed();
            app_time++;
            if (currentApplication.getIn_process()>= currentApplication.getWeight()) {
                currentApplication.setGetOut(form.getTime());
                form.addWaitingTime(currentApplication.getGetOut()- currentApplication.getComeIn()- currentApplication.getWeight());
                int time_in_queue=(form.getTime()- currentApplication.getComeIn()- currentApplication.getWeight());
                priorities[currentApplication.getPriority()]+=time_in_queue;
                num[currentApplication.getPriority()]++;
                setApplication(queue.get_maxP_application());
                form.setRequestsNumber(form.getRequestsNumber()-1);
                count++;
            }
            if (app_time >=quant) {
                queue.addRequestDirectly(currentApplication, currentApplication.getPriority()-queue.getMinP());
                setApplication(queue.get_maxP_application());
            }
        }
        else {
            down_time++;
            setApplication(queue.get_maxP_application());
        }
    }
    public Application getCurrentApplication() {return currentApplication;}
    public int getQuant() {return quant;}
    public int getApp_time() {return app_time;}
    public int getDown_time() {return down_time;}
    public void setDown_time(int time) {down_time = time;}
    public int getProcessedNumber() {return count;}
    public void setQueue(PartQ queue) {this.queue=queue;}
    public int[] getPriorityArray() {return priorities;}
    public short[] getProcessedNumberWithPriorities() {return num;}
}
