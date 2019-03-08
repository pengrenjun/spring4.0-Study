
package Test;


import com.smart.domain.XhContractExecution;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.FileCopyUtils;

import java.io.*;

/*ͨ��spring��Resource����ӿڵ�ʵ��������ļ���Դ*/
public class FileSourceExample {



    public static void main(String[] args) throws IOException {


        //ʹ��ϵͳ����·���ķ�ʽ������Դ
        String filePath="E:\\���ص�����\\��ͨspring4.x����Դ��\\chapter2\\src\\main\\java\\com\\smart\\domain\\XhContractExecution.java".replace("\\","/");
        WritableResource writableResource= (WritableResource) getPathResource(filePath);
        System.out.println(writableResource.isWritable());

        //ʹ����·�������ļ�
        String classResoucePath="main/resources/smart-context.xml";
        Resource classResource=getClassResouce(classResoucePath);

        File file= getFileByResoure(classResource);
        System.out.println("�ļ���ϵͳ����·���� "+file.getAbsolutePath());

        System.out.println(getFileRootPath(XhContractExecution.class));

        String path="E:\\���ص�����\\��ͨspring4.x����Դ��\\chapter2\\src\\conf\\asd.text".replace("\\","/");
        WritableResourceTest(path);
        System.out.println("��ȡ���ļ����ݣ�"+ReadResourceTest(path));


        /*ͨ��EmcodeResource����Դ�ļ����б��봦��*/
        Resource resourceToEncode=getPathResource(path);

        String content= getFileContent(resourceToEncode,"UTF-8");
        System.out.println("��ȡ���ļ�����utf-8: "+content);

    }

    /*��ȡ�����������ļ�������Ϣ(ͨ��EncodeResource��Resource������Դ���봦��)*/
    public static String getFileContent(Resource resourceToEncode,String codeStyle) throws IOException {
       return  FileCopyUtils.copyToString(getEncodeResource(resourceToEncode,codeStyle).getReader());
    }

    /*ͨ��Resource��ȡ��������EncodeResource*/
    public static EncodedResource getEncodeResource(Resource resourceToEncode,String codeStyle) {
        return  new EncodedResource(resourceToEncode,codeStyle);
    }

    /*ͨ��resource��ȡFile����*/
    public static File getFileByResoure(Resource resource) throws IOException {
        return resource.getFile();
    }

    /*ͨ��Resource�ӿڶ�ȡ�ļ���Դ*/
    public static String ReadResourceTest(String path) throws IOException {
        Resource resource=getPathResource(path);
        InputStream inputStream=resource.getInputStream();
       return getContentByInputStream(inputStream);


    }

    /*������������ȡ�ļ���Ϣ����*/
    public static String  getContentByInputStream(InputStream inputStream) throws IOException {
        //ByteArrayOutputStream�������þ��ǰ��ֽ���ת���ַ�
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        int i;
        while ((i=inputStream.read())!=-1){
            byteArrayOutputStream.write(i);
        }
        inputStream.close();
        byteArrayOutputStream.close();

        return byteArrayOutputStream.toString();
    }



    //ʹ��WritableResource�ӿ���ϵͳ�����ļ���д��Դ(filePathΪϵͳ����·��)
    public static void WritableResourceTest(String filePath) throws IOException {
        WritableResource writableResource=(WritableResource)getPathResource(filePath);

         OutputStream outputStream=  getOutputStream(writableResource);
         //���д���ظ���֮ǰ�ļ��е�����
         outputStream.write("��Դ�ļ�д�����".getBytes());
         outputStream.flush();
    }


    /*ͨ��WritableResource��ȡ��Ӧ�������FileOutputStream*/
    public static OutputStream getOutputStream(WritableResource writableResource) throws IOException {
        //writableResource���д��Դ����,ʵ�ʵ��õ���jdk��outputStream
        return  writableResource.getOutputStream();
    }

    public static Resource getClassResouce(String str) {
        return  new ClassPathResource(str);
    }

    public  static Resource getPathResource(String str){
        return new PathResource(str);
    }
    //��ȡ����صĸ�·��(ϵͳ��·��)
    public static String getFileRootPath(Class<?> cls){
        return  cls.getClass().getResource("/").getPath();
    }


}