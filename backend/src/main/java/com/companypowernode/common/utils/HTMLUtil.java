package com.companypowernode.common.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;


import java.io.*;

/**
 * @author liyue
 * @since 2023-12-27
 */
@Component
public class HTMLUtil {
    public String getInfo(){
        String path = "https://quote.eastmoney.com/sz300750.html";

        String htmlStr = toHtmlString(new File(path));
        Document doc = Jsoup.parse(htmlStr);

        Elements table = doc.body().getElementsByClass("");
        return null;
    }


    public String toHtmlString(File file){
        StringBuffer htmlbuf = new StringBuffer();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file),"unicode"
            ));
            while (reader.ready()){
                htmlbuf.append(reader.readLine());
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String htmlStr = htmlbuf.toString();
        return htmlStr;
    }

}
