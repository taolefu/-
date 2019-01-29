package learn.chapterfive.utils;


import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SharedpreferenceServcie {

	private Context context;

	public SharedpreferenceServcie(Context context) {
		this.context = context;
	}
	
	public void save(String name, String content)
	{
		SharedPreferences preferences = this.context.getSharedPreferences("test", Context.MODE_PRIVATE);
		Editor editor = preferences.edit();
		editor.putString(name, content);
		editor.commit();
	}
	
	public String read(String name)
	{
		SharedPreferences preferences = this.context.getSharedPreferences("test", Context.MODE_PRIVATE);
		return preferences.getString(name, "null");
	}
	
	
	
}
