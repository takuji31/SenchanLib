package jp.senchan.lib;

import java.io.File;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

public abstract class BaseApp extends Application {
	public SharedPreferences pref;

	@Override
	public void onCreate() {
		super.onCreate();
		pref = PreferenceManager.getDefaultSharedPreferences(this);
	}

	public abstract int getDefaultPrefVersion();

	public int getInteger(int id) {
		return getResources().getInteger(id);
	}

	/**
	 * Show short toast
	 *
	 * @param id
	 *            text_id
	 * @return
	 */
	public Toast toast(int id) {
		return Toast.makeText(this, getText(id).toString(), Toast.LENGTH_SHORT);
	}

	/**
	 * Show short toast
	 *
	 * @param text
	 */
	public Toast toast(String text) {
		return Toast.makeText(this, text, Toast.LENGTH_SHORT);
	}

	/**
	 * Show long toast
	 *
	 * @param text
	 */
	public Toast longToast(String text) {
		return Toast.makeText(this, text, Toast.LENGTH_LONG);
	}

	/**
	 * Show long toast
	 *
	 * @param id
	 *            text_id
	 * @return Toast
	 */
	public Toast longToast(int id) {
		return Toast.makeText(this, getText(id).toString(), Toast.LENGTH_LONG);
	}

	/**
	 * 設定を取得するメソッド
	 *
	 * @param key
	 *            キー
	 * @param def
	 *            デフォルト値
	 * @return 設定値
	 */
	public String getPref(String key, String def) {
		return pref.getString(key, def);
	}

	public int getPref(String key, int def) {
		return pref.getInt(key, def);
	}

	public boolean getPref(String key, boolean def) {
		return pref.getBoolean(key, def);
	}

	public long getPref(String key, long def) {
		return pref.getLong(key, def);
	}

	/**
	 * 設定を代入するメソッド
	 *
	 * @param key
	 *            キー
	 * @param value
	 *            値
	 */
	public void setPref(String key, String value) {
		pref.edit().putString(key, value).commit();
	}

	public void setPref(String key, int value) {
		pref.edit().putInt(key, value).commit();
	}

	public void setPref(String key, boolean value) {
		pref.edit().putBoolean(key, value).commit();
	}

	public void setPref(String key, long value) {
		pref.edit().putLong(key, value).commit();
	}

	/**
	 * 設定を全部クリアするメソッド ※デバッグ時と初期セットアップ時以外は使用すべきでない。
	 */
	public void clearPref() {
		pref.edit().clear().commit();
	}

	public int getPrefVersion () {
		return getPref("pref_version", 0);
	}

	public void updatePrefVersion () {
		setPref("pref_version", getDefaultPrefVersion());
	}

	public static boolean deleteFileRecursive(File dirOrFile) {
		if (dirOrFile.isDirectory()) {//ディレクトリの場合
			String[] children = dirOrFile.list();//ディレクトリにあるすべてのファイルを処理する
			for (int i=0; i<children.length; i++) {
				boolean success = deleteFileRecursive(new File(dirOrFile, children[i]));
				if (!success) {
					return false;
				}
			}
		}
		return dirOrFile.delete();
	}
}
