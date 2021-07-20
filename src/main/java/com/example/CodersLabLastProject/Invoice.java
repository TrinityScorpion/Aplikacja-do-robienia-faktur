package com.example.CodersLabLastProject;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.*;
import org.hibernate.sql.Update;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;


public class Invoice {

    public static void main(String[] args) throws IOException {
        String fileName = "test.docx";

        XWPFDocument document = new XWPFDocument();
        XWPFParagraph p1 = document.createParagraph();
        p1.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun r1 = p1.createRun();
        r1.setBold(true);
        r1.setItalic(true);
        r1.setFontSize(22);
        r1.setFontFamily("New Roman");
        r1.setText("I am first Paragraph");

        XWPFParagraph p2 = document.createParagraph();
        p2.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun r2 = p2.createRun();
        r2.setText("I am second Paragraph");
        r2.setColor("ff0000");


        String fileName1 = "Invoice-Template.docx";

        XWPFDocument doc = new XWPFDocument(
                Files.newInputStream(Paths.get(fileName1)));

        XWPFWordExtractor xwpfWordExtractor = new XWPFWordExtractor(doc);
        String docText = xwpfWordExtractor.getText();
//        System.out.println(docText);

        //   find number of words in the document
        long count = Arrays.stream(docText.split("\\s+")).count();
//        System.out.println("Total words: " + count);

        List<XWPFParagraph> list = doc.getParagraphs();
        for (XWPFParagraph paragraph : list) {
//            System.out.println(paragraph.getText());
        }

        Invoice invoice = new Invoice();

        invoice.updateDocument("Invoice-Template.docx", "test3.docx", "Ada Gwozdzik", "${name}");

    }

    private static void updateDocument(String input, String output, String name, String swap) throws IOException {

        XWPFDocument doc = new XWPFDocument(
                Files.newInputStream(Paths.get(input)));

        for (XWPFTable tbl : doc.getTables()) {
            for (XWPFTableRow row : tbl.getRows()) {
                for (XWPFTableCell cell : row.getTableCells()) {
                    for (XWPFParagraph p : cell.getParagraphs()) {
                        for (XWPFRun r : p.getRuns()) {
                            String text = r.getText(0);
                            if (text != null && text.contains(swap)) {
                                text = text.replace(swap, name);
                                r.setText(text,0);
                            }
                        }
                    }
                }
            }
        }

        // save the docs
        try (FileOutputStream out = new FileOutputStream(output)) {
            doc.write(out);
        }


    }


}





