package springboot.test_springboot.controller;

public class ResultCode {
	private int status;
	private String code;
	private String msg;
	private Object data;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	/**
	 * @param data
	 * @return
	 */
	public static ResultCode succese(Object data) {
		ResultCode result = new ResultCode();
		result.setCode("succese");
		result.setStatus(200);
		result.setData(data);
		return result;
		
	}
	public static ResultCode succese() {
		ResultCode result = new ResultCode();
		result.setCode("succese");
		result.setStatus(200);
		return result;
		
	}
	public static ResultCode errorCode(String code,String msg) {
		ResultCode result = new ResultCode();
		result.setCode(code);
		result.setStatus(500);
		result.setMsg(msg);
		return result;
		
	}
	public static ResultCode errorCode(String msg) {
		ResultCode result = new ResultCode();
		result.setCode("error");
		result.setStatus(500);
		result.setMsg(msg);
		return result;
		
	}
	
}
