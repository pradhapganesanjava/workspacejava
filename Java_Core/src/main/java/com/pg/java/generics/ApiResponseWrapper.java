package com.pg.java.generics;

public class ApiResponseWrapper {

	enum ERROR {
		NUM("0"), MSG("success");
		private String val;
		
		ERROR(String valp){
			this.val = valp;
		}
		public ERROR set(String valp){
			this.val = valp;
			return this;
		}
		public String val(){
			return this.val;
		}
	}
	
	public static void main(String...str){
		ApiResponseWrapper _this = new ApiResponseWrapper();
		logErr();
		logErr();
		
	}
	
	static void logErr(ERROR...status){
		String val = null != status && status.length > 0 ? status[0].toString() + status[0].val() : ERROR.NUM.val();
		System.out.println("v "+val);
		String val2 = null != status && status.length > 1 ? status[1].toString() + status[1].val() : ERROR.MSG.val();
		System.out.println("v2 "+val2);
	}
}

class FrontierApiResponse<T> {

	private String error_num = "";
	private String error_msg = "";
	private T result = null;

	public static <T> FrontierApiResponse<T> create(String error_num, String error_msg, T result) {
		final FrontierApiResponse<T> _this = new FrontierApiResponse<T>();
		_this.error_num = null != error_num ? error_num : _this.error_num;
		_this.error_msg = null != error_msg ? error_msg : _this.error_msg;
		_this.result = result;

		return _this;
	}
}