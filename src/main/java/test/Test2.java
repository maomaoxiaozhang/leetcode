package test;

import Study.jvm.MyClassLoader;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.sun.jmx.remote.internal.ArrayQueue;
import lombok.Cleanup;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import sun.misc.BASE64Encoder;

import javax.swing.Timer;
import java.io.*;
import java.lang.reflect.Method;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lenovo on 2017/11/24.
 */
public class Test2 {
    public static void main(String[] args) {
        new Thread(() -> {});

        Set set = new TreeSet((x, y) -> {
            return 0;
        });


        ClassLoader loader = Test2.class.getClassLoader();
        while (loader != null) {
            System.out.println(loader.getClass());
            loader = loader.getParent();
        }
    }
}





