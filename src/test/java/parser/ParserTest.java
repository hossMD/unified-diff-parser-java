package parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class ParserTest {
	
	private static final Logger log = Logger.getLogger(ParserTest.class);
	
    private Parser parser = new Parser();

    String diff = "0a1,6\n" +
            "> This is an important\n" +
            "> notice! It should\n" +
            "> therefore be located at\n" +
            "> the beginning of this\n" +
            "> document!\n" +
            ">\n" +
            "8,14c14\n" +
            "< compress the size of the\n" +
            "< changes.\n" +
            "<\n" +
            "< This paragraph contains\n" +
            "< text that is outdated.\n" +
            "< It will be deleted in the\n" +
            "< near future.\n" +
            "---\n" +
            "> compress anything.\n" +
            "17c17\n" +
            "< check this dokument. On\n" +
            "---\n" +
            "> check this document. On\n" +
            "24a25,28\n" +
            ">\n" +
            "> This paragraph contains\n" +
            "> important new additions\n" +
            "> to this document.\n" +
            "41,46d40\n" +
            "< Lorem ipsum dolor sit amet,\n" +
            "< consectetuer adipiscing elit,\n" +
            "< sed diam nonummy nibh euismod\n" +
            "< tincidunt ut laoreet dolore magna\n" +
            "< aliquam erat volutpat.\n" +
            "< Ut wisi enim ad minim veniam.";
    
    @Before
    public void setUp(){
    	
    	parser.parse(diff);
    }

    @Test
    public void testGetHeaders() {

        List<Header> list = parser.getHeaders();
        
        assertNotNull(list);
        assertEquals(5, list.size());
        
        
    }
    
    @Test
    public void testDeletedBlocks() {
    	
    	List<DeletedBlock> list = parser.getDeletedBlockList();
    	
    	assertNotNull(list);
    	assertEquals(1, list.size());
    	
    	
    }

    @Test
    public void testChangedBlocks() {
    	
    	List<ChangedBlock> list = parser.getChangedBlockList();
    	
    	assertNotNull(list);
    	assertEquals(2, list.size());
    	
    	
    }

}
