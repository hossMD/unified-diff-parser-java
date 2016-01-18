package parser;

public class DeletedBlock extends Block {

    private String deleteBeginLine;
    private String deleteLastLine;
    private String deleteInsertLine;

    public DeletedBlock(Header header, String text) {
        super(header, text);

        deleteBeginLine = header.getHeaderString().split("d")[0].split(",")[0];
        deleteLastLine = header.getHeaderString().split("d")[0].split(",")[1];
        deleteInsertLine = header.getHeaderString().split("d")[1];

    }


    public String getDeleteBeginLine() {
        return deleteBeginLine;
    }


    public String getDeleteLastLine() {
        return deleteLastLine;
    }


    public String getDeleteInsertLine() {
        return deleteInsertLine;
    }


}
