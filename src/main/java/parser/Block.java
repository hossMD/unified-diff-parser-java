package parser;

public abstract class Block {

    private Header header;
    private String text;

    public Block(Header header, String text) {
        super();
        this.header = header;
        this.text = text;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
