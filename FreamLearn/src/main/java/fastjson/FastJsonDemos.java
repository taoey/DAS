package fastjson;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FastJsonDemos {


    /**
     * 操作list格式的Json对象
     */
    @Test
    public void operateJsonList() throws Exception{
        //读取数据
        File file = new File("src/main/java/fastjson/data/JsonData.json");
        String data = FileUtils.readFileToString(file, "UTF-8");

        //String  --> JSONObject
        JSONObject dataJson = JSONObject.parseObject(data);

        //获取JSONObject中的list数据
        JSONArray jsonList = dataJson.getJSONObject("result").getJSONArray("rows");

        //遍历JSONArray
        for(Iterator iterator = jsonList.iterator();iterator.hasNext();){
            JSONObject jsonObject = JSONObject.parseObject(iterator.next().toString());
            Long id = jsonObject.getLong("id");
            System.out.println(id);
        }
    }

    /**
     * JSONArray中筛选出特定的数据
     * 基本思路就是：把符合的数据保存到另一个数据容器中，然后再把该容器Json序列化即可
     */
    @Test
    public void saveDataFromJsonArray() throws Exception{
        File file = new File("src/main/java/fastjson/data/JsonArrayData.json");
        String data = FileUtils.readFileToString(file, "UTF-8");

        JSONArray dataList = JSONObject.parseArray(data);
        //新建数据容器
        List<JSONObject> result = new ArrayList(dataList.size());
        //筛选sex==1的数据
        for(Iterator iterator=dataList.iterator();iterator.hasNext();){
            JSONObject next = (JSONObject) iterator.next();
            Integer sex = next.getInteger("sex");
            if(sex.equals(1)){
                result.add(next);
            }
        }
        //把新的容器进行序列化
        dataList = JSONObject.parseArray(result.toString());
        System.out.println(dataList);
    }
}
