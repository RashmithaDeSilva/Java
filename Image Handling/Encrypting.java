import java.io.*;
import java.nio.file.*;
import javax.swing.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class FileEncryptor {
  public static void main(String[] args) throws Exception {
    // Open a file explorer and let the user select a file
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Select a file to encrypt");
    int result = fileChooser.showOpenDialog(null);
    if (result != JFileChooser.APPROVE_OPTION) {
      System.out.println("No file selected");
      return;
    }
    File selectedFile = fileChooser.getSelectedFile();

    // Create a copy of the selected file
    Path sourcePath = selectedFile.toPath();
    String fileName = selectedFile.getName();
    String copyFileName = fileName + ".copy";
    Path targetPath = Paths.get(copyFileName);
    Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
    File copyFile = targetPath.toFile();

    // Encrypt the copy of the file
    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    cipher.init(Cipher.ENCRYPT_MODE, getSecretKey());
    InputStream in = new FileInputStream(copyFile);
    OutputStream out = new FileOutputStream(fileName + ".encrypted");
    byte[] buffer = new byte[1024];
    int read;
    while ((read = in.read(buffer)) != -1) {
      out.write(cipher.update(buffer, 0, read));
    }
    out.write(cipher.doFinal());
    in.close();
    out.close();

    // Delete the unencrypted copy
    copyFile.delete();
  }

  private static SecretKey getSecretKey() throws Exception {
    // Generate a new secret key
    KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
    keyGenerator.init(128);
    SecretKey secretKey = keyGenerator.generateKey();
    return secretKey;
  }
}

// Create By SLR De Silva
