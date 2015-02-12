package lazyguy.yyf.threadObject;

class R implements Runnable {
    private int x = 0;

    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.print(x++);
        }
        System.out.println("\n");
    }
}