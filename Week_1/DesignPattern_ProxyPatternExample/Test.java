package ProxyPatternExample;

public class Test {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.jpg");

        image1.display(); // Loading and displaying image1
        image1.display(); // Directly displaying cached image1

        image2.display(); // Loading and displaying image
    }
}





interface Image {
    void display();
}

class RealImage implements Image {
    private String imagePath;

    public RealImage(String imagePath) {
        this.imagePath = imagePath;
        loadImageFromServer();
    }

    private void loadImageFromServer() {
        System.out.println("Loading image from server: " + imagePath);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + imagePath);
    }
}

class ProxyImage implements Image {
    private RealImage realImage;
    private String imagePath;
    private boolean isLoaded = false;

    public ProxyImage(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public void display() {
        if (!isLoaded) {
            realImage = new RealImage(imagePath);
            isLoaded = true;
        }
        realImage.display();
    }
}


