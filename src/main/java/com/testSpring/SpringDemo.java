package main.java.com.testSpring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;



public class SpringDemo {
	public static void main(String[] args){
		Resource rs = new FileSystemResource("beans-config.xml");
		BeanFactory factory = new XmlBeanFactory(rs);
		
		HelloBean hello=(HelloBean)factory.getBean("helloBean");
		System.out.println(hello.getHelloWord());
	}
}

/*org.springframework.core.io.FileSystemResource 類 別實作 了
org.springframework.core.io.Resource.Resource 介面，可指定絕對路徑或相對路徑來
指 定 Bean 定義檔的位置，由於這邊使用的是 XML 定義檔，所以使用
org.springframework.beans.factory.xml.XmlBeanFactory 類別，XmlBeanFactory 實作
8
了 org.springframework.beans.factory.xml.BeanFactory 介面，用來讀取定義並建
立 BeanFactory 實例。
BeanFactory 是 Factory 模式的一個實作例子，但用途更為一般，可以建立、管理
不同型態的物件，在 Spring 1.2 之後，XmlBeanFactory 只接受實作 Resource 介面的
物件，像是 ClassPathResource、FileSystemResource、InputStreamResource、
ServletContextResource、UrlResource 等，如果您的 Bean 定義檔是位於 Classpath
路徑中，您也可以使用 ClasspPathResource 來取得定義檔。
這是從比較低層次的角度來使用 Spring 的 IoC 容器功能，藉由 BeanFactory 來讀
取組態檔案並完成依賴的關係注入，這邊的依賴是什麼？指的是 HelloBean 的實例相
依於 String 物件，透過 Setter 所保留的介面，使用 Setter injection 來完成這個依賴注
入，而不是將招呼語寫死在 HelloBean 中，BeanFactory 是整個 Spring 的重點所在，
整個 Spring 的核心都圍繞著它。
BeanFactory 讀取 Bean 的組態設定並完成關係維護之後，可以藉由 getBean()方
法並指定 Bean 的別名來取得 Bean 實例，如果使用 BeanFactory 的話，只有在真正需
要 Bean 物件時，才會實際建立 Bean 實例，而不是在一開始建立 BeanFactory 時就建
立 Bean 實例。
*/