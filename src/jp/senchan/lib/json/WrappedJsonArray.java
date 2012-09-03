package jp.senchan.lib.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WrappedJsonArray extends JSONArray {

	public WrappedJsonArray(JSONArray json) throws JSONException {
		this(json.toString());
	}
	
	public WrappedJsonArray(String jsonString) throws JSONException {
		super(jsonString);
	}
	
	@Override
	public JSONObject getJSONObject(int index) throws JSONException {
		return new WrappedJsonObject(super.getJSONObject(index));
	}
	
	@Override
	public JSONArray getJSONArray(int index) throws JSONException {
		return new WrappedJsonArray(super.getJSONArray(index));
	}
	
}
