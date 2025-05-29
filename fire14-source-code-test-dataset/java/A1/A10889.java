package utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fabien Renaud
 */
public class File {

  public static boolean delete(String filename) {
    java.io.File f = new java.io.File(filename);
    if (f != null) {
      return f.delete();
    }
    return false;
  }

  public static String[] readAllLines(String filename) {
    return readAllLines(new java.io.File(filename));
  }

  public static String[] readAllLines(java.io.File file) {
    List<String> list = new ArrayList<String>();

    try {
      BufferedReader input = new BufferedReader(new FileReader(file));
      try {
        String line = null;

        while ((line = input.readLine()) != null) {
          list.add(line);
        }
      } finally {
        input.close();
      }
    } catch (IOException ex) {
      Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
    }

    String[] s = new String[list.size()];
    return list.toArray(s);
  }

  public static String readAllText(String filename) {
    return readAllText(new java.io.File(filename));
  }

  public static String readAllText(java.io.File file) {
    StringBuilder content = new StringBuilder();
    String lf = System.getProperty("line.separator");

    try {
      BufferedReader input = new BufferedReader(new FileReader(file));
      try {
        String line = null;

        while ((line = input.readLine()) != null) {
          content.append(line);
          content.append(lf);
        }
      } finally {
        input.close();
      }
    } catch (IOException ex) {
      Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
    }

    return content.toString();
  }

  public static byte[] readAllBytes(String filename) {
    return readAllBytes(new java.io.File(filename));
  }

  public static byte[] readAllBytes(java.io.File file) {
    byte[] bytes = new byte[0];
    InputStream is = null;
    try {
      is = new FileInputStream(file);
      long length = file.length();
      if (length > Integer.MAX_VALUE) {
        // File is too large
      }

      bytes = new byte[(int) length];
      int offset = 0;
      int numRead = 0;
      while (offset < bytes.length && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
        offset += numRead;
      }
      if (offset < bytes.length) {
        throw new IOException("Could not completely read file " + file.getName());
      }
      is.close();
    } catch (Exception ex) {
      Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      try {
        is.close();
      } catch (IOException ex) {
        Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    return bytes;
  }

  public static void writeAllLines(String filename, String[] lines) {
    writeAllLines(new java.io.File(filename), lines);
  }

  public static void writeAllLines(java.io.File file, String[] lines) {
    String lf = System.getProperty("line.separator");

    try {
      FileWriter fw = new FileWriter(file);
      for (String l : lines) {
        fw.write(l);
        fw.write(lf);
        fw.flush();
      }
      fw.close();
    } catch (IOException ex) {
      Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public static void writeAllText(String filename, String text) {
    writeAllText(new java.io.File(filename), text);
  }

  public static void writeAllText(java.io.File file, String text) {
    String lf = System.getProperty("line.separator");

    try {
      FileWriter fw = new FileWriter(file);
      fw.write(text);
      fw.flush();
      fw.close();
    } catch (IOException ex) {
      Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public static void writeAllBytes(String filename, byte[] bytes) {
    writeAllBytes(new java.io.File(filename), bytes);
  }

  public static void writeAllBytes(java.io.File file, byte[] bytes) {
    try {
      FileOutputStream fos = new FileOutputStream(file);
      fos.write(bytes);
      fos.close();
    } catch (Exception ex) {
      Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
