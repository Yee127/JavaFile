package A;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

public class Dom4jTest {
    @Test
    public void test(){
        try {
            SAXReader reader = new SAXReader();
            Document document = reader.read("src/books.xml");
            System.out.println(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test2() throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read("src/books.xml");
//        通过document对象获取根元素
        Element rootElement = document.getRootElement();
//        System.out.println(rootElement);
        List<Element> books = rootElement.elements("book");

//        遍历
        for (Element book: books){
//            System.out.println(book);
//            Element name = book.element("name");
//            System.out.println(name.asXML());
//            getText() 获取标签文本内容
//            String nameText = name.getText();
//            System.out.println(nameText);


//           elementText() 直接获取  指定标签文本内容
            String name = book.elementText("name");
            String price = book.elementText("price");
            String author = book.elementText("author");
            String sn = book.attributeValue("sn");
//            System.out.println(price);
            System.out.println(new Book(sn,name, null,author));
        }

    }

}
