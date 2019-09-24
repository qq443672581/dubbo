package cn.dlj1.world;

import java.io.*;
import java.util.List;

public class ClassLoaderDemo extends ClassLoader{

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File file = new File("/Users/fivewords/Desktop/java/Test.class");
        if (file.exists()){
            FileInputStream in = null;
            ByteArrayOutputStream out = null;
            try {
                in = new FileInputStream(file);
                out = new ByteArrayOutputStream();

                byte[] buffer = new byte[1024];
                int size = 0;
                while ((size = in.read(buffer)) != -1) {
                    out.write(buffer, 0, size);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                } catch (IOException e) {

                    e.printStackTrace();
                }
            }
            Class<?> aClass = defineClass(name, out.toByteArray(), 0, out.size());
            return aClass;
        }

        return List.class;
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoaderDemo demo = new ClassLoaderDemo();
        Class<?> aaaaaaaaa = demo.loadClass("xx.Test");

        System.out.println(aaaaaaaaa.getFields()[0].getName());
    }
}
