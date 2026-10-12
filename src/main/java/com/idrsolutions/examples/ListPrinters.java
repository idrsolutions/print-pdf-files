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

import java.awt.print.PrinterJob;
import javax.print.PrintService;

public class ListPrinters {

    public static void main(final String[] args) {

        // JPedal selects a printer by name, so it is useful to know which
        // printers are available to Java on this machine.

        // Look up all of the print services installed on the system
        final PrintService[] printers = PrinterJob.lookupPrintServices();

        if (printers.length == 0) {
            System.out.println("No printers found");
            return;
        }

        // Print out the name of each printer
        // Any of these names can be passed to the PrintPdfPages print methods
        for (final PrintService printer : printers) {
            System.out.println(printer.getName());
        }

    }

}
