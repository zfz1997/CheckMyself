package single;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

class ShowFileTest {
	 
    public static void main(String[] args) throws IOException {
        Path initPath = Paths.get("D:/demo");
        Files.walkFileTree(initPath, new SimpleFileVisitor<Path>() {
 
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) 
                    throws IOException {
                System.out.println(file.getFileName().toString());
                return FileVisitResult.CONTINUE;
            }
 
        });
    }
}
