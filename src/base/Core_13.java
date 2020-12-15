package base;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.*;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * XML
 */
public class Core_13 {
}

/**
 * 基本模型
 */
class DomReader {
    public static void main(String[] args) {
        recursiveTraverse();  // 自上而下进行解析
        System.out.println("=========================");
        traverseBySearch();  // 根据名称进行搜索
    }

    public static void recursiveTraverse() {
        try {
            // 采用Dom解析XML文件
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse("src/data/users.xml");

            // 获取所有的一级子节点
            NodeList usersList = document.getChildNodes();
            System.out.println(usersList.getLength());  // 1

            for (int i = 0; i < usersList.getLength(); i++) {
                Node users = usersList.item(i);
                NodeList userList = users.getChildNodes();
                System.out.println("==" + userList.getLength());  // 9
                for (int j = 0; j < userList.getLength(); j++) {
                    Node user = userList.item(j);
                    if (user.getNodeType() == Node.ELEMENT_NODE) {
                        NodeList metaList = user.getChildNodes();
                        System.out.println("====" + metaList.getLength());
                        for (int k = 0; k < metaList.getLength(); k++) {
                            Node meta = metaList.item(k);
                            if (meta.getNodeType() == Node.ELEMENT_NODE) {
                                System.out.println(metaList.item(k).getNodeName() + ":"
                                        + metaList.item(k).getTextContent());
                            }
                        }
                        System.out.println();
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void traverseBySearch() {
        try {
            // 采用Dom解析XML文件
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse("src/data/users.xml");
            Element rootElement = document.getDocumentElement();
            NodeList nodeList = rootElement.getElementsByTagName("name");
            if (nodeList != null) {
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Element element = (Element) nodeList.item(i);
                    System.out.println(element.getNodeName() + " = "
                            + element.getTextContent());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class DomWriter {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            // 新创建一个Document节点
            Document document = db.newDocument();
            if (document != null) {
                Element docx = document.createElement("document");  // 都是采用Document创建元素
                Element element = document.createElement("element");
                element.setAttribute("type", "paragraph");
                element.setAttribute("alignment", "left");

                Element object = document.createElement("object");
                object.setAttribute("type", "text");

                Element text = document.createElement("text");
                text.appendChild(document.createElement("abcdefg"));

                Element bold = document.createElement("bold");
                bold.appendChild(document.createElement("true"));

                object.appendChild(text);
                object.appendChild(bold);
                element.appendChild(object);
                docx.appendChild(element);

                TransformerFactory tf = TransformerFactory.newInstance();
                Transformer t = tf.newTransformer();
                DOMSource source = new DOMSource(document);

                // 定义目标文件
                File file = new File("dom_result.xml");
                StreamResult result = new StreamResult(file);

                // 将XML内容写入到文件中
                t.transform(source, result);
                System.out.println("write xml file successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/**
 * SAX
 */
class SAXReader {
    public static void main(String[] args) throws SAXException, IOException {
        XMLReader parser = XMLReaderFactory.createXMLReader();
        BookHandler bookHandler = new BookHandler();
        parser.setContentHandler(bookHandler);
        parser.parse("src/data/books.xml");
        System.out.println(bookHandler.getNameList());
    }
}

class BookHandler extends DefaultHandler {
    private List<String> nameList;
    private boolean title = false;

    @Override
    public void startDocument() throws SAXException {
        // xml文档加载时
        System.out.println("Start parsing document...");
        nameList = new ArrayList<String>();
    }

    @Override
    public void endDocument() throws SAXException {
        // 文档解析结束时
        System.out.println("End");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
        // 访问某一个元素
        if (qName.equals("title")) {
            title = true;
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        // 结束访问元素
        if (title) {
            title = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        // 访问元素正文
        if (title) {
            String bookTitle = new String(ch, start, length);
            System.out.println("Book title: " + bookTitle);
            nameList.add(bookTitle);
        }
    }

    public List<String> getNameList() {
        return nameList;
    }

    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }
}

/**
 * Stax
 */
class StaxReader {
    public static void main(String[] args) {
        StaxReader.readByStream();
        System.out.println("==============");
        StaxReader.readByEvent();
    }

    // 流模式
    public static void readByStream() {
        String xmlFile = "src/data/books.xml";
        XMLInputFactory factory = XMLInputFactory.newFactory();
        XMLStreamReader streamReader = null;
        try {
            streamReader = factory.createXMLStreamReader(new FileReader(xmlFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }

        // 基于指针遍历
        try {
            while (streamReader.hasNext()) {
                int event = streamReader.next();
                // 如果时元素的开始
                if (event == XMLStreamConstants.START_ELEMENT) {
                    // 列出所有书籍名称
                    if ("title".equalsIgnoreCase(streamReader.getLocalName())) {
                        System.out.println("title: " + streamReader.getElementText());
                    }
                }
            }
            streamReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 事件模式
    public static void readByEvent() {
        String xmlFile = "src/data/books.xml";
        XMLInputFactory factory = XMLInputFactory.newFactory();
        boolean titleFlag = false;
        try {
            // 创建基于迭代器的事件读取器对象
            XMLEventReader eventReader = factory.createXMLEventReader(new FileReader(xmlFile));
            while (eventReader.hasNext()){
                XMLEvent event = eventReader.nextEvent();
                if (event.isStartElement()){
                    StartElement start = event.asStartElement();
                    String name = start.getName().getLocalPart();
                    if (name.equals("title")){
                        titleFlag = true;
                        System.out.print("title: ");
                    }
                    // 读取所有属性
                    Iterator attrs = start.getAttributes();
                    while (attrs.hasNext()){
                        Attribute attr = (Attribute) attrs.next();
                    }
                }
                if (event.isCharacters()){
                    String s = event.asCharacters().getData();
                    if (null != s && s.trim().length()>0&&titleFlag){
                        System.out.println(s.trim());
                    }
                }
                if (event.isEndElement()){
                    EndElement end = event.asEndElement();
                    String name = end.getName().getLocalPart();
                    if (name.equals("title")){
                        titleFlag = false;
                    }
                }
            }
            eventReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}