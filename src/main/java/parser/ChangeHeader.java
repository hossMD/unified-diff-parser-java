package parser;

/**
 * Created by denees on 15/01/16.
 */
public class ChangeHeader extends Header {

    private int sourceStartLine;
    private int sourceEndLine;
    private int targetStartLine;
    private int targetEndLine;

    public ChangeHeader(String header) {
        super(header);

        String source = header.split("c")[0];

        if (source.split(",").length > 1) {
            sourceStartLine = Integer.parseInt(source.split(",")[0]);
            sourceEndLine = Integer.parseInt(source.split(",")[1]);
        } else {
            sourceStartLine = Integer.parseInt(source);
        }

        String target = header.split("c")[1];

        if (target.split(",").length > 1) {
            targetStartLine = Integer.parseInt(target.split(",")[0]);
            targetEndLine = Integer.parseInt(target.split(",")[1]);
        } else {
            targetStartLine = Integer.parseInt(target);
        }
    }

    public int getSourceStartLine() {
        return sourceStartLine;
    }

    public int getSourceEndLine() {
        return sourceEndLine;
    }

    public int getTargetStartLine() {
        return targetStartLine;
    }

    public int getTargetEndLine() {
        return targetEndLine;
    }
}
