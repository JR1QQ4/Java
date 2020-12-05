package practice_02;

public class Word implements Comparable<Word> {
    private String text;  // 单词文本
    private int times;  // 单词次数

    public Word(String text, int times) {
        this.text = text;
        this.times = times;
    }

    /**
     * 定义两个单词的排序，逐序输出
     */
    @Override
    public int compareTo(Word o) {
        return (-1) * (this.getTimes() - o.getTimes());
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }
}
