package practice_02;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

public class Searcher implements FileVisitor {
    private final PathMatcher matcher;
    private ArrayList<String> filePaths = new ArrayList<>();

    public Searcher(String ext) {
        matcher = FileSystems.getDefault().getPathMatcher("glob:" + ext);
    }

    public void judgeFile(Path file) throws IOException {
        Path name = file.getFileName();
        if (name != null && matcher.matches(name)) {
//            System.out.println("Searched file was found: " + name + " in " + file.toRealPath().toString());
            filePaths.add(file.toRealPath().toString());
        }
    }

    @Override
    public FileVisitResult preVisitDirectory(Object dir, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {
        judgeFile((Path) file);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Object file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Object dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    public ArrayList<String> getFilePaths() {
        return filePaths;
    }
}
