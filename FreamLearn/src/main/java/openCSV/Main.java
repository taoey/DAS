package openCSV;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.junit.Test;

import java.io.*;
import java.util.List;

public class Main {

    /**
     * 根据列名进行转换
     * @throws Exception
     */
    @Test
    public void readCSVByAnnotationByColName() throws Exception{
        String filePath = "E:\\projects\\back-end\\DAS\\LittleTool\\src\\main\\java\\Alipay\\read-data.csv";
        File f = new File(filePath);
        InputStreamReader inReader = new InputStreamReader(new FileInputStream(f),"GBK");
        BufferedReader br = new BufferedReader(inReader);
        CsvToBean<Student> csvToBean = new CsvToBeanBuilder<Student>(br)
                .withType(Student.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        List<Student> students = csvToBean.parse();
        System.out.println(students.toString());

    }
    @Test
    public void readCSVByAnnotationByColPostion() throws Exception{
        String filePath = "E:\\projects\\back-end\\DAS\\FreamLearn\\src\\main\\java\\openCSV\\read-data.csv";
        File f = new File(filePath);
        InputStreamReader inReader = new InputStreamReader(new FileInputStream(f),"GBK");
        BufferedReader br = new BufferedReader(inReader);
        CsvToBean<Teacher> csvToBean = new CsvToBeanBuilder<Teacher>(br)
                .withType(Teacher.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        List<Teacher> students = csvToBean.parse();
        System.out.println(students.toString());

    }




    public static  void read() throws Exception{
        String filePath = "E:\\projects\\back-end\\DAS\\FreamLearn\\src\\main\\java\\openCSV\\read-data.csv";
        File f = new File(filePath);
        DataInputStream in = new DataInputStream(new FileInputStream(f));
        CSVReader reader = new CSVReader(new InputStreamReader(in,"gbk"));
        List<String[]> list = reader.readAll();

        CsvToBean<Student> csvToBean = null;
        csvToBean = new CsvToBeanBuilder<Student>(new InputStreamReader(in,"utf-8"))
                .withIgnoreLeadingWhiteSpace(true)
                .withType(Student.class)
                .build();

        List<Student> students = csvToBean.parse();

        System.out.println(students.toString());

    }


    @Test
    public void test() throws Exception{
        readCSVByAnnotationByColPostion();
    }
}
