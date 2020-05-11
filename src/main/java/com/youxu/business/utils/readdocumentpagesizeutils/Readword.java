package com.youxu.business.utils.readdocumentpagesizeutils;
import java.io.FileInputStream;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.hslf.HSLFSlideShow;
import org.apache.poi.hslf.usermodel.SlideShow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.itextpdf.text.pdf.PdfReader;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.stereotype.Component;

/**
 * 计算ppt,Word,excel的页数
 * @author
 *
 */
@Component
public class Readword {
    /**
     * description: 静态方法，用于判断文件类型，并返回页数
     * @param filePath 文件完整路径
     */
    public int getFilePageNum(String filePath) throws Exception {
        int pageNum = 0;
        String lowerFilePath = filePath.toLowerCase();
        if (lowerFilePath.endsWith(".xls")) {
            HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(lowerFilePath));
            Integer sheetNums = workbook.getNumberOfSheets();
            if (sheetNums > 0) {
                pageNum = workbook.getSheetAt(0).getRowBreaks().length + 1;
            }
        } else if (lowerFilePath.endsWith(".xlsx")) {
            XSSFWorkbook xwb = new XSSFWorkbook(lowerFilePath);
            Integer sheetNums = xwb.getNumberOfSheets();
            if (sheetNums > 0) {
                pageNum = xwb.getSheetAt(0).getRowBreaks().length + 1;
            }
        } else if (lowerFilePath.endsWith(".docx")) {
            XWPFDocument docx = new XWPFDocument(POIXMLDocument.openPackage(lowerFilePath));
            pageNum = docx.getProperties().getExtendedProperties().getUnderlyingProperties().getPages();
        } else if (lowerFilePath.endsWith(".doc")) {
            //下方的方法不好使，经常只统计出一页
//            HWPFDocument wordDoc = new HWPFDocument(new FileInputStream(lowerFilePath));
//            pageNum = wordDoc.getSummaryInformation().getPageCount();
            //采用如下方法   todo    no jacob-1.14.3-x86 in java.library.path
            //pageNum = getDocPageNum(lowerFilePath);
            throw new Exception();
        } else if (lowerFilePath.endsWith(".ppt")) {
            HSLFSlideShow document = new HSLFSlideShow(new FileInputStream(lowerFilePath));
            SlideShow slideShow = new SlideShow(document);
            pageNum = slideShow.getSlides().length;
        } else if (lowerFilePath.endsWith(".pptx")) {
            XMLSlideShow xslideShow = new XMLSlideShow(new FileInputStream(lowerFilePath));
            pageNum = xslideShow.getSlides().length + 1;
        } else if (lowerFilePath.endsWith(".pdf")){
            PdfReader reader = new PdfReader(filePath);
            pageNum = reader.getNumberOfPages();
        }
        return pageNum;
    }


    /**
     * description: 静态方法，专门用于判断Office 2003版本之前的Word（格式为.doc）的页数
     * @param filePath 文件完整路径
     */
    private int getDocPageNum(String filePath) {
        try {
            int pageNum = 0;
            // 建立ActiveX部件
            ActiveXComponent wordCom = new ActiveXComponent("BusinessApplication.Application");
            //word应用程序不可见
            wordCom.setProperty("Visible", false);
            // 返回wrdCom.Documents的Dispatch
            Dispatch wrdDocs = wordCom.getProperty("Documents").toDispatch();//Documents表示word的所有文档窗口（word是多文档应用程序）

            // 调用wrdCom.Documents.Open方法打开指定的word文档，返回wordDoc
            Dispatch wordDoc = Dispatch.call(wrdDocs, "Open", filePath, false, true, false).toDispatch();
            Dispatch selection = Dispatch.get(wordCom, "Selection").toDispatch();
            pageNum = Integer.parseInt(Dispatch.call(selection, "information", 4).toString());//总页数 //显示修订内容的最终状态

            //关闭文档且不保存
            Dispatch.call(wordDoc, "Close", new Variant(false));
            //退出进程对象
            wordCom.invoke("Quit", new Variant[]{});
            return pageNum;
        }catch(Exception e){
            return 0;
        }
    }

    public static void main(String[] args) {

        try{
            /*int xlsNum = Readword.getFilePageNum("E:\\workspace\\DocumentReader\\src\\main\\resources\\5 pages.xls");
            System.out.println("Office2003之前版本的Excel：5 pages.xls 的页数为：" + xlsNum);*/

            /*int xlsxNum = Readword.getFilePageNum("C:\\Users\\Dell\\Desktop\\Book1.xlsx");
            System.out.println("Office2003之后版本的Excel：8 pages.xlsx 的页数为：" + xlsxNum);*/

            /*int docNum = Readword.getFilePageNum("E:\\workspace\\DocumentReader\\src\\main\\resources\\30 pages.doc");
            System.out.println("Office2003之前版本的Word：30 pages.doc 的页数为：" + docNum);*/

            /*int docxNum =  Readword.getFilePageNum("C:\\Users\\Dell\\Desktop\\as.docx");
            System.out.println("Office2003之后版本的Word：133 pages.docx 的页数为：" + docxNum);*/

            /*int pptNum = Readword.getFilePageNum("E:\\workspace\\DocumentReader\\src\\main\\resources\\35 pages.ppt");
            System.out.println("Office2003之前版本的PPT：35 pages.ppt 的页数为：" + pptNum);*/

            /*int pptxNum = Readword.getFilePageNum("E:\\workspace\\DocumentReader\\src\\main\\resources\\95 pages.pptx");
            System.out.println("Office2003之后版本的PPT：95 pages.pptx 的页数为：" + pptxNum);*/

            /*int pdfNum = Readword.getFilePageNum("C:\\Users\\Dell\\Desktop\\阿里巴巴Java开发手册终极版v1.3.0.pdf");
            System.out.println("PDF：30 pages.pdf 的页数为：" + pdfNum);*/
        } catch (Exception e){
            e.printStackTrace();
        }
    }


}

