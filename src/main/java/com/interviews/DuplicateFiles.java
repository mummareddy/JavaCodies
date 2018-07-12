package com.interviews;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mummareddy.mahesh
 */
public class DuplicateFiles {
    static void printDuplicateFiles(List<String> filePaths) throws Exception {
        Map<String,String> map = new HashMap<>();
        for (String path : filePaths) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            StringBuilder sb = new StringBuilder();
            String line ;
            while ((line = bufferedReader.readLine())!= null) {
                sb.append(line);
            }
            if(map.containsKey(sb.toString())){
                System.out.println(map.get(sb.toString()) + " and " + path +" are duplicates ");
            }
            else {
                map.put(sb.toString(),path);
            }

        }
    }

    public static void main(String[] args) throws Exception{
        List<String> paths = new ArrayList<>();
        paths.add("src/main/resources/dupe1");
        paths.add("src/main/resources/dupe2");
        paths.add("src/main/resources/dupe3");
        paths.add("src/main/resources/dupe4");
        paths.add("src/main/resources/dupe5");
        printDuplicateFiles(paths);
    }
}
