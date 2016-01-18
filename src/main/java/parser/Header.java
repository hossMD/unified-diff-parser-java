package parser;

/**
 * Header types
 * <p/>
 * 0a1,6 - ADD type
 * 8,14c14 - Change
 * 17c17 - change line 17
 * 24a25,28 - add
 */
public class Header {

    protected String headerString;

    public Header(String header) {
        this.headerString = header;
    }

    public String getHeaderString() {
        return headerString;
    }
}
