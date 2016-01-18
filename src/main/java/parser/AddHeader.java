package parser;

/**
 * Created by denees on 15/01/16.
 */
public class AddHeader extends Header {

    private int insertLine;
    private int startLine;
    private int endLine;


    public AddHeader(String header) {
        super(header);

        insertLine = Integer.parseInt(header.split("a")[0]);
        startLine = Integer.parseInt(header.split("a")[1].split(",")[0]);
        endLine = Integer.parseInt(header.split("a")[1].split(",")[1]);
    }

    public int getInsertLine() {
        return insertLine;
    }

    public int getStartLine() {
        return startLine;
    }

    public int getEndLine() {
        return endLine;
    }
}
