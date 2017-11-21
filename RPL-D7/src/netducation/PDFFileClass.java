/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netducation;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Graphics2D;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author yoelt
 */
public class PDFFileClass {
    public static void PrintFrameToPDF(JFrame print, String user) {
        try {
            Document doc = new Document();
//            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                UIManager.setLookAndFeel(info.getClassName());
//                break;
//                }
//            }
            
            File f = new File("C:\\Users\\yoelt\\Documents\\5th Semester\\RPL - Software Engineering\\PROJECT RPL\\PdfNetducation\\" + user + ".pdf");
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream (f));
            doc.open();
            PdfContentByte cb = writer.getDirectContent();
            PdfTemplate template = cb.createTemplate(PageSize.A4.width(),PageSize.A4.height());
            cb.addTemplate(template, 0, 0);
            Graphics2D g2d = template.createGraphics(PageSize.A4.width(),PageSize.A4.height());
            g2d.scale(0.98, 0.98);
            print.print(g2d);
            print.addNotify();
            print.validate();
            g2d.dispose();
            doc.newPage();
            doc.close();
        } catch (IOException | DocumentException e) {
            System.out.println(e.getMessage());
        }
    }
}