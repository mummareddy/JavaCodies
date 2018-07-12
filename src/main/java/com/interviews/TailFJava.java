package com.interviews;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mummareddy.mahesh
 */
public class TailFJava {
    String file;
    long numOfLines;
    TailFJava(String file, long numOfLines) {
        this.file = file;
        this.numOfLines = numOfLines;
    }

    String getContent() throws FileNotFoundException,IOException {
        StringBuilder sb = new StringBuilder();
        Long totalLength =1l;
        Map<Long,String> fileMap = new HashMap<>();
        BufferedReader bf = new BufferedReader(new FileReader(file));
        String line;
        while((line = bf.readLine()) != null) {
            fileMap.put(totalLength,line);
            totalLength++;
        }

        for(Long in = totalLength-numOfLines-1 ; in < totalLength-1 ; in++ ) {
            sb.append(fileMap.get(in));
            if(in != totalLength-1)
                sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        TailFJava tailFJava = new TailFJava("src/main/resources/tailinput.txt", 5l);
        System.out.println(tailFJava.getContent());
    }
}
