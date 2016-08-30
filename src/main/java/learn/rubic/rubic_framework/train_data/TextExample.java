package learn.rubic.rubic_framework.train_data;

/**
 * 存储一行文本数据
 * Created by Vigo on 16/8/25.
 */
public class TextExample {

    //文本数据内容
    private String content;

    //标签
    private String label;

    /**
     * 初始化不带标签的文本数据
     * @param content
     */
    public TextExample(String content){
        this(content, null);
    }

    /**
     * 初始化带标签的文本数据
     * @param content
     * @param label
     */
    public TextExample(String content, String label){
        this.content = content;
        this.label = label;
    }

    public String getContent() {
        return content;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return "TextExample{" +
                "content='" + content + '\'' +
                ", label='" + label + '\'' +
                "}\n";
    }
}
