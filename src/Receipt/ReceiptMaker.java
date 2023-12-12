package Receipt;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;

import java.io.FileNotFoundException;

public class ReceiptMaker {
    public void generateReceipt(String ticketNo) throws FileNotFoundException {
        // Directory and name of file
        String currentDir = System.getProperty("user.dir");
        StringBuilder path = new StringBuilder();
        path.append(currentDir).append("/src/Receipt/").append(ticketNo).append(".pdf");

        // Properties of the said file
        PdfWriter pdfWriter = new PdfWriter(path.toString());
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.setDefaultPageSize(PageSize.A4);

    }

}
