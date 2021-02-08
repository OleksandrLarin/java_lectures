package lecture18.io;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class FileExample {
    public static void main(String[] args) {
        File project = new File("D://a-level//jc//src");
        String prefix = "  ";

        List<File> files = createSortedFileList(project);

        explore(files, prefix);
    }

    private static List<File> createSortedFileList(File file) {
        List<File> files = Arrays.asList(file.listFiles());
        files.sort(new FileComparator());

        return files;
    }

    private static void explore(List<File> files, String prefix) {
        for (File item : files) {
            if (item.isFile()) {
                System.out.println(prefix + item.getName());
            } else {
                System.out.println(prefix + "*" + item.getName());
                explore(createSortedFileList(item), prefix + "  ");
            }
        }
    }
}
