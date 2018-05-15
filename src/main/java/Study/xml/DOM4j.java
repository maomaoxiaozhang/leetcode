package Study.xml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by lenovo on 2018/1/8.
 */
public class DOM4j {
}


///**
// * package test;
//
// import org.dom4j.Document;
// import org.dom4j.DocumentException;
// import org.dom4j.Element;
// import org.dom4j.io.OutputFormat;
// import org.dom4j.io.SAXReader;
// import org.dom4j.io.XMLWriter;
//
// import java.io.File;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.util.Iterator;
//
// /**
// * Created by lenovo on 2017/12/16.
// */
//public class test{
//    public static void main(String[] args) {
//        try {
//            XMLWriter writer = null;
//            SAXReader reader = new SAXReader();
//
//            OutputFormat format = OutputFormat.createPrettyPrint();
//            format.setEncoding("GBK");
//
//            String filePath = "C:\\Users\\lenovo\\Desktop\\student.xml";
//            File file = new File(filePath);
//            if (file.exists()) {
//                Document document = reader.read(file);
//                Element root = document.getRootElement();
//                boolean add_new = false;
//                for (Iterator i = root.elementIterator(); i.hasNext();) {
//                    Element student = (Element) i.next();
//                    if (student.attributeValue("sid").equals("001")) {
//                        Element info_num = student.element("编号");
//                        System.out.println("属性名为：" + info_num.getName());
//                        System.out.println("属性值为：" + info_num.getText());
//
//                        Element info_name = student.element("姓名");
//                        System.out.println("属性名为：" + info_name.getName());
//                        System.out.println("属性值为：" + info_name.getText());
//
//                        info_name.setName("外号");
//                        info_name.setText("余小二");
//
//                        writer = new XMLWriter(new FileWriter(filePath), format);
//                        writer.write(document);
//                        writer.close();
//                        add_new = true;
//                        break;
//                    }
//                }
//                if (add_new) {
//                    Element student = root.addElement("小学生");
//                    student.addAttribute("sid", "100");
//                    Element sid = student.addElement("编号");
//                    sid.setText("100");
//                    Element name = student.addElement("姓名");
//                    name.setText("老大");
//                    Element sex = student.addElement("性别");
//                    sex.setText("男");
//                    Element age = student.addElement("年龄");
//                    age.setText("40");
//
//                    writer = new XMLWriter(new FileWriter(filePath), format);
//                    writer.write(document);
//                    writer.close();
//                }
//            }
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}