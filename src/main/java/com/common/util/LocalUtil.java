package com.common.util;


import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class LocalUtil {
     /**
      *根据属性名获取属性值
     * */
    static public Object getFieldValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[] {});
            Object value = method.invoke(o, new Object[] {});
            return value;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    /**
     * 获取属性名数组
     * */
    static public String[] getFiledName(Object o){
        Field[] fields=o.getClass().getDeclaredFields();
        String[] fieldNames=new String[fields.length];
        for(int i=0;i<fields.length;i++){
            System.out.println(fields[i].getType());
            fieldNames[i]=fields[i].getName();
        }
        return fieldNames;
    }
    /**
     * 获取属性类型(type)，属性名(name)，属性值(value)的map组成的list
     * */
    static public List getFiledsInfo(Object o){
        Field[] fields=o.getClass().getDeclaredFields();
        String[] fieldNames=new String[fields.length];
        List list = new ArrayList();
        Map infoMap=null;
        for(int i=0;i<fields.length;i++){
            infoMap = new HashMap();
            infoMap.put("type", fields[i].getType().toString());
            infoMap.put("name", fields[i].getName());
            infoMap.put("value", getFieldValueByName(fields[i].getName(), o));
            list.add(infoMap);
        }
        return list;
    }
    /**
     * 获取对象的所有属性值，返回一个对象数组
     * */
    static public Object[] getFiledValues(Object o){
        String[] fieldNames=getFiledName(o);
        Object[] value=new Object[fieldNames.length];
        for(int i=0;i<fieldNames.length;i++){
            value[i]=getFieldValueByName(fieldNames[i], o);
        }
        return value;
    }

    /**
     * 递归获取某路径下的所有文件，文件夹，并输出
     */

    public static void getModelFiles(String path, List<Map> classList) {
        File file = new File(path);
        // 如果这个路径是文件夹
        if (file.isDirectory()) {
            // 获取路径下的所有文件
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                // 如果还是文件夹 递归获取里面的文件 文件夹
                if (files[i].isDirectory()) {
                    System.out.println("目录：" + files[i].getPath());
                    getModelFiles(files[i].getPath(),classList);
                } else {
                    System.out.println("文件：" + files[i].getPath());
                    String[] tmpList = files[i].getPath().split("\\\\");

                    HashMap mapValue = new HashMap();
                    mapValue.put("className",tmpList[tmpList.length-1]);
                    classList.add((mapValue));
                }

            }
        } else {
            System.out.println("文件：" + file.getPath());
        }
    }

    /**
     * 将存放在sourceFilePath目录下的源文件，打包成fileName名称的zip文件，并存放到zipFilePath路径下
     *
     * @param sourceFilePath
     *            :待压缩的文件路径
     * @param zipFilePath
     *            :压缩后存放路径
     * @param fileName
     *            :压缩后文件的名称
     * @return
     */
    public static boolean folderToZip(String sourceFilePath, String zipFilePath, String fileName) {
        boolean flag = false;
        File sourceFile = new File(sourceFilePath);
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        ZipOutputStream zos = null;

        if (sourceFile.exists() == false) {
            System.out.println("待压缩的文件目录：" + sourceFilePath + "不存在.");
            return false;
                    //ToolsExceptionConstant.NOTEXSITERROR_CODE,
                    //String.format(ToolsExceptionConstant.NOTEXSITERROR_MSG, sourceFilePath));
        } else {
            try {
                File zipFile = new File(zipFilePath + "/" + fileName + ".zip");
                if (zipFile.exists()) {
                    System.out.println(zipFilePath + "目录下存在名字为:" + fileName + ".zip" + "打包文件.");
                    return false;
//                    throw new ToolsException(ToolsExceptionConstant.EXSITERROR_CODE,
//                            String.format(ToolsExceptionConstant.EXSITERROR_MSG, zipFilePath, fileName + ".zip"));
                } else {
                    File[] sourceFiles = sourceFile.listFiles();
                    if (null == sourceFiles || sourceFiles.length < 1) {
                        System.out.println("待压缩的文件目录：" + sourceFilePath + "里面不存在文件，无需压缩.");
                        return false;
//                        throw new ToolsException(ToolsExceptionConstant.EMPTYERROR_CODE,
//                                String.format(ToolsExceptionConstant.EMPTYERROR_MSG, sourceFilePath));
                    } else {
                        fos = new FileOutputStream(zipFile);
                        zos = new ZipOutputStream(new BufferedOutputStream(fos));
                        byte[] bufs = new byte[1024];
                        for (int i = 0; i < sourceFiles.length; i++) {
                            // 创建ZIP实体，并添加进压缩包
                            ZipEntry zipEntry = new ZipEntry(sourceFiles[i].getName());
                            zos.putNextEntry(zipEntry);
                            // 读取待压缩的文件并写进压缩包里
                            fis = new FileInputStream(sourceFiles[i]);
                            bis = new BufferedInputStream(fis, 1024);
                            int read = 0;
                            while ((read = bis.read(bufs, 0, 1024)) != -1) {
                                zos.write(bufs, 0, read);
                            }
                        }
                        flag = true;
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } finally {
                // 关闭流
                try {
                    if (null != bis)
                        bis.close();
                    if (null != zos)
                        zos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
        return flag;
    }

    /**
     * 将sourceFilePath文件，打包成fileName名称的zip文件，并存放到zipFilePath路径下
     *
     * @param sourceFilePath
     *            :待压缩的文件路径
     * @param zipFilePath
     *            :压缩后存放路径
     * @param fileName
     *            :压缩后文件的名称
     * @return
     */
    public static boolean fileToZip(String sourceFilePath, String zipFilePath, String fileName) {
        boolean flag = false;
        File sourceFile = new File(sourceFilePath);
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        ZipOutputStream zos = null;
        if (sourceFile.exists() == false) {
            System.out.println("待压缩的文件：" + sourceFilePath + "不存在.");
//            throw new ToolsException(ToolsExceptionConstant.NOTEXSITERROR_CODE,
//                    String.format(ToolsExceptionConstant.NOTEXSITERROR_MSG, sourceFilePath));
        } else {
            try {
                File zipFile = new File(zipFilePath + "/" + fileName + ".zip");
                if (zipFile.exists()) {
                    System.out.println(zipFilePath + "目录下存在名字为:" + fileName + ".zip" + "打包文件.");
//                    throw new ToolsException(ToolsExceptionConstant.EXSITERROR_CODE,
//                            String.format(ToolsExceptionConstant.EXSITERROR_MSG, zipFilePath, fileName + ".zip"));
                } else {
                    fos = new FileOutputStream(zipFile);
                    zos = new ZipOutputStream(new BufferedOutputStream(fos));
                    byte[] bufs = new byte[1024 * 10];
                    // 创建ZIP实体，并添加进压缩包
                    ZipEntry zipEntry = new ZipEntry(sourceFile.getName());
                    zos.putNextEntry(zipEntry);
                    // 读取待压缩的文件并写进压缩包里
                    fis = new FileInputStream(sourceFile);
                    bis = new BufferedInputStream(fis, 1024 * 10);
                    int read = 0;
                    while ((read = bis.read(bufs, 0, 1024 * 10)) != -1) {
                        zos.write(bufs, 0, read);
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } finally {
                // 关闭流
                try {
                    if (null != bis)
                        bis.close();
                    if (null != zos)
                        zos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
            flag = true;
        }
        return flag;
    }

    /**
     * 将流的内容打包成fileName名称的zip文件，并存放到zipFilePath路径下
     *
     * @param fis
     *            :待压缩的文件流
     * @param streamfilename
     *            :待压缩的文件流名称
     * @param zipFilePath
     *            :压缩后存放路径
     * @param fileName
     *            :压缩后文件的名称
     * @return
     */
    public static boolean streamToZip(InputStream fis, String streamfilename, String zipFilePath, String fileName) {
        boolean flag = false;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        ZipOutputStream zos = null;
        try {
            File zipFile = new File(zipFilePath + "/" + fileName + ".zip");
            if (zipFile.exists()) {
                System.out.println(zipFilePath + "目录下存在名字为:" + fileName + ".zip" + "打包文件.");
//                throw new ToolsException(ToolsExceptionConstant.EXSITERROR_CODE,
//                        String.format(ToolsExceptionConstant.EXSITERROR_MSG, zipFilePath, fileName + ".zip"));
                return false;
            } else {
                fos = new FileOutputStream(zipFile);
                zos = new ZipOutputStream(new BufferedOutputStream(fos));
                byte[] bufs = new byte[1024 * 10];
                // 创建ZIP实体，并添加进压缩包
                ZipEntry zipEntry = new ZipEntry(streamfilename);
                zos.putNextEntry(zipEntry);
                // 读取待压缩的文件并写进压缩包里
                bis = new BufferedInputStream(fis, 1024 * 10);
                int read = 0;
                while ((read = bis.read(bufs, 0, 1024 * 10)) != -1) {
                    zos.write(bufs, 0, read);
                }
                flag = true;
            }
            zos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            // 关闭流
            try {
                if (null != bis)
                    bis.close();
                if (null != zos)
                    zos.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return flag;
    }

    /**
     * 将流转成zip文件输出
     * @param inputstream
     *            文件流
     * @param streamfilename
     *            流文件的名称
     * @param fileName zip包的名称
     * @param response
     * @return
     */
    public static boolean streamToZipStream(InputStream inputstream, String streamfilename, String fileName,
                                            HttpServletResponse response) {
        boolean flag = false;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        ZipOutputStream zos = null;
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            response.reset();
            response.setHeader("Content-Disposition",
                    "attachment;filename=" + new String(fileName.getBytes("GB2312"), "ISO-8859-1"));
            response.setContentType("application/octet-stream; charset=utf-8");
            response.setCharacterEncoding("UTF-8");
            zos = new ZipOutputStream(out);
            byte[] bufs = new byte[1024 * 10];
            // 创建ZIP实体，并添加进压缩包
            ZipEntry zipEntry = new ZipEntry(streamfilename);
            zos.putNextEntry(zipEntry);
            // 读取待压缩的文件并写进压缩包里
            bis = new BufferedInputStream(inputstream, 1024 * 10);
            int read = 0;
            while ((read = bis.read(bufs, 0, 1024 * 10)) != -1) {
                zos.write(bufs, 0, read);
            }
            flag = true;
            zos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            // 关闭流
            try {
                if (null != bis)
                    bis.close();
                if (null != zos)
                    zos.close();
                if (null != out)
                    out.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return flag;
    }

    /**
     * 将多个流转成zip文件输出
     * @param listStream
     *            文件流实体类对象
     * @param fileName zip包的名称
     * @param response
     * @return
     */
    public static boolean listStreamToZipStream(List<ZipStreamEntity> listStream, String fileName, HttpServletResponse response) {
        boolean flag = false;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        ZipOutputStream zos = null;
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            response.reset();
            response.setHeader("Content-Disposition",
                    "attachment;filename=" + new String(fileName.getBytes("GB2312"), "ISO-8859-1"));
            response.setContentType("application/octet-stream; charset=utf-8");
            response.setCharacterEncoding("UTF-8");
            zos = new ZipOutputStream(out);
            byte[] bufs = new byte[1024 * 10];
            for (ZipStreamEntity zipstream : listStream) {
                String streamfilename = zipstream.getName();
                // 创建ZIP实体，并添加进压缩包
                ZipEntry zipEntry = new ZipEntry(streamfilename);
                zos.putNextEntry(zipEntry);
                // 读取待压缩的文件并写进压缩包里
                bis = new BufferedInputStream(zipstream.getInputstream(), 1024 * 10);
                int read = 0;
                while ((read = bis.read(bufs, 0, 1024 * 10)) != -1) {
                    zos.write(bufs, 0, read);
                }
            }
            flag = true;
            zos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            // 关闭流
            try {
                if (null != bis)
                    bis.close();
                if (null != zos)
                    zos.close();
                if (null != out)
                    out.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return flag;
    }



}
