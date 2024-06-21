import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class imageeditor {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the image file name: ");
        String imageName = scanner.nextLine();

        BufferedImage image = loadImage(imageName);
        if (image == null) {
            System.out.println("Image not found.");
            return;
        }

        System.out.println("Options:");
        System.out.println("1. Blur image");
        System.out.println("2. Convert to grayscale");
        System.out.println("3. Rotate image");
        System.out.print("Enter option: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                System.out.print("Enter blur percentage (0-100): ");
                int blurPercentage = scanner.nextInt();
                BufferedImage blurredImage = applyBlur(image, blurPercentage);
                saveImage(blurredImage, "blurred_" + imageName);
                break;
            case 2:
                BufferedImage grayscaleImage = applyGrayscale(image);
                saveImage(grayscaleImage, "grayscale_" + imageName);
                break;
            case 3:
                System.out.print("Enter rotation angle (in degrees): ");
                double rotationAngle = scanner.nextDouble();
                BufferedImage rotatedImage = applyRotation(image, rotationAngle);
                saveImage(rotatedImage, "rotated_" + imageName);
                break;
            default:
                System.out.println("Invalid option.");
        }

        System.out.println("Image processing completed.");
    }

    public static BufferedImage loadImage(String imageName) {
        try {
            return ImageIO.read(new File(imageName));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void saveImage(BufferedImage image, String outputFileName) {
        try {
            ImageIO.write(image, "png", new File(outputFileName));
            System.out.println("Image saved as " + outputFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage applyBlur(BufferedImage image, int blurPercentage) {
        // Implement your blurring logic here
        return image; // Placeholder
    }

    public static BufferedImage applyGrayscale(BufferedImage image) {
        // Implement your grayscale conversion logic here
        return image; // Placeholder
    }

    public static BufferedImage applyRotation(BufferedImage image, double rotationAngle) {
        // Implement your rotation logic here
        return image; // Placeholder
    }

}
