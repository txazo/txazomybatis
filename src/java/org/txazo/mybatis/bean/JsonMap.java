package org.txazo.mybatis.bean;

import java.io.Serializable;
import java.util.Map;

public class JsonMap implements Serializable {

	private static final long serialVersionUID = -6057303011564728365L;

	private Map<String, Object> json;

	public JsonMap() {
	}

	public JsonMap(Map<String, Object> json) {
		this.json = json;
	}

	public Map<String, Object> getJson() {
		return json;
	}

	public void setJson(Map<String, Object> json) {
		this.json = json;
	}

}
