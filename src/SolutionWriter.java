import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SolutionWriter {

    /**
     * Writes a solution as CSV.
     *
     * @param filename  - filename for the csv file
     * @param sol       - solution to be written to the file
     * @param timeLimit - time limit that was used while generating the solution
     */
    public static void writeSolutionAsCSV(String filename, Solution sol, double timeLimit) {
        try {
            File file = new File(filename);
            boolean newFile = false;
            if (!file.exists()) {
                file.createNewFile();
                newFile = true;
            }
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            if (newFile) {
                bw.write("instance,prec_model,time_limit,runtime,obj\n");
            }
            if (sol.isFeasible()) {
                bw.write(
                    sol.getNameOfSolvedInstance() + ",m" + sol.getPrecModel() + "," + timeLimit + ","
                        + sol.getTimeToSolve() + "," + sol.getSumOfCompletionTimes() + "\n"
                );
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
