import java.util.*;

public class WordExample {

    /**
     * 统计每个单词的出现次数，并按照格式输出
     * 单词1=xx次
     * 单词2=xx次
     * 单词3=xx次
     */
    public static final String words = "Shall I compare thee to a summer's day?\n"
            + "Thou art more lovely and more temperate:\n"
            + "Rough winds do shake the darling buds of May,\n"
            + "And summer's lease hath all too short a date:\n"
            + "Sometime too hot the eye of heaven shines,\n"
            + "And often is his gold complexion dimmed,\n"
            + "And every fair from fair sometime declines,\n"
            + "By chance, or nature's changing course untrimmed:\n"
            + "But thy eternal summer shall not fade,\n"
            + "Nor lose possession of that fair thou ow'st,\n"
            + "Nor shall death brag thou wand'rest in his shade,\n"
            + "When in eternal lines to time thou grow'st,\n"
            + "So long as men can breathe or eyes can see,\n"
            + "So long lives this, and this gives life to thee.";


    public static void main(String[] args) {
        Map<String, Integer> wordCount = new HashMap<>();
        String[] tokens = words.split("[ ,.?:]");
        int count = 0;
        for (String token : tokens) {
            if (token.length() == 0) {
                continue;
            }
            Integer countOne = wordCount.getOrDefault(token, 0) + 1;
            wordCount.put(token,countOne);
            count++;
        }
        System.out.println(wordCount);
        for (Integer value : wordCount.values()) {
            count -= value;
        }
        System.out.println(count);

    }
}
