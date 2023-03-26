package com.util;

import com.pojo.User;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.xml.parsers.SAXParser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyClassPathXmlApplicationContext {
    Map<String ,Object> IoC=new HashMap<String, Object>();
    public MyClassPathXmlApplicationContext(String resources) throws DocumentException, FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //仿照classPathXmlApplicationContext 读取文件路径
//        InputStream inputStream=MyClassPathXmlApplicationContext.class.getResourceAsStream(resources);
        InputStream inputStream=null;
        inputStream=new FileInputStream(new File(resources));
        // dom4j 解析xml 读取bean标签的id和class
        SAXReader reader = new SAXReader();
        Document document=reader.read(inputStream);
        Element rootElement=document.getRootElement();
        List<Element> elements=rootElement.elements();

        for (Element e:elements
             ) {
            System.out.println(e.getName());
            List<Attribute> attributes=e.attributes();
            String id="";
            String clazz="";
            for (Attribute a:attributes
                 ) {
                if(a.getName().equals("id")){
                    id=a.getValue();
                    System.out.println("id:"+id);
                }else if(a.getName().equals("class")){
                    clazz=a.getValue();
                    System.out.println("class:"+clazz);
                }
            }
            // 反射生成实例
            Class<?>  aClass= Class.forName(clazz);
            Object obj=aClass.newInstance();
            // Map存储id和class对应的值
            IoC.put(id,obj);

        }



    }
    public Object getBean(String id){
        return IoC.get(id);
    }

    public static void main(String[] args) throws DocumentException, FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        MyClassPathXmlApplicationContext context =new MyClassPathXmlApplicationContext("I:\\JavaProject\\SpringDemo\\Mymaven\\src\\main\\resources\\applicationContext.xml");
        User user = (User)context.getBean("User");
        user.setUsername("atong");
        user.setPhone("1234");
        System.out.println(user.toString());
    }
}
