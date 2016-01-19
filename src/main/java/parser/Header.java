package parser;

/**
 * Header types
 * <p/>
 * 0a1,6 - Add type
 * 8,14c14 - Change type
 * 17c17 - change line 17
 * 24a25,28 - add
 */
public class Header {

    protected String headerString;
    
    public Header(String header) {
        this.headerString = header;
        validate(header);
    }

    public String getHeaderString() {
        return headerString;
    }
    
    public boolean validate(String header){
    	//TODO:
		return false;    	
    }
}
