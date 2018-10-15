package bean;

import java.io.Serializable;

public class Menu implements Serializable {
	private int id;     //メニューを特定するためのid
	private String name;//メニュー名
	private String url; //レシピURL

	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getUrl() {
		return url;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
