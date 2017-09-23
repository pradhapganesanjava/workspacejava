package com.pg.java.enums;

public class AdventOfEnum {
	 
    public enum Status{
        STATUS_OPEN,
        STATUS_STARTED,
        STATUS_INPROGRESS,
        STATUS_COMPLETED,
    }
 
    public static void main(String[] args){
    	Status dupButSame = Status.valueOf("STATUS_OPEN");
    	System.out.println("dupButSame == Status.STATUS_OPEN ? "+ (dupButSame == Status.STATUS_OPEN));
        for (Status stat: Status.values()){
            System.out.println(stat);
        }
    }
}


class ReqStatus {}

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