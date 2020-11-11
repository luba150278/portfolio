package com.shpp.p2p.cs.sserheiev.assignment15;

public class ByteBuilderHelper {
    /**
     * Append zero bits to the start of bit sequence.
     */
    public static void appendBitsToTheStart (StringBuilder byteBuilder) {
        byteBuilder.reverse();
        int bitDifference = Byte.SIZE - byteBuilder.length();
        for (int i = 0; i < bitDifference; i++) {
            byteBuilder.append("0");
        }
        byteBuilder.reverse();
    }

    /**
     * Append zero bits to the end of bit sequence.
     */
    public static void appendBitsToTheEnd (StringBuilder byteBuilder) {
        int bitDifference = Byte.SIZE - byteBuilder.length();
        for (int i = 0; i < bitDifference; i++) {
            byteBuilder.append("0");
        }
    }
}
