package com.pingan.rym.utils;

import com.pingan.rym.dto.PersonDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.*;

import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 刘欣武
 * @version $Id: ExcelExportUtil, v 0.1 2020/5/10 18:11 刘欣武 Exp$
 */
@Slf4j
public class ExcelExportUtil {

    public static void main(String[] args){

        Field[] declaredFields = PersonDTO.class.getDeclaredFields();
        String[] title = new String[declaredFields.length];
        String[] fields = new String[declaredFields.length];
        for(int i=0;i<declaredFields.length;i++){
            String name = declaredFields[i].getName();
            title[i] = name;
            fields[i] = name;
        }
        List<PersonDTO> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            PersonDTO personDTO = new PersonDTO();
            personDTO.setId(i+"");
            personDTO.setName("lixinw"+i);
            personDTO.setAge(22+i);
            list.add(personDTO);
        }
        export(title,fields,list,"/file/exportLiu.xls");
    }

    public static void export(String[] title, String[] fields, List list,String path){

        //创建工作簿对象
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建工作表对象
        HSSFSheet sheet = workbook.createSheet();
        //创建标题行
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = null;
        //添加标题
        for(int i=0;i<title.length;i++){
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
        }
        //向表中插入数据
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        int size = list.size();
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        HSSFCellStyle cellStyle2 = workbook.createCellStyle();
        for(int i=1;i<=size;i++){
            //创建行对象
            HSSFRow nextRow = sheet.createRow(i);
            //创建单元格对象
            for(int j=0;j<fields.length;j++){
                HSSFCell cell2 = nextRow.createCell(j);
                //判断类型
                Object result = getResult(fields[j], list.get(i - 1));
                if(result instanceof Integer){
                    //数字设置下样式
                    cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0"));
                    cell2.setCellStyle(cellStyle);
                    cell2.setCellValue((Integer)result);
                }else if(result instanceof String){
                    cell2.setCellValue((String)result);
                }else if(result instanceof Timestamp || result instanceof Date){
                    //日期设置样式
                    cell2.setCellValue(format.format(result));
                }else if(result instanceof Double){
                    HSSFDataFormat df = workbook.createDataFormat();
                    cellStyle2.setDataFormat(df.getBuiltinFormat("#,##0.00"));
                    cell2.setCellStyle(cellStyle2);
                    cell2.setCellValue((Double)result);
                }else{
                    cell2.setCellValue("");
                }

            }
        }
        //生成文件
        File file = new File(path);
        try(FileOutputStream stream = FileUtils.openOutputStream(file);){
            file.createNewFile();
            workbook.write(stream);
            System.out.println("生成excel表格在"+file.getAbsolutePath());
            log.info("file path in our disk is "+file.getAbsolutePath());
        }catch (Exception e){
            e.printStackTrace();
            log.error("export file error");
        }


    }

    private static Object getResult(Object fieldName,Object object){
        try{
            Class<?> aClass = object.getClass();
            Field declaredField = aClass.getDeclaredField(fieldName.toString());
            declaredField.setAccessible(true);
            PropertyDescriptor pd = new PropertyDescriptor(declaredField.getName(), aClass);
            Method readMethod = pd.getReadMethod();
            return readMethod.invoke(object);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}


