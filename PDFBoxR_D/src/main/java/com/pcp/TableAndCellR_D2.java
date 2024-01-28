package com.pcp;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;

public class TableAndCellR_D2 {

	public static void main(String[] args) {
		try {
			PDDocument document = new PDDocument();
			PDPage page = new PDPage(PDRectangle.A4);
			document.addPage(page);

			PDPageContentStream contentStream = new PDPageContentStream(document, page);

			float margin = 50;
			float yStart = page.getMediaBox().getHeight() - margin;
			float tableWidth = page.getMediaBox().getWidth() - 2 * margin;
			float yPosition = yStart;
			int rows = 5;
			float rowHeight = 20;
			float tableHeight = rowHeight * rows;
			float colWidth = tableWidth / 3f;
			float cellMargin = 5f;

			// Define the starting point of the table
			float nextY = yStart;

			// Draw the table headers
			drawCell(contentStream, margin, nextY, colWidth, rowHeight, "Header 1");
			drawCell(contentStream, margin + colWidth, nextY, colWidth, rowHeight, "Header 2");
			drawCell(contentStream, margin + 2 * colWidth, nextY, colWidth, rowHeight, "Header 3");

			nextY -= rowHeight;

			// Draw the table content
			for (int i = 0; i < rows; i++) {
				drawCell(contentStream, margin, nextY, colWidth, rowHeight, "Data " + (i + 1) + ",1");
				drawCell(contentStream, margin + colWidth, nextY, colWidth, rowHeight, "Data " + (i + 1) + ",2");
				drawCell(contentStream, margin + 2 * colWidth, nextY, colWidth, rowHeight, "Data " + (i + 1) + ",3");

				nextY -= rowHeight;
			}

			contentStream.close();

			document.save("TableExample.pdf");
			document.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void drawCell(PDPageContentStream contentStream, float x, float y, float width, float height,
			String text)

			throws IOException {

		contentStream.setLineWidth(0.5f);

		contentStream.setNonStrokingColor(0f, 0f, 0f); // Black text color

//		contentStream.addRect(x, y, width, height);

		contentStream.stroke();

		contentStream.beginText();

		// Calculate the width of the text

		float textWidth = PDType1Font.HELVETICA_BOLD.getStringWidth(text) / 1000 * 12;

		// Right-align the text within the cell

		float startX = x + width  - textWidth; // Adjust the padding as needed

		float startY = y + height-18;

		contentStream.newLineAtOffset(startX, startY);

		contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);

		contentStream.showText(text);

		contentStream.endText();

	}

}
