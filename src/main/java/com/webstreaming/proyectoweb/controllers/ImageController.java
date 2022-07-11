package com.webstreaming.proyectoweb.controllers;

import com.webstreaming.proyectoweb.AppConfig;
import com.webstreaming.proyectoweb.models.Imagen;
import com.webstreaming.proyectoweb.repositories.ImagenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/image")
public class ImageController {

    private final ImagenRepository imagenRepository;
    private final AppConfig appConfig;

    @Autowired
    public ImageController(ImagenRepository imagenRepository, AppConfig appConfig) {
        this.imagenRepository = imagenRepository;
        this.appConfig = appConfig;
    }

    @PostMapping()
    public ResponseEntity<Integer> uploadImage(@RequestBody MultipartFile file){
        Path fileStorageLocation = Paths.get(appConfig.getUploadDir())
                .toAbsolutePath().normalize();
        String fileName = file.getOriginalFilename();
        String newFileName = UUID.randomUUID().toString();

        boolean success = false;
        Path targetLocation = fileStorageLocation.resolve(newFileName);
        try {
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            success = true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(!success){
            return ResponseEntity.status(500).body(0);
        }

        Imagen img = new Imagen();
        img.setFechaSubida(new Date());
        img.setEsTemporal(true);
        img.setFileName(fileName);
        img.setDirec(targetLocation.toString());

        img = imagenRepository.save(img);

        return ResponseEntity.ok(img.getImagenId());
    }
    @GetMapping()
    public ResponseEntity<List<Imagen>> getContactosUsuario(){
        List<Imagen> imagenes = imagenRepository.findAll();
        return ResponseEntity.ok(imagenes);
    }
    @GetMapping("/{imageId}")
    public ResponseEntity<String> getImage(@PathVariable Integer imageId){

        Imagen img = imagenRepository.findByImagenId(imageId);
        if(img == null)
            return ResponseEntity.notFound().build();

        Path path = Paths.get(img.getDirec());

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + img.getDirec());

        return ResponseEntity.ok(img.getDirec());

    }

//    @GetMapping("/{imageId}")
//    public ResponseEntity<Resource> getImage(@PathVariable Integer imageId){
//
//        Imagen img = imagenRepository.findByImagenId(imageId);
//        if(img == null)
//            return ResponseEntity.notFound().build();
//
//        Path path = Paths.get(img.getDirec());
//
//        byte[] file = null;
//        ByteArrayResource resource = null;
//        try {
//            file = Files.readAllBytes(path);
//            resource = new ByteArrayResource(file);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        HttpHeaders headers = new HttpHeaders();
//        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + img.getDirec());
//
//        return ResponseEntity.ok()
//                .headers(headers)
//                .contentLength(file.length)
//                .contentType(MediaType.APPLICATION_OCTET_STREAM)
//                .body(resource);
//
//    }
}
