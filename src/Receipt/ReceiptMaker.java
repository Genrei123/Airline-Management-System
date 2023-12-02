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
import com.itextpdf.layout.element.Image;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReceiptMaker {

    public void generateReceipt(String first_name, String last_name, int age, String destination, String origin, String class1, String seat, String flight_no, double amount) throws IOException {


        // Directory and name of the file
        String currentDir = System.getProperty("user.dir");
        StringBuilder path = new StringBuilder();
        path.append(currentDir + "/src/Receipt/" + flight_no + ".pdf");

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
        header.addCell(new Cell().add(new Paragraph("TICKET NUMBER: " + flight_no + "\n" + "DATE: " + formattedDate)).setBorder(Border.NO_BORDER));
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
                "PASSENGER NAME: " + first_name + "\n"
                + "SEX: M" + "\n")).setBorder(Border.NO_BORDER));
        passengerInfobody.addCell(new Cell().add(new Paragraph(
                "PASSENGER SURNAME: " + last_name + "\n"
                + "AGE: " + age + "\n")).setBorder(Border.NO_BORDER));
        document.add(passengerInfobody);

        // Space
        document.add(new Paragraph("\n"));

        // Flight Info
        Table flightInfobody = new Table(twoColumnWidthBody);
        document.add(new Paragraph("FLIGHT INFO").setBold());
        flightInfobody.addCell(new Cell().add(new Paragraph(
                "PASSENGER NAME: " + first_name + "\n"
                + "FLIGHT DATE: " + "12/12/2021" + "\n"
                + "FLIGHT FROM: " + origin + "\n")).setBorder(Border.NO_BORDER));

        flightInfobody.addCell(new Cell().add(new Paragraph(
                "FLIGHT NUMBER: " + "ER-123" + "\n"
                + "FLIGHT TIME: " + "12:00" + "\n"
                + "FLIGHT TO: " + destination + "\n")).setBorder(Border.NO_BORDER));
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
        header2.addCell(new Cell().add(new Paragraph("TICKET NUMBER: " + flight_no + "\n" + "DATE: " + formattedDate)).setBorder(Border.NO_BORDER));
        document.add(header2);

        // Space
        document.add(new Paragraph("\n"));

        // Body2
        float twoColumnWidthBody2[] = {285+150};
        Table passengerInfobody2 = new Table(twoColumnWidthBody2);

        passengerInfobody2.addCell(new Cell().add(new Paragraph("FLIGHT NUMBER: " + flight_no +"\n"
                + "CLASS SEAT: " + class1 + "\n"
                + "SEAT NO. : " + seat + "\n")).setBorder(Border.NO_BORDER));

        document.add(passengerInfobody2);

        // Space
        document.add(new Paragraph("\n"));
        document.close();

        // Body3
        float twoColumnWidthBody3[] = {285+150};
        Table passengerInfobody3 = new Table(twoColumnWidthBody3);

        passengerInfobody3.addCell(new Cell().add(new Paragraph("TOTAL AMOUNT: " + amount + "\n")).setBorder(Border.NO_BORDER));
    }

    public String getReceiptPath(String flight_no) {
        String currentDir = System.getProperty("user.dir");
        StringBuilder path = new StringBuilder();
        path.append(currentDir + "/src/Receipt/" + flight_no + ".pdf");
        return path.toString();
    }

    // Open receipt
    public void openReceipt(String path) throws IOException {
        File file = new File(path);
        Desktop.getDesktop().open(file);
    }
}
