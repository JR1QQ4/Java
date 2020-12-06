package practice_02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class FileAnalyzer {
    private String fileStr;

    public FileAnalyzer(String fileStr) {
        this.fileStr = fileStr;
    }

    public HashMap<String, Word> getWordCount(){
        HashMap<String, Word> result = new HashMap<>();
        String line;
        try(BufferedReader in = new BufferedReader(new InputStreamReader(
                new FileInputStream(fileStr)))){
            while ((line =in.readLine())!=null){
                String[] words = line.split(" ");
                for (String word :
                        words) {
                    if (null != word && word.length() > 0) {
                        if (result.containsKey(word)){
                            Word w = result.get(word);
                            w.setTimes(w.getTimes() + 1);
                        }else {
                            result.put(word, new Word(word, 1));
                        }
                    }
                    }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
