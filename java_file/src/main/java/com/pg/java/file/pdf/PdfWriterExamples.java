package com.pg.java.file.pdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfWriterExamples {
	
	public static final String PATH = "C://Users//pg38446//Desktop//Tmp//genpdf//";
	
    public static void main(String[] args)
            throws DocumentException, IOException {
            // canvasTest();
    		// columnTest();
    		// paragraph();
    		paragFont();
        }

	private static void canvasTest() throws DocumentException, FileNotFoundException, IOException {
		final String PATH_FILE = PATH+"canvas.pdf";
		// step 1
		Document document = new Document();
		// step 2
		PdfWriter writer =
		    PdfWriter.getInstance(document, new FileOutputStream(PATH_FILE));
		// step 3
		document.open();
		// step 4
		PdfContentByte canvas = writer.getDirectContentUnder();
		writer.setCompressionLevel(0);
		canvas.saveState();                               // q
		canvas.beginText();                               // BT
		canvas.moveText(36, 788);                         // 36 788 Td
		canvas.setFontAndSize(BaseFont.createFont(), 12); // /F1 12 Tf
		canvas.showText("Hello World");                   // (Hello World)Tj
		canvas.endText();                                 // ET
		canvas.restoreState();                            // Q
		// step 5
		document.close();
	}
	
    public static void columnTest() throws DocumentException, IOException {
    	
    	final String RESULT = PATH+"column.pdf";
    	
            // step 1
            Document document = new Document();
            // step 2
            PdfWriter writer
                = PdfWriter.getInstance(document, new FileOutputStream(RESULT));
            // step 3
            document.open();
            // step 4
            // we set the compression to 0 so that we can read the PDF syntax
            writer.setCompressionLevel(0);
            // writes something to the direct content using a convenience method
            Phrase hello = new Phrase("Hello World");
            PdfContentByte canvas = writer.getDirectContentUnder();
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,
                hello, 36, 788, 0);
            // step 5
            document.close();
        }
    
    public static void paragraph()
            throws DocumentException, IOException {
    	
    		final String RESULT = PATH+"paragraph.pdf";
    	
            // step 1
            Document document = new Document();
            // step 2
            PdfWriter.getInstance(document, new FileOutputStream(RESULT));
            // setting page size, margins and mirrered margins
            document.setPageSize(PageSize.A5);
            document.setMargins(36, 72, 108, 180);
            document.setMarginMirroringTopBottom(true);
            // step 3
            document.open();
            // step 4
            document.add(new Paragraph(
                "The left margin of this odd page is 36pt (0.5 inch); " +
                "the right margin 72pt (1 inch); " +
                "the top margin 108pt (1.5 inch); " +
                "the bottom margin 180pt (2.5 inch)."));
            Paragraph paragraph = new Paragraph();
            paragraph.setAlignment(Element.ALIGN_JUSTIFIED);
            for (int i = 0; i < 20; i++) {
                paragraph.add("Hello World! Hello People! " +
                    "Hello Sky! Hello Sun! Hello Moon! Hello Stars!");
            }
            document.add(paragraph);
            document.add(new Paragraph("The top margin 180pt (2.5 inch)."));
            // step 5
            document.close();
        }
    
    public static void paragFont() throws IOException, DocumentException {
    	
    	final String RESULT = PATH+"paragfont.pdf";

        final String FONT = "resources/fonts/NotoSansCJKsc-Regular.otf";
        final String TEXT = "These are the protagonists in 'Hero', a movie by Zhang Yimou:\n"
            + "\u7121\u540d (Nameless), \u6b98\u528d (Broken Sword), "
            + "\u98db\u96ea (Flying Snow), \u5982\u6708 (Moon), "
            + "\u79e6\u738b (the King), and \u9577\u7a7a (Sky).";
        final String CHINESE = "\u5341\u950a\u57cb\u4f0f";
        final String JAPANESE = "\u8ab0\u3082\u77e5\u3089\u306a\u3044";
        final String KOREAN = "\ube48\uc9d1";
    	
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(RESULT));
        document.open();
        Font font = FontFactory.getFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Paragraph p = new Paragraph(TEXT, font);
        document.add(p);
        document.add(new Paragraph(CHINESE, font));
        document.add(new Paragraph(JAPANESE, font));
        document.add(new Paragraph(KOREAN, font));
        document.close();
    }
}
