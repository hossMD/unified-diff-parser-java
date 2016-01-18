package parser;

/**
 * Created by denees on 15/01/16.
 */
public class DeleteHeader extends Header {

    private int startLine;
    private int endLine;
    private int deleteLine;

    public DeleteHeader(String header) {
        super(header);

        startLine = Integer.parseInt(header.split("d")[0].split(",")[0]);
        endLine = Integer.parseInt(header.split("d")[0].split(",")[1]);
        deleteLine = Integer.parseInt(header.split("d")[1]);
    }

    public int getStartLine() {
        return startLine;
    }

    public int getEndLine() {
        return endLine;
    }

    public int getDeleteLine() {
        return deleteLine;
    }
}
