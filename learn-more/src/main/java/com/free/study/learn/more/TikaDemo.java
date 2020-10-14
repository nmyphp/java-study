package com.free.study.learn.more;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.apache.tika.language.LanguageIdentifier;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.microsoft.ooxml.OOXMLParser;
import org.apache.tika.sax.BodyContentHandler;
import org.junit.Test;
import org.xml.sax.SAXException;

public class TikaDemo {

    @Test
    public void LanguageDetection() throws Exception {
        Parser parser = new AutoDetectParser();
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        FileInputStream content = new FileInputStream(new File(
            "E:\\document\\桌面文档\\tmp.txt"));
        //Parsing the given document
        parser.parse(content, handler, metadata, new ParseContext());
        LanguageIdentifier object = new LanguageIdentifier(handler.toString());
        System.out.println("Language name :" + object.getLanguage());
    }

    @Test
    public void getFileType() throws IOException {
        File file = new File("E:\\document\\桌面文档\\QDAM版本说明书.docx");
        Tika tika = new Tika();
        String fileType = tika.detect(file);
        if (fileType != null && fileType.contains("/")) {
            fileType = fileType.substring(fileType.indexOf("/") + 1);
        }
        System.out.println(fileType);
    }

    @Test
    public void getMetaData() throws TikaException, SAXException, IOException {
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        FileInputStream inputstream = new FileInputStream(new File("E:\\document\\桌面文档\\实体名单影响分析--软件清单汇总_大数据平台&产品.xlsx"));
        ParseContext pcontext = new ParseContext();
        //parsing the document using PDF parser
        OOXMLParser parser = new OOXMLParser();
        parser.parse(inputstream, handler, metadata, pcontext);
        //getting the content of the document
        System.out.println("Contents of the excel :" + handler.toString());
        // 元数据提取
        System.out.println("Metadata of the excel:");
        String[] metadataNames = metadata.names();
        for (String name : metadataNames) {
            System.out.println(name + " : " + metadata.get(name));
        }
    }
}
