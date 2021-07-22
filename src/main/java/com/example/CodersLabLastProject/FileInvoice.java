package com.example.CodersLabLastProject;

import org.apache.poi.xwpf.usermodel.*;

import java.io.IOException;

public class FileInvoice {

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
