package com.shpp.p2p.cs.sserheiev.assignment15;

/*
    This class exist only to do testing a little bit easier.
    Change arguments of the string array freely.
    But don't forget to comment another Assignment15.main(arguments) calls.
 */
public class Tester {
    public static void main(String[] args) {
        String[] arguments;

        arguments = new String[]{};
        Assignment15.main(arguments);

        arguments = new String[]{"L2.txt"};
        Assignment15.main(arguments);

        arguments = new String[]{"L2.par", "L3"};
        Assignment15.main(arguments);

        arguments = new String[]{"file.txt", "enFile.noMatterWhat"};
        Assignment15.main(arguments);

        arguments = new String[]{"enFile.par"};
        Assignment15.main(arguments);

        arguments = new String[]{"-a", "fairy.jpg", "enFairy.rightWhatYouWant"};
        Assignment15.main(arguments);

        arguments = new String[]{"-u", "enFairy.rightWhatYouWant", "deFairy.jpg"};
        Assignment15.main(arguments);
    }
}
