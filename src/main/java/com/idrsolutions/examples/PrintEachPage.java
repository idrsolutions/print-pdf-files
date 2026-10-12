/*
 * Copyright (C) 2026 IDRsolutions
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.idrsolutions.examples;

import org.jpedal.examples.printing.PrintPdfPages;
import org.jpedal.parser.DecoderOptions;

public class PrintEachPage {

    public static void main(final String[] args) {

        // The PrintPdfPages class is used to send the pages of a PDF
        // to any printer installed on the system.

        // The name of the printer to use
        // The printer is selected if its name contains this value, so it must
        // match one of the printers listed by the ListPrinters example
        final String printerName = "printerName";

        // Set the password if the file is encrypted, otherwise leave as null
        final String password = null;

        // Initialize a new instance with a file
        final PrintPdfPages print = new PrintPdfPages("inputFile.pdf");

        if (password != null) {
            print.setPassword(password);
        }

        try {

            // Attempt to decode the file
            // This method returns true if the decode was successful and false otherwise
            if (print.openPDFFile()) {

                // Get the number of pages in the document
                final int pageCount = print.getPageCount();

                // PDF page indices start from one, not zero!
                // Each page is sent to the printer as a separate print job,
                // which gives you control over which pages are printed
                for (int page = 1; page <= pageCount; page++) {
                    print.printPage(printerName, page);
                }

            } else {
                System.err.println("Unable to open file.");
            }

        } catch (Exception e) {
            // An Exception may be thrown if the file cannot be opened or printing fails
            e.printStackTrace(System.err);
        } finally {
            // You should always call this to free up system resources
            // Passing true also exits the JVM, which JPedal does when running on Windows
            print.closePDFfile(DecoderOptions.isRunningOnWindows);
        }

    }

}
