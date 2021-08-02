package com.example.CodersLabLastProject;

import org.apache.poi.xwpf.usermodel.*;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class FileInvoice {

    public static void main(String[] args) {
//        JFrame parentFrame = new JFrame();
//
//        JFileChooser fileChooser = new JFileChooser();
//        fileChooser.setDialogTitle("Specify a file to save");
//
//        int userSelection = fileChooser.showSaveDialog(parentFrame);
//
//        if (userSelection == JFileChooser.APPROVE_OPTION) {
//            File fileToSave = fileChooser.getSelectedFile();
//            System.out.println("Save as file: " + fileToSave.getAbsolutePath());
//        }
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        String fileLocation = path.substring(0, path.length() - 1) + "NoxHoursReport"  + ".xlsx";
        System.out.println(fileLocation);


    }

    public void updateDocument(XWPFDocument doc, String name, String swap) throws IOException {

        for (XWPFTable tbl : doc.getTables()) {
            for (XWPFTableRow row : tbl.getRows()) {
                for (XWPFTableCell cell : row.getTableCells()) {
                    for (XWPFParagraph p : cell.getParagraphs()) {
                        for (XWPFRun r : p.getRuns()) {
                            String text = r.getText(0);
                            if (text != null && text.contains(swap)) {
                                text = text.replace(swap, name);
                                r.setText(text, 0);
                            }
                        }
                    }
                }
            }
        }
    }
}
