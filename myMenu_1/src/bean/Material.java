package bean;

import java.io.Serializable;

public class Material implements Serializable {
	private String name;     //食材名
	private double quantity; //分量
	private String data;     //単位

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}

}
