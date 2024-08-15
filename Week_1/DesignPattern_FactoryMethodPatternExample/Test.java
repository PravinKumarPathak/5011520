package FactoryMethodPatternExample;

// Client Code
public class Test {
	public static void main(String[] args) {
		DocumentFactory wordfactory = new WordDocumentFactory();
		Document wordproduct = wordfactory.createDocument();
		wordproduct.display();

		DocumentFactory pdffactory = new PdfDocumentFactory();
		Document pdfproduct = pdffactory.createDocument();
		pdfproduct.display();
	}
}


// Abstract Document Class
abstract class Document {
	public abstract void display();
}

// Concrete Document
class WordDocument extends Document {
	public void display() {
		System.out.println("This is a WordDocument.");
	}
}

class PdfDocument extends Document {
	public void display() {
		System.out.println("This is a PdfDocument.");
	}
}

class ExcelDocument extends Document {
	public void display() {
		System.out.println("This is an ExcelDocument.");
	}
}

// Abstract DocumentFactory Class
abstract class DocumentFactory {
	public abstract Document createDocument();
}

// Concrete DocumentFactory
class WordDocumentFactory extends DocumentFactory {
	public Document createDocument() {
		return new WordDocument();
	}
}

class PdfDocumentFactory extends DocumentFactory {
	public Document createDocument() {
		return new PdfDocument();
	}
}

class ExcelDocumentFactory extends DocumentFactory {
	public Document createDocument() {
		return new ExcelDocument();
	}
}


