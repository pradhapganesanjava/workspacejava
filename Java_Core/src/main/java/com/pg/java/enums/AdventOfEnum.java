package com.pg.java.enums;

public class AdventOfEnum {

}


class ReqStatus {
	 
    public enum Status{
        STATUS_OPEN,
        STATUS_STARTED,
        STATUS_INPROGRESS,
        STATUS_COMPLETED,
    }
 
    public static void main(String[] args){
        for (Status stat: Status.values()){
            System.out.println(stat);
        }
    }
}

class RequestStatus {
	 
    private final int status;
 
    private RequestStatus(int aStatus){
        this.status = aStatus;
    }
 
    public static final RequestStatus STATUS_OPEN = new RequestStatus(0);
    public static final RequestStatus STATUS_STARTED = new RequestStatus(1);
    public static final RequestStatus STATUS_INPROGRESS = new RequestStatus(2);
    public static final RequestStatus STATUS_COMPLETED = new RequestStatus(4);
}