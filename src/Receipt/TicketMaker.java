package Receipt;


import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.draw.DashedLine;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.DashedBorder;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;

public class TicketMaker {

    public void generateTicket(String first_name, String middle_name, String last_name, int age, String destination, String origin, String class1,
                               String seat, String flight_no,
                               double amount, LocalDate departure,
                               String ticket_no, String fare) throws IOException {

        String total = Double.toString(amount);


        // Directory and name of the file
        String currentDir = System.getProperty("user.dir");
        StringBuilder path = new StringBuilder();
        path.append(currentDir + "/src/Receipt/" + flight_no + ticket_no + ".pdf");

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
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("\n"));

        // Body
        float twoColumnWidthBody[] = {285+150, 285};
        Table passengerInfobody = new Table(twoColumnWidthBody);

        // Passenger Info
        document.add(new Paragraph("PASSENGER DETAILS").setBold());
        passengerInfobody.addCell(new Cell().add(new Paragraph(
                "PASSENGER NAME: " + " " + first_name + " " + middle_name + " " + last_name)).setBorder(Border.NO_BORDER));
        passengerInfobody.addCell(new Cell().add(new Paragraph(
                "AGE: " + age + "\n")).setBorder(Border.NO_BORDER));
        document.add(passengerInfobody);




        // Flight Info
        Table flightInfobody = new Table(twoColumnWidthBody);
        document.add(new Paragraph("TICKET DETAILS").setBold());
        flightInfobody.addCell(new Cell().add(new Paragraph(
                "TICKET NUMBER: " + ticket_no + "\n"
                + "FLIGHT DATE: " + departure + "\n"
                + "FLIGHT FROM: " + origin + "\n")).setBorder(Border.NO_BORDER));

        flightInfobody.addCell(new Cell().add(new Paragraph(
                "FLIGHT NUMBER: " + flight_no + "\n"
                + "FLIGHT TIME: " + "TO BE SET" + "\n"
                + "FLIGHT TO: " + destination + "\n")).setBorder(Border.NO_BORDER));
        document.add(flightInfobody);

        // Space
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("\n"));

        // Create a 5-column, 2-row table
        Table table = new Table(UnitValue.createPercentArray(5)).useAllAvailableWidth();

        // Column headers
        table.addCell(createHeaderCell("From"));
        table.addCell(createHeaderCell("To"));
        table.addCell(createHeaderCell("Flight"));
        table.addCell(createHeaderCell("Flight Date"));
        table.addCell(createHeaderCell("Seat Type"));

        // Row 1 with information
        table.addCell(createCell(origin));
        table.addCell(createCell(destination));
        table.addCell(createCell(flight_no));
        table.addCell(createCell(departure.toString()));
        table.addCell(createCell(class1));

        document.add(table);

        // Space
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("\n"));

        // Fare Details Table
        Table fareDetailsTable = new Table(UnitValue.createPercentArray(2)).useAllAvailableWidth();
        fareDetailsTable.setHorizontalAlignment(HorizontalAlignment.RIGHT);

        // Fare Details Header
        fareDetailsTable.addCell(new Cell(1, 2).add(new Paragraph("Fare Details").setBold()));

        // Fare Details Rows
        fareDetailsTable.addCell(createFareDetailRow("Fare:", "PHP " + fare));
        fareDetailsTable.addCell(createFareDetailRow("Taxes:", "PHP 50"));
        fareDetailsTable.addCell(createFareDetailRow("Carrier Imposed Fees:",  "PHP 30"));
        fareDetailsTable.addCell(createFareDetailRow("Total Amount:", "PHP " + total));

        document.add(fareDetailsTable);
        document.close();
    }

    public String getReceiptPath(String flight_no, String ticket_no) {
        String currentDir = System.getProperty("user.dir");
        StringBuilder path = new StringBuilder();
        path.append(currentDir + "/src/Receipt/" + flight_no + ticket_no + ".pdf");
        return path.toString();
    }

    // Open receipt
    public void openReceipt(String path) throws IOException {
        File file = new File(path);
        Desktop.getDesktop().open(file);
    }

    private static Cell createHeaderCell(String header) {
        return new Cell().add(new Paragraph(header).setBackgroundColor(com.itextpdf.kernel.colors.Color.makeColor(ColorConstants.BLUE.getColorSpace())).setFontColor(ColorConstants.WHITE).setBold());
    }

    private static Cell createCell(String content) {
        return new Cell().add(new Paragraph(content));
    }

    private static Cell createFareDetailRow(String label, String value) {
        return new Cell().add(new Paragraph(label)).add(new Paragraph(value).setMarginLeft(10));
    }


}
