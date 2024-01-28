package com.pcp;

import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class TableAndCellR_D {

    public static void main(String[] args) {
        try {
            // Create a new document
            PDDocument document = new PDDocument();
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            // Obtain the content stream from the page
            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            // Set the font and font size (optional)
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);

            // Set the coordinates and dimensions for the table
            float margin = 50;
            float yStart = page.getMediaBox().getHeight() - margin;
            float tableWidth = page.getMediaBox().getWidth() - 2 * margin;
            float yPosition = yStart;
            int rows = 5;
            float rowHeight = 20;
            float tableHeight = rowHeight * rows;
            float cellMargin = 5f;
            float[] columnWidths = { 100, 150, 200 }; // Adjust column widths as needed

            // Draw the table header
            drawTableHeader(contentStream, margin, yPosition, tableWidth, rowHeight, cellMargin, columnWidths);
            yPosition -= rowHeight;

            // Draw the table content with right-aligned text
            drawTableContent(contentStream, margin, yPosition, tableWidth, tableHeight, rowHeight, cellMargin, columnWidths);

            // Close the content stream
            contentStream.close();

            // Save the document
            document.save("TableWithRightAlignedText.pdf");

            // Close the document
            document.close();

            System.out.println("PDF created successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void drawTableHeader(PDPageContentStream contentStream, float margin, float yPosition, float tableWidth,
            float rowHeight, float cellMargin, float[] columnWidths) throws IOException {
        contentStream.setLineWidth(1f);
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);

        float xPosition = margin;
        for (float width : columnWidths) {
            contentStream.moveTo(xPosition, yPosition);
            contentStream.lineTo(xPosition + width, yPosition);
            contentStream.stroke();
            xPosition += width + cellMargin;
        }
    }

    private static void drawTableContent(PDPageContentStream contentStream, float margin, float yPosition,
            float tableWidth, float tableHeight, float rowHeight, float cellMargin, float[] columnWidths) throws IOException {
        contentStream.setFont(PDType1Font.HELVETICA, 12);

        float xPosition = margin;
        for (float width : columnWidths) {
            contentStream.moveTo(xPosition, yPosition - tableHeight);
            contentStream.lineTo(xPosition, yPosition);
            contentStream.stroke();
            xPosition += width + cellMargin;
        }

        // Right-aligned text in cells
        contentStream.beginText();

        float textXPosition = margin + cellMargin; // Initial X position for text in the first cell

        for (int row = 0; row < 5; row++) { // Adjust the number of rows as needed
            float textYPosition = yPosition - row * rowHeight - 15; // Adjust vertical positioning as needed

            // Iterate over each column
            for (float width : columnWidths) {
//                contentStream.setTextMatrix(textXPosition + width, textYPosition);
                contentStream.showText("Left Aligned Text");
                textXPosition += width + cellMargin;
            }

            textXPosition = margin + cellMargin; // Reset X position for the next row
        }

        contentStream.endText();
    }
}

