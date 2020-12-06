package practice_02;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * 统计文件里单词出现的次数
 */
public class WordCounter {
    public static void main(String[] args) throws IOException {
        // 接收目录参数和扩展名
        Path fileTree = Paths.get("c:/a_temp/");  // 转换path
        Searcher walk = new Searcher("*.txt");

        // 查找该目录下所有的txt文件
        // 创建最初包含指定元素的枚举集，FileVisitOption定义文件树遍历选项，FOLLOW_LINKS遵循符号链接
        EnumSet<FileVisitOption> opts = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        // walkFileTree此方法遍历以给定起始文件为根的文件树
        Files.walkFileTree(fileTree, opts, Integer.MAX_VALUE, walk);
        ArrayList<String> filePaths = walk.getFilePaths();
//        System.out.println(filePaths.get(0));

        // 解析每个文件的单词
        HashMap<String, Word> totalMap = new HashMap<String, Word>();
        for (String str :
                filePaths) {
            HashMap<String, Word> partMap = new FileAnalyzer(str).getWordCount();
            if (partMap != null && partMap.size() > 0) {
                combinMap(totalMap, partMap);
            }
        }

        // 排序
//        Collection<Word> words = totalMap.values();
        // values返回此映射中包含的值的Collection视图
        ArrayList<Word> words = new ArrayList<>(totalMap.values());
        Collections.sort(words);

        // 输出
        System.out.println("最后结果：");
        for (Word w :
                words) {
            System.out.println(w.getText() + ", " + w.getTimes());
        }

    }

    private static void combinMap(HashMap<String, Word> totalMap, HashMap<String, Word> partMap) {
        // entrySet返回此映射中包含的映射的Set视图
        //  Map.entrySet方法返回地图的集合视图，映射条目（键值对）
        Iterator<Map.Entry<String, Word>> iter = partMap.entrySet().iterator();
        while (iter.hasNext()){
            Map.Entry<String, Word> entry = iter.next();
            String partKey = entry.getKey();
            Word partWord = entry.getValue();
            if (totalMap.containsKey(partKey)){
                Word totalWord = totalMap.get(partKey);
                totalWord.setTimes(totalWord.getTimes() + partWord.getTimes());
            }else {
                totalMap.put(partKey, partWord);
            }
        }
    }
}
