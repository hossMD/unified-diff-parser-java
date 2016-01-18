package parser;

public class ChangedBlock extends Block {

    private String insertLine;
    private String beginLine;
    private String lastLine;

    public ChangedBlock(Header header, String text) {
        super(header, text);
    }
}
