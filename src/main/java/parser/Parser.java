package parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class Parser {
	
	private static final Logger log = Logger.getLogger(Parser.class);

    private String text;
    private List<Header> headers = new ArrayList<>();
    private List<String> cleanTextList = new ArrayList<>();

    private List<AddedBlock> addedBlockList = new ArrayList<>();
    private List<ChangedBlock> changedBlockList = new ArrayList<>();
    private List<DeletedBlock> deletedBlockList = new ArrayList<>();

    public Parser() {
    }

    public void parse(String text) {

        StringBuilder builder = new StringBuilder();
        Scanner scanner = new Scanner(text);

        getCleanText(text);

        while (scanner.hasNext()) {

            String line = scanner.nextLine();
            String firstCharacter = line.substring(0, 1);
            int[] rangeOfRows;
            int[] sourceRangeOfRows;
            int[] targetRangeOfRows;

            if (isInteger(firstCharacter)) {

                switch (whichTypeContains(line)) {

                    case "a":

                        AddHeader addHeader = new AddHeader(line);

                        rangeOfRows = getNumbersInARange(addHeader.getStartLine(), addHeader.getEndLine());

                        String addedText = sortTextToBlocks(cleanTextList, rangeOfRows.length);

                        System.out.println("added at index " + addHeader.getInsertLine() + ": \n" + addedText);

                        addedBlockList.add(new AddedBlock(addHeader, addedText));

                        break;

                    case "c":

                        ChangeHeader changeHeader = new ChangeHeader(line);

                        String sourceChangedText;
                        String targetChangedText;

                        if (changeHeader.getSourceEndLine() != 0) {
                            sourceRangeOfRows = getNumbersInARange(changeHeader.getSourceStartLine(), changeHeader.getSourceEndLine());
                            sourceChangedText = sortTextToBlocks(cleanTextList, sourceRangeOfRows.length);
                        } else {
                            sourceChangedText = sortTextToBlocks(cleanTextList, 1);
                        }
                        if (changeHeader.getTargetEndLine() != 0) {
                            targetRangeOfRows = getNumbersInARange(changeHeader.getTargetStartLine(), changeHeader.getTargetEndLine());
                            targetChangedText = sortTextToBlocks(cleanTextList, targetRangeOfRows.length);
                        } else {
                            targetChangedText = sortTextToBlocks(cleanTextList, 1);
                        }

                        System.out.println("changed source at index " + changeHeader.getSourceStartLine() + ", " + changeHeader.getSourceEndLine() + ": \n" + sourceChangedText);
                        System.out.println("changed target at index " + changeHeader.getTargetStartLine() + ", " + changeHeader.getTargetEndLine() + ": \n" + targetChangedText);

                        break;

                    case "d":

                        DeleteHeader deleteHeader = new DeleteHeader(line);

                        rangeOfRows = getNumbersInARange(deleteHeader.getStartLine(), deleteHeader.getEndLine());

                        String deletedText = sortTextToBlocks(cleanTextList, rangeOfRows.length);

                        System.out.println("deleted at index " + deleteHeader.getDeleteLine() + ": \n" + deletedText);

                        deletedBlockList.add(new DeletedBlock(deleteHeader, deletedText));

                        break;
                }
            }
        }
    }
    
    public static boolean isInteger(String s) {

        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }

        return true;
    }

    public static String whichTypeContains(String str) {

        String name = null;

        for (Type t : Type.values()) {
            if (str.contains(t.name())) {
                name = t.name();
                break;
            }
        }

        return name;
    }

    private String sortTextToBlocks(List<String> cleanTextList, int rangeOfRowsLength) {

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < rangeOfRowsLength; i++) {
            builder.append(cleanTextList.get(i) + "\n");
        }

        cleanTextList.subList(0, rangeOfRowsLength).clear();

        return builder.toString();
    }

    public String getCleanText(String parseString) {

        StringBuilder builder = new StringBuilder();
        Scanner scanner = new Scanner(parseString);

        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();
            char firstLineChar = line.charAt(0);

            if (!Character.isDigit(firstLineChar) && !line.contains("---")) {
                builder.append(line + "\n");
                cleanTextList.add(line);
            }
        }

        return builder.toString();
    }

    public List<Header> getHeaders(String text) {

        List<Header> headers = new ArrayList<>();
        Scanner scanner = new Scanner(text);

        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();
            char firstLineChar = line.charAt(0);

            if (Character.isDigit(firstLineChar)) {
                headers.add(new Header(line));
            }
        }

        scanner.close();

        return headers;

    }

    private static int[] getNumbersInARange(int a, int b) {

        int[] temp = new int[(b - a) + 1];
        int i = 0;

        while (a <= b) {
            temp[i] = a;
            i++;
            a++;
        }

        return Arrays.copyOfRange(temp, 0, i);
    }

    public List<DeletedBlock> getDeletedBlockList() {
        return deletedBlockList;
    }

    public List<ChangedBlock> getChangedBlockList() {
        return changedBlockList;
    }

    public List<AddedBlock> getAddedBlockList() {
        return addedBlockList;
    }

    public List<Header> getHeaders() {
        return headers;
    }

    public String getText() {
        return text;
    }

}
