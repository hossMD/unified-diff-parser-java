package parser;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.List;

public class ParserTest {

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

    @Test
    public void testGetHeaders() {

        parser.parse(diff);

//        List<AddedBlock> list = parser.getAddedBlockList();
//        System.out.println(list);

//        System.out.println(parser.getTextByHeader(new Header("0a1,6")));

        // for (Header header : parser.getHeaders()){
        //
        // System.out.println(header);
        //
        // }
        // assertEquals(4, parser.getHeaders().size());

    }
    //
    // @Test
    // public void testParse() {
    //
    // parser.parse(diff);
    //
    // for (Header header : parser.getHeaders()){
    //
    // System.out.println(header);
    //
    // }
    // assertEquals(4, parser.getHeaders().size());
    //
    // }

}
