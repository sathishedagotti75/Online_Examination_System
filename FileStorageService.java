package com.sathish.demo.file;
import org.springframework.stereotype.Service;import org.springframework.web.multipart.MultipartFile;import java.io.IOException;import java.nio.file.*;
@Service public class FileStorageService {
 private final Path root=Paths.get("uploads");
 public String store(MultipartFile file)throws IOException{Files.createDirectories(root);String name=java.util.UUID.randomUUID()+"_"+Path.of(file.getOriginalFilename()).getFileName();Files.copy(file.getInputStream(),root.resolve(name),StandardCopyOption.REPLACE_EXISTING);return name;}
}
