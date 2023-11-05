package Receipt;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.FileNotFoundException;

import static com.itextpdf.kernel.pdf.PdfName.Path;

public class Invoice {


    public void createInvoice(String FName, String LName) throws FileNotFoundException {

    }
    public static void main(String[] args) throws FileNotFoundException {
        String currentDir = System.getProperty("user.dir");

        StringBuilder path = new StringBuilder();
        path.append(currentDir + "/src/Receipt/invoice.pdf");


        PdfWriter pdfWriter = new PdfWriter(path.toString());

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.setDefaultPageSize(PageSize.A4);

        // Create a Document object from the PdfDocument object.
        Document document = new Document(pdfDocument);

        // Add a paragraph to the document.
        document.add(new Paragraph("Hello Ervhyne"));

        // Close the Document object to generate the PDF file.
        document.close();

        // Close the PdfDocument object to flush the writer.
        pdfDocument.close();
    }
}