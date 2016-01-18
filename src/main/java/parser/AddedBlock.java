package parser;

public class AddedBlock extends Block {

    private String insertLine;
    private String beginLine;
    private String lastLine;

    public AddedBlock(Header header, String text) {
        super(header, text);

        insertLine = header.getHeaderString().split("a")[0];
        beginLine = header.getHeaderString().split("a")[1].split(",")[0];
        lastLine = header.getHeaderString().split("a")[1].split(",")[1];
    }

    public String getInsertLine() {
        return insertLine;
    }


    public String getBeginLine() {
        return beginLine;
    }


    public String getLastLine() {
        return lastLine;
    }

    @Override
    public String toString() {
        return "AddedBlock{" +
                "insertLine='" + insertLine + '\'' +
                ", beginLine='" + beginLine + '\'' +
                ", lastLine='" + lastLine + '\'' +
                ", text='\n" + getText() + '\'' +
                '}';
    }
}
