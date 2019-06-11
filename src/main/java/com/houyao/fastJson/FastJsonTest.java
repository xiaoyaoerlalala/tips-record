package com.houyao.fastJson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.houyao.fastJson.domain.Course;
import com.houyao.fastJson.domain.Student;
import com.houyao.fastJson.domain.Teacher;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: houyao
 * @Description:fastJson对于json格式字符串的解析主要用到了一下三个类：
 * 1.JSON：fastJson的解析器，用于JSON格式字符串与JSON对象及javaBean之间的转换。
 * 2.JSONObject：fastJson提供的json对象。
 * 3.JSONArray：fastJson提供json数组对象。
 * @Date: Created in 10:42:42 2019/6/11
 */
public class FastJsonTest {
    //json字符串-简单对象型
    private static final String  JSON_OBJ_STR = "{\"studentName\":\"lily\",\"studentAge\":12}";
    //json字符串-数组类型
    private static final String  JSON_ARRAY_STR = "[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]";
    //复杂格式json字符串
    private static final String  COMPLEX_JSON_STR = "{\"teacherName\":\"crystall\",\"teacherAge\":27,\"course\":{\"courseName\":\"english\",\"code\":1270},\"students\":[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]}";

    public static void main(String[] args) {
        //json字符串-简单对象型与JSONObject之间的转换
        //testJSONStrToJSONObject();

        //json字符串-数组类型与JSONArray之间的转换
        //testJSONStrToJSONArray();

        //复杂json格式字符串与JSONObject之间的转换
        //testComplexJSONStrToJSONObject();

        /*此外的：
        1，对于JSON对象与JSON格式字符串的转换可以直接用 toJSONString()这个方法。
        2，javaBean与JSON格式字符串之间的转换要用到：JSON.toJSONString(obj);
        3，javaBean与json对象间的转换使用：JSON.toJSON(obj)，然后使用强制类型转换，JSONObject或者JSONArray。*/
    }
    /**
    * @Description: json字符串-简单对象型与JSONObject之间的转换
    * @auther: houyao
    * @date: 10:51:05 2019/6/11
    * @param: []
    * @return: void
    *
    */
    public static void testJSONStrToJSONObject(){

        JSONObject jsonObject = JSON.parseObject(JSON_OBJ_STR);
        //JSONObject jsonObject1 = JSONObject.parseObject(JSON_OBJ_STR); //因为JSONObject继承了JSON，所以这样也是可以的

        System.out.println(jsonObject.getString("studentName")+":"+jsonObject.getInteger("studentAge"));

    }

    /**
    * @Description: json字符串-数组类型与JSONArray之间的转换
    * JSONArray继承了List<Object>，我们可以把JSONArray看成JSONObject对象的一个集合List<JsonObject>。
    * @auther: houyao
    * @date: 10:51:55 2019/6/11
    * @param: []
    * @return: void
    *
    */
    public static void testJSONStrToJSONArray(){

        JSONArray jsonArray = JSON.parseArray(JSON_ARRAY_STR);
        //JSONArray jsonArray1 = JSONArray.parseArray(JSON_ARRAY_STR);//因为JSONArray继承了JSON，所以这样也是可以的

        //遍历方式1
        int size = jsonArray.size();
        for (int i = 0; i < size; i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            System.out.println(jsonObject.getString("studentName")+":"+jsonObject.getInteger("studentAge"));
        }
        //遍历方式2
        for (Object obj : jsonArray) {
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject.getString("studentName")+":"+jsonObject.getInteger("studentAge"));
        }
    }

    /**
    * @Description: 复杂json格式字符串与JSONObject之间的转换
    * @auther: houyao
    * @date: 10:58:53 2019/6/11
    * @param: []
    * @return: void
    *
    */
    public static void testComplexJSONStrToJSONObject(){

        JSONObject jsonObject = JSON.parseObject(COMPLEX_JSON_STR);
        //JSONObject jsonObject1 = JSONObject.parseObject(COMPLEX_JSON_STR);//因为JSONObject继承了JSON，所以这样也是可以的

        String teacherName = jsonObject.getString("teacherName");
        Integer teacherAge = jsonObject.getInteger("teacherAge");
        JSONObject course = jsonObject.getJSONObject("course");
        JSONArray students = jsonObject.getJSONArray("students");

    }

    /**
    * @Description: json字符串-简单对象与JavaBean_obj之间的转换
     * json字符串与javaBean之间的转换推荐使用 TypeReference<T> 这个类，使用泛型可以更加清晰
    * @auther: houyao
    * @date: 11:08:04 2019/6/11
    * @param: []
    * @return: void
    *
    */
    public static void testJSONStrToJavaBeanObj(){

        Student student = JSON.parseObject(JSON_OBJ_STR, new TypeReference<Student>() {});
        //Student student1 = JSONObject.parseObject(JSON_OBJ_STR, new TypeReference<Student>() {});//因为JSONObject继承了JSON，所以这样也是可以的

        System.out.println(student.getStudentName()+":"+student.getStudentAge());

    }

    /**
     * json字符串-数组类型与JavaBean_List之间的转换
     */
    public static void testJSONStrToJavaBeanList(){

        ArrayList<Student> students = JSON.parseObject(JSON_ARRAY_STR, new TypeReference<ArrayList<Student>>() {});
        //ArrayList<Student> students1 = JSONArray.parseObject(JSON_ARRAY_STR, new TypeReference<ArrayList<Student>>() {});//因为JSONArray继承了JSON，所以这样也是可以的

        for (Student student : students) {
            System.out.println(student.getStudentName()+":"+student.getStudentAge());
        }
    }

    /**
     * 复杂json格式字符串与JavaBean_obj之间的转换
     */
    public static void testComplexJSONStrToJavaBean(){

        Teacher teacher = JSON.parseObject(COMPLEX_JSON_STR, new TypeReference<Teacher>() {});
        //Teacher teacher1 = JSON.parseObject(COMPLEX_JSON_STR, new TypeReference<Teacher>() {});//因为JSONObject继承了JSON，所以这样也是可以的
        String teacherName = teacher.getTeacherName();
        Integer teacherAge = teacher.getTeacherAge();
        Course course = teacher.getCourse();
        List<Student> students = teacher.getStudents();
    }
}
