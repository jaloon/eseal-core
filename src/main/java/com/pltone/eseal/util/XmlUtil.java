package com.pltone.eseal.util;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;

/**
 * XML操作工具类
 *
 * <p>
 * 节点对象操作的方法
 * <ol>
 * <li>获取文档的根节点.<br>
 * <code>Element root = document.getRootElement();</code></li>
 * <li>取得某个节点的子节点.<br>
 * <code>Element element = node.element(“四大名著");</code></li>
 * <li>取得节点的文字.<br>
 * <code>String text = node.getText();</code></li>
 * <li>取得某节点下所有名为“csdn”的子节点，并进行遍历.<br>
 * <code>List nodes = rootElm.elements("csdn");<br>
 * for (Iterator it = nodes.iterator(); it.hasNext();)<br>
 * { Element elm = (Element) it.next(); }</code></li>
 * <li>对某节点下的所有子节点进行遍历.<br>
 * <code>for(Iterator it = root.elementIterator();it.hasNext();)<br>
 * { Element element = (Element) it.next(); }</code></li>
 * <li>在某节点下添加子节点.<br>
 * <code>Element elm = newElm.addElement("朝代");</code></li>
 * <li>设置节点文字.<br>
 * <code>elm.setText("明朝");</code></li>
 * <li>删除某节点.//childElement是待删除的节点,parentElement是其父节点<br>
 * <code>parentElement.remove(childElment);</code></li>
 * <li>添加一个CDATA节点.<br>
 * <code>Element contentElm = infoElm.addElement("content");<br>
 * contentElm.addCDATA(“cdata区域”);</code></li>
 * </ol>
 * </p>
 * <p>
 * 节点对象的属性方法操作
 * <ol>
 * <li>取得某节点下的某属性.<br>
 * <code>Element root = document.getRootElement();<br>
 * Attribute attribute = root.attribute("id");  </code></li>
 * <li>取得属性的文字.<br>
 * <code>String text=attribute.getText();</code></li>
 * <li>删除某属性.<br>
 * <code>Attribute attribute = root.attribute("size");<br>
 * root.remove(attribute);</code></li>
 * <li>遍历某节点的所有属性.<br>
 * <code>Element root=document.getRootElement();<br>
 * for(Iterator it=root.attributeIterator();it.hasNext();){<br>
 * &emsp;Attribute attribute = (Attribute) it.next();<br>
 * &emsp;String text=attribute.getText();<br>
 * &emsp;System.out.println(text);<br>
 * }</code></li>
 * <li>向节点添加属性.<br>
 * <code>new MemberElm.addAttribute("name", "sitinspring");</code></li>
 * <li>设置属性的文字.<br>
 * <code>Attribute attribute=root.attribute("name");<br>
 * attribute.setText("csdn");</code></li>
 * </ol>
 * </p>
 * <p>
 * 字符串与XML的转换
 * <ol>
 * <li>将字符串转化为XML文档对象.<br>
 * <code>String text = "&lt;csdn&gt;&lt;java&gt;Java班&lt;/java&gt;&lt;/csdn&gt;";<br>
 * Document document = DocumentHelper.parseText(text);</code></li>
 * <li>取得属性的文字.<br>
 * <code>SAXReader reader = new SAXReader();<br>
 * Document document = reader.read(new File("csdn.xml"));<br>
 * Element root = document.getRootElement();<br>
 * String docXmlText = document.asXML();<br>
 * String rootXmlText = root.asXML();<br>
 * Element memberElm = root.element("csdn");<br>
 * String memberXmlText = memberElm.asXML();  </code></li>
 * </ol>
 * </p>
 *
 * @author chenlong
 * @version 1.0 2018-01-18
 */
public class XmlUtil {
    /**
     * 创建Document对象
     */
    public static Document createDocument() {
        return DocumentHelper.createDocument();
    }

    /**
     * 读取XML文本内容获取Document对象
     *
     * @param xmlStr XML文本
     * @return Document对象
     * @throws DocumentException
     */
    public static Document getDocumentByXmlStr(String xmlStr) throws DocumentException {
        return DocumentHelper.parseText(xmlStr);
    }

    /**
     * 读取XML文件获取Document对象
     *
     * @param xmlFlie XML文件
     * @return Document对象
     * @throws DocumentException
     */
    public static Document getDocumentByXmlFile(File xmlFlie) throws DocumentException {
        // 创建SAXReader对象
        SAXReader reader = new SAXReader();
        // 读取文件，转换成Document
        return reader.read(xmlFlie);
    }

    /**
     * 获取根节点
     *
     * @param document Document对象
     * @return 根节点Element
     */
    public static Element getRootNode(Document document) {
        return document.getRootElement();
    }

    // 遍历当前节点下的所有节点示例
    @SuppressWarnings({"unused"})
    private void listNodes(Element node) {
        // 首先获取当前节点的所有属性节点
        List<Attribute> list = node.attributes();
        // 遍历属性节点
        for (Attribute attribute : list) {
            System.out.println("属性" + attribute.getName() + ":" + attribute.getValue());
        }
        // 如果当前节点内容不为空，则输出
        if (!(node.getTextTrim().equals(""))) {
            System.out.println(node.getName() + "：" + node.getText());
        }
        // 同时迭代当前节点下面的所有子节点
        // 使用递归
        Iterator<Element> iterator = node.elementIterator();
        while (iterator.hasNext()) {
            Element e = iterator.next();
            listNodes(e);
        }
    }

    /**
     * document写入新的文件
     *
     * @param document       Document对象
     * @param filePath       要写入的文件路径全名
     * @param isFormatOutput 是否对输出文档进行排版格式化，<code>true</code>格式化输出，<code>false</code>紧凑型输出
     * @throws IOException
     */
    public static void writerDocumentToNewFile(Document document, String filePath, boolean isFormatOutput)
            throws IOException {
        // 输出格式
        OutputFormat format;
        if (isFormatOutput) {
            // 输出文档时进行排版格式化
            format = OutputFormat.createPrettyPrint();
        } else {
            // 输出内容是一行，不进行格式化，是紧凑型的输出
            format = OutputFormat.createCompactFormat();
        }
        // 设置编码
        format.setEncoding("UTF-8");
        // XMLWriter 指定输出文件以及格式
        XMLWriter writer = null;
        try {
            writer = new XMLWriter(
                    new OutputStreamWriter(new FileOutputStream(new File(filePath)), StandardCharsets.UTF_8),
                    format
            );
            // 写入新文件
            writer.write(document);
            writer.flush();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
