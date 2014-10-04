package controller;

import java.util.ArrayList;
import java.util.List;

public class InfoSheet {
    public List<String> myKeywordTable = new ArrayList<>();

    public void setKeywordTable(List<String> keywordTable) {
	myKeywordTable = keywordTable;
    }

    @SuppressWarnings("rawtypes")
    public List getKeywordTable() {
	return myKeywordTable;
    }

}
