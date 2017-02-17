package com.livecounter.parser.impl;

import com.livecounter.parser.Saver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SysCountersSaverImpl implements Saver{

    private final static String FILE_TO_SAVE = File.separator + "temp" + File.separator + "counters_parsed.cps";
//    private final String pathToSave;

    public SysCountersSaverImpl() {
//        this.pathToSave = getPathToSave();
        System.out.println(System.getProperty("user.dir"));
    }

    @Override
    public boolean save(List<String> data) {
        boolean result = false;
        File file = null;
        try {
            file = createFileIfNotExists();
        } catch (IOException e) {
            System.out.println("save");
            System.out.println(e.getMessage());
            return result;
        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            for(String line : data) {
                bw.write(line);
                bw.newLine();
            }
            result = true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public String getPathToSave() {
        return getResourcePath(FILE_TO_SAVE);
    }

    private String getResourcePath(final String resourceFolderName) {
        return (getClass().getClassLoader().getResource(resourceFolderName).getFile())
                .replaceAll("%20", " ");
    }

    private File createFileIfNotExists() throws IOException {
        File file = new File(System.getProperty("user.dir") + FILE_TO_SAVE);
        if(!file.getParentFile().exists()) {
            if(file.getParentFile().mkdir()) {
                file.createNewFile();
            } else {
                throw new IOException("Failed to create directory " + file.getParent());
            }
        }
        System.out.println(file);
        if(!file.exists()) {
            file.createNewFile();
        }
        return file;
    }
}
