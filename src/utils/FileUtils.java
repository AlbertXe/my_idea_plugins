package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtils {
    public static List<String> listFiles(String dir) {
        Collection<File> files = org.apache.commons.io.FileUtils.listFiles(new File(dir), null, true);
        return files.stream().map(File::getAbsolutePath).collect(Collectors.toList());
    }

    public static void copy(String src, String desc) {
        File file = new File(src);
        try (FileInputStream is = new FileInputStream(src);
             FileOutputStream os = new FileOutputStream(desc);) {
            FileChannel in = is.getChannel();
            FileChannel out = os.getChannel();
            long size = in.size();
            long pos = 0L;
            long copied;
            for (long count = 0L; pos < size; pos += copied) {
                long remain = size - pos;
                count = remain;
                copied = in.transferTo(pos, count, out);
                if (copied == 0) {
                    break;
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copy(String src, String desc, int partSize) {
        File file = new File(src);
        try (FileInputStream is = new FileInputStream(src);
             FileOutputStream os = new FileOutputStream(desc);) {
            FileChannel in = is.getChannel();
            FileChannel out = os.getChannel();
            long size = partSize;
            long pos = 0L;
            long copied;
            for (long count = 0L; pos < size; pos += copied) {
                long remain = size - pos;
                count = remain;
                copied = in.transferTo(pos, count, out);
                if (copied == 0) {
                    break;
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
