package base;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * XML
 */
public class Core_13 {
}

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