import static javax.swing.JOptionPane.*;
import java.util.*;
import java.io.*;

class KontoVedlikehold {

    public static void main (String[] args) {

        int response = 0;
        double sum = 0;
        double balanceDouble = 0;
        String accountfile = "saldo.txt";
        String transactionfile = "transaksjoner.txt";

        /*
        *Lese nåværende saldo
        */
        try {
            FileReader readerToAccount = new FileReader(accountfile);
            BufferedReader accountReader = new BufferedReader(readerToAccount);

            String balance = accountReader.readLine();
            String accountBalance = "Nåværende saldo på konto:";
            while(balance != null) {

                accountBalance += ("\n" + balance);
                balanceDouble = Double.parseDouble(balance);
                balance = accountReader.readLine();
            }

            accountReader.close();
            showMessageDialog(null, accountBalance);
        } catch (FileNotFoundException e) {
           showMessageDialog(null, "Fil ikke funnet: " + accountfile);

        } catch (IOException e) {
           showMessageDialog(null, "IO.Feil ved åpning/lukking av fil");

       }

        /*
        *utføre transaksjoner
        */

        int svar = showConfirmDialog(null, "Ønsker du å utføre transaksjoner?",
                                            "Kontoalternativer", YES_NO_OPTION);

        if (svar == YES_OPTION) {

            try {
                FileWriter writerToTransactions = new FileWriter(transactionfile, false);
                PrintWriter transactionsWriter = new PrintWriter(new BufferedWriter(writerToTransactions));
                while (svar == YES_OPTION) {

                    String[] options = new String[] {"Sett inn penger", "Ta ut penger", "Cancel"};
                    while (response < options.length) {

                        response = showOptionDialog(null, "Vennligst velg hva du vil gjøre: ",
                        "Kontoalternativer", DEFAULT_OPTION, PLAIN_MESSAGE,
                        null, options, options[0]);

                        if (response == 0) { //sett inn penger
                            String deposit = showInputDialog("Tast inn beløp du vil sette inn:");
                            transactionsWriter.println("I " + deposit);
                            double depositDouble = Double.parseDouble(deposit);
                            sum += depositDouble;

                        } else if (response == 1) { //ta ut penger
                            String withdrawal = showInputDialog("Tast inn beløp du vil ta ut:");
                            transactionsWriter.println("U " + withdrawal);
                            double withdrawalDouble = Double.parseDouble(withdrawal);
                            sum -= withdrawalDouble;

                        } else { //cancel
                            break;
                        }//slutt på dialogvalg
                    }//slutt på while response
                    transactionsWriter.close();
                    break;
                }//slutt på while YES_OPTION
            }//slutt på if YES_OPTION
            catch (FileNotFoundException e) {
                showMessageDialog(null, "Fil ikke funnet: " + transactionfile);

            } catch (IOException e) {
                showMessageDialog(null, "IO.Feil ved åpning/lukking av fil");

            }
        }

        sum += balanceDouble;

        /*
        * Oppdatere saldo hvis positiv, forkaste transaksjoner hvis negativ.
        */

        if (sum > 0) {
            try {
                FileWriter writerToAccount = new FileWriter(accountfile, false);
                PrintWriter accountWriter = new PrintWriter(new BufferedWriter(writerToAccount));

                accountWriter.println(sum);
                accountWriter.close();
            }catch (FileNotFoundException e) {
               showMessageDialog(null, "Fil ikke funnet: " + accountfile);

           } catch (IOException e) {
               showMessageDialog(null, "IO.Feil ved åpning/lukking av fil");

           }
        } else {
            try {
                FileWriter writerToTransactions = new FileWriter(transactionfile, false);
                PrintWriter transactionsWriter = new PrintWriter(new BufferedWriter(writerToTransactions));
                transactionsWriter.println("");
                transactionsWriter.close();
                showMessageDialog(null, "Totalsummen blir negativ, operasjoner kan ikke utføres");
            } catch (FileNotFoundException e) {
                showMessageDialog(null, "Fil ikke funnet: " + transactionfile);

            } catch (IOException e) {
                showMessageDialog(null, "IO-Feil ved åpning/lukking av fil");

            }
        }

        /*
        *
        */
    }//main
}//class
