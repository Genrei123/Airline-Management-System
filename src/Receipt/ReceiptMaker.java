package Receipt;


import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.draw.DashedLine;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReceiptMaker {
    public static void main(String[] args) throws IOException {
        // Directory and name of the file
        String currentDir = System.getProperty("user.dir");
        StringBuilder path = new StringBuilder();
        String TICKET_NUMBER = "20220456";
        path.append(currentDir + "/src/Receipt/" + TICKET_NUMBER + ".pdf");

        // Properties of the said file
        PdfWriter pdfWriter = new PdfWriter(path.toString());
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.setDefaultPageSize(PageSize.A4);

        // Writing starts here
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = date.format(formatter);

        // Header
        Document document = new Document(pdfDocument);
        float twoColumnWidth[] = {285+150, 285};
        Table header = new Table(twoColumnWidth);

        header.addCell(new Cell().add(new Paragraph("ERMINO AIRLINES").setFontSize(25).setBold()).setBorder(Border.NO_BORDER).setFont(PdfFontFactory.createFont("Helvetica")));
        header.addCell(new Cell().add(new Paragraph("TICKET NUMBER: " + TICKET_NUMBER + "\n" + "DATE: " + formattedDate)).setBorder(Border.NO_BORDER));
        document.add(header);

        // Watermark
        ImageData watermark = ImageDataFactory.create(currentDir + "/src/Images/ICONS/EA Logo.png");
        Image watermarkImage = new Image(watermark);

        watermarkImage.setFixedPosition(pdfDocument.getDefaultPageSize().getWidth()/2-200, pdfDocument.getDefaultPageSize().getHeight()/2-175); // Set the position of the watermark in the page in the middle
        watermarkImage.setOpacity(0.1f);
        document.add(watermarkImage);

        // Space
        document.add(new Paragraph("\n"));

        // Body
        float twoColumnWidthBody[] = {285+150, 285};
        Table passengerInfobody = new Table(twoColumnWidthBody);

        // Passenger Info
        document.add(new Paragraph("PASSENGER INFO").setBold());
        passengerInfobody.addCell(new Cell().add(new Paragraph(
                "PASSENGER NAME: " + "John Doe" + "\n"
                + "SEX: M" + "\n")).setBorder(Border.NO_BORDER));
        passengerInfobody.addCell(new Cell().add(new Paragraph(
                "PASSENGER SURNAME: " + "Doe" + "\n"
                + "AGE: 25" + "\n")).setBorder(Border.NO_BORDER));
        document.add(passengerInfobody);

        // Space
        document.add(new Paragraph("\n"));

        // Flight Info
        Table flightInfobody = new Table(twoColumnWidthBody);
        document.add(new Paragraph("FLIGHT INFO").setBold());
        flightInfobody.addCell(new Cell().add(new Paragraph(
                "PASSENGER NAME: " + "John Doe" + "\n"
                + "FLIGHT DATE: " + "12/12/2021" + "\n"
                + "FLIGHT FROM: " + "Istanbul" + "\n")).setBorder(Border.NO_BORDER));

        flightInfobody.addCell(new Cell().add(new Paragraph(
                "FLIGHT NUMBER: " + "ER-123" + "\n"
                + "FLIGHT TIME: " + "12:00" + "\n"
                + "FLIGHT TO: " + "Ankara" + "\n")).setBorder(Border.NO_BORDER));
        document.add(flightInfobody);

        // Space
        document.add(new Paragraph("\n"));

        // Cut here
        DashedLine dashedLine = new DashedLine(1);
        document.add(new LineSeparator(dashedLine));

        // Space
        document.add(new Paragraph("\n"));

        // Header2
        float twoColumnWidth2[] = {285+150, 285};
        Table header2 = new Table(twoColumnWidth2);

        header2.addCell(new Cell().add(new Paragraph("ERMINO AIRLINES").setFontSize(25).setBold()).setBorder(Border.NO_BORDER));
        header2.addCell(new Cell().add(new Paragraph("TICKET NUMBER: " + TICKET_NUMBER + "\n" + "DATE: " + formattedDate)).setBorder(Border.NO_BORDER));
        document.add(header2);

        // Space
        document.add(new Paragraph("\n"));

        // Body2
        float twoColumnWidthBody2[] = {285+150};
        Table passengerInfobody2 = new Table(twoColumnWidthBody2);

        passengerInfobody2.addCell(new Cell().add(new Paragraph("FLIGHT NUMBER: " + "ER-123" +"\n"
                + "CLASS SEAT: " + "Economy" + "\n"
                + "SEAT NO. : " + "12A" + "\n")).setBorder(Border.NO_BORDER));

        document.add(passengerInfobody2);

        // Space
        document.add(new Paragraph("\n"));
        document.close();
    }
}
