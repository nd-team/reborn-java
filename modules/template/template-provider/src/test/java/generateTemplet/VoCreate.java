package generateTemplet;

import buildfile.Model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

/**
 * @Author: [tanghaixiang]
 * @Date: [2017-03-13 09:48]
 * @Description: []
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public class VoCreate {

    public static void createModel(Map<String, String> cus, List<Model> models,String createOrDelete) {

        String packageName = cus.get("模块名");
        String className = cus.get("类名");
        className = className.substring(className.lastIndexOf("/")+1,className.length());
        String author = cus.get("作者");
        String desc = cus.get("描述")+"表现层对象";
        LocalDateTime date = LocalDateTime.now();
        String time = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm"));
        String relativePath = "";
        if( cus.get("类名").contains("/")){
            relativePath = cus.get("类名").substring( 0,cus.get("类名").lastIndexOf("/"));
        }
        String packageRelativePath = (relativePath.equals("")?"":"."+relativePath).replaceAll("/",".");

        int size = 0;
        if (models != null && models.size() > 0) {
            size = models.size(); //属性字段长度
        }


        StringBuilder sb = new StringBuilder("");
        sb.append("package com.bjike.reborn."+packageName+".vo"+packageRelativePath+";\n\n");

        //类描述
        sb.append( "/**\n")
                .append("* "+desc+"\n")
                .append("* @Author:\t\t\t[ "+author+" ]\n")
                .append("* @Date:\t\t\t[  "+time+" ]\n")
                .append("* @Description:\t[ "+desc+" ]\n")
                .append("* @Version:\t\t[ v1.0.0 ]\n")
                .append("* @Copy:   \t\t[ com.bjike ]\n")
                .append("*/\n");
        //类创建
        sb.append("public class "+className+"VO { \n\n");


        //拼接属性
        sb.append("/**\n")
                .append("* id\n")
                .append("*/\n");
        sb.append(" private String  id; \n");
        for(int i =0 ;i<size;i++){
            Model model = models.get(i);
            sb.append("/**\n")
                    .append("* "+model.getAnnotation().trim()+"\n")
                    .append("*/\n");

            sb.append(" private "+model.getType()+"  "+model.getFieldName()+"; ");
            if( i==size-1 ){
                sb.append("\n\n\n\n");
            }else{
                sb.append("\n\n");
            }
        }

        //拼接get和set
        sb.append(" public String getId () { \n")
                .append(" return id;\n")
                .append(" } \n")
                .append(" public void setId (String id ) { \n")
                .append(" this.id = id ; \n")
                .append(" } \n");
        for(int i =0 ;i<size;i++){
            Model m = models.get(i);

            sb.append(" public "+m.getType()+" get"+m.getSwapCaseName()+" () { \n")
                    .append(" return "+m.getFieldName()+";\n")
                    .append(" } \n")
                    .append(" public void set"+m.getSwapCaseName()+" ("+m.getType()+" "+m.getFieldName()+" ) { \n")
                    .append(" this."+m.getFieldName().trim() +" = "+m.getFieldName().trim()+" ; \n")
                    .append(" } \n");
        }

        //拼接类完成
        sb.append(" }");

        //文件创建路径
        StringBuffer  filePath = new StringBuffer( System.getProperty("user.dir") + "/modules/" )
                .append(packageName.toLowerCase()+"/")
                .append( packageName.toLowerCase()+"-api/src/main/java/com/bjike/reborn/")
                .append( packageName.toLowerCase()+"/vo/")
                ;

        //相对包路径
        if(!relativePath.trim().equals("")){
            filePath.append(relativePath+"/");
        }
        //文件创建
        File file = new File( filePath.toString() );
        //如果文件夹不存在则创建
        if  (!file .exists()  && !file .isDirectory())
        {
            file .mkdirs();
        }
        filePath.append( className+"VO.java" );
        file = new File( filePath.toString() );
        if( createOrDelete.equals("create")){

            try {
                FileWriter writer = new FileWriter(file);
                writer.write( sb.toString() ,0 ,sb.toString().length());
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(createOrDelete.equals("delete")){
            if(file.exists()){
                file.delete();
            }
        }
    }

}
