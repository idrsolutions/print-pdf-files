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

public class PrintAllPages {

    public static void main(final String[] args) {

        // The PrintPdfPages class is used to send the pages of a PDF
        // to any printer installed on the system.

        // The name of the printer to use
        // The printer is selected if its name contains this value, so it must
        // match one of the printers listed by the ListPrinters example
        final String printerName = "printerName";

        // Simple static method to print all pages in the given PDF using the specified printer
        // A RuntimeException is thrown if the file cannot be opened or printing fails
        PrintPdfPages.printPDF("inputFile.pdf", printerName);

    }

}
