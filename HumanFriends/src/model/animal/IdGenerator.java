package model.animal;

import model.writer.FileHandler;

import java.io.Serializable;

public class IdGenerator implements Serializable {
    private String path = "src/model/writer/serialized_files/id_generator.ser";
    private transient FileHandler fileHandler;
    private int currentId;

    public IdGenerator() {
        this.fileHandler = new FileHandler();
        fileHandler.setPath(path);
    }

    public int getCurrentId() {
        Object readObject = fileHandler.read();
        if (readObject == null) {
            currentId = 1;
        } else {
            currentId = (Integer) readObject + 1;
        }
        fileHandler.save(currentId);
        return currentId;
    }
}