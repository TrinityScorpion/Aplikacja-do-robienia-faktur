package com.example.CodersLabLastProject;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.spire.pdf.PdfDocument;

import com.spire.pdf.exporting.xps.schema.Table;
import com.spire.pdf.exporting.xps.schema.TableRow;
import com.spire.pdf.tables.PdfTable;
import lombok.Data;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFTable;

import com.spire.data.table.DataTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import javax.swing.text.TableView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Invoice {

    public static void main(String[] args) {
        try {
            Document document = new Document();
            String dest = "C:/itextExamples/addingTable.pdf";
            XWPFDocument doc = new XWPFDocument();
            FileOutputStream out = new FileOutputStream("Invoice-Template.docx");
            XWPFTable table = doc.createTable();
            XWPFTable table1 = doc.createTable();

            XWPFTableRow tableRowOne = table.getRow(0);
//            tableRowOne.getCell(0).setText("Invoice");
//            tableRowOne.addNewTableCell().setText("col two, row one");
//            tableRowOne.addNewTableCell().setText("col three, row one");
//            tableRowOne.addNewTableCell().setText("X");
//            tableRowOne.setHeight(1000);
//
//            //create second row
//            XWPFTableRow tableRowTwo = table.createRow();
//            tableRowTwo.getCell(0).setText("col one, row two");
//            tableRowTwo.getCell(1).setText("col two, row two");
//            tableRowTwo.getCell(2).setText("col three, row two");
//            tableRowTwo.getCell(3).setText("col three, row two");
//            //create third row
//            XWPFTableRow tableRowThree = table.createRow();
//            tableRowThree.getCell(0).setText("col one, row three");
//            tableRowThree.getCell(1).setText("col two, row three");
//            tableRowThree.getCell(2).setText("col three, row three");
//            tableRowThree.getCell(3).setText("col three, row three");
//
//            XWPFTableRow tableRowFour = table.createRow();
//            tableRowFour.getCell(0).setText("col one, row three");
//            tableRowFour.getCell(1).setText("col two, row three");
//            tableRowFour.getCell(2).setText("col three, row three");
//            tableRowFour.getCell(3).setText("col three, row three");
//
//
//            //Table 2
//            XWPFTableRow tableRowOne1 = table1.getRow(0);
//            tableRowOne1.getCell(0).setText("Invoice");
//            tableRowOne1.addNewTableCell().setText("col two, row one");
//            tableRowOne1.addNewTableCell().setText("col three, row one");
//            tableRowOne1.addNewTableCell().setText("X");
//            tableRowOne1.setHeight(1000);
//
//            //create second row
//            XWPFTableRow tableRowTwo1 = table1.createRow();
//            tableRowTwo1.getCell(0).setText("col one, row two");
//            tableRowTwo1.getCell(1).setText("col two, row two");
//            tableRowTwo1.getCell(2).setText("col three, row two");
//            tableRowTwo1.getCell(3).setText("col three, row two");
//            //create third row
//            XWPFTableRow tableRowThree1 = table1.createRow();
//            tableRowThree1.getCell(0).setText("col one, row three");
//            tableRowThree1.getCell(1).setText("col two, row three");
//            tableRowThree1.getCell(2).setText("col three, row three");
//            tableRowThree1.getCell(3).setText("col three, row three");
//
//            XWPFTableRow tableRowFour1 = table1.createRow();
//            tableRowFour1.getCell(0).setText("col one, row three");
//            tableRowFour1.getCell(1).setText("col two, row three");
//            tableRowFour1.getCell(2).setText("col three, row three");
//            tableRowFour1.getCell(3).setText("col three, row three");
//
//            doc.write(out);
//            out.close();
            System.out.println("create_table.docx written successully");



//            Document document = new Document();
//			PdfWriter.getInstance(document, new FileOutputStream("iTextHelloWorld.pdf"));
//            PdfWriter.getInstance(document, new FileOutputStream("iTextHelloWorld.pdf"));
//            document.open();
//            Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
//            Chunk chunk1 = new Chunk("Hello World1", font);
//            Chunk chunk2 = new Chunk("Hello World2", font);
//            document.add(chunk1);
//            document.add(chunk2);
//            document.close();
            System.out.println("Done");
        }  catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
