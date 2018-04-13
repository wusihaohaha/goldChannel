package goldChannelWX;

import net.sf.json.JSONObject;
import net.sf.json.processors.JsDateJsonBeanProcessor;

public class Test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("1", "1");
        jsonObject.put("2", "2");
        jsonObject.put("3", 3);
        System.out.println(jsonObject.get("1"));
        System.out.println(jsonObject.get("3"));
    }

}
