package jp.senchan.lib.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WrappedJsonObject extends JSONObject {
	public WrappedJsonObject(JSONObject json) throws JSONException {
		this(json.toString());
	}
	
	public WrappedJsonObject(String jsonString) throws JSONException {
		super(jsonString);
	}
	
	@Override
	public String getString(String name) throws JSONException {
		if (isNull(name)) {
			return null;
		} else {
			return super.getString(name);
		}
	}
	
	@Override
	public JSONObject getJSONObject(String name) throws JSONException {
		return new WrappedJsonObject(super.getJSONObject(name));
	}
	
	@Override
	public JSONArray getJSONArray(String name) throws JSONException {
		return super.getJSONArray(name);
	}
}
