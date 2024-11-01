public class ProgressBarThread extends Thread {

    @Override
    public void run() {
        while (DataProcessingApplication.getNumbersRead() < DataProcessingApplication.getTotalNumbers()) {
            updateProgressBar();
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {}
        }
    }

    private static void updateProgressBar() {
        int progress = (int) Math.round(((50.0 * DataProcessingApplication.getNumbersRead()) / DataProcessingApplication.getTotalNumbers()));
        for (int i = 0; i < progress; i++) System.out.print("█");
        for (int i = progress; i < 50; i++) System.out.print("░");
        System.out.println();
    }

}
