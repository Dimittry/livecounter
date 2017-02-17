package com.livecounter.parser;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParserDataHolder {
    private final Parser parser;
    private final Saver saver;

    public ParserDataHolder(Parser parser, Saver saver) {
        this.parser = parser;
        this.saver = saver;
    }

    public void run() {
        String[] files = getFileNamesToParse();
        Arrays.stream(files).forEach(System.out::println);
        List<String> toSave = new ArrayList<>();

        for (int i = 0; i < files.length; i++) {
            toSave.clear();
            try(BufferedReader br = new BufferedReader(new FileReader(files[i]))) {
                String line;
                while((line = br.readLine()) != null) {
                    String preparedData = parser.parse(line);
                    if(!preparedData.isEmpty()) {
                        toSave.add(preparedData);
                    }
                }
                saver.save(toSave);
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    public String[] getFileNamesToParse() {
        String path = getResourcePath(parser.getFolderToParse());
        System.out.println(path);
        File file = new File(path);
        if(file == null || !file.exists()) {
            throw new IllegalStateException("Can't find resource path");
        }
        String[] files = file.list();
        String[] filesWithFullPath = new String[files.length];
        for(int i = 0; i < files.length; i++) {
            filesWithFullPath[i] = path + File.separator + files[i];
        }
        return filesWithFullPath;
    }

    private String getResourcePath(final String resourceFolderName) {
        return System.getProperty("user.dir")+ File.separator + resourceFolderName;
//        return (getClass().getClassLoader().getResource(resourceFolderName).getFile())
//                .replaceAll("%20", " ");
    }

}
