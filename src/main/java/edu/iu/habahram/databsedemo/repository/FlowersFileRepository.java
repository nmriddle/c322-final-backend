package edu.iu.habahram.databsedemo.repository;

import edu.iu.habahram.databsedemo.model.Flower;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FlowersFileRepository {
    private String IMAGES_FOLDER_PATH = "flowers/images/";

    public byte[] getImage(int id) throws IOException {
        String fileExtension = ".jpeg";
        Path path = Paths.get(IMAGES_FOLDER_PATH
                + id + fileExtension);
        byte[] image = Files.readAllBytes(path);
        return image;
    }

    public boolean updateImage(int id, MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getContentType());

        String fileExtension = ".jpeg";
        Path path = Paths.get(IMAGES_FOLDER_PATH
                + id + fileExtension);
        System.out.println("The file " + path + " was saved successfully.");
        file.transferTo(path);
        return true;
    }

    public List<Flower> search(Iterable<Flower> allFlowers, Flower searchFlower) {
        List<Flower> searchFlowers = new ArrayList<>();
        for (Flower flower : allFlowers) {
            if (searchFlower.getType() != null && !searchFlower.getType().equals(flower.getType())) {
                continue;
            }
            if (searchFlower.getOccasion() != null && !searchFlower.getOccasion().equals(flower.getOccasion())) {
                continue;
            }
            if (searchFlower.getColor() != null && !searchFlower.getColor().equals(flower.getColor())) {
                continue;
            }

            searchFlowers.add(flower);
        }
        return searchFlowers;
    }
}
