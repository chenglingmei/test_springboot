package springboot.test_springboot.controller;

import java.util.List;

public class PageBean {
	private List data;
	private long total;
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	

}
