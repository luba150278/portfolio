package com.shpp.p2p.cs.sserheiev.assignment15;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EncodeMapWorker {
    /**
     * Create glossary for encode, based on symbols of file and code-tree.
     * @param symbolsInFile Set of file symbols.
     * @param root root of code-tree.
     * @return glossary of symbol - "bit code".
     */
    public static Map<Integer, String> makeEncodeGlossary(Set<Integer> symbolsInFile, TreeNode root) {
        HashMap<Integer, String> glossary = new HashMap<>();

        for (Integer symbol : symbolsInFile) {
            String code = CodeTreeWorker.getCodeForeSymbol(symbol, root);
            //todo: check for code = null
            glossary.put(symbol, code);
        }

        return glossary;
    }

    /**
     * Create glossary for decode, based on symbols of file and code-tree.
     * @param symbolsInFile Set of file symbols.
     * @param root root of code-tree.
     * @return glossary of "bit code" - symbol.
     */
    public static Map<String, Integer> makeDecodeGlossary(Set<Integer> symbolsInFile, TreeNode root) {
        HashMap<String, Integer> glossary = new HashMap<>();

        for (Integer symbol : symbolsInFile) {
            String code = CodeTreeWorker.getCodeForeSymbol(symbol, root);
            //todo: check for code = null
            glossary.put(code, symbol);
        }

        return glossary;
    }
}
