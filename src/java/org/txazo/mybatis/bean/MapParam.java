package org.txazo.mybatis.bean;

import java.util.HashMap;

public class MapParam extends HashMap<String, Object> {

	private static final long serialVersionUID = 1474632150580556544L;

	public static final String KEY_FIELD = "mapKeyField";
	public static final String VALUE_FIELD = "mapValueField";

	public MapParam() {
	}

	public MapParam(String keyField, String valueField) {
		put(KEY_FIELD, keyField);
		put(VALUE_FIELD, valueField);
	}

}
